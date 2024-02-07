package pe.com.colc.test05.controller.request;

import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class LibroRequest {

    @NotNull(message = "The titulo is required.")
    private String titulo;


    @NotBlank(message = "The autor is not blank.")
    private String autor;


    private LocalDateTime fechaPublicacion;

    @NotNull(message = "The fechaRegistro is required.")
    private LocalDateTime fechaRegistro;


    @Email(message = "No es un email valido.")
    private String emailEditorial;

    @NotNull(message = "The precio is required.")
    @Min(value = 9, message = "The precio must be equal or greater than 9")
    @Max(value = 50, message = "The precio must be equal or greater than 50")
    private Double precio;

    @NotNull(message = "The stock is required.")
    @Min(value = 1, message = "The stock must be equal or greater than 1")
    private Integer stock;


    @Size(min = 10, max = 50, message = "The resumenLibro must be from 9 to 50 characters.")
    private String resumenLibro;

}
