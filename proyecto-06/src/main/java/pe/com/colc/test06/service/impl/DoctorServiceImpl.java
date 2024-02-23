package pe.com.colc.test06.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.colc.test06.controller.request.CiudadRequest;
import pe.com.colc.test06.controller.request.DoctorRequest;
import pe.com.colc.test06.controller.response.DoctorResponse;
import pe.com.colc.test06.controller.response.GenericResponse;
import pe.com.colc.test06.repository.bd2.entity.DoctorRegistrarEntity;
import pe.com.colc.test06.repository.bd2.entity.ListarDoctoresEntity;
import pe.com.colc.test06.repository.bd2.entity.ListarDoctoresPorNombreEntity;
import pe.com.colc.test06.repository.bd2.procedure.DoctorRepository;
import pe.com.colc.test06.service.DoctorService;
import java.util.List;


@Slf4j
@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public List<DoctorResponse> obtenerDoctores() {

        List<ListarDoctoresEntity> resultDataBase = doctorRepository.listarDoctores();
        log.info("obtenerPorPoblacionAndSueldo - resultDataBase = {}", resultDataBase);

        List<DoctorResponse> response = new ModelMapper().map(resultDataBase, new TypeToken<List<DoctorResponse>>(){}.getType());

        return  response;
    }

    @Override
    public List<DoctorResponse> obtenerDoctoresPorNombre(String nombre) {

        List<ListarDoctoresPorNombreEntity> resultDataBase = doctorRepository.listarDoctoresPorNombre(nombre);
        log.info("obtenerPorPoblacionAndSueldo - resultDataBase = {}", resultDataBase);

        List<DoctorResponse> response = new ModelMapper().map(resultDataBase, new TypeToken<List<DoctorResponse>>(){}.getType());

        return  response;
    }

    @Override
    public DoctorResponse obtenerUno(Integer id) {
        return null;
    }

    @Override
    public DoctorResponse crear(DoctorRequest request) {

        DoctorRegistrarEntity requestDataBase = new ModelMapper().map(request, DoctorRegistrarEntity.class);

        Integer idDoctorGenerated = doctorRepository.crearDoctor(requestDataBase);

        DoctorResponse response = DoctorResponse.builder().idDoctor(idDoctorGenerated).build();

        return response;
    }

    @Override
    public void actualizar(Integer id, DoctorRequest request) {

        DoctorRegistrarEntity requestDataBase = new ModelMapper().map(request, DoctorRegistrarEntity.class);
        log.info("request del controller = {}", request);
        log.info("convertido en entity para la BD = {}", requestDataBase);

        doctorRepository.actualizarDoctor(id, requestDataBase);
    }

    @Override
    public void eliminar(Integer id) {

        doctorRepository.eliminarDoctor(id);

    }
}
