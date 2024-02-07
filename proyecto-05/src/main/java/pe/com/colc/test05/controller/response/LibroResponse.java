package pe.com.colc.test05.controller.response;

import lombok.*;
import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class LibroResponse {

    private Integer id;
    private String titulo;
    private String autor;
    private LocalDateTime fechaPublicacion;
    private LocalDateTime fechaRegistro;
    private String emailEditorial;
    private Double precio;
    private Integer stock;
    private String resumenLibro;

}
