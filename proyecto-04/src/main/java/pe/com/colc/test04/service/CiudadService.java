package pe.com.colc.test04.service;

import pe.com.colc.test04.controller.request.CiudadRequest;
import pe.com.colc.test04.controller.response.CiudadResponse;
import pe.com.colc.test04.repository.entity.CiudadEntity;
import java.util.List;

public interface CiudadService {

    public List<CiudadResponse> obtenerTodos();
    public CiudadResponse obtenerPorId(Integer id);
    public CiudadResponse crear(CiudadRequest request);
    public boolean eliminar(Integer id);
    public boolean actualizar(Integer id, CiudadRequest request);


}
