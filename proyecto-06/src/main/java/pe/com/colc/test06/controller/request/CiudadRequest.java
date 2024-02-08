package pe.com.colc.test06.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CiudadRequest {


    private String nombreCiudad;
    private Integer poblacion;
    private Double sueldoPromedio;
    private LocalDateTime fechaSenso;
    private String descripcion;

}
