package com.example.demo.services;

import com.example.demo.entities.Alumno;
import com.example.demo.repositories.AlumnoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.List;

/**
 * Implementación de negocio para {@link Alumno}.
 *
 * <p>Se apoya en {@link AlumnoRepository} para el acceso a datos y se marca como
 * {@link Service} para que Spring la detecte e inyecte.</p>
 */
@Service
public class AlumnoService implements BaseService<Alumno>{

    private final AlumnoRepository alumnoRepository;

    public AlumnoService(AlumnoRepository alumnoRepository){
        this.alumnoRepository = alumnoRepository;
    }

    @Override
    @Transactional
    public List<Alumno> findAll() throws Exception {
        try {
            return alumnoRepository.findAll();
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
            return alumnoRepository.save(entity);
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Alumno update(Long id, Alumno entity) throws Exception {
        try {
            Optional<Alumno> entityOptional = alumnoRepository.findById(id);
            // Asegura que exista (si no, Optional.get() lanza excepción).
            entityOptional.get();

            // El id de la URL es la fuente de verdad para la actualización.
            entity.setId(id);
            return alumnoRepository.save(entity);
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
