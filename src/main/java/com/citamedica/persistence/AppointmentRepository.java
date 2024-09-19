package com.citamedica.persistence;

import com.citamedica.entities.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long> {

    //No se puede agendar cita en un mismo consultorio a la misma hora.
    @Query("from AppointmentEntity a join a.medicalOffice m where a.date= :date and m.id= :moffice and a.time=:time")
    List<AppointmentEntity> searchByConsultorio(@Param("date") LocalDate date, @Param("time") String time, @Param("moffice") Long moffice);

    // No se puede agendar cita para un mismo Dr. a la misma hora.
    @Query("from AppointmentEntity a join a.doctor d where a.date=:date and  a.time=:time and d.id= :doctor")
    List<AppointmentEntity> searchByDoctor(@Param("date") LocalDate date, @Param("time") String time, @Param("doctor") Long doctorId);

}
