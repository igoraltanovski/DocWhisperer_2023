package com.doc_whisperer.services;

import com.doc_whisperer.model.DocumentationKey;
import com.doc_whisperer.model.enums.DocumentationType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class DocumentationService {

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

}
