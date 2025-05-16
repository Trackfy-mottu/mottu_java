package com.fiap.sprint1_java2025.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.fiap.sprint1_java2025.model.Pending;

public interface PendingRepository extends JpaRepository<Pending, Long>, JpaSpecificationExecutor<Pending> {
    Page<Pending> findByDescriptionContainingIgnoringCase(String description, Pageable pageable);
}
