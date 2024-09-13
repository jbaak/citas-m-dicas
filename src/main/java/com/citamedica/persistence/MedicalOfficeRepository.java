package com.citamedica.persistence;

import com.citamedica.entities.MedicalOfficeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalOfficeRepository extends JpaRepository<MedicalOfficeEntity, Long> {
}
