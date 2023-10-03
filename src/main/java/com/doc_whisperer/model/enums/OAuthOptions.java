package com.doc_whisperer.model.enums;

public enum OAuthOptions {

    // OAuth 1.0a (if needed)
    OAUTH1A,

    // OAuth 2.0 Grant Types
    AUTHORIZATION_CODE,
    IMPLICIT,
    RESOURCE_OWNER_PASSWORD_CREDENTIALS,
    CLIENT_CREDENTIALS,

    // OAuth 2.0 Extension Grant Types
    REFRESH_TOKEN,
    DEVICE_CODE;

}

