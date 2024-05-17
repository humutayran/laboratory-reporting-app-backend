package com.humut.laboratoryreportingapp.controller;

import com.humut.laboratoryreportingapp.dto.request.LabReportRequestDto;
import com.humut.laboratoryreportingapp.dto.response.LabReportResponseDto;
import com.humut.laboratoryreportingapp.service.abstraction.LabReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@CrossOrigin
@RequestMapping("/reports")
public class LabReportController {
    LabReportService labReportService;

    public LabReportController(LabReportService labReportService) {
        this.labReportService = labReportService;
    }

    @GetMapping
    public ResponseEntity<List<LabReportResponseDto>> getAllReports() {
        List<LabReportResponseDto> reports = labReportService.listAllReports();
        return new ResponseEntity<>(reports, OK);
    }

    @PostMapping
    public ResponseEntity<LabReportResponseDto> saveReport(@RequestBody LabReportRequestDto labReport) {
        LabReportResponseDto saved = labReportService.saveReport(labReport);
        return new ResponseEntity<>(saved, CREATED);
    }


}
