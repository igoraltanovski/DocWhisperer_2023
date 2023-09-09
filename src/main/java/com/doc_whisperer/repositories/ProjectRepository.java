package com.doc_whisperer.repositories;

import com.doc_whisperer.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
