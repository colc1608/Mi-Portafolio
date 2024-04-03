package com.empresa.infraestructure.client.persistence.repository;

import com.empresa.infraestructure.client.persistence.entity.AlumnoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<AlumnoEntity, Long> {



}
