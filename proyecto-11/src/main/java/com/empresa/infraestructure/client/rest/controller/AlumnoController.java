package com.empresa.infraestructure.client.rest.controller;

import com.empresa.application.port.AlumnoService;
import com.empresa.domain.model.Alumno;
import com.empresa.infraestructure.client.rest.dto.AlumnoReq;
import com.empresa.infraestructure.client.rest.dto.AlumnoRes;
import com.empresa.infraestructure.client.rest.mapper.AlumnoRestMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    private final AlumnoService alumnoService;

    public AlumnoController (AlumnoService alumnoService){
        this.alumnoService = alumnoService;
    }


    @GetMapping
    public ResponseEntity<List<Alumno>> getAll() {
        List<Alumno> result = alumnoService.mostrarAlumnos();
        return ResponseEntity.ok(result);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Alumno> readById(@PathVariable("id") Integer idAlumno) {
        return ResponseEntity.ok(alumnoService.mostrarAlumnoPorId(idAlumno));
    }


    @PostMapping
    public ResponseEntity<Alumno> create(@RequestBody AlumnoReq request) {
        Alumno obj = AlumnoRestMapper.toDomain(request);
        obj = alumnoService.crearAlumno(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

}
