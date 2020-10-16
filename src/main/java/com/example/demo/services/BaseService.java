package com.example.demo.services;

import java.util.List;

public interface BaseService<E> {
    public List<E> findAll() throws Exception;
    public E findById(Long Id) throws Exception;
    public E save(E entity) throws Exception;
    public E update(Long id, E entity) throws Exception;
    public boolean delete(Long id) throws Exception;
}
