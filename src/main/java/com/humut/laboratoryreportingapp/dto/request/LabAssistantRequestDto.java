package com.humut.laboratoryreportingapp.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LabAssistantRequestDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String hospitalId;
}
