package com.doc_whisperer.repositories;

import com.doc_whisperer.entities.RegisteredFlow;
import com.doc_whisperer.model.FlowProjectResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RegisteredFlowRepository extends JpaRepository<RegisteredFlow, Long> {

        @Query("SELECT new com.yourpackage.FlowProjectResponse(" +
                "rf.id, " +
                "rf.projectId, " +
                "rf.flowName, " +
                "rf.classInfoJson, " +
                "p.projectName, " +
                "p.classInfoJson) " +
                "FROM RegisteredFlow rf " +
                "JOIN Project p ON rf.projectId = p.projectId")
        List<FlowProjectResponse> fetchFlowWithProjectDetails();

}
