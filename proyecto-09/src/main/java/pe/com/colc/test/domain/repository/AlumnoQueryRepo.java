package pe.com.colc.test.domain.repository;

import pe.com.colc.test.domain.model.AlumnoQuery;

import java.util.List;
import java.util.Optional;

public interface AlumnoQueryRepo {

    Optional<AlumnoQuery> obtenerPorId(int id);

    List<AlumnoQuery> mostrarTodo();

}
