package pe.com.colc.test06.repository.bd1.procedure.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import pe.com.colc.test06.repository.bd1.entity.CiudadEntityProcedure;
import pe.com.colc.test06.repository.bd1.mapper.CiudadMapper;
import pe.com.colc.test06.repository.bd1.procedure.CiudadRepository;
import java.util.List;
import java.util.Map;

@Repository
public class CiudadRepositoryImpl implements CiudadRepository {

    @Autowired
    @Qualifier("jdbcTemplate1")
    private JdbcTemplate jdbcTemplate1;

    @Override
    public List<CiudadEntityProcedure> listarCiudades(Double sueldoPromedio, Integer poblacion) {

        //Preparar parametros
        MapSqlParameterSource sqlParameter = new MapSqlParameterSource()
                .addValue("in_sueldo_promedio", sueldoPromedio)
                .addValue("in_poblacion", poblacion);

        //Preparar Procedure
        Map<String, Object> resultProcedure = new SimpleJdbcCall(jdbcTemplate1)
                .withProcedureName("SP_sueldo_por_poblacion")
                .returningResultSet("resulSet2", new CiudadMapper())
                .execute(sqlParameter);

        //Leer resultados
        List<CiudadEntityProcedure> response = (List<CiudadEntityProcedure>) resultProcedure.get("resulSet2");

        return response;
    }
}
