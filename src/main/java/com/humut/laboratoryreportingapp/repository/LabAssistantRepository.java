package com.humut.laboratoryreportingapp.repository;

import com.humut.laboratoryreportingapp.model.LabAssistant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LabAssistantRepository extends JpaRepository<LabAssistant, Long> {

    @Query(value = "select count(e)>0 from LabAssistant e WHERE hospitalId = :hospitalId")
    Boolean existsByHospitalId(String hospitalId);

    Optional<LabAssistant> findByHospitalId(String hospitalId);
}
