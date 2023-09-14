package com.doc_whisperer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.doc_whisperer.model.enums.DocumentationType;
import com.doc_whisperer.entities.DocumentationTemplate;

import java.util.Optional;

@Repository
public interface DocumentationTemplateRepository extends JpaRepository<DocumentationTemplate, Long> {
    Optional<DocumentationTemplate> findByType(DocumentationType type);
}
