package pe.com.colc.test06.repository.bd1.entity;

import lombok.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class CiudadEntityProcedure {

    private Integer idCiudad;
    private String nombreCiudad;
    private Integer poblacion;
    private Double sueldoPromedio;
    private LocalDateTime fechaSenso;
    private String descripcion;


}
