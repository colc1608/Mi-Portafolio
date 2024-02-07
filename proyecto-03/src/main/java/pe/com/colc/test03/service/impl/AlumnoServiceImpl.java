package pe.com.colc.test03.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.colc.test03.controller.request.AlumnoRequest;
import pe.com.colc.test03.controller.response.AlumnoResponse;
import pe.com.colc.test03.repository.AlumnoRepository;
import pe.com.colc.test03.repository.entity.AlumnoEntity;
import pe.com.colc.test03.service.AlumnoService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AlumnoServiceImpl implements AlumnoService {


    @Autowired
    AlumnoRepository alumnoRepository;

    @Override
    public List<AlumnoResponse> obtenerTodos() {
        List<AlumnoEntity> listaDB = alumnoRepository.findAll();
        log.info("resul DataBase = {}", listaDB);
        List<AlumnoResponse> response = new ModelMapper().map(listaDB, new TypeToken<List<AlumnoResponse>>(){}.getType());
        return response;
    }

    @Override
    public AlumnoResponse obtenerPorId(Integer inputId) {
        Optional<AlumnoEntity> resultRepository = alumnoRepository.findById(inputId);
        log.info("resul DataBase = {}", resultRepository);

        AlumnoResponse productResponse = null;

        if(resultRepository.isPresent()){
            productResponse = new ModelMapper().map(resultRepository.get(), AlumnoResponse.class);
        }

        return productResponse;
    }

    @Override
    public List<AlumnoResponse> obtenerPorFiltro(Double precioMaximo, Double precioMinimo) {
        return null;
    }

    @Override
    public List<AlumnoResponse> buscarActivos() {

        //List<AlumnoEntity> resultDataBase = alumnoRepository.findByActivoTrue(); // METODO 1
        //List<AlumnoEntity> resultDataBase = alumnoRepository.buscarAlumnosActivos(); // METODO 2
        List<AlumnoEntity> resultDataBase = alumnoRepository.procedureBuscarPorActivo(); // JPA CON PROCEDURE
        log.info("resul DataBase = {}", resultDataBase);

        List<AlumnoResponse> response = new ModelMapper().map(resultDataBase, new TypeToken<List<AlumnoResponse>>(){}.getType());
        return response;

    }

    @Override
    public List<AlumnoResponse> buscarPorNombre(String nombre) {

        //List<AlumnoEntity> resultDataBase = alumnoRepository.findByActivoTrueAndNombre(nombre); // METODO 1
        //List<AlumnoEntity> resultDataBase = alumnoRepository.buscarAlumnosActivosYNombre(nombre); // METODO 2
        List<AlumnoEntity> resultDataBase = alumnoRepository.procedureBuscarPorNombre(nombre); // METODO 3
        log.info("resul DataBase = {}", resultDataBase);

        List<AlumnoResponse> response = new ModelMapper().map(resultDataBase, new TypeToken<List<AlumnoResponse>>(){}.getType());
        return response;
    }

    @Override
    public List<AlumnoResponse> findByFechaNacimientoAfter(LocalDateTime fecha) {
        List<AlumnoEntity> resultDataBase = alumnoRepository.findByFechaNacimientoAfter(fecha);
        log.info("resul DataBase = {}", resultDataBase);
        List<AlumnoResponse> response = new ModelMapper().map(resultDataBase, new TypeToken<List<AlumnoResponse>>(){}.getType());
        return response;
    }

    @Override
    public List<AlumnoResponse> findByDni(String dni) {

        //List<AlumnoEntity> resultDataBase = alumnoRepository.findByDni(dni); //METODO 1
        //List<AlumnoEntity> resultDataBase = alumnoRepository.buscarPorDni(dni); //METODO 2
        List<AlumnoEntity> resultDataBase = alumnoRepository.procedureBuscarPorDni(dni); //METODO 3
        log.info("resul DataBase = {}", resultDataBase);

        List<AlumnoResponse> response = new ModelMapper().map(resultDataBase, new TypeToken<List<AlumnoResponse>>(){}.getType());
        return response;
    }

    @Override
    public List<AlumnoResponse> findByPromedioBetween(Double n1, Double n2) {

        //List<AlumnoEntity> resultDataBase = alumnoRepository.findByPromedioBetween(n1, n2);// JPA NATIVO
        List<AlumnoEntity> resultDataBase = alumnoRepository.procedureBuscarPorPromedio(n1, n2);// JPA PROCEDURE

        log.info("resul DataBase = {}", resultDataBase);

        List<AlumnoResponse> response = new ModelMapper().map(resultDataBase, new TypeToken<List<AlumnoResponse>>(){}.getType());
        return response;
    }

    @Override
    public boolean eliminar(Integer id) {
        Optional<AlumnoEntity> resultRepository = alumnoRepository.findById(id);
        log.info("resul DataBase = {}", resultRepository);

        if(resultRepository.isPresent()){
            resultRepository.get().setActivo(false);
            alumnoRepository.save(resultRepository.get());
            return true;
        }

        return false;
    }

    @Override
    public AlumnoResponse crear(AlumnoRequest productRequest) {
        AlumnoEntity productEntity = new ModelMapper().map(productRequest, AlumnoEntity.class);
        productEntity = alumnoRepository.save(productEntity);

        AlumnoResponse response = new ModelMapper().map(productEntity, AlumnoResponse.class);

        return response;
    }

    @Override
    public boolean actualizar(Integer id, AlumnoRequest productRequest) {
        Optional<AlumnoEntity> resultRepository = alumnoRepository.findById(id);
        log.info("resul DataBase = {}", resultRepository);

        if(resultRepository.isPresent()){
            resultRepository.get().setNombre(productRequest.getNombre());
            resultRepository.get().setApellido(productRequest.getApellido());
            resultRepository.get().setFechaNacimiento(productRequest.getFechaNacimiento());
            resultRepository.get().setPromedio(productRequest.getPromedio());
            alumnoRepository.save(resultRepository.get());
            return true;
        }
        return false;
    }
}
