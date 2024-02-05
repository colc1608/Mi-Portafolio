package pe.com.colc.test02.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.colc.test02.controller.request.ProductRequest;
import pe.com.colc.test02.controller.response.RespuestaGenerica;
import pe.com.colc.test02.controller.response.ProductResponse;
import pe.com.colc.test02.service.ProductService;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/products")
public class ProductController {


    @Autowired
    ProductService productService;


    @GetMapping
    List<ProductResponse> getAll() {
        return productService.obtenerTodos();
    }

    @GetMapping("/filters")
    List<ProductResponse> buscarPorParametros(@RequestParam(name = "precioMaximo", required = false) Double precioMaximo,
                                              @RequestParam(name = "precioMinimo", required = false) Double precioMinimo) {

        log.info("valor de precioMaximo = {} " + precioMaximo);
        log.info("valor de precioMinimo = {} " + precioMinimo);



        return null;
    }

    @GetMapping("/{id}")
    ProductResponse findById(@PathVariable("id") Integer id) {
        return productService.obtenerPorId(id);
    }


    @PostMapping
    public ProductResponse crear(@RequestBody ProductRequest productRequest){
        ProductResponse response = productService.crear(productRequest);
        return response;
    }


    @DeleteMapping("/{idProd}")
    public RespuestaGenerica eliminar(@PathVariable("idProd") Integer id){

        Boolean resultado = productService.eliminar(id);
        return RespuestaGenerica.builder()
                .result(resultado)
                .build();

    }

    @PutMapping("/{inputIdProduct}")
    public RespuestaGenerica updateProduct(@PathVariable Integer inputIdProduct, @RequestBody ProductRequest inputProduct) {
        Boolean resultado = productService.actualizar(inputIdProduct, inputProduct);
        return RespuestaGenerica.builder().
                result(resultado)
                .build();

    }


    @PatchMapping("/{id}/precio/{inputPrecio}")
    public void updateProductParcial(@PathVariable Integer id, @PathVariable Double inputPrecio) {

    }
}
