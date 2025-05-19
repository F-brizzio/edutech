package com.edutech.userapi.repository;

import com.edutech.userapi.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}
