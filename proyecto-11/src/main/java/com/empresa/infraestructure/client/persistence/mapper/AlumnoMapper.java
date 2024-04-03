package com.empresa.infraestructure.client.persistence.mapper;

import com.empresa.domain.model.Alumno;
import com.empresa.infraestructure.client.persistence.entity.AlumnoEntity;
import java.util.List;

public class AlumnoMapper {

    public static Alumno toDomain(AlumnoEntity entity) {
        return Alumno.builder()
                .id(entity.getId())
                .precio(entity.getPrecio())
                .stock(entity.getStock())
                .descripcion(entity.getDescripcion())
                .fechaRegistro(entity.getFechaRegistro())
                .build();
    }

    public static List<Alumno> toDomain(List<AlumnoEntity> entityList) {
        return entityList
                .stream()
                .map(AlumnoMapper::toDomain)
                .toList();
    }

    public static AlumnoEntity toEntity(Alumno alumno) {
        return AlumnoEntity.builder()
                .id(alumno.getId())
                .precio(alumno.getPrecio())
                .stock(alumno.getStock())
                .descripcion(alumno.getDescripcion())
                .fechaRegistro(alumno.getFechaRegistro())
                .build();
    }

}
