package com.doc_whisperer.model;

import com.doc_whisperer.model.enums.EncryptionAtRest;
import com.doc_whisperer.model.enums.EncryptionInTransit;
import com.doc_whisperer.model.enums.JWTTokenType;
import com.doc_whisperer.model.enums.MutualTLSState;
import com.doc_whisperer.model.enums.OAuthOptions;
import com.doc_whisperer.model.enums.SSOProtocol;
import com.doc_whisperer.model.enums.UserRole;
import lombok.Data;

@Data
public class SecurityAuthOptions {

    private OAuthOptions oAuthOptions;
    private JWTTokenType jWTTokenType;
    private SSOProtocol sSOProtocol;
    private EncryptionAtRest encryptionAtRest;
    private EncryptionInTransit encryptionInTransit;
    private UserRole userRole;
    private MutualTLSState mutualTLSState;

}
