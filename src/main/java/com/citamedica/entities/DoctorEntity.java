package com.citamedica.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name= "doctor")
public class DoctorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(name="fathers_surname")
    private String fathersSurname;

    @Column(name="mothers_surname")
    private String mothersSurname;

    private String specialty;
}
