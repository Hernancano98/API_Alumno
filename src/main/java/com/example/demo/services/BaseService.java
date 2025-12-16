package com.example.demo.services;

import java.util.List;

/**
 * Contrato genérico de servicios CRUD.
 *
 * <p>La intención es separar el controlador (web) de la lógica de negocio/acceso a datos.</p>
 *
 * @param <E> tipo de entidad manejada por el servicio
 */
public interface BaseService<E> {
    /**
     * Lista todas las entidades.
     */
    List<E> findAll() throws Exception;

    /**
     * Busca una entidad por id.
     */
    E findById(Long Id) throws Exception;

    /**
     * Persiste una nueva entidad.
     */
    E save(E entity) throws Exception;

    /**
     * Actualiza una entidad existente.
     */
    E update(Long id, E entity) throws Exception;

    /**
     * Elimina una entidad por id.
     *
     * @return {@code true} si se eliminó, {@code false} en caso contrario
     */
    boolean delete(Long id) throws Exception;
}
