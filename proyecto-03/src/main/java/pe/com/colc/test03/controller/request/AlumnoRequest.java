package pe.com.colc.test03.controller.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AlumnoRequest {

    private String nombre;
    private String apellido;
    private LocalDateTime fechaNacimiento;
    private Double promedio;
    
}
