package pe.com.colc.test06.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public List<DoctorResponse> obtenerDoctorAndEspecialidad() {

        List<DoctorResponse> lista1 =  doctorService.obtenerPorEstadoAndNombre(true, "juan");
        log.info("controller - obtenerDoctorAndEspecialidad - lista1 = {}", lista1);

        return lista1;
    }

}
