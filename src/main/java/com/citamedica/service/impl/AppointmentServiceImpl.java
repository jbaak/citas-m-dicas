package com.citamedica.service.impl;

import com.citamedica.entities.AppointmentEntity;
import com.citamedica.entities.DoctorEntity;
import com.citamedica.persistence.AppointmentRepository;
import com.citamedica.persistence.DoctorRepository;
import com.citamedica.service.AppointmentService;
import com.citamedica.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public List<AppointmentEntity> findAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public AppointmentEntity findById(Long id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    @Override
    public void createAppointment(AppointmentEntity appointmentEntity) {
        appointmentRepository.save(appointmentEntity);
    }
}
