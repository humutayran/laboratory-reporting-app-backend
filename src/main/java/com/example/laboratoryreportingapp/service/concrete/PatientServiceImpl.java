package com.example.laboratoryreportingapp.service.concrete;

import com.example.laboratoryreportingapp.dto.request.PatientRequestDto;
import com.example.laboratoryreportingapp.dto.response.PatientResponseDto;
import com.example.laboratoryreportingapp.mapper.PatientMapper;
import com.example.laboratoryreportingapp.model.Patient;
import com.example.laboratoryreportingapp.repository.PatientRepository;
import com.example.laboratoryreportingapp.service.abstraction.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {
    PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<PatientResponseDto> findAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream().map(PatientMapper.INSTANCE::entityToResponseDto).collect(Collectors.toList());
    }

    @Override
    public PatientResponseDto getPatient(Long id) {
        Patient patient = getPatientById(id);
        return PatientMapper.INSTANCE.entityToResponseDto(patient);
    }

    @Override
    public PatientResponseDto addPatient(PatientRequestDto patientRequestDto) {
        Patient patient = PatientMapper.INSTANCE.requestDtoToEntity(patientRequestDto);
        patientRepository.save(patient);
        return PatientMapper.INSTANCE.entityToResponseDto(patient);
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    protected Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElseThrow();
    }
}
