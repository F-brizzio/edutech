package com.edutech.demo.service;
import com.edutech.demo.model.Instructor;
import com.edutech.demo.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class InstructorService {
    @Autowired
    private InstructorRepository repository;

    public List<Instructor> listar() {
        return repository.obtenerTodos();
    }

    public Optional<Instructor> obtenerPorId(Long id) {
        return repository.buscarPorId(id);
    }

    public Instructor crear(Instructor instructor) {
        return repository.guardar(instructor);
    }

    public Instructor actualizar(Long id, Instructor nuevo) {
        return repository.actualizar(id, nuevo);
    }

    public boolean eliminar(Long id) {
        return repository.eliminar(id);
    }


}
