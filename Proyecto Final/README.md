# Gestion de Clinica

Un servicio de gestion de agenda mediante llamadas a la api del proyecto

## Tabla de Contenidos

- [Descripción](#descripción)
- [Características](#características)
- [Inicio Rapido](#iniciorapido)
- [Uso](#uso)
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
   
3. **Acceder al directorio del proyecto**
  ```cd xxx```

# Entidades

1. **Reserva**: Representa a una cita entre un terapeuta y un paciente
2. **Terapeuta**: Representa a un terapeuta especifico que lleva su agenda usando el servicio
3. **Paciente**: Representa a un paciente, cliente u otro usuario que use el servicio de los terapeutas


# Servicio Terapeuta

Permite el crud basico de terapeuta en la base de datos propia que incorpora. Ademas tiene metodos propios para filtrar los terapeutas por nombre.
En la tabla incorpora los siguientes campos id_terapeuta, nombre,apellidos,dni,especialidad,inicio_intervalo1,fin_intervalo1,inicio_intervalo2,fin_intervalo2


# Servicio Paciente

Permite el crud basico de paciente en la base de datos propia que incorpora. En la tabla existen los siguientes campos id_paciente,nombre,telefono.

# Servicio Reserva

Permite el crud basico de reserva en la base de datos propia que incorpora. En la tabla existen los siguientes id_reserva,id_paciente,nombre_paciente,id_terapeuta,fecha,hora.

![Screenshot of a comment on a GitHub issue showing an image, added in the Markdown, of an Octocat smiling and raising a tentacle.](https://myoctocat.com/assets/images/base-octocat.svg)

# Funcionalidades
1. **Listar todos los clientes**
2. **Buscar clientes por Id**
3. **Buscar clientes por apellido**

## Endpoints 

### Clientes

1. **Listar todos los clientes**
   - **URL**: `/cliente`
   - **Método**: `GET`

2. **Buscar cliente por ID**
   - **URL**: `/cliente/{id}`
   - **Método**: `GET`

3. **Buscar clientes por apellido**
   - **URL**: `/cliente/detalle/{apellido}`
   - **Método**: `GET`



### Vehículos

1. **Listar todos los vehículos**
   - **URL**: `/vehiculo`
   - **Método**: `GET`

2. **Buscar vehículo por ID**
   - **URL**: `/vehiculo/{id}`
   - **Método**: `GET`

3. **Buscar propietario del vehículo por ID del vehículo**
   - **URL**: `/vehiculo/propietario/{id}`
   - **Método**: `GET`

4. **Buscar vehículo por matrícula**
   - **URL**: `/vehiculo/detalle/matricula/{matricula}`
   - **Método**: `GET`





 
  

