package pe.com.colc.test06.controller.response;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DoctorResponse {

    private Integer idDoctor;
    private String nombreDoctor;
    private String apellidoDoctor;
    private Integer idEspecialidad;
    private String nombreEspecialidad;
    private String codigoColegiatura;
    private Double sueldo;
    private LocalDateTime fechaNacimiento;
    private Boolean estado;

}
