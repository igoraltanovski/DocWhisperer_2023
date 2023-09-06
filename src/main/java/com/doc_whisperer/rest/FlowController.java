package com.doc_whisperer.rest;

import com.doc_whisperer.enteties.RegisteredFlow;
import com.doc_whisperer.model.RegisterFlowRequest;
import com.doc_whisperer.services.FlowService;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("flows")
public class FlowController {

    private static final Logger logger = LoggerFactory.getLogger(FlowController.class);

    @Autowired
    private FlowService flowService;

    @PostMapping("/register")
    public ResponseEntity<RegisteredFlow> registerFlow(@RequestBody RegisterFlowRequest request) {
        logger.info("Attempting to register flow with name: {}", request.getFlowName());
        RegisteredFlow flow = flowService.registerFlow(request.getFlowName(), request.getClassInfos());
        logger.info("Successfully registered flow with ID: {}", flow.getId());
        return ResponseEntity.ok(flow);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getFlow(@PathVariable Long id) {
        logger.info("Fetching flow with ID: {}", id);
        Optional<RegisteredFlow> flow = flowService.getFlowById(id);

        if (flow.isPresent()) {
            logger.info("Found flow with ID: {}", id);
            return ResponseEntity.ok(flow.get().getClassInfoJson());
        } else {
            logger.warn("Flow with ID: {} not found", id);
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<RegisteredFlow>> getAllFlows() {
        logger.info("Fetching all registered flows");
        List<RegisteredFlow> flows = flowService.getAllFlows();
        logger.info("Retrieved {} flows", flows.size());
        return ResponseEntity.ok(flows);
    }
}
