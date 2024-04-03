package com.empresa.infraestructure.client.rest.mapper;

import com.empresa.domain.model.Alumno;
import com.empresa.infraestructure.client.persistence.entity.AlumnoEntity;
import com.empresa.infraestructure.client.persistence.mapper.AlumnoMapper;
import com.empresa.infraestructure.client.rest.dto.AlumnoReq;
import com.empresa.infraestructure.client.rest.dto.AlumnoRes;

import java.util.List;

public class AlumnoRestMapper {

    public static Alumno toDomain(AlumnoReq request) {
        return Alumno.builder()
                .precio(request.getPrecio())
                .stock(request.getStock())
                .descripcion(request.getDescripcion())
                .fechaRegistro(request.getFechaRegistro())
                .build();
    }



}
