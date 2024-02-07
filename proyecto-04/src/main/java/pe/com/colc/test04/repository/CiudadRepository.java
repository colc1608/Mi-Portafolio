package pe.com.colc.test04.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.colc.test04.repository.entity.CiudadEntity;

@Repository
public interface CiudadRepository extends JpaRepository<CiudadEntity, Integer>  {



}
