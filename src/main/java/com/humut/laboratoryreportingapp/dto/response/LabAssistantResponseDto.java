package com.humut.laboratoryreportingapp.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class LabAssistantResponseDto {
    private Long id;

    private String firstName;
    private String lastName;
    private String hospitalId;
    @JsonIgnore
    private List<LabReportResponseDto> labReports;

    public LabAssistantResponseDto(Long id, String firstName, String lastName, String hospitalId, List<LabReportResponseDto> labReports) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hospitalId = hospitalId;
        this.labReports = labReports;
    }

    public LabAssistantResponseDto() {
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

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public List<LabReportResponseDto> getLabReports() {
        return labReports;
    }

    public void setLabReports(List<LabReportResponseDto> labReports) {
        this.labReports = labReports;
    }
}
