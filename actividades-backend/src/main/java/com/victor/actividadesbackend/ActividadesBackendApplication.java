package com.victor.actividadesbackend;

import com.victor.entidades.Actividad;
import com.victor.entidades.Empleado;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@SpringBootApplication
@EnableJpaRepositories("com.victor.*")
@ComponentScan(basePackages = { "com.victor.*" })
@EntityScan("com.victor.*")
public class ActividadesBackendApplication implements RepositoryRestConfigurer {

    public static void main(String[] args) {
            SpringApplication.run(ActividadesBackendApplication.class, args);
    }
        
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(Actividad.class);
        config.exposeIdsFor(Empleado.class);
    }
}