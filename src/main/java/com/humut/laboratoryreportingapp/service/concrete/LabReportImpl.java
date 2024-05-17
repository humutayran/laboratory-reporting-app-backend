package com.humut.laboratoryreportingapp.service.concrete;

import com.humut.laboratoryreportingapp.dto.request.LabReportRequestDto;
import com.humut.laboratoryreportingapp.dto.response.LabReportResponseDto;
import com.humut.laboratoryreportingapp.dto.response.PatientResponseDto;
import com.humut.laboratoryreportingapp.exception.AssistantNotFoundException;
import com.humut.laboratoryreportingapp.mapper.LabAssistantMapper;
import com.humut.laboratoryreportingapp.mapper.LabReportMapper;
import com.humut.laboratoryreportingapp.mapper.PatientMapper;
import com.humut.laboratoryreportingapp.model.LabAssistant;
import com.humut.laboratoryreportingapp.model.LabReport;
import com.humut.laboratoryreportingapp.repository.LabReportRepository;
import com.humut.laboratoryreportingapp.service.abstraction.LabAssistantService;
import com.humut.laboratoryreportingapp.service.abstraction.LabReportService;
import com.humut.laboratoryreportingapp.service.abstraction.PatientService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LabReportImpl implements LabReportService {
    private final LabReportRepository labReportRepository;
    private final LabAssistantService labAssistantService;
    private final PatientService patientService;

    public LabReportImpl(LabReportRepository labReportRepository, LabAssistantService labAssistantService, PatientService patientService) {
        this.labReportRepository = labReportRepository;
        this.labAssistantService = labAssistantService;
        this.patientService = patientService;
    }

    @Override
    public List<LabReportResponseDto> listAllReports() {
        List<LabReport> labReports = labReportRepository.findAll();
        return labReports.stream().map(LabReportMapper.INSTANCE::entityToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public LabReportResponseDto saveReport(LabReportRequestDto labReportRequestDto) {
        LabReport labReport = LabReportMapper.INSTANCE.requestDtoToEntity(labReportRequestDto);
        if (!labAssistantService.existByHospitalId(labReport.getLabAssistant().getHospitalId())) {
            throw new AssistantNotFoundException("bulamadım assitant this id :D ");
        }
        labReport.setLabAssistant(LabAssistantMapper.INSTANCE.responseDtoToEntity
                (labAssistantService.findAssistantWithHospitalId(labReport.getLabAssistant().getHospitalId())));
        Optional<PatientResponseDto> patientWithIdentityNumberOptional =
                patientService.findPatientWithIdentityNumber(labReport.getPatient().getIdentityNumber());
        if (patientWithIdentityNumberOptional.isPresent()) {
            labReport.setPatient(PatientMapper.INSTANCE.responseDtoToEntity(patientWithIdentityNumberOptional.get()));
        } else {
            patientService.addPatient(PatientMapper.INSTANCE.entityToRequestDto(labReport.getPatient()));
        }
        return LabReportMapper.INSTANCE.entityToResponseDto(labReport);
    }

    @Override
    public LabReportResponseDto findReportById(Long id) {
        return null;
    }

    @Override
    public void deleteReportById(Long id) {

    }
}
