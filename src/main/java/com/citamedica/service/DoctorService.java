package com.citamedica.service;

import com.citamedica.entities.DoctorEntity;

import java.util.List;

public interface DoctorService {

    List<DoctorEntity> findAll();
    DoctorEntity findById(Long id);
}
