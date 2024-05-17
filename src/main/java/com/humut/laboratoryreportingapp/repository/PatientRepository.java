package com.humut.laboratoryreportingapp.repository;

import com.humut.laboratoryreportingapp.model.LabAssistant;
import com.humut.laboratoryreportingapp.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> findByIdentityNumber(String identityNumber);
}
