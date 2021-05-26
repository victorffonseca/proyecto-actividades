import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Empleado } from '../common/empleado';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class EmpleadoService {

  private baseUrl = 'http://localhost:8080/api/empleados';

  constructor(private httpClient: HttpClient) { }

  obtenerEmpleados(): Observable<Empleado[]> {
    return this.httpClient.get<Empleado[]>(this.baseUrl).pipe(
      map(response => response)
    );
  }
}
