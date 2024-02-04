package pe.com.colc.test01.Controller.Request;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductoReq {
	
	private Integer id;
	private Double precio;
	private Integer stock;
	private String descripcion;
	private LocalDateTime fechaRegistro;
}
