package com.humut.laboratoryreportingapp.repository;

import com.humut.laboratoryreportingapp.model.LabReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabReportRepository extends JpaRepository<LabReport, Long > {
}