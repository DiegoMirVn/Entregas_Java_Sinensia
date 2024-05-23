DROP SCHEMA  `cursos`  ;
CREATE SCHEMA IF NOT EXISTS `cursos`  ;

CREATE TABLE `cursos`.`cursos` (
  `codigo` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `duracion` INT NULL,
  `precio` DECIMAL(5,2) NULL,
  PRIMARY KEY (`codigo`));