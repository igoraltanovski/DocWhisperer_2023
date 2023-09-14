package com.doc_whisperer.entities;

import com.doc_whisperer.model.enums.DocumentationType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "documentation_template")
public class DocumentationTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DocumentationType type;

    private String templateSystem;

    private String templateUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DocumentationType getType() {
        return type;
    }

    public void setType(DocumentationType type) {
        this.type = type;
    }

    public String getTemplateSystem() {
        return templateSystem;
    }

    public void setTemplateSystem(String templateSystem) {
        this.templateSystem = templateSystem;
    }

    public String getTemplateUser() {
        return templateUser;
    }

    public void setTemplateUser(String templateUser) {
        this.templateUser = templateUser;
    }

    public DocumentationTemplate() {
    }

    public DocumentationTemplate(Long id, DocumentationType type, String templateSystem, String templateUser) {
        this.id = id;
        this.type = type;
        this.templateSystem = templateSystem;
        this.templateUser = templateUser;
    }
}