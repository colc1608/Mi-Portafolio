package pe.com.colc.test06.repository.bd2.mapper;

import org.springframework.jdbc.core.RowMapper;
import pe.com.colc.test06.repository.bd2.entity.ListarDoctoresEntity;
import pe.com.colc.test06.repository.bd2.entity.ListarDoctoresPorNombreEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ListarDoctoresMapper implements RowMapper<ListarDoctoresEntity> {


    @Override
    public ListarDoctoresEntity mapRow(ResultSet rs, int rowNum) throws SQLException {

        return ListarDoctoresEntity.builder()

                .idDoctor(rs.getInt("id_doctor"))
                .nombreDoctor(rs.getString("nombre_doctor").trim())
                .apellidoDoctor(rs.getString("apellido").trim())
                .idEspecialidad(rs.getInt("id_especialidad"))
                .nombreEspecialidad(rs.getString("nombre_especialidad").trim())
                .codigoColegiatura(rs.getString("codigo_colegiatura").trim())
                .sueldo(rs.getDouble("sueldo"))
                .fechaNacimiento( LocalDateTime.parse(rs.getString("fecha_nacimiento"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S")) )
                .estado(rs.getBoolean("estado"))
                .build();
    }
}
