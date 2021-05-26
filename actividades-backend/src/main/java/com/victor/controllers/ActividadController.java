/*
 * Controlador para Actividad
 */
package com.victor.controllers;

import com.victor.entidades.Actividad;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Victor Fonseca
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class ActividadController {
    
    @Autowired
    private ActividadServicio actividadServicio;
    
    @GetMapping("/actividades")
    public List<Actividad> obtenerActividades() {
        return actividadServicio.obtenerActividades();
    }
    
    @PostMapping("/actividades")
    public Actividad guardarActividad(@RequestBody Actividad actividad) {
        return actividadServicio.guardarActividad(actividad);
    }
    
    @GetMapping("/actividades/{idActividad}")
    public Actividad obtenerActividadPorId(@PathVariable Integer idActividad) {
        return actividadServicio.obtenerActividadPorId(idActividad);
    }
    
    @PutMapping("/actividades/{idActividad}")
    public Actividad actualizarActividad(@RequestBody Actividad nuevaActividad, @PathVariable Integer idActividad) {
        return actividadServicio.actualizarActividad(nuevaActividad, idActividad);
    }
    
    @DeleteMapping("/actividades/{idActividad}")
    public void eliminarActividad(@PathVariable Integer idActividad) {
        actividadServicio.eliminarActividad(idActividad);
    }
}
