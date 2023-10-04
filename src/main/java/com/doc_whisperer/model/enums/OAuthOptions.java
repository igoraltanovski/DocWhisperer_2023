package com.doc_whisperer.model.enums;

public enum OAuthOptions {

    // OAuth 1.0a (if needed)
    OAUTH1A("This is OAuth 1.0a which is a user delegation protocol, allowing the client application to access the resource owner's data without their credentials."),

    // OAuth 2.0 Grant Types
    AUTHORIZATION_CODE("This uses Authorization Code flow, suitable for server-side applications where the source code is not publicly exposed, and Client ID and Secret can be kept secure."),
    IMPLICIT("This uses Implicit flow, primarily for client-side applications where the application client code is publicly accessible, and it cannot securely store the client secret."),
    RESOURCE_OWNER_PASSWORD_CREDENTIALS("This involves directly providing the username and password of the resource owner to obtain an access token. Suitable for user agents strictly controlled by the user or highly trusted applications."),
    CLIENT_CREDENTIALS("This is Client Credentials flow, appropriate for machine-to-machine authentication where a specific user’s permission to access data is not required."),

    // OAuth 2.0 Extension Grant Types
    REFRESH_TOKEN("This grant type is used to obtain a new access token by using the refresh token provided when the access token was issued. Ideal for long-lived applications to stay authenticated."),
    DEVICE_CODE("This is Device Code flow, suitable for clients executing on devices that do not have an easy text-entry method to input the user’s credentials, like a smart TV or limited-input device.");

    private final String description;

    OAuthOptions(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}


