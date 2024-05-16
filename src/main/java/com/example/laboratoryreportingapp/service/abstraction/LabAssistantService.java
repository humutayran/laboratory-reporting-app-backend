package com.example.laboratoryreportingapp.service.abstraction;

import com.example.laboratoryreportingapp.dto.request.LabAssistantRequestDto;
import com.example.laboratoryreportingapp.dto.response.LabAssistantResponseDto;

import java.util.List;

public interface LabAssistantService {
    List<LabAssistantResponseDto> findAllAssistants();
    LabAssistantResponseDto addAssistant(LabAssistantRequestDto labAssistant);
    LabAssistantResponseDto getAssistant(Long id);
    void deleteAssistant(Long id);
}
