CREATE DATABASE IF NOT EXISTS sistema_ticket;
USE sistema_ticket;

-- Tabla de usuarios
CREATE TABLE IF NOT EXISTS usuarios (
    usuario_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    tipo ENUM('trabajador', 'tecnico', 'administrador') NOT NULL,
    dni VARCHAR(20) NOT NULL UNIQUE,
    legajo INT UNIQUE,
    contrasena VARCHAR(60) NOT NULL,
    estado ENUM('activo', 'bloqueado') DEFAULT 'activo'
);

CREATE TABLE IF NOT EXISTS tecnicos (
    usuario_id INT PRIMARY KEY, -- Misma clave que en usuarios
    fallas INT DEFAULT 0,
    marcas INT DEFAULT 0,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(usuario_id) ON DELETE CASCADE
);

-- Tabla de tickets
CREATE TABLE IF NOT EXISTS tickets (
    ticket_id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    descripcion TEXT NOT NULL,
    estado ENUM('No atendido', 'Atendido', 'Resuelto', 'Finalizado', 'Reabierto') DEFAULT 'No atendido',
    trabajador_id INT NOT NULL,
    tecnico_id INT DEFAULT NULL,
    tecnico_anterior_id INT DEFAULT NULL,
    FOREIGN KEY (trabajador_id) REFERENCES usuarios(usuario_id),
    FOREIGN KEY (tecnico_id) REFERENCES usuarios(usuario_id),
    FOREIGN KEY (tecnico_anterior_id) REFERENCES usuarios(usuario_id)
);

-- Tabla de logs de cambios de contraseña
CREATE TABLE IF NOT EXISTS cambios_contrasena (
    id_cambio_contrasena INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(usuario_id)
);

-- Tabla de solicitudes de reapertura de tickets
CREATE TABLE IF NOT EXISTS solicitudes_reapertura (
    id_solicitud_reapertura INT AUTO_INCREMENT PRIMARY KEY,
    ticket_id INT NOT NULL,
    tecnico_id INT NOT NULL,
    estado ENUM('pendiente', 'aprobado', 'rechazado') DEFAULT 'pendiente',
    FOREIGN KEY (ticket_id) REFERENCES tickets(ticket_id),
    FOREIGN KEY (tecnico_id) REFERENCES usuarios(usuario_id)
);


DELIMITER $$

DROP PROCEDURE IF EXISTS crearUsuario $$

CREATE PROCEDURE crearUsuario(
    IN p_nombre VARCHAR(100),
    IN p_tipo ENUM('trabajador', 'tecnico', 'administrador'),
    IN p_dni VARCHAR(20),
    IN p_contrasena VARCHAR(60)
)
BEGIN
    DECLARE nuevo_id INT;
    DECLARE nuevo_legajo INT;

    -- Insertar en la tabla usuarios sin `legajo`
    INSERT INTO usuarios (nombre, tipo, dni, contrasena, estado)
    VALUES (p_nombre, p_tipo, p_dni, p_contrasena, 'activo');

    -- Obtener el ID generado
    SET nuevo_id = LAST_INSERT_ID();
    SET nuevo_legajo = nuevo_id + 99;  -- Calcular el legajo manualmente

    -- Actualizar el legajo en la misma fila
    UPDATE usuarios SET legajo = nuevo_legajo WHERE usuario_id = nuevo_id;

    -- Si el usuario es un técnico, insertarlo en la tabla tecnicos
    IF p_tipo = 'tecnico' THEN
        INSERT INTO tecnicos (usuario_id, fallas, marcas)
        VALUES (nuevo_id, 0, 0);
    END IF;
END $$

DELIMITER ;
