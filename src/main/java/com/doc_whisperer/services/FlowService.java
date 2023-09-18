package com.doc_whisperer.services;

import com.doc_whisperer.model.FlowProjectResponse;
import com.doc_whisperer.repositories.RegisteredFlowRepository;
import com.doc_whisperer.entities.RegisteredFlow;
import com.doc_whisperer.model.ClassInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlowService {

    @Autowired
    private RegisteredFlowRepository flowRepository;

    public RegisteredFlow registerFlow(Long projectId, String flowName, List<ClassInfo> classInfos) {
        String json = convertToJson(classInfos);
        RegisteredFlow flow = new RegisteredFlow();
        flow.setFlowName(flowName);
        flow.setClassInfoJson(json);
        flow.setProjectId(projectId);
        return flowRepository.save(flow);
    }

    public RegisteredFlow updateFlow(Long flowId, Long projectId, String flowName, List<ClassInfo> classInfos) {
        if(flowRepository.findById(flowId).isPresent()) {
            String json = convertToJson(classInfos);
            RegisteredFlow flow = new RegisteredFlow();
            flow.setFlowName(flowName);
            flow.setClassInfoJson(json);
            flow.setProjectId(projectId);
            flow.setId(flowId);
            return flowRepository.save(flow);
        }
        return null;
    }

    public void deleteFlow(Long flowId){
        flowRepository.deleteById(flowId);
    }
    private String convertToJson(List<ClassInfo> classInfos) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(classInfos);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting to JSON", e);
        }
    }

    public Optional<RegisteredFlow> getFlowById(Long id) {
        return flowRepository.findById(id);
    }

    public List<FlowProjectResponse> getAllFlows() {
        return flowRepository.fetchFlowWithProjectDetails();
    }
}
