package com.citamedica.service;

import com.citamedica.entities.AppointmentEntity;

import java.util.List;

public interface AppointmentService {

    List<AppointmentEntity> findAll();
    AppointmentEntity findById(Long id);
    void createAppointment(AppointmentEntity appointmentEntity);

}
