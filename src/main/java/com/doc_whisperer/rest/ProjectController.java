package com.doc_whisperer.rest;

import com.doc_whisperer.model.ClassInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.doc_whisperer.services.ProjectService;

import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/classes")
    public List<ClassInfo> getClassesForProject(@RequestParam String projectName) {
        return projectService.getClassesForProject(projectName);
    }

    @GetMapping("/projects")
    public List<String> getProjects() {
        return projectService.getProjects();
    }
}
