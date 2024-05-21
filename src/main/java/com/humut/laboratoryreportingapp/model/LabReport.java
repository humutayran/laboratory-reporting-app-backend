package com.humut.laboratoryreportingapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LabReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileNumber;
    private String diagnosisTitle;
    private String diagnosisDetails;

    @CreationTimestamp
    private Date dateGiven;
    private LocalDateTime modifiedDate;

    private String photoPath;

    @ManyToOne
    @JoinColumn(name = "lab_assistant_id")
    private LabAssistant labAssistant;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public void disassociate() {
        if (this.patient != null) {
            this.patient.getLabReports().remove(this);
            this.patient = null;
        }

        if (this.labAssistant != null) {
            this.labAssistant.getLabReports().remove(this);
            this.labAssistant = null;
        }
    }
}
