package pe.com.colc.test06.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.colc.test06.controller.response.CiudadResponse;
import pe.com.colc.test06.service.CiudadService;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/ciudad")
public class CiudadesController {


    @Autowired
    CiudadService ciudadService;


    @GetMapping
    List<CiudadResponse> obtenerCiudadesPorPoblacionYSueldo() {

        List<CiudadResponse> lista2 =  ciudadService.obtenerPorPoblacionAndSueldo(2000, 1500.0);
        log.info("controller - obtenerDoctorAndEspecialidad - lista2 = {}", lista2);

        return lista2;
    }

}
