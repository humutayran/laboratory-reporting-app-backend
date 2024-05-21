package com.humut.laboratoryreportingapp.controller;

import com.humut.laboratoryreportingapp.dto.request.PatientRequestDto;
import com.humut.laboratoryreportingapp.dto.response.PatientResponseDto;
import com.humut.laboratoryreportingapp.exception.PatientNotFoundException;
import com.humut.laboratoryreportingapp.service.abstraction.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

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
    public ResponseEntity<PatientResponseDto> getPatientById(@PathVariable Long patientId) {
        PatientResponseDto patient = patientService.getPatient(patientId);
        return new ResponseEntity<>(patient, OK);
    }

    @DeleteMapping("/{patientId}")
    public ResponseEntity<String> deletePatient(@PathVariable Long patientId) {
        patientService.deletePatient(patientId);
        return new ResponseEntity<>("Patient deleted successfully.", OK);
    }

    @GetMapping("/searchPatientsByName")
    public ResponseEntity<List<PatientResponseDto>> searchPatientsByName(@RequestParam String firstName, @RequestParam String lastName) {
        List<PatientResponseDto> responseDtos = patientService.searchPatientsByName(firstName, lastName);
        return ResponseEntity.ok(responseDtos);
    }

    @GetMapping("/searchPatientByIdentityNumber")
    public ResponseEntity<Optional<PatientResponseDto>> searchPatientByIdentityNumber(
            @RequestParam String identityNumber) {
        Optional<PatientResponseDto> responseDtos = patientService.findPatientWithIdentityNumber(identityNumber);
        if (responseDtos.isPresent()) {
            return ResponseEntity.ok(responseDtos);
        } else {
            throw new PatientNotFoundException("Patient not found with this identity number: " + identityNumber);
        }
    }
}
