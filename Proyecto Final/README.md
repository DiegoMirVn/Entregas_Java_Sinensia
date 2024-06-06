# Gestion de Clinica

Un servicio de gestion de agenda mediante llamadas a la api del proyecto

## Tabla de Contenidos

- [Descripción](#descripción)
- [Características](#características)
- [Entidades](#entidades)
- [Autores](#autores)


## Descripción

Se pretende crear una servicio para gestion de citas de una clinica, basada en microservicios. La aplicacion consta tres microservicios:
_paciente_, _terapeuta_ y _reserva_ que son totalmente independientes uno de otro con acceso a su propia base de datos y un cuarto _gestor_ que se encarga de relacionarlos.


## Características

- Conexion a una base de datos MySQL
- Implementacion de CRUD para _paciente_, _terapeuta_ y _reserva_
- Permite agendar reservas de citas de forma facil
- Permite crear terapeutas y pacientes de forma rapida
- Exposicion de endpoints para interactuar con las entidades
- Es escalable al basarse en microservicios


## Inicio Rápido

1. **Clonar el repositorio:**
  
   ```git clone https://github.com/DiegoMirVn/Entregas_Java_Sinensia.git```
   
2. **Crear las bases de datos**

    Usar los scripts contenidos dentro del proyecto para crear y generar las bases de datos, tablas y registros de prueba para el proyecto
    

## Entidades

1. **Reserva**: Representa a una cita entre un terapeuta y un paciente
2. **Terapeuta**: Representa a un terapeuta especifico que lleva su agenda usando el servicio
3. **Paciente**: Representa a un paciente, cliente u otro usuario que use el servicio de los terapeutas


### Servicio Terapeuta

Permite el crud basico de terapeuta en la base de datos propia que incorpora. Ademas tiene metodos propios para filtrar los terapeutas por nombre.
En la tabla incorpora los siguientes campos id_terapeuta, nombre,apellidos,dni,especialidad,inicio_intervalo1,fin_intervalo1,inicio_intervalo2,fin_intervalo2

### Servicio Paciente

Permite el crud basico de paciente en la base de datos propia que incorpora. En la tabla existen los siguientes campos id_paciente,nombre,telefono.

### Servicio Reserva

Permite el crud basico de reserva en la base de datos propia que incorpora. En la tabla existen los siguientes id_reserva,id_paciente,nombre_paciente,id_terapeuta,fecha,hora.

### Servicio GestionMedica

Permite relacionar los otros 3 servicios. Tiene metodos propios para insertar una reserva de forma verificada, comprobando que la hora y el terapeuta esta disponible, además permite 
buscar por nombre

## Funcionalidades
1. **Insertar reservas verificadas**
2. **Listar reservas asociadas a un terapeuta por nombre**
3. **CRUD para cada uno de los servicios con base de datos**
4. **Edicion de campo especialidad en terapeuta**
5. **Edicion de campo hora en reserva**

## Endpoints 

### Terapeuta

1. **Listar todos los terapeutas**
   - **URL**: `/terapeuta`
   - **Método**: `GET`

2. **Buscar terapeuta por ID**
   - **URL**: `/terapeuta/{id}`
   - **Método**: `GET`

3. **Crear un terapeuta**
   - **URL**: `/terapeuta`
   - **Método**: `POST`

4. **Editar la especialidad del terapeuta**
   - **URL**: `/terapeuta/{id}/{especialidad}`
   - **Método**: `PATCH`

5. **Editar un terapeuta en general**
   - **URL**: `/terapeuta`
   - **Método**: `PUT`

6. **Borrar un terapeuta**
   - **URL**: `/terapeuta/{id}`
   - **Método**: `DELETE`

7. **Obtener lista de terapeutas por nombre**
   - **URL**: `/terapeuta/lista/{nombre}`
   - **Método**: `GET`

### Reserva

1. **Listar todas las reservas**
   - **URL**: `/reserva/lista`
   - **Método**: `GET`

2. **Buscar una reserva por id**
   - **URL**: `/reserva/lista/{id}`
   - **Método**: `GET`

3. **Crear un reserva**
   - **URL**: `/reserva`
   - **Método**: `POST`

4. **Editar la hora de una reserva**
   - **URL**: `/reserva/{id}/{hora}`
   - **Método**: `PATCH`

6. **Borrar un reserva**
   - **URL**: `/reserva/{id}`
   - **Método**: `DELETE`

### Paciente

1. **Listar todos los pacientes**
   - **URL**: `/paciente/lista`
   - **Método**: `GET`

2. **Crear un paciente**
   - **URL**: `/paciente`
   - **Método**: `POST`

3. **Editar un terapeuta en general**
   - **URL**: `/paciente`
   - **Método**: `PUT`

4. **Borrar un paciente**
   - **URL**: `/paciente/{id}`
   - **Método**: `DELETE`

### GestionMedica

1. **Insertar reserva verificada**
   - **URL**: `/gestion`
   - **Método**: `POST`

2. **Mostrar reservas asociadas a un terapeuta por nombre**
   - **URL**: `/gestion/{nombre}`
   - **Método**: `GET`



 
  

