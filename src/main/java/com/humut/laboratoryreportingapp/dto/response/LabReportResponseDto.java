package com.humut.laboratoryreportingapp.dto.response;

import com.humut.laboratoryreportingapp.model.LabAssistant;
import com.humut.laboratoryreportingapp.model.Patient;

import java.util.Date;
import java.util.List;

public class LabReportResponseDto {
    private Long id;

    private String fileNumber;
    private String diagnosisTitle;
    private String diagnosisDetails;
    private Date dateGiven;
    private String photoPath;
    private LabAssistant labAssistant;
    private Patient patient;
    private List<LabReportResponseDto> labReports;

    public LabReportResponseDto(Long id, String fileNumber, String diagnosisTitle,
                                String diagnosisDetails, Date dateGiven, String photoPath, LabAssistant labAssistant,
                                Patient patient, List<LabReportResponseDto> labReports) {
        this.id = id;
        this.fileNumber = fileNumber;
        this.diagnosisTitle = diagnosisTitle;
        this.diagnosisDetails = diagnosisDetails;
        this.dateGiven = dateGiven;
        this.photoPath = photoPath;
        this.labAssistant = labAssistant;
        this.patient = patient;
        this.labReports = labReports;
    }

    public LabReportResponseDto() {
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

    public LabAssistant getLabAssistant() {
        return labAssistant;
    }

    public void setLabAssistant(LabAssistant labAssistant) {
        this.labAssistant = labAssistant;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
