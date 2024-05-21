package com.humut.laboratoryreportingapp.repository;

import com.humut.laboratoryreportingapp.model.LabReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabReportRepository extends JpaRepository<LabReport, Long> {
    @Query("SELECT lr FROM LabReport lr WHERE lr.patient.firstName LIKE %:firstName% AND lr.patient.lastName LIKE %:lastName%")
    List<LabReport> findByPatientName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Query("SELECT lr FROM LabReport lr WHERE lr.patient.identityNumber LIKE %:identityNumber%")
    List<LabReport> findByPatientIdentityNumber(@Param("identityNumber") String identityNumber);

    @Query("SELECT lr FROM LabReport lr WHERE lr.labAssistant.firstName LIKE %:firstName% AND lr.labAssistant.lastName LIKE %:lastName%")
    List<LabReport> findByLabAssistantName(@Param("firstName") String firstName, @Param("lastName") String lastName);
}