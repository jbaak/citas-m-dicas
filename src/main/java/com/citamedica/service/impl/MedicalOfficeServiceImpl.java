package com.citamedica.service.impl;

import com.citamedica.entities.DoctorEntity;
import com.citamedica.entities.MedicalOfficeEntity;
import com.citamedica.persistence.MedicalOfficeRepository;
import com.citamedica.service.DoctorService;
import com.citamedica.service.MedicalOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalOfficeServiceImpl implements MedicalOfficeService {

    @Autowired
    private MedicalOfficeRepository medicalOfficeRepository;

    @Override
    public List<MedicalOfficeEntity> findAll() {
        return medicalOfficeRepository.findAll();
    }
}
