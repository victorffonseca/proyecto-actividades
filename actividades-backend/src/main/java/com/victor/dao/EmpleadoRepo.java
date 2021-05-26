/*
 * Repositorio para entidad Empleado
 */
package com.victor.dao;

import com.victor.entidades.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author Victor Fonseca
 */
@Repository
public interface EmpleadoRepo extends JpaRepository<Empleado, Integer>{
    
}
