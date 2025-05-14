package com.edutech.demo.repository;
import com.edutech.demo.model.Instructor;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository

public class InstructorRepository {
    private final List<Instructor> instructores = new ArrayList<>();

    public List<Instructor> obtenerTodos() {
        return instructores;
    }

    public Optional<Instructor> buscarPorId(Long id) {
        return instructores.stream().filter(i -> i.getId().equals(id)).findFirst();
    }

    public Instructor guardar(Instructor instructor) {
        instructores.add(instructor);
        return instructor;
    }
    public Instructor actualizar(Long id, Instructor nuevo) {
        Optional<Instructor> existente = buscarPorId(id);
        existente.ifPresent(i -> {
            i.setNombre(nuevo.getNombre());
            i.setApellido(nuevo.getApellido());
            i.setEmail(nuevo.getEmail());
            i.setEspecialidad(nuevo.getEspecialidad());
        });
        return existente.orElse(null);
    }

    public boolean eliminar(Long id) {
        return instructores.removeIf(i -> i.getId().equals(id));
    }

}
