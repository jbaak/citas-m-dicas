package com.citamedica.validation;

import com.citamedica.controller.dto.AppointmentDTO;
import com.citamedica.entities.AppointmentEntity;
import com.citamedica.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.util.List;

@Component
public class AppointmentValidator implements Validator {

    @Autowired
    AppointmentService appointmentService;

    @Override
    public boolean supports(Class<?> clazz) {
        return AppointmentDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AppointmentDTO appointmentDTO = (AppointmentDTO) target;

        List<AppointmentEntity> appointments = appointmentService.searchByConsultorio(appointmentDTO.getDate(), appointmentDTO.getTime(), appointmentDTO.getMedicalOffice().getId() );
        if(!appointments.isEmpty()){
            errors.rejectValue("date", "date", "Ya existe cita en ese consultorio a esa hora.");
        }

        List<AppointmentEntity> appointmentsDoctor = appointmentService.searchByDoctor(appointmentDTO.getDate(), appointmentDTO.getTime(), appointmentDTO.getDoctor().getId() );
        if(!appointmentsDoctor.isEmpty()){
            errors.rejectValue("date", "date", "El doctor ya tiene cita agendada a esa hora.");
        }

        // Custom validation for date
        if (appointmentDTO.getDate()!= null && appointmentDTO.getDate().isBefore(LocalDate.now())) {
            errors.rejectValue("date", "date", "No puede agendar cita con fecha anterior a hoy.");
        }
    }
}
