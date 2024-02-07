package pe.com.colc.test03.controller.response;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class AlumnoResponse {

    private Integer idAlumno;
    private String nombre;
    private String apellido;
    private LocalDateTime fechaNacimiento;
    private Double promedio;
    private Boolean activo;

}
