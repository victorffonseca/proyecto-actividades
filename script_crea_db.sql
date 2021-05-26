-- Creacion de la base de datos
CREATE DATABASE proyecto;

-- Tabla de empleados
CREATE TABLE empleado
(
	numero_documento INT PRIMARY KEY,
	nombre_completo VARCHAR(400) NOT NULL
) ENGINE=InnoDB;

-- Tabla de actividades
CREATE TABLE actividad
(
	id_actividad INT AUTO_INCREMENT PRIMARY KEY,
	nombre_actividad VARCHAR(250) NOT NULL,
	fecha_hora_ejec VARCHAR(100) NOT NULL,
	estado BOOL NOT NULL,
	empleado INT,
	FOREIGN KEY (empleado) REFERENCES empleado(numero_documento)
) ENGINE=INNODB;

INSERT INTO empleado (numero_documento, nombre_completo)
VALUES (40024765, "Jose Perez");

INSERT INTO empleado (numero_documento, nombre_completo)
VALUES (1047256928, "Maria Perdomo");

INSERT INTO empleado (numero_documento, nombre_completo)
VALUES (50019284, "Gustavo Peralta");

INSERT INTO actividad (nombre_actividad, fecha_hora_ejec, estado, empleado)
VALUES ("Organizar documentos", "2021-05-20", TRUE, 40024765);

INSERT INTO actividad (nombre_actividad, fecha_hora_ejec, estado, empleado)
VALUES ("Seguimiento proyecto", "2021-05-01", FALSE, 40024765);

INSERT INTO actividad (nombre_actividad, fecha_hora_ejec, estado, empleado)
VALUES ("Desarrollo web app", "2021-05-24", TRUE, 50019284);