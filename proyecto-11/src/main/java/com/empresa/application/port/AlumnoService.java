package com.empresa.application.port;

import com.empresa.domain.model.Alumno;

import java.util.List;

public interface AlumnoService {

    List<Alumno> mostrarAlumnos();
    Alumno mostrarAlumnoPorId(Integer id);
    Alumno crearAlumno(Alumno alumno);

}
