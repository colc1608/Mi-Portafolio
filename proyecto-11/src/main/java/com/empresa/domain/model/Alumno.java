package com.empresa.domain.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class Alumno {

    private Double precio;
    private Integer stock;
    private String descripcion;
    private LocalDateTime fechaRegistro;
    private Integer id;

}
