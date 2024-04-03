package com.empresa.domain.port;

import com.empresa.domain.model.Alumno;
import java.util.List;

public interface AlumnoPort {

    List<Alumno> mostrarAlumnos();

    Alumno mostrarAlumnoPorId(Integer idAAlumno);

    Alumno crearAlumno(Alumno alumno);


}
