package pe.com.colc.test06.repository.bd2.procedure.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import pe.com.colc.test06.repository.bd2.entity.DoctorEspecialidadEntity;
import pe.com.colc.test06.repository.bd2.mapper.DoctorEspecialidadMapper;
import pe.com.colc.test06.repository.bd2.procedure.DoctorRepository;
import java.util.List;
import java.util.Map;

@Repository
public class DoctorRepositoryImpl implements DoctorRepository {

    @Autowired
    @Qualifier("jdbcTemplate2")
    private JdbcTemplate jdbcTemplate2;

    @Override
    public List<DoctorEspecialidadEntity> obtenerDoctores(Boolean estado, String nombre) {

        //Preparar parametros
        MapSqlParameterSource sqlParameter = new MapSqlParameterSource()
                .addValue("in_activo", estado)
                .addValue("nombre", nombre);

        //Preparar Procedure
        Map<String, Object> resultProcedure = new SimpleJdbcCall(jdbcTemplate2)
                .withProcedureName("SP_ListarDoctores")
                .withSchemaName("dbo")
                .returningResultSet("resulSet1", new DoctorEspecialidadMapper())
                .execute(sqlParameter);

        //Leer resultados
        List<DoctorEspecialidadEntity> listaAfiliado = (List<DoctorEspecialidadEntity>) resultProcedure.get("resulSet1");

        return listaAfiliado;
    }


}
