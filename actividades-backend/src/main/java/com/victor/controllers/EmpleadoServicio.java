/*
 * Servicios para Empleado
 */
package com.victor.controllers;

import com.victor.dao.EmpleadoRepo;
import com.victor.entidades.Empleado;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Victor Fonseca
 */
@Service
public class EmpleadoServicio {
    
    @Autowired
    private EmpleadoRepo empleadoRepo;
    
    public List<Empleado> obtenerEmpleados() {
        return empleadoRepo.findAll();
    }
    
    public Empleado guardarEmpleado(Empleado empleado) {
        return empleadoRepo.save(empleado);
    }
    
    public Empleado obtenerEmpleadoPorId(Integer idEmpleado) {
        return empleadoRepo.findById(idEmpleado).orElse(null);
    }
    
    public Empleado actualizarEmpleado(Empleado nuevoEmpleado, Integer idEmpleado) {
        return empleadoRepo.findById(idEmpleado).map(empleado -> {
            empleado.setNumeroDocumento(nuevoEmpleado.getNumeroDocumento());
            empleado.setNombreCompleto(nuevoEmpleado.getNombreCompleto());
            return empleadoRepo.save(nuevoEmpleado);
        }).orElseGet(() -> {
           nuevoEmpleado.setNumeroDocumento(idEmpleado);
           return empleadoRepo.save(nuevoEmpleado);
        });
    }
    
    public void eliminarEmpleado(Integer idEmpleado) {
        empleadoRepo.deleteById(idEmpleado);
    }
}
