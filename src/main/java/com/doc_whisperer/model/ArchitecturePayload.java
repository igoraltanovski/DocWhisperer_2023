package com.doc_whisperer.model;

import com.doc_whisperer.model.enums.*;
import lombok.Data;

@Data
public class ArchitecturePayload {

    private ArchitecturalPatterns architecturalPatterns;
    private DataArchitecture dataArchitecture;
    private DeploymentStrategy deploymentStrategy;
    private UserExperienceAndFrontEnd userExperienceAndFrontEnd;
    private SecurityAndAuthentication securityAndAuthentication;
    private TechnologyStack technologyStack;

}
