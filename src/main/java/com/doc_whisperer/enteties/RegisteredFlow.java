package com.doc_whisperer.enteties;

import javax.persistence.*;

@Entity
@Table(name = "registered_flow")
public class RegisteredFlow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long projectId;

    private String flowName;

    @Lob  // large object
    private String classInfoJson;  // this will store the JSON representation of list of ClassInfo


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlowName() {
        return flowName;
    }

    public void setFlowName(String flowName) {
        this.flowName = flowName;
    }

    public String getClassInfoJson() {
        return classInfoJson;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public void setClassInfoJson(String classInfoJson) {
        this.classInfoJson = classInfoJson;
    }
}