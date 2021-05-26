/*
 * Controlador para empleado
 */
package com.victor.controllers;

import com.victor.entidades.Empleado;
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
public class EmpleadoController {
    
    @Autowired
    private EmpleadoServicio empleadoServicio;
    
    @GetMapping("/empleados")
    public List<Empleado> obtenerEmpleados() {
        return empleadoServicio.obtenerEmpleados();
    }
    
    @PostMapping("/empleados")
    public Empleado guardarEmpleado(@RequestBody Empleado empleado) {
        return empleadoServicio.guardarEmpleado(empleado);
    }
    
    @GetMapping("/empleados/{idEmpleado}")
    public Empleado obtenerEmpleadoPorId(@PathVariable Integer idEmpleado) {
        return empleadoServicio.obtenerEmpleadoPorId(idEmpleado);
    }
    
    @PutMapping("/empleados/{idEmpleado}")
    public Empleado actualizarEmpleado(@RequestBody Empleado nuevoEmpleado, @PathVariable Integer idEmpleado) {
        return empleadoServicio.actualizarEmpleado(nuevoEmpleado, idEmpleado);
    }
    
    @DeleteMapping("/empleados/{idEmpleado}")
    public void eliminarEmpleado(@PathVariable Integer idEmpleado) {
        empleadoServicio.eliminarEmpleado(idEmpleado);
    }
}
