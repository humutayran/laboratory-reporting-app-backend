package com.example.laboratoryreportingapp.dto.response;

public class LabAssistantResponseDto {
    private Long id;

    private String firstName;
    private String lastName;
    private String hospitalId;

    public LabAssistantResponseDto(Long id, String firstName, String lastName, String hospitalId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hospitalId = hospitalId;
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
}
