package com.example.laboratoryreportingapp.mapper;

import com.example.laboratoryreportingapp.dto.request.LabReportRequestDto;
import com.example.laboratoryreportingapp.dto.response.LabReportResponseDto;
import com.example.laboratoryreportingapp.model.LabReport;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LabReportMapper {
    LabReportMapper INSTANCE = Mappers.getMapper(LabReportMapper.class);
    LabReport requestDtoToEntity(LabReportRequestDto labReportRequestDto);
    LabReportResponseDto entityToResponseDto(LabReport labReport);
}
