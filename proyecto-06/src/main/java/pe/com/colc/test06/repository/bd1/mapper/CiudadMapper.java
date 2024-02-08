package pe.com.colc.test06.repository.bd1.mapper;

import org.springframework.jdbc.core.RowMapper;
import pe.com.colc.test06.repository.bd1.entity.CiudadEntityProcedure;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class CiudadMapper implements RowMapper<CiudadEntityProcedure> {


    @Override
    public CiudadEntityProcedure mapRow(ResultSet rs, int rowNum) throws SQLException {


        return CiudadEntityProcedure.builder()
                .idCiudad(rs.getInt("id_ciudades"))
                .nombreCiudad(rs.getString("nombre").trim())
                .poblacion(rs.getInt("poblacion"))
                .sueldoPromedio(rs.getDouble("sueldo_promedio"))
                .fechaSenso( LocalDateTime.parse(rs.getString("fecha_senso"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) )
                .descripcion(rs.getString("descripcion"))
                .build();
    }


}
