package com.doc_whisperer.repositories;

import com.doc_whisperer.enteties.RegisteredFlow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisteredFlowRepository extends JpaRepository<RegisteredFlow, Long> {
}
