package pe.com.colc.test.application.find;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.com.colc.test.domain.model.AlumnoQuery;
import pe.com.colc.test.domain.repository.AlumnoQueryRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlumnoFindUseCase {

    private final AlumnoQueryRepo alumnoQueryRepo;

    public List<AlumnoQuery> obtenerTodo(){

        return alumnoQueryRepo.mostrarTodo();

    }


    public AlumnoQuery obtenerPorId(Integer id){

        return alumnoQueryRepo.obtenerPorId(id).orElseThrow();

    }


}
