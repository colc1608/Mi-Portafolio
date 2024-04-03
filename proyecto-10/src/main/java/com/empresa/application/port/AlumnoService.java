package com.empresa.application.port;

import com.empresa.domain.model.Alumno;

import java.util.List;

public interface AlumnoService {

    List<Alumno> mostrarAlumnos();
    Alumno mostrarAlumno(Integer id);
    Alumno crearAlumno(Alumno alumno);

}
