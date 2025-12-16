package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Entidad de dominio Alumno.
 *
 * <p>Está auditada con Envers ({@link Audited}) para registrar cambios históricos.</p>
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Audited
@Table(name = "alumno")
public class Alumno implements Serializable {
    /**
     * Identificador autogenerado en base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del alumno.
     */
    @Column(name = "nombre")
    private String nombre;

    /**
     * Apellido del alumno.
     */
    @Column(name = "apellido")
    private String apellido;

    /**
     * Email de contacto del alumno.
     */
    @Column(name = "email")
    private String email;

    /**
     * Fecha de creación/registro.
     */
    @Column(name = "createAt")
    private Date createAt;
}
