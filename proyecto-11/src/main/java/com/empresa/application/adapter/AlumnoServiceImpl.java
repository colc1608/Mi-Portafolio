package com.empresa.application.adapter;

import com.empresa.application.port.AlumnoService;
import com.empresa.domain.model.Alumno;
import com.empresa.domain.port.AlumnoPort;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public class AlumnoServiceImpl implements AlumnoService {

    AlumnoPort alumnoPort;

    public AlumnoServiceImpl(AlumnoPort alumnoPort){
        this.alumnoPort = alumnoPort;

    }

    @Override
    public List<Alumno> mostrarAlumnos() {
        return alumnoPort.mostrarAlumnos();
    }

    @Override
    public Alumno mostrarAlumnoPorId(Integer idInput) {
        Alumno alumno = alumnoPort.mostrarAlumnoPorId(idInput);
        return alumno;
    }

    @Override
    public Alumno crearAlumno(Alumno alumnoInput) {
        Alumno alumno = alumnoPort.crearAlumno(alumnoInput);
        return alumno;
    }
}
