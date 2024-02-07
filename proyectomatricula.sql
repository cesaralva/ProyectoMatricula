drop database proyectomatricula;
-- Crear la base de datos si no existe
CREATE DATABASE IF NOT EXISTS proyectomatricula;
use proyectomatricula;
-- Seleccionar la base de datos

-- Crear la tabla permisos
CREATE TABLE IF NOT EXISTS permisos (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  descripcion VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Crear la tabla usuarios
CREATE TABLE IF NOT EXISTS usuarios (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  contrasena VARCHAR(100) NOT NULL,
  conficontra VARCHAR(100) NOT NULL,
  rol VARCHAR(50) NOT NULL,
  permisos_id INT, 
  PRIMARY KEY (id),
  FOREIGN KEY (permisos_id) REFERENCES permisos(id) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO usuarios (nombre, contrasena, conficontra, rol, permisos_id) VALUES
('admin', 'admin', 'admin', 'Administrador', NULL);

create table Alumno
(idAlumno int primary key auto_increment,
dniAlumno varchar(255),
nomAlumno varchar(255),
apeAlumno varchar(255),
edadAlumn int,
correoAlumno varchar(255),
estado int
 );
ALTER TABLE Alumno AUTO_INCREMENT = 1000;


create table Curso
(
codCurso int primary key ,
nomCurso varchar(255),
ciclo int ,
creditCurso int,
horasdeCurso int
);


create table Matricula
(
numMatricula int primary key auto_increment,
idAlumno int,
codCurso int,
fecha date,
hora time,
foreign key (idAlumno) references Alumno(idAlumno),
foreign key (codCurso) references Curso(codCurso)
);
ALTER TABLE Matricula AUTO_INCREMENT = 3000;
ALTER TABLE Matricula ADD estado INT;
create table Retiro
(
numRetiro int primary key auto_increment, 
numMatricula int,
fecha date,
hora time,
foreign key (numMatricula) references Matricula(numMatricula)
);
ALTER TABLE Retiro AUTO_INCREMENT = 4000;

select* from curso;

