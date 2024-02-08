package pe.com.colc.test06.repository.bd2.procedure;

import org.springframework.stereotype.Repository;
import pe.com.colc.test06.repository.bd2.entity.DoctorEspecialidadEntity;

import java.util.List;


public interface DoctorRepository {

    public List<DoctorEspecialidadEntity> obtenerDoctores(Boolean estado, String nombre);

}
