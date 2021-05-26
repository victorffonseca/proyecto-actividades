/*
 * Repositorio para entidad Actividad
 */
package com.victor.dao;

import com.victor.entidades.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Victor Fonseca
 */
@Repository
public interface ActividadRepo extends JpaRepository<Actividad, Integer> {
    
}