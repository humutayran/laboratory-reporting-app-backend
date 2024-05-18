package com.humut.laboratoryreportingapp.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LabAssistantResponseDto {
    private Long id;

    private String firstName;
    private String lastName;
    private String hospitalId;
    private List<LabReportResponseDto> labReports;
}
