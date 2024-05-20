package com.humut.laboratoryreportingapp.service.concrete;

import com.humut.laboratoryreportingapp.dto.request.PatientRequestDto;
import com.humut.laboratoryreportingapp.dto.response.LabReportResponseDto;
import com.humut.laboratoryreportingapp.dto.response.PatientResponseDto;
import com.humut.laboratoryreportingapp.mapper.LabReportMapper;
import com.humut.laboratoryreportingapp.mapper.PatientMapper;
import com.humut.laboratoryreportingapp.model.Patient;
import com.humut.laboratoryreportingapp.repository.PatientRepository;
import com.humut.laboratoryreportingapp.service.abstraction.LabReportService;
import com.humut.laboratoryreportingapp.service.abstraction.PatientService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {
    PatientRepository patientRepository;

    @Override
    public List<PatientResponseDto> findAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream()
                .map(patient -> {
                    PatientResponseDto dto = PatientMapper.INSTANCE.entityToResponseDto(patient);
                    dto.setLabReports(patient.getLabReports().stream()
                            .map(labReport -> {
                                LabReportResponseDto labReportDto = LabReportMapper.INSTANCE.entityToResponseDto(labReport);
                                return labReportDto;
                            })
                            .collect(Collectors.toList()));
                    return dto;
                })
                .collect(Collectors.toList());
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

    @Override
    public Optional<PatientResponseDto> findPatientWithIdentityNumber(String identityNumber) {
        Optional<Patient> patientOptional = patientRepository.findByIdentityNumber(identityNumber);

        if (patientOptional.isPresent()) {
            PatientResponseDto patientResponseDto = PatientMapper.INSTANCE.entityToResponseDto(patientOptional.get());
            return Optional.ofNullable(patientResponseDto);
        } else {
            return Optional.empty();
        }
    }

    protected Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElseThrow();
    }
}
