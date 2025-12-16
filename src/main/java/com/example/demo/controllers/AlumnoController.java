package com.example.demo.controllers;

import com.example.demo.entities.Alumno;
import com.example.demo.services.AlumnoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para operaciones CRUD de {@link Alumno}.
 *
 * <p>Ruta base: {@code /api/v1/alumno}</p>
 *
 * <p>Nota: Se devuelve un mensaje de error genérico para no filtrar detalles internos.</p>
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/alumno")
public class AlumnoController {

    /**
     * Capa de servicio que encapsula la lógica y acceso a datos.
     * Se inyecta por constructor (recomendado por Spring).
     */
    private final AlumnoService alumnoService;

    public AlumnoController(AlumnoService alumnoService){
        this.alumnoService = alumnoService;
    }

    /**
     * Devuelve todos los alumnos registrados.
     */
    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(alumnoService.findAll());

        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Intente mas tarde.\"}");
        }
    }

    /**
     * Devuelve un alumno por id.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(alumnoService.findById(id));

        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Intente mas tarde.\"}");
        }
    }

    /**
     * Crea un alumno.
     */
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Alumno entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(alumnoService.save(entity));
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Intente mas tarde.\"}");
        }
    }

    /**
     * Actualiza un alumno existente. El id de la URL prevalece sobre cualquier id del body.
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Alumno entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(alumnoService.update(id,entity));
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Intente mas tarde.\"}");
        }
    }

    /**
     * Elimina un alumno por id.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(alumnoService.delete(id));
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Intente mas tarde.\"}");
        }
    }

}
