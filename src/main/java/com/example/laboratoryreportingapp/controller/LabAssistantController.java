package com.example.laboratoryreportingapp.controller;

import com.example.laboratoryreportingapp.dto.request.LabAssistantRequestDto;
import com.example.laboratoryreportingapp.dto.response.LabAssistantResponseDto;
import com.example.laboratoryreportingapp.service.abstraction.LabAssistantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@CrossOrigin
@RequestMapping("/lab-assistant")
public class LabAssistantController {
    private LabAssistantService labAssistantService;

    public LabAssistantController(LabAssistantService labAssistantService) {
        this.labAssistantService = labAssistantService;
    }

    @GetMapping
    public ResponseEntity<List<LabAssistantResponseDto>> getAllAssistants() {
        List<LabAssistantResponseDto> labAssistants = labAssistantService.findAllAssistants();
        return new ResponseEntity<>(labAssistants, OK);
    }

    @PostMapping
    public ResponseEntity<LabAssistantResponseDto> addAssistant(@RequestBody LabAssistantRequestDto labAssistant) {
        LabAssistantResponseDto labAssistantResp = labAssistantService.addAssistant(labAssistant);
        return new ResponseEntity<>(labAssistantResp, CREATED);
    }
}
