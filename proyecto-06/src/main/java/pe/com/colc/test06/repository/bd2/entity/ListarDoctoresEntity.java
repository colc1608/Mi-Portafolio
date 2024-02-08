package pe.com.colc.test06.repository.bd2.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ListarDoctoresEntity {

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
