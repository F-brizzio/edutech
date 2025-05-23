package com.edutech.cursoapi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cursos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCurso;

    @Column(nullable = false)
    private String nombreCurso;

    private Long profesorId;

    @ElementCollection
    private List<Long> alumnos = new ArrayList<>();

    private LocalTime horaInicio;

    private LocalTime horaTermino;
}
