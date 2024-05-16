package com.example.laboratoryreportingapp.mapper;

import com.example.laboratoryreportingapp.dto.request.PatientRequestDto;
import com.example.laboratoryreportingapp.dto.response.PatientResponseDto;
import com.example.laboratoryreportingapp.model.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PatientMapper {
    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);
    Patient requestDtoToEntity(PatientRequestDto patientRequestDto);
    PatientResponseDto entityToResponseDto(Patient patient);
}