package com.edutech.demo.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Instructor {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String especialidad;

}
