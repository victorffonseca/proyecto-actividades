import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { CrearActividadComponent } from './componentes/crear-actividad/crear-actividad.component';
import { ListaActividadesComponent } from './componentes/lista-actividades/lista-actividades.component';
import { DetallesActividadComponent } from './componentes/detalles-actividad/detalles-actividad.component';

const routes: Routes = [
  { path: '', redirectTo: 'actividad', pathMatch: 'full' },
  { path: 'actividad', component: ListaActividadesComponent },
  { path: 'agregarActividad', component: CrearActividadComponent },
  { path: 'detallesActividad/:id', component: DetallesActividadComponent },
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }