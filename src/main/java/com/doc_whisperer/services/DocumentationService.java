package com.doc_whisperer.services;

import com.doc_whisperer.entities.DocumentationTemplate;
import com.doc_whisperer.model.ArchitectureProposalResponse;
import com.doc_whisperer.model.DocumentationKey;
import com.doc_whisperer.entities.Requirement;
import com.doc_whisperer.model.SummarizedResponse;
import com.doc_whisperer.model.enums.DocumentationType;
import com.doc_whisperer.repositories.DocumentationTemplateRepository;
import com.doc_whisperer.repositories.RegisteredFlowRepository;
import com.doc_whisperer.repositories.RequirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.doc_whisperer.services.OpenAiIntegrationService.gtp_3_5_model;
import static com.doc_whisperer.services.OpenAiIntegrationService.gtp_4_model;

@Service
public class DocumentationService {

    @Autowired
    private DocumentationTemplateRepository repository;

    @Autowired
    private RegisteredFlowRepository flowRepository;

    @Autowired
    private OpenAiIntegrationService openAiIntegrationService;

    @Autowired
    private RequirementRepository requirementRepository;

    // URL of the AI instance
    private final Map<DocumentationKey, String> mockData = new HashMap<>();

    @PostConstruct
    public void init() {
        // Add your mock data here. For example:
        mockData.put(new DocumentationKey(1l, DocumentationType.TECHNICAL), "Given the code provided below, generate a concise yet comprehensive documentation based on the following topic model:\\n\\nFunctionality Overview: A brief description of what the code does .\\nUsage: How to use or implement the code.\\nParameters and Returns: Details about the input parameters and return values.\\n\\n    @PreAuthorize(\\\"hasRole(@roles.VET_ADMIN)\\\")\\n    @Override\\n    public ResponseEntity<SpecialtyDto> getSpecialty(Integer specialtyId) {\\n        Specialty specialty = this.clinicService.findSpecialtyById(specialtyId);\\n        if (specialty == null) {\\n            return new ResponseEntity<>(HttpStatus.NOT_FOUND);\\n        }\\n        return new ResponseEntity<>(specialtyMapper.toSpecialtyDto(specialty), HttpStatus.OK);\\n    }\\n\\n\\t@Override\\n\\t@Transactional(readOnly = true)\\n\\tpublic Specialty findSpecialtyById(int specialtyId) {\\n\\t\\tSpecialty specialty = null;\\n\\t\\ttry {\\n\\t\\t\\tspecialty = specialtyRepository.findById(specialtyId);\\n\\t\\t} catch (ObjectRetrievalFailureException|EmptyResultDataAccessException e) {\\n\\t\\t// just ignore not found exceptions for Jdbc/Jpa realization\\n\\t\\t\\treturn null;\\n\\t\\t}\\n\\t\\treturn specialty;\\n\\t}\\n\\n@Entity\\n@Table(name = \\\"specialties\\\")\\npublic class Specialty extends NamedEntity {\\n\\n}\\n");
        // Add other mock data as needed
    }

    public String fetchDocumentation(Long flowName, DocumentationType docType) {
         // If the specific combination is found, return that
            if (mockData.containsKey(new DocumentationKey(flowName, docType))) {
                return mockData.get(new DocumentationKey(flowName, docType));
            }

            // Otherwise, return the first value in the map (if it exists)
            return mockData.values().stream().findFirst().orElse("No mock data available.");
        }


    @Cacheable(value = "documentationCache", key = "#flowId + '_' + #type")
    public String generateDocumentation(Long flowId, DocumentationType type) {
        DocumentationTemplate template = repository.findByType(type)
                .orElseThrow(() -> new RuntimeException("Template not found for type: " + type));

        String code = readRelativeFileContent(flowId); // Read the code from the file

        System.out.println("code "+ code);

        return openAiIntegrationService.completeCode(template.getTemplateSystem(), template.getTemplateUser(), code, gtp_4_model);
    }

    @Cacheable(value = "requirementsSummarizationCache", key = "#root.method.name")
    public List<SummarizedResponse> summarizeRequirementsByCategory() {
        List<Requirement> requirements = requirementRepository.findAll();

        Map<String, List<Requirement>> groupedByCategory = requirements.stream()
                .collect(Collectors.groupingBy(Requirement::getCategory));

        return groupedByCategory.entrySet().stream().map(entry -> {
            String category = entry.getKey();
            String prompt = createPromptForCategory(entry.getValue());
            String summarization = openAiIntegrationService.completeCode("You are an software architect", prompt, "", gtp_3_5_model);

            return new SummarizedResponse(category, summarization);
        }).collect(Collectors.toList());
    }

    @Cacheable(value = "generateArchitectureProposal", key = "#root.method.name")
    public ArchitectureProposalResponse generateArchitectureProposal(List<SummarizedResponse> summarizedResponses) {
        // Concatenate all summarizations into a single string
        String allSummarizations = summarizedResponses.stream()
                .map(SummarizedResponse::getSummarization)
                .collect(Collectors.joining(", "));

        DocumentationTemplate template = repository.findByType(DocumentationType.ARCHITECTURE)
                .orElseThrow(() -> new RuntimeException("Template not found for type: " + DocumentationType.ARCHITECTURE));
        // Create a prompt for architectural design based on the summarizations
         String proposedArchitecture = openAiIntegrationService.completeCode(template.getTemplateSystem(), template.getTemplateUser(), allSummarizations, 3000, gtp_4_model);

        return new ArchitectureProposalResponse(summarizedResponses, proposedArchitecture);
    }

    @Cacheable(value = "generateArchitectureProposal", key = "#root.method.name")
    public ArchitectureProposalResponse generateBusinessRequirements(List<SummarizedResponse> summarizedResponses) {
        // Concatenate all summarizations into a single string
        String allSummarizations = summarizedResponses.stream()
                .map(SummarizedResponse::getSummarization)
                .collect(Collectors.joining(", "));

        DocumentationTemplate template = repository.findByType(DocumentationType.PO)
                .orElseThrow(() -> new RuntimeException("Template not found for type: " + DocumentationType.ARCHITECTURE));
        // Create a prompt for architectural design based on the summarizations
        String proposedArchitecture = openAiIntegrationService.completeCode(template.getTemplateSystem(), template.getTemplateUser(), allSummarizations, 2000, gtp_4_model);

        return new ArchitectureProposalResponse(summarizedResponses, proposedArchitecture);
    }

    private String createPromptForCategory(List<Requirement> requirementsForCategory) {
        StringBuilder prompt = new StringBuilder("Summarize the following requirements:\n\n");

        for (Requirement req : requirementsForCategory) {
            prompt.append(req.getTitle()).append(": ").append(req.getDescription()).append("\n");
        }

        return prompt.toString();
    }

    public String readRelativeFileContent(Long flowPAth) {
        // Relative path to the file
        InputStream in = getClass().getClassLoader().getResourceAsStream("code/"+flowPAth.toString()+".txt");
        try {
            return new String(in.readAllBytes());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
