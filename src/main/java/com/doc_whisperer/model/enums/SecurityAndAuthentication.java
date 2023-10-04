package com.doc_whisperer.model.enums;

public enum SecurityAndAuthentication {

    OAUTH("OAuth"),
    JWT("JWT (JSON Web Tokens)"),
    SSO("SSO (Single Sign-On)"),
    RBAC("Role-based Access Control (RBAC)"),
    MUTUAL_TLS("Mutual TLS"),
    ENCRYPTION_AT_REST_IN_TRANSIT("Encryption at Rest & in Transit");

    private final String description;

    SecurityAndAuthentication(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static SecurityAndAuthentication fromDisplayName(String displayName) {
        for (SecurityAndAuthentication value : SecurityAndAuthentication.values()) {
            if (value.getDescription().equals(displayName)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown display name: " + displayName);
    }

    @Override
    public String toString() {
        return getDescription();
    }
}
