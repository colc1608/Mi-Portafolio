package pe.com.colc.test06.repository.bd2.mapper;

import org.springframework.jdbc.core.RowMapper;
import pe.com.colc.test06.repository.bd2.entity.DoctorEspecialidadEntity;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorEspecialidadMapper implements RowMapper<Object> {


    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return DoctorEspecialidadEntity.builder()
                .nombreEspecialidad(rs.getString("nombre").trim())
                .idDoctor(rs.getInt("id_doctor"))
                .nombreDoctor(rs.getString("nombre").trim())
                .apellidoDoctor(rs.getString("apellido").trim())
                .codigoColegiatura(rs.getString("codigo_colegiatura").trim())
                .sueldo(rs.getDouble("sueldo"))
                .estado(rs.getBoolean("estado"))
                .build();
    }


}
