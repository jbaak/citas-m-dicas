package com.citamedica.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name= "appointmet")
public class AppointmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="patient_name")
    private String patientName;

    @ManyToOne
    private DoctorEntity doctor;

    @ManyToOne
    private MedicalOfficeEntity medicalOffice;

    private LocalDate date;

}
