package pe.com.colc.test.domain.model;

import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@Builder
public class AlumnoCommand {

    private Double precio;
    private Integer stock;
    private String descripcion;
    private LocalDateTime fechaRegistro;

}
