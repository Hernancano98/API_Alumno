package com.example.demo.repositories;

import com.example.demo.entities.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para {@link Alumno}.
 *
 * <p>Extiende {@link JpaRepository} para obtener CRUD, paginación y consultas básicas.</p>
 */
@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
