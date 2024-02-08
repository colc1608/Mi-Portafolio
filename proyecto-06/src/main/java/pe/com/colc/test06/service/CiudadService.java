package pe.com.colc.test06.service;

import pe.com.colc.test06.controller.request.CiudadRequest;
import pe.com.colc.test06.controller.response.CiudadResponse;
import pe.com.colc.test06.controller.response.GenericResponse;
import java.util.List;

public interface CiudadService {

    public List<CiudadResponse> obtenerPorPoblacionAndSueldo(Integer poblacion, Double sueldoPromedio);
    public CiudadResponse obtenerUno(Integer id);
    public GenericResponse crear(CiudadRequest request);


}
