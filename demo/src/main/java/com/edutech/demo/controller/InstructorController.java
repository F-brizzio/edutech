package com.edutech.demo.controller;
import com.edutech.demo.model.Instructor;
import com.edutech.demo.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/instructores")

public class InstructorController {

    @Autowired
    private InstructorService service;

    @GetMapping
    public List<Instructor> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Optional<Instructor> obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    public Instructor crear(@RequestBody Instructor instructor) {
        return service.crear(instructor);
    }

    @PutMapping("/{id}")
    public Instructor actualizar(@PathVariable Long id, @RequestBody Instructor instructor) {
        return service.actualizar(id, instructor);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

}
