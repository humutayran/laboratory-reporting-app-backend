package com.humut.laboratoryreportingapp.repository;

import com.humut.laboratoryreportingapp.model.LabAssistant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LabAssistantRepository extends JpaRepository<LabAssistant, Long> {

    @Query(value = "select count(e)>0 from LabAssistant e WHERE hospitalId = :hospitalId")
    Boolean existsByHospitalId(String hospitalId);

    Optional<LabAssistant> findByHospitalId(String hospitalId);

    @Query("SELECT la FROM LabAssistant la WHERE la.firstName LIKE %:firstName% AND la.lastName LIKE %:lastName%")
    List<LabAssistant> findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);
}
