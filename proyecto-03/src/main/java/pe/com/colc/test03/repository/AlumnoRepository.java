package pe.com.colc.test03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.com.colc.test03.repository.entity.AlumnoEntity;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AlumnoRepository extends JpaRepository<AlumnoEntity, Integer> {

    // =============================== NATIVO ===============================
    public List<AlumnoEntity> findByActivoTrue();
    public List<AlumnoEntity>  findByActivoTrueAndNombre(String nombre);
    public List<AlumnoEntity>  findByFechaNacimientoAfter(LocalDateTime fecha);
    public List<AlumnoEntity>  findByDni(String dni);
    public List<AlumnoEntity>  findByPromedioBetween(Double num1, Double num2);


    // =============================== QUERY ===============================

    // 1 -  QUERY SIMPLE
    @Query(value = "SELECT * FROM ALUMNO WHERE ACTIVO = TRUE", nativeQuery = true)
    public List<AlumnoEntity> buscarAlumnosActivos();

    @Query(value = "SELECT * FROM ALUMNO WHERE ACTIVO = TRUE AND NOMBRE = :inputNombre", nativeQuery = true)
    List<AlumnoEntity> buscarAlumnosActivosYNombre(@Param("inputNombre")String var1);

    @Query(value = "SELECT * FROM ALUMNO WHERE DNI = ?1", nativeQuery = true)
    public List<AlumnoEntity> buscarPorDni(String inputDni);



    // 2 -  QUERY CON PROCEDURE
    @Query(value = "CALL SP_buscarPorNombre(?1)", nativeQuery = true)
    public List<AlumnoEntity> procedureBuscarPorNombre(String nombre);

    @Query(value = "CALL SP_buscarPorDni(:inDni)", nativeQuery = true)
    public List<AlumnoEntity> procedureBuscarPorDni(@Param("inDni")String value1);

    @Query(value = "CALL SP_buscarPorPromedio(?1 , ?2);", nativeQuery = true)
    public List<AlumnoEntity> procedureBuscarPorPromedio(Double num1, Double num2);

    @Query(value = "CALL SP_buscarPorActivos()", nativeQuery = true)
    public List<AlumnoEntity> procedureBuscarPorActivo();

}
