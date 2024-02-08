package pe.com.colc.test06.controller.response;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DoctorResponse {

    private String nombreEspecialidad;
    private Integer idDoctor;
    private String nombreDoctor;
    private String apellidoDoctor;
    private String codigoColegiatura;
    private Double sueldo;
    private Boolean estado;

}
