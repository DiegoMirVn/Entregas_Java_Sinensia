DROP SCHEMA IF EXISTS terapeuta;

CREATE SCHEMA terapeuta;

CREATE TABLE IF NOT EXISTS `terapeuta`.`terapeuta` (
  `id_terapeuta` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `apellidos` VARCHAR(45) NULL,
  `dni` VARCHAR(45) NULL,
  `especialidad` VARCHAR(45) NULL,
  `inicio_intervalo1` TIME NULL,
  `fin_intervalo1` TIME NULL,
  `inicio_intervalo2` TIME NULL,
  `fin_intervalo2` TIME NULL,
  PRIMARY KEY (`id_terapeuta`));

  
  INSERT INTO terapeuta (nombre, apellidos, dni, especialidad, inicio_intervalo1, fin_intervalo1, inicio_intervalo2, fin_intervalo2)
VALUES 
    ('Juan', 'González', '12345678A', 'Fisioterapia', '09:00:00', '13:00:00', '15:00:00', '19:00:00'),
    ('María', 'Martínez', '87654321B', 'Psicología', '10:00:00', '14:00:00', '16:00:00', '20:00:00'),
    ('Pedro', 'Sánchez', '45678912C', 'Nutrición', '08:30:00', '12:30:00', '14:30:00', '18:30:00'),
    ('Ana', 'López', '78912345D', 'Quiropráctica', '09:30:00', '13:30:00', '15:30:00', '19:30:00');
