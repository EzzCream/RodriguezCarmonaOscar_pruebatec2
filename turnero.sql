CREATE DATABASE turnero;

USE turnero;

-- Tabla para almacenar los ciudadanos
CREATE TABLE ciudadano (
    id_ciudadano INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    telefono VARCHAR(15),
    email VARCHAR(100),
    CURP VARCHAR(17)
);

INSERT INTO ciudadano (nombre, apellido, CURP, telefono, email) VALUES
('Juan', 'Pérez', '12345678', '1234567890', 'juan.perez@example.com'),
('María', 'Gómez', '87654321', '0987654321', 'maria.gomez@example.com'),
('Carlos', 'Ramírez', '45678912', '1122334455', 'carlos.ramirez@example.com'),
('Laura', 'Fernández', '78912345', '2233445566', 'laura.fernandez@example.com'),
('Sofía', 'Martínez', '15975346', '3344556677', 'sofia.martinez@example.com');

-- Tabla para almacenar los trámites
CREATE TABLE tramite (
    id_tramite INT AUTO_INCREMENT PRIMARY KEY,
    nombre_tramite VARCHAR(100) NOT NULL,
    descripcion TEXT
);

INSERT INTO tramite (nombre_tramite, descripcion) VALUES
('Renovación de Licencia', 'Renovar la licencia de conducir para vehículos particulares.'),
('Pasaporte Nuevo', 'Solicitud para obtener un pasaporte nuevo.'),
('Cambio de Domicilio', 'Actualización de domicilio en el registro oficial.'),
('Certificado de Nacimiento', 'Solicitud de copia certificada del acta de nacimiento.'),
('Reclamo Tributario', 'Presentación de reclamos sobre impuestos.');

-- Tabla para almacenar los usuarios del sistema
CREATE TABLE usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

INSERT INTO Usuario (username, password) VALUES
('admin1', 'pass');

-- Tabla para almacenar los turnos
CREATE TABLE turno (
    id_turno INT AUTO_INCREMENT PRIMARY KEY,
    numero_turno INT NOT NULL,
    fecha DATE NOT NULL,
    estado VARCHAR(50) NOT NULL,
    id_ciudadano INT NOT NULL,
    id_tramite INT NOT NULL,
    id_usuario INT NOT NULL,
    FOREIGN KEY (id_ciudadano) REFERENCES Ciudadano(id_ciudadano),
    FOREIGN KEY (id_tramite) REFERENCES Tramite(id_tramite),
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario)
);

INSERT INTO Turno (numero_turno, fecha, estado, id_ciudadano, id_tramite, id_usuario) VALUES
(1, '2025-01-20', 'En espera', 1, 1, 1),
(2, '2025-01-21', 'Ya atendido', 2, 2, 1),
(3, '2025-01-22', 'En espera', 3, 3, 1),
(4, '2025-01-20', 'Ya atendido', 4, 4, 1),
(5, '2025-01-23', 'En espera', 5, 5, 1);
