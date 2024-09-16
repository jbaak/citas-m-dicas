package com.citamedica.controller.dto;

import com.citamedica.entities.DoctorEntity;
import com.citamedica.entities.MedicalOfficeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDTO {

    private String patientName;

    private DoctorEntity doctor;

    private MedicalOfficeEntity medicalOffice;

    private LocalDate date;

    private String time;
}
