CREATE TABLE Paciente (
    id_paciente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    telefono VARCHAR(15)
);


INSERT INTO Paciente (nombre, telefono)
VALUES 
    ('Juan Pérez', '123456789'),
    ('María Rodríguez', '987654321'),
    ('Pedro Gómez', '567890123'),
    ('Ana López', '321098765'),
    ('Laura García', '456789012'),
    ('Carlos Martínez', '890123456'),
    ('Elena Sánchez', '234567890'),
    ('Andrés Ruiz', '678901234'),
    ('Sofía Pérez', '890123456'),
    ('David López', '123456789');
