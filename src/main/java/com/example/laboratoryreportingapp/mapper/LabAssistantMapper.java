package com.example.laboratoryreportingapp.mapper;

import com.example.laboratoryreportingapp.dto.request.LabAssistantRequestDto;
import com.example.laboratoryreportingapp.dto.response.LabAssistantResponseDto;
import com.example.laboratoryreportingapp.model.LabAssistant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LabAssistantMapper {
    LabAssistantMapper INSTANCE = Mappers.getMapper(LabAssistantMapper.class);
    LabAssistant requestDtoToEntity(LabAssistantRequestDto labAssistantRequestDto);
    LabAssistantResponseDto entityToResponseDto(LabAssistant labAssistant);
}
