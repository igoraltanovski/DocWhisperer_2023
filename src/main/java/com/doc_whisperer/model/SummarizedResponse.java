package com.doc_whisperer.model;

public class SummarizedResponse {

    private String category;
    private String summarization;

    public SummarizedResponse() {
    }

    public SummarizedResponse(String category, String summarization) {
        this.category = category;
        this.summarization = summarization;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSummarization() {
        return summarization;
    }

    public void setSummarization(String summarization) {
        this.summarization = summarization;
    }

    @Override
    public String toString() {
        return "feature {" +
                "category='" + category + '\'' +
                ", summarization='" + summarization + '\'' +
                '}';
    }
}
