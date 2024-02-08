package pe.com.colc.test05.controller;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.com.colc.test05.controller.request.LibroRequest;
import pe.com.colc.test05.controller.response.LibroResponse;


@Validated
@Slf4j
@RestController
@RequestMapping("/api/libros")
public class LibroController {


    @PostMapping
    public LibroResponse crear(@Valid @RequestBody LibroRequest productRequest){

        return LibroResponse.builder()
                .id(1)
                .build();

    }


    @GetMapping("/search-by-precio")
    LibroResponse buscarPorPrecio(@RequestParam(name = "precio")  @Min(2) @Max(40) Double precio) {

        return LibroResponse.builder()
                .id(1)
                .build();
    }

}
