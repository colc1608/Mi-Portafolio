package pe.com.colc.test06.repository.bd1.procedure;

import pe.com.colc.test06.repository.bd1.entity.CiudadEntityProcedure;

import java.util.List;

public interface CiudadRepository {

    public List<CiudadEntityProcedure> listarCiudades(Double sueldoPromedio, Integer poblacion);

}
