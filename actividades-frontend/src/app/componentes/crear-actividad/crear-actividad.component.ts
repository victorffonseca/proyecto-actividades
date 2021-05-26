import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Actividad } from 'src/app/common/actividad';
import { Empleado } from 'src/app/common/empleado';
import { ActividadService } from 'src/app/servicios/actividad.service';
import { EmpleadoService } from 'src/app/servicios/empleado.service';

@Component({
  selector: 'app-crear-actividad',
  templateUrl: './crear-actividad.component.html',
  styleUrls: ['./crear-actividad.component.css']
})
export class CrearActividadComponent implements OnInit {

  actividad: Actividad = new Actividad();
  empleados: Empleado[] = [];

  constructor(private actividadServicio: ActividadService, private empleadoServicio: EmpleadoService, private router: Router) { }

  ngOnInit(): void {
    this.obtenerEmpleados();
  }

  guardarActividad() {
    this.actividad.estado = false;
    this.actividadServicio.guardarActividad(this.actividad).subscribe(
      data => console.log(data)
    );
    this.actividad = new Actividad();
    this.actividad.estado = false;
    this.volverALista();
  }

  obtenerEmpleados() {
    this.empleadoServicio.obtenerEmpleados().subscribe(
      data => {
        this.empleados = data;
      }
    )
  }

  onSubmit() {
    this.guardarActividad();
  }

  volverALista() {
    this.router.navigate(['actividad']);
  }
}
