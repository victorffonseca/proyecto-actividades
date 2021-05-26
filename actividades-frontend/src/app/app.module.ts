import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ListaActividadesComponent } from './componentes/lista-actividades/lista-actividades.component';
import { HttpClientModule } from '@angular/common/http'
import { ActividadService } from './servicios/actividad.service';
import { YesNoPipe } from './yes-no.pipe';
import { CrearActividadComponent } from './componentes/crear-actividad/crear-actividad.component';
import { DetallesActividadComponent } from './componentes/detalles-actividad/detalles-actividad.component';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';

@NgModule({
  declarations: [
    AppComponent,
    ListaActividadesComponent,
    YesNoPipe,
    CrearActividadComponent,
    DetallesActividadComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [ActividadService],
  bootstrap: [AppComponent]
})
export class AppModule { }
