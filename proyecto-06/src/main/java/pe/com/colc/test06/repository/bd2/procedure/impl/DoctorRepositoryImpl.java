package pe.com.colc.test06.repository.bd2.procedure.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import pe.com.colc.test06.repository.bd2.entity.DoctorRegistrarEntity;
import pe.com.colc.test06.repository.bd2.entity.ListarDoctoresEntity;
import pe.com.colc.test06.repository.bd2.entity.ListarDoctoresPorNombreEntity;
import pe.com.colc.test06.repository.bd2.mapper.ListarDoctoresMapper;
import pe.com.colc.test06.repository.bd2.mapper.ListarDoctoresPorNombreMapper;
import pe.com.colc.test06.repository.bd2.procedure.DoctorRepository;
import java.util.List;
import java.util.Map;

@Slf4j
@Repository
public class DoctorRepositoryImpl implements DoctorRepository {

    @Autowired
    @Qualifier("jdbcTemplate2")
    private JdbcTemplate jdbcTemplate2;

    private static final String SP_CREAR_DOCTOR = "SP_CrearDoctor";
    private static final String SP_OBTENER_DOCTORES = "SP_ListarDoctores";
    private static final String SP_OBTENER_DOCTORES_POR_NOMBRE = "SP_ListarDoctoresPorNombre";
    private static final String SP_ACTUALIZAR_DOCTOR = "SP_ActualizarDoctor";
    private static final String SP_ELIMNINAR_DOCTOR = "SP_EliminarDoctor";
    private static final String ESQUEMA_DATABASE = "dbo";


    @Override
    public List<ListarDoctoresPorNombreEntity> listarDoctoresPorNombre(String nombre) {

        //Preparar parametros
        MapSqlParameterSource sqlParameter = new MapSqlParameterSource()
                .addValue("P_nombre", nombre);

        //Preparar Procedure
        Map<String, Object> resultProcedure = new SimpleJdbcCall(jdbcTemplate2)
                .withProcedureName(SP_OBTENER_DOCTORES_POR_NOMBRE)
                .withSchemaName(ESQUEMA_DATABASE)
                .returningResultSet("rptaDataBase", new ListarDoctoresPorNombreMapper())
                .execute(sqlParameter);

        //Leer resultados
        List<ListarDoctoresPorNombreEntity> listaAfiliado = (List<ListarDoctoresPorNombreEntity>) resultProcedure.get("rptaDataBase");

        return listaAfiliado;
    }

    @Override
    public List<ListarDoctoresEntity> listarDoctores() {

        //Preparar Procedure
        Map<String, Object> resultProcedure = new SimpleJdbcCall(jdbcTemplate2)
                .withProcedureName(SP_OBTENER_DOCTORES)
                .withSchemaName(ESQUEMA_DATABASE)
                .returningResultSet("rptaDataBase", new ListarDoctoresMapper())
                .execute();

        //Leer resultados
        List<ListarDoctoresEntity> listaAfiliado = (List<ListarDoctoresEntity>) resultProcedure.get("rptaDataBase");

        return listaAfiliado;
    }

    @Override
    public Integer crearDoctor(DoctorRegistrarEntity request) {

        //Preparar parametros
        MapSqlParameterSource sqlParameter = new MapSqlParameterSource()
                .addValue("P_id_especialidad", request.getIdEspecialidad())
                .addValue("P_nombre", request.getNombreDoctor())
                .addValue("P_apellido", request.getApellidoDoctor())
                .addValue("P_codigo_colegiatura", request.getCodigoColegiatura())
                .addValue("P_sueldo", request.getSueldo())
                .addValue("P_fecha_nacimiento", request.getFechaNacimiento());

        //Preparar Procedure
        Map<String, Object> resultProcedure = new SimpleJdbcCall(jdbcTemplate2)
                .withProcedureName(SP_CREAR_DOCTOR)
                .withSchemaName(ESQUEMA_DATABASE)
                .execute(sqlParameter);

        //Leer resultados
        List<Map<String, Object>> result1  = (List<Map<String, Object>>) resultProcedure.get("#result-set-1");
        Integer idResponse = (Integer) result1.get(0).get("id_doctor");

        // Pruebas para obtener el ID
        //log.info("crearDoctor - result 2 = {}", result1);
        //log.info("crearDoctor - result 3 = {}", result1.get(0));
        //log.info("crearDoctor - result 4 = {}", result1.get(0).get("id_doctor"));
        log.info("crearDoctor - Se genero el ID = {}", idResponse);
        log.info("crearDoctor - Para el request entity = {}", request);

        return idResponse;
    }

    @Override
    public void actualizarDoctor(Integer id, DoctorRegistrarEntity request) {

        //Preparar parametros
        MapSqlParameterSource sqlParameter = new MapSqlParameterSource()
                .addValue("P_id", id)
                .addValue("P_id_especialidad", request.getIdEspecialidad())
                .addValue("P_nombre", request.getNombreDoctor())
                .addValue("P_apellido", request.getApellidoDoctor())
                .addValue("P_codigo_colegiatura", request.getCodigoColegiatura())
                .addValue("P_sueldo", request.getSueldo())
                .addValue("P_fecha_nacimiento", request.getFechaNacimiento());

        //Preparar Procedure
        new SimpleJdbcCall(jdbcTemplate2)
                .withProcedureName(SP_ACTUALIZAR_DOCTOR)
                .withSchemaName(ESQUEMA_DATABASE)
                .execute(sqlParameter);

    }

    @Override
    public void eliminarDoctor(Integer id) {

        //Preparar parametros
        MapSqlParameterSource sqlParameter = new MapSqlParameterSource()
                .addValue("P_id", id);

        //Preparar Procedure
        new SimpleJdbcCall(jdbcTemplate2)
                .withProcedureName(SP_ELIMNINAR_DOCTOR)
                .withSchemaName(ESQUEMA_DATABASE)
                .execute(sqlParameter);

    }


}
