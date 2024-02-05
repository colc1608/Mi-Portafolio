package pe.com.colc.test02.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductResponse {

    private Integer idProducts;
    private String descripcion;
    private Integer stock;
    private LocalDateTime fechaRegistro;
    private Boolean activo;
    private Double precio;
    private String otro;

}
