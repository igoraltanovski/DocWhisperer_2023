package com.doc_whisperer.entities;

import javax.persistence.*;

@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;
    private String projectName;
    private String classInfoJson;

    public Project() {
    }

    public Project(Long projectId, String projectName, String classInfoJson) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.classInfoJson = classInfoJson;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getClassInfoJson() {
        return classInfoJson;
    }

    public void setClassInfoJson(String classInfoJson) {
        this.classInfoJson = classInfoJson;
    }
}
