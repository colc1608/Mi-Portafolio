package pe.com.colc.test04.repository.entity;

import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
@Entity
@Table(name = "ciudad")
public class CiudadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CIUDAD_ID")
    private Integer idAlumno;

    @Column(name = "CIUDAD_NOMBRE")
    private String ciudadNombre;

    @Column(name = "CIUDAD_CODIGO_POSTAL")
    private Integer ciudadCodigoPostal;


}
