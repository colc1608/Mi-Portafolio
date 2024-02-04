package pe.com.colc.test01.Storage;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pe.com.colc.test01.Controller.Response.ProductRes;


@Configuration
public class ProductsStorage {
	
	@Bean(name = "misProductos")
	ArrayList<ProductRes> productosEnMemoria() {
		
		ProductRes obj1 = ProductRes.builder()
				.uuid(UUID.randomUUID())
				.id(1)
				.precio(48.6)
				.descripcion("laptop")
				.stock(11)
				.fechaRegistro(LocalDateTime.of(2019, 6, 28, 9, 12, 48))
				.build();
		
		ProductRes obj2 = ProductRes.builder()
				.uuid(UUID.randomUUID())
				.id(2)
				.precio(36.4)
				.descripcion("iphone")
				.stock(22)
				.fechaRegistro(LocalDateTime.of(2017, 8, 16, 14, 33, 48))
				.build();
		
		ProductRes obj3 = ProductRes.builder()
				.uuid(UUID.randomUUID())
				.id(3)
				.precio(83.1)
				.descripcion("smart tv")
				.stock(34)
				.fechaRegistro(LocalDateTime.of(2021, 4, 19, 19, 47, 48))
				.build();
		
		ArrayList<ProductRes> response = new ArrayList<>();
		response.add(obj1);
		response.add(obj2);
		response.add(obj3);
		
        return response;
    }
	
}
