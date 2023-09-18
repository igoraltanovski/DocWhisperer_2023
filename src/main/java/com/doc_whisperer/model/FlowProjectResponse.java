package com.doc_whisperer.model;

public class FlowProjectResponse {

    private Long id;
    private Long projectId;
    private String flowName;
    private String classInfoJsonFromFlow;
    private String projectName;
    private String classInfoJsonFromProject;

    public FlowProjectResponse() {
    }

    public FlowProjectResponse(Long id, Long projectId, String flowName, String classInfoJsonFromFlow, String projectName, String classInfoJsonFromProject) {
        this.id = id;
        this.projectId = projectId;
        this.flowName = flowName;
        this.classInfoJsonFromFlow = classInfoJsonFromFlow;
        this.projectName = projectName;
        this.classInfoJsonFromProject = classInfoJsonFromProject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getFlowName() {
        return flowName;
    }

    public void setFlowName(String flowName) {
        this.flowName = flowName;
    }

    public String getClassInfoJsonFromFlow() {
        return classInfoJsonFromFlow;
    }

    public void setClassInfoJsonFromFlow(String classInfoJsonFromFlow) {
        this.classInfoJsonFromFlow = classInfoJsonFromFlow;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getClassInfoJsonFromProject() {
        return classInfoJsonFromProject;
    }

    public void setClassInfoJsonFromProject(String classInfoJsonFromProject) {
        this.classInfoJsonFromProject = classInfoJsonFromProject;
    }


}
