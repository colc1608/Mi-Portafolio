package pe.com.colc.test.infraestructure.in.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.colc.test.application.find.AlumnoFindUseCase;

@RestController
@RequestMapping("/alumnos")
@RequiredArgsConstructor
public class ProductoRest {

    private final AlumnoFindUseCase alumnoFindUseCase;

    @GetMapping
    public ResponseEntity listarAlumnos(){

        return ResponseEntity.ok(this.alumnoFindUseCase.obtenerTodo());

    }

}
