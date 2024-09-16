package com.citamedica.service.impl;

import com.citamedica.entities.DoctorEntity;
import com.citamedica.persistence.DoctorRepository;
import com.citamedica.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<DoctorEntity> findAll() {
        return doctorRepository.findAll();
    }

    @Override
    public DoctorEntity findById(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }
}
