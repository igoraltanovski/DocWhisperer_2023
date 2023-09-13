package com.doc_whisperer.rest;

import com.doc_whisperer.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.doc_whisperer.services.ProjectService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projects")
@CrossOrigin(origins = "http://localhost:4200")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("{projectId}")
    public Optional<Project> getProjectById(@PathVariable Long projectId) {
        return projectService.getProjectById(projectId);
    }

    @GetMapping
    public List<Project> getProjects() {
        return projectService.getProjects();
    }
}
