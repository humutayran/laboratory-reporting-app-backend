package com.humut.laboratoryreportingapp.service.abstraction;

import com.humut.laboratoryreportingapp.dto.request.LabReportRequestDto;
import com.humut.laboratoryreportingapp.dto.response.LabReportResponseDto;
import com.humut.laboratoryreportingapp.model.LabReport;

import java.util.List;


public interface LabReportService {
    List<LabReportResponseDto> listAllReports();
    LabReportResponseDto saveReport(LabReportRequestDto labReportRequestDto);
    LabReportResponseDto findReportById(Long id);
    void deleteReportById(Long id);
    LabReportResponseDto updateReport(Long labReportId, LabReportRequestDto labReportRequestDto);
    List<LabReportResponseDto> searchReportsByPatientName(String firstName, String lastName);

    List<LabReportResponseDto> searchReportsByPatientIdentityNumber(String identityNumber);
}
