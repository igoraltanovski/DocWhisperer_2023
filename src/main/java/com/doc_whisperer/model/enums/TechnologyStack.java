package com.doc_whisperer.model.enums;

public enum TechnologyStack {
    MEAN("MongoDB, Express.js, Angular, Node.js"),
    MERN("MongoDB, Express.js, React, Node.js"),
    LAMP("Linux, Apache, MySQL, PHP/Python/Perl"),
    DOT_NET(".NET Framework"),
    SPRING_BOOT("Spring Boot"),
    DJANGO("Django Framework"),
    FLASK("Flask Framework"),
    RUBY_ON_RAILS("Ruby on Rails");

    private final String description;

    TechnologyStack(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return name() + " (" + description + ")";
    }
}

