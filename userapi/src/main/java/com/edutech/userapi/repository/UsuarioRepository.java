package com.edutech.userapi.repository;

import com.edutech.userapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByUsername(String username);
}
