package pe.com.colc.test06.repository.bd2.entity;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DoctorRegistrarEntity {

    private String nombreDoctor;
    private String apellidoDoctor;
    private String codigoColegiatura;
    private Double sueldo;
    private LocalDateTime fechaNacimiento;

}
