package com.humut.laboratoryreportingapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LabReportResponseDto {
    private Long id;

    private String fileNumber;
    private String diagnosisTitle;
    private String diagnosisDetails;
    private Date dateGiven;
    private String photoPath;
    private String labAssistantFirstName;
    private String labAssistantLastName;
    private String labAssistantHospitalId;
    private String patientFirstName;
    private String patientLastName;
    private String patientIdentityNumber;
    private LocalDateTime modifiedDate;
}
