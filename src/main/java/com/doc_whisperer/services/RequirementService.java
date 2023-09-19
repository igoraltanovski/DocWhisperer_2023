package com.doc_whisperer.services;

import com.doc_whisperer.entities.Requirement;
import com.doc_whisperer.repositories.RequirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequirementService {

    @Autowired
    private RequirementRepository requirementRepository;


    public List<Requirement> getAllRequirements() {
        return requirementRepository.findAll();
    }

}
