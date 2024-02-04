package pe.com.colc.test01.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import pe.com.colc.test01.Controller.Request.ProductoReq;
import pe.com.colc.test01.Controller.Response.ProductRes;

@Slf4j
@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired()
	@Qualifier(value = "misProductos")
	ArrayList<ProductRes> listProductosEnMemoria;

	@GetMapping("/{id}")
	ProductRes findById(@PathVariable("id") Integer id) {

		log.info("ProductController - findById: {}", id);

		for (ProductRes obj : listProductosEnMemoria) {
			if (id.equals(obj.getId())) {
				return obj;
			}
		}
		return null;
	}

	@GetMapping
	List<ProductRes> getAll() {
		return listProductosEnMemoria;
	}

	@GetMapping("/filters")
	List<ProductRes> findByParams(@RequestParam(name = "precioMaximo", required = false) Double precioMaximo) {

		log.info("valor de precioMaximo = {} " + precioMaximo);

		ArrayList<ProductRes> result = new ArrayList<>();

		for (ProductRes obj : listProductosEnMemoria) {
			if (precioMaximo > obj.getPrecio()) {
				result.add(obj);
			}
		}

		return result;
	}

	@PostMapping()
	ProductRes create(@RequestBody ProductoReq objInput) {

		log.info("create --> objInput = {} " + objInput);

		ProductRes productResponse = new ModelMapper().map(objInput, ProductRes.class);
		productResponse.setUuid(UUID.randomUUID());

		log.info("create --> productResponse = {} " + productResponse);

		listProductosEnMemoria.add(productResponse);

		return productResponse;
	}

	@DeleteMapping("/{idProd}")
	public void delete(@PathVariable("idProd") Integer idProd) {

		ProductRes find = null;

		for (ProductRes obj : listProductosEnMemoria) {
			if (idProd.equals(obj.getId())) {
				find = obj;
			}
		}

		listProductosEnMemoria.remove(find);

	}

	// Reemplaza el objeto
	@PutMapping("/{inputIdProduct}")
	public void updateProduct(@PathVariable Integer inputIdProduct, @RequestBody ProductoReq inputProduct) {

		for (ProductRes obj : listProductosEnMemoria) {
			if (inputIdProduct.equals(obj.getId())) {
				obj.setDescripcion(inputProduct.getDescripcion());
				obj.setFechaRegistro(inputProduct.getFechaRegistro());
				obj.setPrecio(inputProduct.getPrecio());
				obj.setStock(inputProduct.getStock());
			}
		}

	}

	@PatchMapping("/{id}/precio/{inputPrecio}")
	public void updateProductParcial(@PathVariable Integer id, @PathVariable Double inputPrecio) {

		for (ProductRes obj : listProductosEnMemoria) {
			if (id.equals(obj.getId())) {
				obj.setPrecio(inputPrecio);
			}
		}

	}

}


