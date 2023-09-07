package com.doc_whisperer.model;


import com.doc_whisperer.model.enums.DocumentationType;

import java.util.Objects;

public class DocumentationKey {
    private Long flowId;
    private DocumentationType docType;

    public DocumentationKey(Long flowId, DocumentationType docType) {
        this.flowId = flowId;
        this.docType = docType;
    }

    // Override equals() and hashCode() for proper Map key behavior
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentationKey that = (DocumentationKey) o;
        return Objects.equals(flowId, that.flowId) &&
                docType == that.docType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(flowId, docType);
    }
}
