package com.doc_whisperer.rest;

import com.doc_whisperer.entities.RegisteredFlow;
import com.doc_whisperer.model.FlowProjectResponse;
import com.doc_whisperer.model.RegisterFlowRequest;
import com.doc_whisperer.model.enums.DocumentationType;
import com.doc_whisperer.services.DocumentationService;
import com.doc_whisperer.services.FlowService;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("flows")
@CrossOrigin(origins = "http://localhost:4200")
public class FlowController {

    private static final Logger logger = LoggerFactory.getLogger(FlowController.class);

    @Autowired
    private FlowService flowService;

    @Autowired
    private DocumentationService documentationService;

    @PostMapping("/register")
    public ResponseEntity<RegisteredFlow> registerFlow(@RequestBody RegisterFlowRequest request) {
        logger.info("Attempting to register flow with name: {}", request.getFlowName());
        RegisteredFlow flow = flowService.registerFlow(request.getProjectId(),request.getFlowName(), request.getClassInfos());
        logger.info("Successfully registered flow with ID: {}", flow.getId());
        return ResponseEntity.ok(flow);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<RegisteredFlow> updateFlow(@PathVariable Long id, @RequestBody RegisterFlowRequest request) {
        logger.info("Attempting to update flow with name: {}", request.getFlowName());
        RegisteredFlow flow = flowService.updateFlow(id,request.getProjectId(),request.getFlowName(), request.getClassInfos());
        logger.info("Successfully update flow with ID: {}", flow.getId());
        return ResponseEntity.ok(flow);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity deleteFlow(@PathVariable Long id, @RequestBody RegisterFlowRequest request) {
        try {
            logger.info("Attempting to delete flow with name: {}", request.getFlowName());
            flowService.deleteFlow(id);
            logger.info("Successfully deleted flow with ID: {}", id);
            return ResponseEntity.noContent().build(); // Return 204 No Content on success.
        } catch (Exception e) {
            logger.error("Error deleting flow with ID: {}", id, e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Return an error response on failure.
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<RegisteredFlow> getFlow(@PathVariable Long id) {
        logger.info("Fetching flow with ID: {}", id);
        Optional<RegisteredFlow> flow = flowService.getFlowById(id);

        if (flow.isPresent()) {
            logger.info("Found flow with ID: {}", id);
            return ResponseEntity.ok(flow.get());
        } else {
            logger.warn("Flow with ID: {} not found", id);
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<FlowProjectResponse>> getAllFlows() {
        logger.info("Fetching all registered flows");
        List<FlowProjectResponse> flows = flowService.getAllFlows();
        logger.info("Retrieved {} flows", flows.size());
        return ResponseEntity.ok(flows);
    }

    @GetMapping("/generate")
    public ResponseEntity<String> getFlowDetails(@RequestParam Long flowID,
                                                 @RequestParam DocumentationType docType) {
        String bigText = documentationService.fetchDocumentation(flowID, docType);

        return ResponseEntity.ok(bigText);
    }

    @GetMapping("/generate/live")
    public ResponseEntity<String> generateDocumentation(@RequestParam Long flowId, @RequestParam DocumentationType type) {
        System.out.println("generateDocumentation " + flowId + " " + type);
        String bigText = documentationService.generateDocumentation(flowId, type);
        return ResponseEntity.ok(bigText);
    }
}
