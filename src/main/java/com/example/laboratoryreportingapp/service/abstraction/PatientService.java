package com.example.laboratoryreportingapp.service.abstraction;

import com.example.laboratoryreportingapp.dto.request.PatientRequestDto;
import com.example.laboratoryreportingapp.dto.response.PatientResponseDto;

import java.util.List;

public interface PatientService {
    List<PatientResponseDto> findAllPatients();
    PatientResponseDto getPatient(Long id);
    PatientResponseDto addPatient(PatientRequestDto patientRequestDto);
    void deletePatient(Long id);
}
