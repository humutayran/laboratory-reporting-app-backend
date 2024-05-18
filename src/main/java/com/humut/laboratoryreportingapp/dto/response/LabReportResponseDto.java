package com.humut.laboratoryreportingapp.dto.response;

import java.util.Date;
import java.util.List;

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

    public LabReportResponseDto(Long id, String fileNumber, String diagnosisTitle, String diagnosisDetails,
                                Date dateGiven, String photoPath, String labAssistantName,
                                String getLabAssistantLastName, String labAssistantHospitalId,
                                String patientName, String patientLastName, String patientIdentityNumber) {
        this.id = id;
        this.fileNumber = fileNumber;
        this.diagnosisTitle = diagnosisTitle;
        this.diagnosisDetails = diagnosisDetails;
        this.dateGiven = dateGiven;
        this.photoPath = photoPath;
        this.labAssistantFirstName = labAssistantName;
        this.labAssistantLastName = getLabAssistantLastName;
        this.labAssistantHospitalId = labAssistantHospitalId;
        this.patientFirstName = patientName;
        this.patientLastName = patientLastName;
        this.patientIdentityNumber = patientIdentityNumber;
    }

    public LabReportResponseDto() {
    }

    public String getLabAssistantFirstName() {
        return labAssistantFirstName;
    }

    public void setLabAssistantFirstName(String labAssistantFirstName) {
        this.labAssistantFirstName = labAssistantFirstName;
    }

    public String getLabAssistantLastName() {
        return labAssistantLastName;
    }

    public void setLabAssistantLastName(String labAssistantLastName) {
        this.labAssistantLastName = labAssistantLastName;
    }

    public String getLabAssistantHospitalId() {
        return labAssistantHospitalId;
    }

    public void setLabAssistantHospitalId(String labAssistantHospitalId) {
        this.labAssistantHospitalId = labAssistantHospitalId;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public String getPatientIdentityNumber() {
        return patientIdentityNumber;
    }

    public void setPatientIdentityNumber(String patientIdentityNumber) {
        this.patientIdentityNumber = patientIdentityNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(String fileNumber) {
        this.fileNumber = fileNumber;
    }

    public String getDiagnosisTitle() {
        return diagnosisTitle;
    }

    public void setDiagnosisTitle(String diagnosisTitle) {
        this.diagnosisTitle = diagnosisTitle;
    }

    public String getDiagnosisDetails() {
        return diagnosisDetails;
    }

    public void setDiagnosisDetails(String diagnosisDetails) {
        this.diagnosisDetails = diagnosisDetails;
    }

    public Date getDateGiven() {
        return dateGiven;
    }

    public void setDateGiven(Date dateGiven) {
        this.dateGiven = dateGiven;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }
}
