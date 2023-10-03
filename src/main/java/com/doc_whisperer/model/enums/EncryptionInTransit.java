package com.doc_whisperer.model.enums;

public enum EncryptionInTransit {
    TLS,        // Transport Layer Security
    SSL,        // Secure Sockets Layer (deprecated, listed for legacy systems)
    DTLS,       // Datagram Transport Layer Security
    HTTPS,      // HTTP over TLS/SSL
    IPSEC,      // Internet Protocol Security
    SSH,        // Secure Shell
    NONE;       // No encryption in transit
}
