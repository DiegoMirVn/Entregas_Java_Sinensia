package com.curso.controller;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Terapeuta;
import com.curso.service.ServiceTerapeuta;

@RestController
public class ControllerTerapeuta {

	@Autowired
	ServiceTerapeuta service;

	/**
	 * Peticion REST que trae todos los terapeutas
	 * 
	 * @return deuelve una lista de {@link Terapeuta}
	 */
	@GetMapping(value = "/terapeuta", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Terapeuta> listarTerapeutas() {

		return service.listarTerapeutas();
	}

	/**
	 * Peticion CRUD que trae a un terapeuta buscandolo por id que se le pasas por
	 * parametro
	 * 
	 * @param id
	 * @return Objeto Terapeuta
	 */
	@GetMapping(value = "/terapeuta/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Terapeuta listarPorId(@PathVariable("id") int id) {

		return service.listarPorId(id);
	}

	/**
	 * Peticion CRUD para insertar un terapeuta en la base de datos terapeuta
	 * 
	 * @param terapeuta que se envia por el body en la peticion
	 * @return Terapeuta que se ha insertado
	 */
	@PostMapping(value = "/terapeuta", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Terapeuta crearTerapeuta(@RequestBody Terapeuta terapeuta) {
		return service.crearTerapeuta(terapeuta);

	}

	/**
	 * Peticion CRUD para editar el campo especifico especialidad de un terapeuta
	 * buscado por id
	 * 
	 * @param especialidad El valor nuevo que se quiere agregar
	 * @param id           El valor identificador del terapeuta
	 */
	@PatchMapping(value = "/terapeuta/{id}/{especialidad}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void actualizarEspecialidad(@PathVariable("especialidad") String especialidad, @PathVariable("id") int id) {
		service.actualizarEspecialidad(especialidad, id);
	}

	/**
	 * Peticion CRUD para editar un terapeuta en general.
	 * 
	 * @param terapeuta Informacion que se enviar en el body de la peticion
	 */
	@PutMapping(value = "/terapeuta", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void actualizarTerapeuta(@RequestBody Terapeuta terapeuta) {

		service.actualizarTerapeuta(terapeuta);
	}

	/**
	 * Peticion CRUD para eliminar un terapeuta especificandolo por id del mismo
	 * 
	 * @param id Indentificador unico de terapeuta
	 */
	@DeleteMapping(value = "/terapeuta/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void borrarTerapeuta(@PathVariable("id") int id) {
		service.borrarTerapeuta(id);
	}

	/**
	 * Metodo para obtener una lista de terapeuta en funcion del nombre que se le
	 * pasa en la peticion
	 * 
	 * @param nombre a buscar dentro de la lista de terapeutas
	 * @return devuelve una lista de {@link Terapeuta}
	 */
	@GetMapping(value = "/terapeuta/lista/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Terapeuta> obtenerListaPorNombre(@PathVariable("nombre") String nombre) {
		return service.listarTerapeutasPorNombre(nombre);
	}

}
