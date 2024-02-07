package pe.com.colc.test02;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import pe.com.colc.test02.controller.response.ProductResponse;
import pe.com.colc.test02.repository.entity.ProductEntity;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Prueba {

    public static void main(String[] args) {
        System.out.println("hola mundo");

        List<ProductResponse> userDTO = new ArrayList<>();

        List<ProductEntity> listDB = new ArrayList<>();
        listDB.add(ProductEntity.builder().idProducts(1).stock(11).descripcion("producto 01").precio(11.1).activo(true).build());
        listDB.add(ProductEntity.builder().idProducts(2).stock(22).descripcion("producto 02").precio(22.2).activo(true).build());


        ModelMapper modelMapper = new ModelMapper();
        userDTO = modelMapper.map(listDB, new TypeToken<List<ProductResponse>>(){}.getType());

        log.info("lista DB  = {}", listDB);
        log.info("lista DTO = {}", userDTO);


    }
}
