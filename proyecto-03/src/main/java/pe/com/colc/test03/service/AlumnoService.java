package pe.com.colc.test03.service;

import pe.com.colc.test03.controller.request.AlumnoRequest;
import pe.com.colc.test03.controller.response.AlumnoResponse;

import java.time.LocalDateTime;
import java.util.List;

public interface AlumnoService {

    public List<AlumnoResponse> obtenerTodos();
    public AlumnoResponse obtenerPorId(Integer inputId);
    public boolean eliminar(Integer id);
    public AlumnoResponse crear(AlumnoRequest productRequest);
    public boolean actualizar(Integer id, AlumnoRequest productRequest);

    //OTROS
    public List<AlumnoResponse> obtenerPorFiltro(Double precioMaximo, Double precioMinimo);
    public List<AlumnoResponse> buscarActivos();
    public List<AlumnoResponse> buscarPorNombre(String nombre);
    public List<AlumnoResponse> findByFechaNacimientoAfter(LocalDateTime nombre);
    public List<AlumnoResponse> findByDni(String nombre);
    public List<AlumnoResponse> findByPromedioBetween(Double num1, Double num2);

}
