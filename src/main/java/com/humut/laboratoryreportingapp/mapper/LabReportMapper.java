package com.humut.laboratoryreportingapp.mapper;

import com.humut.laboratoryreportingapp.dto.request.LabReportRequestDto;
import com.humut.laboratoryreportingapp.dto.response.LabReportResponseDto;
import com.humut.laboratoryreportingapp.model.LabReport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LabReportMapper {
    LabReportMapper INSTANCE = Mappers.getMapper(LabReportMapper.class);
    LabReport requestDtoToEntity(LabReportRequestDto labReportRequestDto);
    @Mapping(source = "labAssistant.firstName", target = "labAssistantFirstName")
    @Mapping(source = "labAssistant.lastName", target = "labAssistantLastName")
    @Mapping(source = "labAssistant.hospitalId", target = "labAssistantHospitalId")
    @Mapping(source = "patient.firstName", target = "patientFirstName")
    @Mapping(source = "patient.lastName", target = "patientLastName")
    @Mapping(source = "patient.identityNumber", target = "patientIdentityNumber")
    LabReportResponseDto entityToResponseDto(LabReport labReport);
}
