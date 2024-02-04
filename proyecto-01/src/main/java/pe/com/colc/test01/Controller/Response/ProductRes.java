package pe.com.colc.test01.Controller.Response;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductRes {

	private UUID uuid;
	private Integer id;
	private Double precio;
	private Integer stock;
	private String descripcion;
	private LocalDateTime fechaRegistro;
	
}
