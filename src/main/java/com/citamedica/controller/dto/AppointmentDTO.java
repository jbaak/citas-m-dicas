package com.citamedica.controller.dto;

import com.citamedica.entities.DoctorEntity;
import com.citamedica.entities.MedicalOfficeEntity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDTO {

    @NotEmpty
    private String patientName;


    private DoctorEntity doctor;


    private MedicalOfficeEntity medicalOffice;

    @NotNull
    private LocalDate date;

    @NotEmpty
    private String time;
}
