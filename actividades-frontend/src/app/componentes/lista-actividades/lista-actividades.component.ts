import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Actividad } from 'src/app/common/actividad';
import { ActividadService } from 'src/app/servicios/actividad.service';

@Component({
  selector: 'app-lista-actividades',
  templateUrl: './lista-actividades.component.html',
  styleUrls: ['./lista-actividades.component.css']
})
export class ListaActividadesComponent implements OnInit {

  actividades: Actividad[];

  constructor(private actividadServicio: ActividadService, private router: Router) {
    this.actividades = [];
   }

  ngOnInit(): void {
    this.actividadesLista();
  }

  actividadesLista() {
    this.actividadServicio.obtenerActividades().subscribe(
      data => {
        this.actividades = data;
        this.actividades.forEach(actividad => {
          if (actividad.estado == false) {
            actividad.diasRetraso = Math.floor((+new Date(actividad.fechaHoraEjecucion) - +new Date())/ (1000 * 3600 * 24));
          } else {
            actividad.diasRetraso = 0;
          }
        });
      }
    )
  }

  eliminarActividad(id: number) {
    this.actividadServicio.eliminarActividad(id).subscribe(
      data => {
        console.log(data);
        this.actividadesLista();
      }
    )
  }

  detallesActividad(id: number){
    this.router.navigate(['detallesActividad', id]);
  }

  agregarActividad() {
    this.router.navigate(['agregarActividad']);
  }
}
