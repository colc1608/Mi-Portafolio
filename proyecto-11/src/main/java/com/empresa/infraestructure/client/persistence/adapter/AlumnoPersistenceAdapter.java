package com.empresa.infraestructure.client.persistence.adapter;

import com.empresa.domain.model.Alumno;
import com.empresa.domain.port.AlumnoPort;
import com.empresa.infraestructure.client.persistence.entity.AlumnoEntity;
import com.empresa.infraestructure.client.persistence.mapper.AlumnoMapper;
import com.empresa.infraestructure.client.persistence.repository.AlumnoRepository;
import com.empresa.infraestructure.client.rest.exception.ConflictException;
import com.empresa.infraestructure.client.rest.exception.NotFoundException;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

//@Component
public class AlumnoPersistenceAdapter implements AlumnoPort {

    AlumnoRepository alumnoRepository;

    public AlumnoPersistenceAdapter(AlumnoRepository alumnoRepository){
        this.alumnoRepository = alumnoRepository;
    }


    @Override
    public List<Alumno> mostrarAlumnos() {
        List<AlumnoEntity> listEntity = alumnoRepository.findAll();
        return AlumnoMapper.toDomain(listEntity);
    }

    @Override
    public Alumno mostrarAlumnoPorId(Integer idAAlumno) {
        Optional<AlumnoEntity> entity = alumnoRepository.findById(idAAlumno);
        entity.orElseThrow( () -> new NotFoundException("Alumno id: " + idAAlumno) );
        return AlumnoMapper.toDomain(entity.get());
    }

    @Override
    public Alumno crearAlumno(Alumno alumno) {
        AlumnoEntity entity = AlumnoMapper.toEntity(alumno);
        entity = alumnoRepository.save(entity);
        Alumno response = AlumnoMapper.toDomain(entity);
        return response;
    }


    private void assertIdNotExist(Integer id) {
        alumnoRepository.findById(id).ifPresent(val -> {
            throw new ConflictException("Alumno ya existe: " + id);
        });
    }


}
