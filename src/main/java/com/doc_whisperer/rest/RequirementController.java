package com.doc_whisperer.rest;

import com.doc_whisperer.model.ArchitectureProposalResponse;
import com.doc_whisperer.entities.Requirement;
import com.doc_whisperer.model.SummarizedResponse;
import com.doc_whisperer.services.DocumentationService;
import com.doc_whisperer.services.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/requirements")
public class RequirementController {

    @Autowired
    private RequirementService requirementService;

    @Autowired
    private DocumentationService documentationService;

    @GetMapping
    public List<Requirement> getAllRequirements() {
        return requirementService.getAllRequirements();
    }

    @GetMapping("/generate-architecture")
    public ArchitectureProposalResponse generateArchitectureProposal() {
        List<SummarizedResponse> summarizedResponses = documentationService.summarizeRequirementsByCategory();
        return documentationService.generateArchitectureProposal(summarizedResponses);
    }

    @GetMapping("/generate-business-requirements")
    public ArchitectureProposalResponse generateBusinessRequirements() {
        List<SummarizedResponse> summarizedResponses = documentationService.summarizeRequirementsByCategory();
        return documentationService.generateBusinessRequirements(summarizedResponses);
    }

}