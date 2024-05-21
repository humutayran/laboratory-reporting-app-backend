package com.humut.laboratoryreportingapp.service.concrete;

import com.humut.laboratoryreportingapp.dto.request.LabReportRequestDto;
import com.humut.laboratoryreportingapp.dto.request.PatientRequestDto;
import com.humut.laboratoryreportingapp.dto.response.LabAssistantResponseDto;
import com.humut.laboratoryreportingapp.dto.response.LabReportResponseDto;
import com.humut.laboratoryreportingapp.dto.response.PatientResponseDto;
import com.humut.laboratoryreportingapp.exception.AssistantNotFoundException;
import com.humut.laboratoryreportingapp.mapper.LabAssistantMapper;
import com.humut.laboratoryreportingapp.mapper.LabReportMapper;
import com.humut.laboratoryreportingapp.mapper.PatientMapper;
import com.humut.laboratoryreportingapp.model.LabAssistant;
import com.humut.laboratoryreportingapp.model.LabReport;
import com.humut.laboratoryreportingapp.model.Patient;
import com.humut.laboratoryreportingapp.repository.LabReportRepository;
import com.humut.laboratoryreportingapp.service.abstraction.LabAssistantService;
import com.humut.laboratoryreportingapp.service.abstraction.LabReportService;
import com.humut.laboratoryreportingapp.service.abstraction.PatientService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LabReportServiceImpl implements LabReportService {
    private final LabReportRepository labReportRepository;
    private final LabAssistantService labAssistantService;
    private final PatientService patientService;

    @Override
    public List<LabReportResponseDto> listAllReports() {
        List<LabReport> labReports = labReportRepository.findAll();
        return labReports.stream().map(LabReportMapper.INSTANCE::entityToResponseDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public LabReportResponseDto saveReport(LabReportRequestDto labReportRequestDto) {
        LabReport labReport = LabReportMapper.INSTANCE.requestDtoToEntity(labReportRequestDto);

        validateAndSetLabAssistant(labReport);
        handlePatient(labReport);

        labReport = labReportRepository.save(labReport);
        return LabReportMapper.INSTANCE.entityToResponseDto(labReport);
    }

    private void validateAndSetLabAssistant(LabReport labReport) {
        String hospitalId = labReport.getLabAssistant().getHospitalId();

        if (!labAssistantService.existByHospitalId(hospitalId)) {
            throw new AssistantNotFoundException("Assistant not found with hospital ID: " + hospitalId);
        }

        LabAssistantResponseDto assistantDto = labAssistantService.findAssistantWithHospitalId(hospitalId);
        LabAssistant labAssistant = LabAssistantMapper.INSTANCE.responseDtoToEntity(assistantDto);
        labReport.setLabAssistant(labAssistant);
    }

    private void handlePatient(LabReport labReport) {
        String identityNumber = labReport.getPatient().getIdentityNumber();

        Optional<PatientResponseDto> patientOptional = patientService.findPatientWithIdentityNumber(identityNumber);

        if (patientOptional.isPresent()) {
            setExistingPatient(labReport, patientOptional.get());
        } else {
            addNewPatient(labReport);
        }
    }

    private void setExistingPatient(LabReport labReport, PatientResponseDto patientDto) {
        Patient patient = PatientMapper.INSTANCE.responseDtoToEntity(patientDto);
        labReport.setPatient(patient);
    }

    private void addNewPatient(LabReport labReport) {
        PatientRequestDto patientRequestDto = PatientMapper.INSTANCE.entityToRequestDto(labReport.getPatient());
        patientService.addPatient(patientRequestDto);
    }


    @Override
    public LabReportResponseDto findReportById(Long id) {
        LabReport labReport = labReportRepository.findById(id).orElseThrow();
        return LabReportMapper.INSTANCE.entityToResponseDto(labReport);
    }

    @Override
    @Transactional
    public void deleteReportById(Long id) {
        LabReport labReport = labReportRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("LabReport not found"));

        labReport.disassociate();
        labReportRepository.deleteById(id);
    }

    @Override
    public LabReportResponseDto updateReport(Long labReportId, LabReportRequestDto labReportRequestDto) {
        LabReport labReportFromDb = labReportRepository.findById(labReportId).orElseThrow();
        LabReport requestedReport = LabReportMapper.INSTANCE.requestDtoToEntity(labReportRequestDto);
        updateLabReportField(labReportFromDb, requestedReport);
        labReportRepository.save(labReportFromDb);
        return LabReportMapper.INSTANCE.entityToResponseDto(labReportFromDb);
    }

    private void updateLabReportField(LabReport labReportFromDb, LabReport requestedReport) {
        handlePatient(requestedReport);
        validateAndSetLabAssistant(requestedReport);

        labReportFromDb.setPatient(requestedReport.getPatient());
        labReportFromDb.setLabAssistant(requestedReport.getLabAssistant());
        labReportFromDb.setFileNumber(requestedReport.getFileNumber());
        labReportFromDb.setDiagnosisTitle(requestedReport.getDiagnosisTitle());
        labReportFromDb.setDiagnosisDetails(requestedReport.getDiagnosisDetails());
        labReportFromDb.setPhotoPath(requestedReport.getPhotoPath());
        labReportFromDb.setModifiedDate(LocalDateTime.now());
    }
}
