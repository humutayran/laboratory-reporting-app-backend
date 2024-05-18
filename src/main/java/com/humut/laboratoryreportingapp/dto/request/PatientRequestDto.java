package com.humut.laboratoryreportingapp.dto.request;

import com.humut.laboratoryreportingapp.dto.response.LabReportResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PatientRequestDto {
    private Long id;

    private String firstName;
    private String lastName;
    private String identityNumber;
    private List<LabReportResponseDto> labReports;
}
