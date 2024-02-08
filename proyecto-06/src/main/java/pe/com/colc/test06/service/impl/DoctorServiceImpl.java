package pe.com.colc.test06.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.colc.test06.controller.request.CiudadRequest;
import pe.com.colc.test06.controller.response.DoctorResponse;
import pe.com.colc.test06.controller.response.GenericResponse;
import pe.com.colc.test06.repository.bd2.entity.DoctorEspecialidadEntity;
import pe.com.colc.test06.repository.bd2.procedure.DoctorRepository;
import pe.com.colc.test06.service.DoctorService;
import java.util.List;


@Slf4j
@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public List<DoctorResponse> obtenerPorEstadoAndNombre(Boolean estado, String nombre) {

        List<DoctorEspecialidadEntity> resultDataBase = doctorRepository.obtenerDoctores(estado,nombre);
        log.info("obtenerPorPoblacionAndSueldo - resultDataBase = {}", resultDataBase);

        List<DoctorResponse> response = new ModelMapper().map(resultDataBase, new TypeToken<List<DoctorResponse>>(){}.getType());

        return  response;
    }

    @Override
    public DoctorResponse obtenerUno(Integer id) {
        return null;
    }

    @Override
    public GenericResponse crear(CiudadRequest request) {
        return null;
    }
}
