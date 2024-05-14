package com.example.laboratoryreportingapp.repository;

import com.example.laboratoryreportingapp.model.LabAssistant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabAssistantRepository extends JpaRepository<LabAssistant, Long> {
}
