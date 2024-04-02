package pe.com.colc.test.infraestructure.out;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pe.com.colc.test.domain.model.AlumnoQuery;
import pe.com.colc.test.domain.repository.AlumnoQueryRepo;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AlumnoQueryRepoImpl implements AlumnoQueryRepo {
    @Override
    public Optional<AlumnoQuery> obtenerPorId(int id) {

        AlumnoQuery obj1 = AlumnoQuery.builder()
                .id(1)
                .precio(48.6)
                .descripcion("laptop")
                .stock(11)
                .fechaRegistro(LocalDateTime.of(2019, 6, 28, 9, 12, 48))
                .build();

        //return Optional.empty();
        return Optional.of(obj1);

    }

    @Override
    public List<AlumnoQuery> mostrarTodo() {

        AlumnoQuery obj2 = AlumnoQuery.builder()
                .id(2)
                .precio(36.4)
                .descripcion("iphone")
                .stock(22)
                .fechaRegistro(LocalDateTime.of(2017, 8, 16, 14, 33, 48))
                .build();

        AlumnoQuery obj3 = AlumnoQuery.builder()
                .id(3)
                .precio(83.1)
                .descripcion("smart tv")
                .stock(34)
                .fechaRegistro(LocalDateTime.of(2021, 4, 19, 19, 47, 48))
                .build();

        ArrayList<AlumnoQuery> response = new ArrayList<>();
        response.add(obj2);
        response.add(obj3);

        return response;
    }
}
