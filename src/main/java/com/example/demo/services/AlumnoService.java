package com.example.demo.services;

import javax.transaction.Transactional;
import java.util.List;

public class AlumnoService implements BaseService<Alumno>{

    private AlumnoRepository alumnoRepository;

    public AlumnoService(AlumnoRepository alumnoRepository){
        this.alumnoRepository = alumnoRepository;
    }

    @Override
    @Transactional
    public List<Alumno> findAll() throws Exception {
        try {
            List<Alumno> entities = alumnoRepository.findAll();
            return entities;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Alumno findById(Long Id) throws Exception {
        try {
            Optional<Alumno> entityOptional = alumnoRepository.findById(Id);
            return entityOptional.get();
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Alumno save(Alumno entity) throws Exception {
        try {
            entity = alumnoRepository.save(entity);
            return entity;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Alumno update(Long id, Alumno entity) throws Exception {
        try {
            Optional<Alumno> entityOptional = alumnoRepository.findById(id);
            Alumno entityUpdate = entityOptional.get();
            entityUpdate = alumnoRepository.save(entity);
            return entityUpdate;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if (alumnoRepository.existsById(id)){
                alumnoRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
