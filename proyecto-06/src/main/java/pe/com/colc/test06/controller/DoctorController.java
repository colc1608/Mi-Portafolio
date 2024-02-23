package pe.com.colc.test06.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.colc.test06.controller.request.DoctorRequest;
import pe.com.colc.test06.controller.response.DoctorResponse;
import pe.com.colc.test06.service.DoctorService;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @GetMapping
    public List<DoctorResponse> obtenerDoctores() {

        List<DoctorResponse> response =  doctorService.obtenerDoctores();
        return response;
    }

    @GetMapping("/search-by-name")
    public List<DoctorResponse> buscarPorNombre(@RequestParam(name = "nombreDoctor", required = true) String nombre) {

        List<DoctorResponse> response =  doctorService.obtenerDoctoresPorNombre(nombre);
        return response;
    }

    @PostMapping
    public DoctorResponse crearDoctor(@RequestBody DoctorRequest objInput) {
        DoctorResponse response =  doctorService.crear(objInput);
        return response;
    }


    @DeleteMapping("/{idDoc}")
    public void eliminarDoctor(@PathVariable("idDoc") Integer idDoctor) {

        doctorService.eliminar(idDoctor);

    }


    @PutMapping("/{idDoctor}")
    public void updateProduct(@PathVariable("idDoctor") Integer idDoc, @RequestBody DoctorRequest request) {

        doctorService.actualizar(idDoc, request);

    }

}
