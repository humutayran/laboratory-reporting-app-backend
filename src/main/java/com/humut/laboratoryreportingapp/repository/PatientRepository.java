package com.humut.laboratoryreportingapp.repository;

import com.humut.laboratoryreportingapp.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("SELECT p FROM Patient p WHERE p.firstName LIKE %:firstName% AND p.lastName LIKE %:lastName%")
    List<Patient> findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    Optional<Patient> findByIdentityNumber(String identityNumber);

}
