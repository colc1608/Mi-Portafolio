package pe.com.colc.test03.repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
@Entity
@Table(name = "alumno")
public class AlumnoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAlumno")
    private Integer idAlumno;

    private String nombre;
    private String apellido;

    @Column(name = "fechaNacimiento")
    private LocalDateTime fechaNacimiento;

    private Double promedio;
    private String dni;
    private Boolean activo;



}
