CREATE DATABASE IF NOT EXISTS sistema_ticket;
USE sistema_ticket;

-- Crea el usuario para la conexion con la BD
CREATE USER IF NOT EXISTS 'UserSistemaTicket'@'%' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON sistema_ticket.* TO 'UserSistemaTicket'@'%';
FLUSH PRIVILEGES;

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




DELIMITER $$

DROP PROCEDURE IF EXISTS crearTicket $$

CREATE PROCEDURE crearTicket(
    IN p_titulo VARCHAR(255),
    IN p_descripcion TEXT,
    IN p_informadorId INT,
    OUT po_ticketId INT)

BEGIN
    DECLARE informador_id INT;
    
    SET informador_id = p_informadorId - 99;
    INSERT INTO tickets (titulo, descripcion, trabajador_id) VALUES(
        p_titulo,
        p_descripcion,
        informador_id );

    SET po_ticketId = LAST_INSERT_ID();
    
END $$

DELIMITER ;


DELIMITER $$

DROP PROCEDURE IF EXISTS actualizarEstadoTicket $$

CREATE PROCEDURE actualizarEstadoTicket(
    IN p_ticketId INT,
    IN p_estado VARCHAR(20),
    IN p_tecnicoId INT,
    IN p_tecnicoAntId INT
)
BEGIN
    DECLARE estadoValido ENUM('No atendido', 'Atendido', 'Resuelto', 'Finalizado', 'Reabierto');

    -- Validar que el estado ingresado sea válido
    SET estadoValido = (
        CASE 
            WHEN p_estado IN ('No atendido', 'Atendido', 'Resuelto', 'Finalizado', 'Reabierto') 
            THEN p_estado 
            ELSE NULL 
        END
    );

    IF estadoValido IS NULL THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Error: Estado inválido';
    END IF;

    -- Actualizar el estado del ticket
    UPDATE tickets 
    SET estado = estadoValido, 
        tecnico_id = p_tecnicoId, 
        tecnico_anterior_id = p_tecnicoAntId
    WHERE ticket_id = p_ticketId;

    -- Si el estado es "Finalizado", cerrar todas las solicitudes de reapertura asociadas
    IF p_estado = 'Finalizado' THEN
        UPDATE solicitudes_reapertura
        SET estado = 'rechazado'
        WHERE ticket_id = p_ticketId AND estado = 'pendiente';
    END IF;
END$$

DELIMITER ;



DELIMITER $$

DROP PROCEDURE IF EXISTS reiniciarContrasenia $$

CREATE PROCEDURE reiniciarContrasenia(
    IN p_dni VARCHAR(20), 
    IN  p_contrasena VARCHAR(255)
)
BEGIN
    DECLARE v_usuario_id INT DEFAULT NULL;
    DECLARE v_tipo VARCHAR(15);
	
    -- Verificar si el usuario existe
    SELECT usuario_id, tipo INTO v_usuario_id, v_tipo FROM Usuarios WHERE dni = p_dni LIMIT 1;

    IF v_usuario_id IS NULL THEN
        -- Si el usuario no existe, lanzar un error de restricción de integridad simulando un DNI no encontrado
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Usuario no encontrado';
    ELSE
        -- Actualizar la contraseña
        UPDATE usuarios 
        SET contrasena =  p_contrasena 
        WHERE dni = p_dni;
        IF v_tipo = 'tecnico' THEN
			UPDATE tecnicos 
            SET fallas = 0, marcas = 0
            WHERE usuario_id = v_usuario_id;
        END IF;
    END IF;
END $$

DELIMITER ;

