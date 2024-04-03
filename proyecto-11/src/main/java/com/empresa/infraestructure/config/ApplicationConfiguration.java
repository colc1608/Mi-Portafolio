package com.empresa.infraestructure.config;

import com.empresa.application.adapter.AlumnoServiceImpl;
import com.empresa.application.port.AlumnoService;
import com.empresa.domain.port.AlumnoPort;
import com.empresa.infraestructure.client.persistence.adapter.AlumnoPersistenceAdapter;
import com.empresa.infraestructure.client.persistence.repository.AlumnoRepository;
import com.empresa.infraestructure.client.rest.controller.AlumnoController;
import com.empresa.infraestructure.client.rest.exception.ApiExceptionHandler;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackageClasses = {ApiExceptionHandler.class})
@EntityScan(basePackageClasses = {com.empresa.infraestructure.client.persistence.entity.AlumnoEntity.class})
@EnableJpaRepositories(basePackageClasses = { com.empresa.infraestructure.client.persistence.repository.AlumnoRepository.class })
public class ApplicationConfiguration {

    @Bean
    public AlumnoController alumnoController(AlumnoService service) {
        return new AlumnoController(service);
    }

    @Bean
    public AlumnoService movieService(AlumnoPort persistence) {
        return new AlumnoServiceImpl(persistence);
    }

    @Bean
    public AlumnoPort moviePersistence(AlumnoRepository repository) {
        return new AlumnoPersistenceAdapter(repository);
    }

}
