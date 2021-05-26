import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Actividad } from 'src/app/common/actividad';
import { Empleado } from 'src/app/common/empleado';
import { ActividadService } from 'src/app/servicios/actividad.service';
import { EmpleadoService } from 'src/app/servicios/empleado.service';

@Component({
  selector: 'app-detalles-actividad',
  templateUrl: './detalles-actividad.component.html',
  styleUrls: ['./detalles-actividad.component.css']
})
export class DetallesActividadComponent implements OnInit {

  id: number = 0;
  actividad: Actividad = new Actividad();
  diasRetraso: number = 0;
  empleados: Empleado[] = [];

  constructor(private actividadServicio: ActividadService, private route: ActivatedRoute, private router: Router,
              private empleadoServicio: EmpleadoService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.actividadServicio.obtenerActividadPorId(this.id).subscribe(
      data => {
        this.actividad = data;
      });

    this.obtenerEmpleados();
  }

  volverALista() {
    this.router.navigate(['actividad']);
  }

  actualizarActividad() {
    this.actividadServicio.actualizarActividad(this.actividad.idActividad, this.actividad).subscribe(
      data => console.log(data)
    );
    this.actividad = new Actividad();
    this.actividad.estado = false;
  }

  onSubmit() {
    this.actualizarActividad();
    this.router.navigate(['/actividad']);
  }

  obtenerEmpleados() {
    this.empleadoServicio.obtenerEmpleados().subscribe(
      data => {
        this.empleados = data;
      });
  }
}
