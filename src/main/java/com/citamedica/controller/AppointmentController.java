package com.citamedica.controller;

import com.citamedica.controller.dto.AppointmentDTO;
import com.citamedica.entities.AppointmentEntity;
import com.citamedica.entities.DoctorEntity;
import com.citamedica.service.AppointmentService;
import com.citamedica.service.DoctorService;
import com.citamedica.service.MedicalOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private DoctorService  doctorService;

    @Autowired
    private MedicalOfficeService medicalOfficeService;

    @GetMapping(path = {"/", "/all"})
    public String showAllAppointments(Model model) {
        List<AppointmentEntity> appointmentEntityList = appointmentService.findAll();

        model.addAttribute("appointments", appointmentEntityList);
        return "index";
    }

    @GetMapping("/create/form")
    public String createForm(Model model){
        model.addAttribute("appointment", new AppointmentEntity());
        model.addAttribute("doctors", doctorService.findAll());
        model.addAttribute("medicalOffices", medicalOfficeService.findAll());
        return "form";
    }

    @PostMapping("/create/process")
    public String createProcess(AppointmentDTO appointmentDTO){

        AppointmentEntity appointmentEntity = AppointmentEntity.builder()
                .patientName(appointmentDTO.getPatientName())
                .doctor(appointmentDTO.getDoctor())
                .medicalOffice(appointmentDTO.getMedicalOffice())
                .date(appointmentDTO.getDate())
                .time(appointmentDTO.getTime())
                .build();

        appointmentService.createAppointment(appointmentEntity);
        return "redirect:/all";
    }
}
