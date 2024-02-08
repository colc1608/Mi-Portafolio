package pe.com.colc.test06.repository.bd2.mapper;

import org.springframework.jdbc.core.RowMapper;
import pe.com.colc.test06.repository.bd2.entity.ListarDoctoresPorNombreEntity;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListarDoctoresPorNombreMapper implements RowMapper<ListarDoctoresPorNombreEntity> {


    @Override
    public ListarDoctoresPorNombreEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return ListarDoctoresPorNombreEntity.builder()
                .nombreEspecialidad(rs.getString("nombre_especialidad").trim())
                .idDoctor(rs.getInt("id_doctor"))
                .nombreDoctor(rs.getString("nombre_doctor").trim())
                .apellidoDoctor(rs.getString("apellido").trim())
                .codigoColegiatura(rs.getString("codigo_colegiatura").trim())
                .sueldo(rs.getDouble("sueldo"))
                .estado(rs.getBoolean("estado"))
                .build();
    }

}
