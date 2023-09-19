package com.doc_whisperer.model;

import java.util.List;

public class ArchitectureProposalResponse {

    private List<SummarizedResponse> summarizedResponses;
    private String proposedArchitecture;

    public ArchitectureProposalResponse() {
    }

    public ArchitectureProposalResponse(List<SummarizedResponse> summarizedResponses, String proposedArchitecture) {
        this.summarizedResponses = summarizedResponses;
        this.proposedArchitecture = proposedArchitecture;
    }

    public List<SummarizedResponse> getSummarizedResponses() {
        return summarizedResponses;
    }

    public void setSummarizedResponses(List<SummarizedResponse> summarizedResponses) {
        this.summarizedResponses = summarizedResponses;
    }

    public String getProposedArchitecture() {
        return proposedArchitecture;
    }

    public void setProposedArchitecture(String proposedArchitecture) {
        this.proposedArchitecture = proposedArchitecture;
    }
}
