package com.empresa.infraestructure.client.rest.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class AlumnoReq {

    private Double precio;
    private Integer stock;
    private String descripcion;
    private LocalDateTime fechaRegistro;


}
