package pe.com.colc.test06.controller.response;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CiudadResponse {

    private Integer idCiudad;
    private String nombreCiudad;
    private Integer poblacion;
    private Double sueldoPromedio;
    private LocalDateTime fechaSenso;
    private String descripcion;

}
