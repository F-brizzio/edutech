package com.edutech.userapi.service;

import com.edutech.userapi.model.*;
import com.edutech.userapi.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final ProfesorRepository profesorRepository;
    private final AlumnoRepository alumnoRepository;
    private final GerenteRepository gerenteRepository;

public Usuario crearUsuario(Usuario usuario) {
    if (usuarioRepository.existsByUsername(usuario.getUsername())) {
        throw new IllegalArgumentException("El nombre de usuario ya está en uso.");
    }

    // Guarda primero el usuario
    Usuario nuevoUsuario = usuarioRepository.save(usuario);

    // Asocia y guarda la entidad correspondiente al rol
    switch (usuario.getRol()) {
        case PROFESOR:
            asociarProfesor(nuevoUsuario, usuario.getProfesor());
            break;
        case ALUMNO:
            asociarAlumno(nuevoUsuario, usuario.getAlumno());
            break;
        case GERENTE:
            asociarGerente(nuevoUsuario, usuario.getGerente());
            break;
        default:
            break;
    }

    return nuevoUsuario;
}

private void asociarProfesor(Usuario usuario, Profesor profesor) {
    if (profesor != null) {
        profesor.setUsuario(usuario);
        profesorRepository.save(profesor);
    }
}

private void asociarAlumno(Usuario usuario, Alumno alumno) {
    if (alumno != null) {
        alumno.setUsuario(usuario);
        alumnoRepository.save(alumno);
    }
}

private void asociarGerente(Usuario usuario, Gerente gerente) {
    if (gerente != null) {
        gerente.setUsuario(usuario);
        gerenteRepository.save(gerente);
    }
}

    public Optional<Usuario> obtenerUsuario(Long id) {
        return usuarioRepository.findById(id);
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
public List<Usuario> listarTodos() {
    return usuarioRepository.findAll();
}

    
}
