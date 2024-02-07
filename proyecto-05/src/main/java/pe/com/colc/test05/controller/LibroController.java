package pe.com.colc.test05.controller;


import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.colc.test05.controller.request.LibroRequest;
import pe.com.colc.test05.controller.response.LibroResponse;

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

}
