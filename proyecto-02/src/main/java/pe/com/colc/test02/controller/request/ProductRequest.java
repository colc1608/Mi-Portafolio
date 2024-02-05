package pe.com.colc.test02.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductRequest {


    private String descripcion;
    private Integer stock;
    private LocalDateTime fechaRegistro;
    private Boolean activo;
    private Double precio;

}
