package com.humut.laboratoryreportingapp.service.abstraction;

import com.humut.laboratoryreportingapp.dto.request.LabReportRequestDto;
import com.humut.laboratoryreportingapp.dto.response.LabReportResponseDto;

import java.util.List;


public interface LabReportService {
    List<LabReportResponseDto> listAllReports();
    LabReportResponseDto saveReport(LabReportRequestDto labReportRequestDto);
    LabReportResponseDto findReportById(Long id);
    void deleteReportById(Long id);
}
