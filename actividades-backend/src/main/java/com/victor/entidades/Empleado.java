/*
 * Entidad para tabla Empleado
 */
package com.victor.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Victor Fonseca
 */

@Entity
@Table(name = "empleado")
@Getter
@Setter
public class Empleado implements Serializable {
    
    @Id
    @Column(name = "numero_documento")
    private int numeroDocumento;
    
    @Column(name = "nombre_completo")
    private String nombreCompleto;
}