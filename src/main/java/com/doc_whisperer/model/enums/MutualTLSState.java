package com.doc_whisperer.model.enums;

public enum MutualTLSState {
    NOT_STARTED,
    CLIENT_CERTIFICATE_REQUESTED,
    CLIENT_CERTIFICATE_RECEIVED,
    CLIENT_CERTIFICATE_VERIFIED,
    SERVER_CERTIFICATE_RECEIVED,
    SERVER_CERTIFICATE_VERIFIED,
    HANDSHAKE_COMPLETE,
    HANDSHAKE_FAILED;
}

