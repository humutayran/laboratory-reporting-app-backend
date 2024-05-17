package com.humut.laboratoryreportingapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
public class LabReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileNumber;
    private String diagnosisTitle;
    private String diagnosisDetails;

    @CreationTimestamp
    private Date dateGiven;

    private String photoPath;

    @ManyToOne
    @JoinColumn(name = "lab_assistant_id")
    @JsonBackReference
    private LabAssistant labAssistant;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    @JsonBackReference
    private Patient patient;

    public LabReport(Long id, String fileNumber, String diagnosisTitle, String diagnosisDetails,
                     Date dateGiven, String photoPath, LabAssistant labAssistant, Patient patient) {
        this.id = id;
        this.fileNumber = fileNumber;
        this.diagnosisTitle = diagnosisTitle;
        this.diagnosisDetails = diagnosisDetails;
        this.dateGiven = dateGiven;
        this.photoPath = photoPath;
        this.labAssistant = labAssistant;
        this.patient = patient;
    }

    public LabReport() {
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
