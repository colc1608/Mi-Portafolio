package pe.com.colc.test02.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.colc.test02.controller.request.ProductRequest;
import pe.com.colc.test02.controller.response.ProductResponse;
import pe.com.colc.test02.repository.entity.ProductEntity;
import pe.com.colc.test02.repository.ProductRepository;
import pe.com.colc.test02.service.ProductService;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;


    @Override
    public List<ProductResponse> obtenerTodos() {

        List<ProductEntity> resultRepository = productRepository.findAll();

        //1) Using TypeToken
        List<ProductResponse> response = new ModelMapper().map(resultRepository, new TypeToken<List<ProductResponse>>(){}.getType());

        //2) Using the array way
        //List<ProductResponse> response = Arrays.asList(new ModelMapper().map(resultRepository, ProductResponse[].class));


        log.info("lista BD =  {}", resultRepository);
        log.info("lista DTO = {}", response);

        return response;
    }

    @Override
    public ProductResponse obtenerPorId(Integer inputId) {
        Optional<ProductEntity> resultRepository = productRepository.findById(inputId);

        ProductResponse productResponse = null;

        if(resultRepository.isPresent()){
            productResponse = new ModelMapper().map(resultRepository.get(), ProductResponse.class);
        }

        return productResponse;
    }

    @Override
    public List<ProductResponse> obtenerPorFiltro(Double precioMaximo, Double precioMinimo) {
        return null;
    }

    @Override
    public boolean eliminar(Integer id) {

        Optional<ProductEntity> resultRepository = productRepository.findById(id);

        if(resultRepository.isPresent()){
            resultRepository.get().setActivo(false);
            productRepository.save(resultRepository.get());
            return true;
        }

        return false;

    }

    @Override
    public ProductResponse crear(ProductRequest productRequest) {

        ProductEntity productEntity = new ModelMapper().map(productRequest, ProductEntity.class);
        productEntity = productRepository.save(productEntity);

        ProductResponse response = new ModelMapper().map(productEntity, ProductResponse.class);

        return response;
    }

    @Override
    public boolean actualizar(Integer id, ProductRequest productRequest) {

        Optional<ProductEntity> resultRepository = productRepository.findById(id);

        if(resultRepository.isPresent()){
            resultRepository.get().setStock(productRequest.getStock());
            resultRepository.get().setPrecio(productRequest.getPrecio());
            resultRepository.get().setDescripcion(productRequest.getDescripcion());
            resultRepository.get().setFechaRegistro(productRequest.getFechaRegistro());
            resultRepository.get().setActivo(productRequest.getActivo());
            productRepository.save(resultRepository.get());
            return true;
        }
        return false;

    }
}
