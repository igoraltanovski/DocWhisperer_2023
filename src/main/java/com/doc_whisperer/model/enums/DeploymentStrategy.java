package com.doc_whisperer.model.enums;

public enum DeploymentStrategy {

    SINGLE_INSTANCE("The application is deployed on a single instance or server. Simple but may have scalability and availability issues."),
    CLOUD_NATIVE("Designed to embrace the principles of cloud computing, offering scalability, flexibility, and resilience by utilizing cloud services and tools."),
    MULTI_INSTANCE("The application is deployed on multiple instances or servers for improved scalability and availability."),
    MULTI_TENANCY("A single instance of the application serves multiple tenants or customer organizations, ensuring data isolation and customization for each tenant."),
    EDGE_COMPUTING("Processes data at the edge of the network, close to the source of data. It reduces latency and bandwidth use."),
    HYBRID_CLOUD("Combines private and public clouds, allowing data and applications to be shared between them, offering flexibility, innovation, and cost optimization.");

    private final String description;

    DeploymentStrategy(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}