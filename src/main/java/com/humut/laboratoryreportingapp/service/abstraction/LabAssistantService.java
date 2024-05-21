package com.humut.laboratoryreportingapp.service.abstraction;

import com.humut.laboratoryreportingapp.dto.request.LabAssistantRequestDto;
import com.humut.laboratoryreportingapp.dto.response.LabAssistantResponseDto;

import java.util.List;

public interface LabAssistantService {
    List<LabAssistantResponseDto> findAllAssistants();

    LabAssistantResponseDto addAssistant(LabAssistantRequestDto labAssistant);

    LabAssistantResponseDto getAssistant(Long id);

    void deleteAssistant(Long id);

    boolean existByHospitalId(String hospitalId);

    LabAssistantResponseDto findAssistantWithHospitalId(String hospitalId);

    List<LabAssistantResponseDto> searchLabAssistantsByName(String firstName, String lastName);
}
