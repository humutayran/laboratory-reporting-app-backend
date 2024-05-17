package com.humut.laboratoryreportingapp.mapper;

import com.humut.laboratoryreportingapp.dto.request.LabAssistantRequestDto;
import com.humut.laboratoryreportingapp.dto.response.LabAssistantResponseDto;
import com.humut.laboratoryreportingapp.model.LabAssistant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LabAssistantMapper {
    LabAssistantMapper INSTANCE = Mappers.getMapper(LabAssistantMapper.class);
    LabAssistant requestDtoToEntity(LabAssistantRequestDto labAssistantRequestDto);
    LabAssistantResponseDto entityToResponseDto(LabAssistant labAssistant);
    LabAssistant responseDtoToEntity(LabAssistantResponseDto labAssistantResponseDto);
}
