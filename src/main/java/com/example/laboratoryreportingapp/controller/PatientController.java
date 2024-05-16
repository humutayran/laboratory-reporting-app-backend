package com.example.laboratoryreportingapp.controller;

import com.example.laboratoryreportingapp.dto.request.PatientRequestDto;
import com.example.laboratoryreportingapp.dto.response.PatientResponseDto;
import com.example.laboratoryreportingapp.service.abstraction.PatientService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/patient")
@CrossOrigin
public class PatientController {
    PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<List<PatientResponseDto>> listPatients() {
        List<PatientResponseDto> patients = patientService.findAllPatients();
        return new ResponseEntity<>(patients, OK);
    }

    @PostMapping
    public ResponseEntity<PatientResponseDto> addPatient(@RequestBody PatientRequestDto patientRequestDto) {
        PatientResponseDto patient = patientService.addPatient(patientRequestDto);
        return new ResponseEntity<>(patient, CREATED);
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<PatientResponseDto> getPatient(@PathVariable Long patientId) {
        PatientResponseDto patient = patientService.getPatient(patientId);
        return new ResponseEntity<>(patient, OK);
    }

    @DeleteMapping("/{patientId}")
    public ResponseEntity<String> deletePatient(@PathVariable Long patientId) {
        patientService.deletePatient(patientId);
        return new ResponseEntity<>("Patient deleted successfully.", OK);
    }
}
