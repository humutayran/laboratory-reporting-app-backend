package com.humut.laboratoryreportingapp.dto.request;

import com.humut.laboratoryreportingapp.dto.response.LabReportResponseDto;

import java.util.List;

public class PatientRequestDto {
    private Long id;

    private String firstName;
    private String lastName;
    private String identityNumber;
    private List<LabReportResponseDto> labReports;

    public PatientRequestDto(Long id, String firstName, String lastName, String identityNumber,
                             List<LabReportResponseDto> labReports) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.identityNumber = identityNumber;
        this.labReports = labReports;
    }

    public PatientRequestDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public List<LabReportResponseDto> getLabReports() {
        return labReports;
    }

    public void setLabReports(List<LabReportResponseDto> labReports) {
        this.labReports = labReports;
    }
}
