package pe.com.colc.test06.controller.request;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DoctorRequest {

    private String idEspecialidad;
    private String nombreDoctor;
    private String apellidoDoctor;
    private String codigoColegiatura;
    private Double sueldo;
    private LocalDateTime fechaNacimiento;

}
