package com.edutech.cursoapi.controller;

import com.edutech.cursoapi.model.Curso;
import com.edutech.cursoapi.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
@RequiredArgsConstructor
public class CursoController {

    private final CursoService cursoService;

    @PostMapping
    public ResponseEntity<Curso> crearCurso(@RequestBody Curso curso) {
        return ResponseEntity.ok(cursoService.crearCurso(curso));
    }

    @GetMapping
    public ResponseEntity<List<Curso>> listarCursos() {
        return ResponseEntity.ok(cursoService.listarCursos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> obtenerCurso(@PathVariable Long id) {
        Curso curso = cursoService.listarCursos()
                .stream()
                .filter(c -> c.getIdCurso().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
        return ResponseEntity.ok(curso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> actualizarCurso(@PathVariable Long id, @RequestBody Curso curso) {
        return ResponseEntity.ok(cursoService.actualizarCurso(id, curso));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCurso(@PathVariable Long id) {
        cursoService.eliminarCurso(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{idCurso}/asignar/profesor/{idProfesor}")
    public ResponseEntity<Curso> asignarProfesor(@PathVariable Long idCurso, @PathVariable Long idProfesor) {
        return ResponseEntity.ok(cursoService.asignarProfesor(idCurso, idProfesor));
    }

    @PostMapping("/{idCurso}/asignar/alumno/{idAlumno}")
    public ResponseEntity<Curso> asignarAlumno(@PathVariable Long idCurso, @PathVariable Long idAlumno) {
        return ResponseEntity.ok(cursoService.asignarAlumno(idCurso, idAlumno));
    }
}


