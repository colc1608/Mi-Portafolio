package pe.com.colc.test06.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.colc.test06.controller.request.CiudadRequest;
import pe.com.colc.test06.controller.response.CiudadResponse;
import pe.com.colc.test06.controller.response.GenericResponse;
import pe.com.colc.test06.repository.bd1.entity.CiudadEntityProcedure;
import pe.com.colc.test06.repository.bd1.procedure.CiudadRepository;
import pe.com.colc.test06.service.CiudadService;
import java.util.List;


@Slf4j
@Service
public class CiudadServiceImpl implements CiudadService {

    @Autowired
    CiudadRepository ciudadRepository;

    @Override
    public List<CiudadResponse> obtenerPorPoblacionAndSueldo(Integer poblacion, Double sueldoPromedio) {

        List<CiudadEntityProcedure> resultDataBase = ciudadRepository.listarCiudades(sueldoPromedio,poblacion);
        log.info("obtenerPorPoblacionAndSueldo - resultDataBase = {}", resultDataBase);
        List<CiudadResponse> response = new ModelMapper().map(resultDataBase, new TypeToken<List<CiudadResponse>>(){}.getType());

        return  response;
    }

    @Override
    public CiudadResponse obtenerUno(Integer id) {
        return null;
    }

    @Override
    public GenericResponse crear(CiudadRequest request) {
        return null;
    }
}
