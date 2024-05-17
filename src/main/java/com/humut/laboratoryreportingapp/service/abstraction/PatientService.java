package com.humut.laboratoryreportingapp.service.abstraction;

import com.humut.laboratoryreportingapp.dto.request.PatientRequestDto;
import com.humut.laboratoryreportingapp.dto.response.PatientResponseDto;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    List<PatientResponseDto> findAllPatients();
    PatientResponseDto getPatient(Long id);
    PatientResponseDto addPatient(PatientRequestDto patientRequestDto);
    void deletePatient(Long id);
    Optional<PatientResponseDto> findPatientWithIdentityNumber(String identityNumber);
}
