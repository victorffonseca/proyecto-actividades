/*
 * Servicios para Actividad
 */
package com.victor.controllers;

import com.victor.dao.ActividadRepo;
import com.victor.entidades.Actividad;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Victor Fonseca
 */
@Service
public class ActividadServicio {
    
    @Autowired
    private ActividadRepo actividadRepo;
    
    public List<Actividad> obtenerActividades() {
        return actividadRepo.findAll();
    }
    
    public Actividad guardarActividad(Actividad actividad) {
        return actividadRepo.save(actividad);
    }
    
    public Actividad obtenerActividadPorId(Integer idActividad) {
        return actividadRepo.findById(idActividad).orElse(null);
    }
    
    public Actividad actualizarActividad(Actividad nuevaActividad, Integer idActividad) {
        return actividadRepo.findById(idActividad).map(actividad -> {
            actividad.setNombreActividad(nuevaActividad.getNombreActividad());
            actividad.setFechaHoraEjecucion(nuevaActividad.getFechaHoraEjecucion());
            return actividadRepo.save(nuevaActividad);
        }).orElseGet(() -> {
           nuevaActividad.setIdActividad(idActividad);
           return actividadRepo.save(nuevaActividad);
        });
    }
    
    public void eliminarActividad(Integer idActividad) {
        actividadRepo.deleteById(idActividad);
    }
}
