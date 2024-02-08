package pe.com.colc.test06.repository.bd2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DoctorEspecialidadEntity {

    private String nombreEspecialidad;
    private Integer idDoctor;
    private String nombreDoctor;
    private String apellidoDoctor;
    private String codigoColegiatura;
    private Double sueldo;
    private Boolean estado;

}
