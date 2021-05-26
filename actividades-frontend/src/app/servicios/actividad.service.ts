import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Actividad } from '../common/actividad';
import { Empleado } from '../common/empleado';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ActividadService {

  private baseUrl = 'http://localhost:8080/api/actividades';

  constructor(private httpClient: HttpClient) { }

  obtenerActividades(): Observable<Actividad[]> {
    return this.httpClient.get<Actividad[]>(this.baseUrl).pipe(
      map(response => response)
    );
  }

  guardarActividad(actividad: Actividad): Observable<Object> {
    return this.httpClient.post(this.baseUrl, actividad);
  }

  actualizarActividad(id: number, actividad: Actividad): Observable<Object> {
    return this.httpClient.put(`${this.baseUrl}/${id}`, actividad);
  }

  eliminarActividad(id: number): Observable<Object> {
    return this.httpClient.delete(`${this.baseUrl}/${id}`);
  }

  obtenerActividadPorId(id: number): Observable<Actividad> {
    return this.httpClient.get<Actividad>(`${this.baseUrl}/${id}`).pipe(
      map(response => response)
    );
  }


}
