package pe.com.colc.test03.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.colc.test03.controller.request.AlumnoRequest;
import pe.com.colc.test03.controller.response.AlumnoResponse;
import pe.com.colc.test03.controller.response.GenericResponse;
import pe.com.colc.test03.service.AlumnoService;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    @Autowired
    AlumnoService alumnoService;


    @GetMapping
    List<AlumnoResponse> getAll() {
        return alumnoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    AlumnoResponse findById(@PathVariable("id") Integer id) {
        return alumnoService.obtenerPorId(id);
    }


    @PostMapping
    public AlumnoResponse crear(@RequestBody AlumnoRequest productRequest){
        AlumnoResponse response = alumnoService.crear(productRequest);
        return response;
    }


    @DeleteMapping("/{idProd}")
    public GenericResponse eliminar(@PathVariable("idProd") Integer id){

        Boolean resultado = alumnoService.eliminar(id);
        return GenericResponse.builder()
                .result(resultado)
                .build();

    }

    @PutMapping("/{inputIdProduct}")
    public GenericResponse updateProduct(@PathVariable Integer inputIdProduct, @RequestBody AlumnoRequest inputProduct) {
        Boolean resultado = alumnoService.actualizar(inputIdProduct, inputProduct);
        return GenericResponse.builder().
                result(resultado)
                .build();

    }


    @GetMapping("/search-by-activos")
    List<AlumnoResponse> obtenerAlumnosActivos() {
        return alumnoService.buscarActivos();
    }

    @GetMapping("/search-by-name")
    List<AlumnoResponse> obtenerAlumnosActivosPorNombre(@RequestParam(name = "nombre", required = true) String nombre) {
        return alumnoService.buscarPorNombre(nombre);
    }

    @GetMapping("/search-by-fechaNacimiento")
    List<AlumnoResponse> findByFechaNacimientoAfter(@RequestParam(name = "fecha", required = true) String fecha) {

        LocalDateTime fechaDateTime = LocalDateTime.parse(fecha);
        return alumnoService.findByFechaNacimientoAfter(fechaDateTime);
    }
    @GetMapping("/search-by-dni")
    List<AlumnoResponse> findByDni(@RequestParam(name = "dni", required = true) String dni) {
        return alumnoService.findByDni(dni);
    }
    @GetMapping("/search-by-promedio")
    List<AlumnoResponse> findByPromedioBetween(@RequestParam(name = "num1", required = true) Double num1,
                                               @RequestParam(name = "num2", required = true) Double num2) {
        return alumnoService.findByPromedioBetween(num1, num2);
    }

}
