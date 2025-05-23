package com.edutech.cursoapi.service;

import com.edutech.cursoapi.client.UsuarioClient;
import com.edutech.cursoapi.model.Curso;
import com.edutech.cursoapi.repository.CursoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CursoService {

    private final CursoRepository cursoRepository;
    private final UsuarioClient usuarioClient;

    public Curso crearCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Curso actualizarCurso(Long id, Curso actualizado) {
        Curso existente = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
        existente.setNombreCurso(actualizado.getNombreCurso());
        existente.setHoraInicio(actualizado.getHoraInicio());
        existente.setHoraTermino(actualizado.getHoraTermino());
        return cursoRepository.save(existente);
    }

    public void eliminarCurso(Long id) {
        cursoRepository.deleteById(id);
    }

    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    public Curso asignarProfesor(Long idCurso, Long idProfesor) {
        Curso curso = cursoRepository.findById(idCurso)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        var usuario = usuarioClient.getUsuario(idProfesor);
        String rol = (String) usuario.get("rol");

        if (!"profesor".equalsIgnoreCase(rol)) {
            throw new RuntimeException("El usuario no es profesor");
        }
        curso.setProfesorId(idProfesor);
        return cursoRepository.save(curso);
    }

    public Curso asignarAlumno(Long idCurso, Long idAlumno) {
        Curso curso = cursoRepository.findById(idCurso)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        var usuario = usuarioClient.getUsuario(idAlumno);
        String rol = (String) usuario.get("rol");

        if (!"alumno".equalsIgnoreCase(rol)) {
            throw new RuntimeException("El usuario no es alumno");
        }
        if (!curso.getAlumnos().contains(idAlumno)) {
            curso.getAlumnos().add(idAlumno);
        }
        return cursoRepository.save(curso);
    }
}