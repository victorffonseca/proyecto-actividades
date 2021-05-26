import { Empleado } from "./empleado";

export class Actividad {
    idActividad: number;
    nombreActividad: string;
    fechaHoraEjecucion: string;
    estado: boolean;
    empleado: Empleado;
    diasRetraso: number;

    constructor() {
        this.idActividad = 0;
        this.nombreActividad = '';
        this.fechaHoraEjecucion = "";
        this.estado = true;
        this.empleado = new Empleado();
        this.diasRetraso = 0;
    }
}
