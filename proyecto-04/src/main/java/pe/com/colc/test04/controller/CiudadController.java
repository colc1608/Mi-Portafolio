package pe.com.colc.test04.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.colc.test04.controller.request.CiudadRequest;
import pe.com.colc.test04.controller.response.CiudadResponse;
import pe.com.colc.test04.controller.response.GenericResponse;
import pe.com.colc.test04.service.CiudadService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/ciudades")
public class CiudadController {

    @Autowired
    CiudadService ciudadService;

    @GetMapping
    List<CiudadResponse> obtenerTodos() {
        return ciudadService.obtenerTodos();
    }

    @GetMapping("/{id}")
    CiudadResponse obtenerPorId(@PathVariable("id") Integer id) {
        return ciudadService.obtenerPorId(id);
    }

    @PostMapping
    public CiudadResponse crear(@RequestBody CiudadRequest request){
        CiudadResponse response = ciudadService.crear(request);
        return response;
    }

    @DeleteMapping("/{idProd}")
    public GenericResponse eliminar(@PathVariable("idProd") Integer id){

        Boolean resultado = ciudadService.eliminar(id);
        return GenericResponse.builder()
                .result(resultado)
                .build();

    }

    @PutMapping("/{inputIdProduct}")
    public GenericResponse updateProduct(@PathVariable Integer inputIdProduct, @RequestBody CiudadRequest inputProduct) {
        Boolean resultado = ciudadService.actualizar(inputIdProduct, inputProduct);
        return GenericResponse.builder().
                result(resultado)
                .build();

    }

}
