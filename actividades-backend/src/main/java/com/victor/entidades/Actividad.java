/*
 * Entidad para tabla Actividad
 */
package com.victor.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Victor Fonseca
 */

@Entity
@Table(name = "actividad")
@Data
public class Actividad implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_actividad")
    private int idActividad;
    
    @Column(name = "nombre_actividad")
    private String nombreActividad;
    
    @Column(name = "fecha_hora_ejec")
    private String fechaHoraEjecucion;
    
    @Column(name = "estado")
    private boolean estado;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "empleado", nullable = false)
    private Empleado empleado;

    public Actividad() {
    }
    
    public Actividad(int idActividad, String nombreActividad, String fechaHoraEjecucion, boolean estado, Empleado empleado) {
        this.idActividad = idActividad;
        this.nombreActividad = nombreActividad;
        this.fechaHoraEjecucion = fechaHoraEjecucion;
        this.estado = estado;
        this.empleado = empleado;
    }
}
