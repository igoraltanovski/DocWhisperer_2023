package com.doc_whisperer.model.enums;

public enum JWTTokenType {

    ACCESS_TOKEN("Access Token is used to make authenticated requests to a secured API. It is short-lived and often expires in minutes."),
    REFRESH_TOKEN("Refresh Token is used to obtain a new Access Token after the current one expires. It usually has a longer lifespan than an Access Token."),
    ID_TOKEN("ID Token contains user profile information (like user ID, username, email, etc.) and is used to authenticate the user.");

    private final String description;

    JWTTokenType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
