package pe.com.colc.test02.service;

import pe.com.colc.test02.controller.request.ProductRequest;
import pe.com.colc.test02.controller.response.ProductResponse;
import pe.com.colc.test02.entity.ProductEntity;

import java.util.List;

public interface ProductService {

    public List<ProductResponse> obtenerTodos();
    public ProductResponse obtenerPorId(Integer inputId);
    public List<ProductResponse> obtenerPorFiltro(Double precioMaximo, Double precioMinimo);

    public boolean eliminar(Integer id);
    public ProductResponse crear(ProductRequest productRequest);
    public boolean actualizar(Integer id, ProductRequest productRequest);

}
