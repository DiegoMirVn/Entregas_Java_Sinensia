package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Paciente;
import com.curso.service.ServicePaciente;

@RestController
public class ControllerPaciente {

	@Autowired
	ServicePaciente service;

	/**
	 * Crud para insertar paciente en base de datos paciente
	 * 
	 * @param paciente
	 */
	@PostMapping(value = "/paciente", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void crearPaciente(@RequestBody Paciente paciente) {
		service.crearPaciente(paciente);

	}

	/**
	 * Crud para traer lista de pacientes de la base de datos paciente
	 * 
	 * @return devuelve una lista de {@link Paciente}
	 */
	@GetMapping(value = "/paciente/lista", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Paciente> listarPacientes() {

		return service.listarPacientes();
	}

	/**
	 * Crud para editar un paciente en general , pasandole nueva informacion a
	 * traves del body de la peticion
	 * 
	 * @param paciente
	 * @return
	 */
	@PutMapping(value = "/paciente", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Paciente actualizarPaciente(@RequestBody Paciente paciente) {

		return service.actualizarPaciente(paciente);
	}

	/**
	 * Crud para borrar un paciente por identificador unico del mismo
	 * 
	 * @param id identificador unico de paciente
	 */
	@DeleteMapping(value = "/paciente/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void eliminarPaciente(@PathVariable("id") int id) {
		service.eliminarPaciente(id);

	}
}
