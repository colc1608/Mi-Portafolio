package pe.com.colc.test.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Builder
public class AlumnoQuery {

    private Double precio;
    private Integer stock;
    private String descripcion;
    private LocalDateTime fechaRegistro;
    private Integer id;

}
