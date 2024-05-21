package com.humut.laboratoryreportingapp.mapper;

import com.humut.laboratoryreportingapp.dto.request.PatientRequestDto;
import com.humut.laboratoryreportingapp.dto.response.PatientResponseDto;
import com.humut.laboratoryreportingapp.model.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PatientMapper {
    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

    Patient requestDtoToEntity(PatientRequestDto patientRequestDto);

    PatientResponseDto entityToResponseDto(Patient patient);

    Patient responseDtoToEntity(PatientResponseDto patient);

    PatientRequestDto entityToRequestDto(Patient patient);
}