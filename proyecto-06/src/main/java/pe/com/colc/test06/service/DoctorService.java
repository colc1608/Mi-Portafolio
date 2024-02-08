package pe.com.colc.test06.service;

import pe.com.colc.test06.controller.request.CiudadRequest;
import pe.com.colc.test06.controller.response.DoctorResponse;
import pe.com.colc.test06.controller.response.GenericResponse;

import java.util.List;

public interface DoctorService {

    public List<DoctorResponse> obtenerPorEstadoAndNombre(Boolean estado, String nombre);
    public DoctorResponse obtenerUno(Integer id);
    public GenericResponse crear(CiudadRequest request);

}
