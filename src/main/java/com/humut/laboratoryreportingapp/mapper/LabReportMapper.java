package com.humut.laboratoryreportingapp.mapper;

import com.humut.laboratoryreportingapp.dto.request.LabReportRequestDto;
import com.humut.laboratoryreportingapp.dto.response.LabReportResponseDto;
import com.humut.laboratoryreportingapp.model.LabReport;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LabReportMapper {
    LabReportMapper INSTANCE = Mappers.getMapper(LabReportMapper.class);
    LabReport requestDtoToEntity(LabReportRequestDto labReportRequestDto);
    LabReportResponseDto entityToResponseDto(LabReport labReport);
}
