package com.humut.laboratoryreportingapp.controller;

import com.humut.laboratoryreportingapp.dto.request.LabReportRequestDto;
import com.humut.laboratoryreportingapp.dto.response.LabReportResponseDto;
import com.humut.laboratoryreportingapp.service.abstraction.LabReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

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

    @GetMapping("/{labReportId}")
    public ResponseEntity<LabReportResponseDto> getLabReportById(@PathVariable Long labReportId) {
        LabReportResponseDto labReportResponseDto = labReportService.findReportById(labReportId);
        return new ResponseEntity<>(labReportResponseDto, OK);
    }

    @DeleteMapping("/{labReportId}")
    public ResponseEntity<String> deleteLabReportById(@PathVariable Long labReportId) {
        labReportService.deleteReportById(labReportId);
        return new ResponseEntity<>("Report has been removed successfully", OK);
    }

    @PutMapping("/{labReportId}")
    public ResponseEntity<LabReportResponseDto> updateReport(@PathVariable Long labReportId, @RequestBody LabReportRequestDto labReportRequestDto) {
        LabReportResponseDto labReportResponseDto = labReportService.updateReport(labReportId, labReportRequestDto);
        return new ResponseEntity<>(labReportResponseDto, OK);
    }

    @GetMapping("/searchReports")
    public ResponseEntity<List<LabReportResponseDto>> searchReports(@RequestParam String firstName, @RequestParam String lastName) {
        List<LabReportResponseDto> reports = labReportService.searchReportsByPatientName(firstName, lastName);
        return ResponseEntity.ok(reports);
    }

    @GetMapping("/searchReportsByIdentityNumber")
    public ResponseEntity<List<LabReportResponseDto>> searchReportsByIdentityNumber(@RequestParam String identityNumber) {
        List<LabReportResponseDto> responseDtos = labReportService.searchReportsByPatientIdentityNumber(identityNumber);
        return ResponseEntity.ok(responseDtos);
    }

    @GetMapping("/searchReportsByLabAssistantName")
    public ResponseEntity<List<LabReportResponseDto>> searchReportsByLabAssistantName(@RequestParam String firstName, @RequestParam String lastName) {
        List<LabReportResponseDto> responseDtos = labReportService.searchReportsByLabAssistantName(firstName, lastName);
        return ResponseEntity.ok(responseDtos);
    }
}