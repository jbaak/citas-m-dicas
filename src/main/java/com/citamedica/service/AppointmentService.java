package com.citamedica.service;

import com.citamedica.entities.AppointmentEntity;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {

    List<AppointmentEntity> findAll();
    AppointmentEntity findById(Long id);
    void createAppointment(AppointmentEntity appointmentEntity);
    List<AppointmentEntity> searchByConsultorio(LocalDate date, String time, Long medicalOfficeID);
    List<AppointmentEntity> searchByDoctor(LocalDate date, String time, Long doctorId);
}
