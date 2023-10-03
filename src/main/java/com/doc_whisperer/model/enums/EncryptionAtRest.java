package com.doc_whisperer.model.enums;

public enum EncryptionAtRest {
    AES_256,    // Advanced Encryption Standard (256-bit)
    TDE,        // Transparent Data Encryption
    KMS,        // Key Management Service
    HSM,        // Hardware Security Module
    NONE;       // No encryption
}
