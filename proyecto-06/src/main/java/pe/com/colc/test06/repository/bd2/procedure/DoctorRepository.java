package pe.com.colc.test06.repository.bd2.procedure;

import pe.com.colc.test06.repository.bd2.entity.DoctorRegistrarEntity;
import pe.com.colc.test06.repository.bd2.entity.ListarDoctoresEntity;
import pe.com.colc.test06.repository.bd2.entity.ListarDoctoresPorNombreEntity;

import java.util.List;


public interface DoctorRepository {

    public List<ListarDoctoresPorNombreEntity> listarDoctoresPorNombre(String nombre);

    public List<ListarDoctoresEntity> listarDoctores();

    public Integer crearDoctor(DoctorRegistrarEntity request);

}
