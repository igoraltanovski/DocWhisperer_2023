package com.doc_whisperer.model.enums;

public enum ArchitecturalPatterns {

    MONOLITHIC("A monolithic architecture consists of a single, unified code base that manages the application's UI, business logic, and database operations. It is simple but can become complex and difficult to manage as the application grows."),
    MICROSERVICES("A microservices architecture breaks down the application into small, self-contained services that can be developed, deployed, and scaled independently. Promotes agility and scalability."),
    EVENT_DRIVEN("In an event-driven architecture, components communicate through events. This asynchronous communication enables high scalability and adaptability."),
    PEER_TO_PEER("Peer-to-peer architecture distributes tasks and workloads among peers who are equally privileged participants in the application. It enhances scalability and load distribution."),
    SOA("Service-Oriented Architecture organizes the application as a collection of loosely coupled services, promoting service reusability, flexibility, and maintenance."),
    SERVERLESS("Serverless architecture allows developers to build and run applications without managing servers. It's highly scalable and cost-effective as you only pay for the compute time consumed."),
    N_TIER("N-Tier architecture separates the application into multiple tiers (e.g., presentation, business logic, data storage), enhancing modularity and scalability."),
    LAYERED("Layered architecture organizes the application into layers (e.g., presentation, business, data), each with distinct responsibilities, promoting separation of concerns."),
    MVC_MVVM_MVP("MVC, MVVM, and MVP are patterns for organizing UI code. MVC separates the application into Model, View, Controller; MVVM uses Model, View, ViewModel; MVP has Model, View, Presenter.");

    private final String description;

    ArchitecturalPatterns(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
