package pe.com.colc.test04.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.colc.test04.controller.request.CiudadRequest;
import pe.com.colc.test04.controller.response.CiudadResponse;
import pe.com.colc.test04.repository.CiudadRepository;
import pe.com.colc.test04.repository.entity.CiudadEntity;
import pe.com.colc.test04.service.CiudadService;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CiudadServiceImpl implements CiudadService {

    @Autowired
    CiudadRepository ciudadRepository;

    @Override
    public List<CiudadResponse> obtenerTodos() {

        List<CiudadEntity> resultDataBase = ciudadRepository.findAll();

        log.info("resul DataBase = {}", resultDataBase);
        List<CiudadResponse> response = new ModelMapper().map(resultDataBase, new TypeToken<List<CiudadResponse>>(){}.getType());

        return response;
    }

    @Override
    public CiudadResponse obtenerPorId(Integer id) {

        Optional<CiudadEntity> entity = ciudadRepository.findById(id);

        log.info("resul DataBase = {}", entity);

        CiudadResponse response = null;

        if(entity.isPresent()){
            response = new ModelMapper().map(entity, CiudadResponse.class);
        }

        return response;
    }

    @Override
    public CiudadResponse crear(CiudadRequest request) {

        CiudadEntity entity = new ModelMapper().map(request, CiudadEntity.class);

        entity = ciudadRepository.save(entity);

        CiudadResponse response = new ModelMapper().map(entity, CiudadResponse.class);

        return response;
    }

    @Override
    public boolean eliminar(Integer id) {

        Optional<CiudadEntity> entity = ciudadRepository.findById(id);

        log.info("resul DataBase = {}", entity);

        if(entity.isPresent()){
            ciudadRepository.delete(entity.get());
            return true;
        }

        return false;
    }

    @Override
    public boolean actualizar(Integer id, CiudadRequest request) {

        Optional<CiudadEntity> entity = ciudadRepository.findById(id);

        log.info("resul DataBase = {}", entity);

        if(entity.isPresent()){
            entity.get().setCiudadNombre(request.getCiudadNombre());
            entity.get().setCiudadCodigoPostal(request.getCiudadCodigoPostal());
            ciudadRepository.save(entity.get());
            return true;
        }

        return false;

    }


}
