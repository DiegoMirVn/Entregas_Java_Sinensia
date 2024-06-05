DROP SCHEMA IF EXISTS reserva;
CREATE SCHEMA IF NOT EXISTS reserva;

CREATE TABLE IF NOT EXISTS `reserva`.`reserva` (
  `id_reserva` INT NOT NULL AUTO_INCREMENT,
  `id_paciente` INT NULL,
  `nombre_paciente` VARCHAR(45) NULL,
  `id_terapeuta` INT NULL,
  `fecha` DATE NULL,
  `hora` TIME NULL,
  PRIMARY KEY (`id_reserva`));
  

INSERT INTO reserva.reserva (id_paciente, nombre_paciente, id_terapeuta, fecha, hora)
VALUES 
    (1, 'Juan Pérez', 1, '2024-06-05', '10:00:00'),
    (2, 'María Rodríguez', 2, '2024-06-06', '11:30:00'),
    (3, 'Pedro Gómez', 3, '2024-06-07', '15:00:00'),
    (4, 'Ana López', 4, '2024-06-08', '16:30:00'),
    (5, 'Laura García', 1, '2024-06-05', '14:00:00'),   
    (6, 'Carlos Martínez', 2, '2024-06-05', '10:30:00'),  
    (7, 'Elena Sánchez', 3, '2024-06-05', '16:00:00'),  
    (8, 'Andrés Ruiz', 4, '2024-06-06', '10:00:00'), 
    (9, 'Sofía Pérez', 1, '2024-06-07', '11:00:00'),  
    (10, 'David López', 2, '2024-06-08', '12:00:00'); 
