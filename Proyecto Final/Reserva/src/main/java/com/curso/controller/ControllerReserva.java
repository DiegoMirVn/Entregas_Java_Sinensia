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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Reserva;
import com.curso.service.ServiceReserva;

@RestController
public class ControllerReserva {
	@Autowired
	ServiceReserva service;

	/**
	 * Peticion REST que trae una lista de todas las reservas de la base de datos
	 * reserva
	 * 
	 * @return devuelve una lista {@link Reserva}
	 */
	@GetMapping(value = "/reserva/lista", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Reserva> listarTodasReservas() {

		return service.listarTodasReservas();
	}

	/**
	 * Peticion REST que trae una lista de reservas segun el id del terapeuta que se
	 * le pasa por parametro
	 * 
	 * @param id
	 * @return devuelve una lista de {@link Reserva}
	 */
	@GetMapping(value = "/reserva/lista/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Reserva> buscarReservaIdTerapeuta(@PathVariable("id") int id) {

		return service.buscarReservaIdTerapeuta(id);
	}

	/**
	 * Insertar una reserva en la base de datos reserva
	 * 
	 * @param reserva Contenido de la reserva pasada por body de la peticion
	 */
	@PostMapping(value = "/reserva", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void crearReserva(@RequestBody Reserva reserva) {
		service.crearReserva(reserva);

	}

	/**
	 * Borrado de una reserva por el id de la misma
	 * 
	 * @param id numero identificador de la reserva clave primaria de la base de
	 *           datos
	 */
	@DeleteMapping(value = "/reserva/{id}")
	public void borrarReserva(@PathVariable("id") int id) {
		service.borrarReserva(id);

	}

	/**
	 * Metodo para editar la hora de una reserva, que se busca por la clave primaria
	 * de la entidad
	 * 
	 * @param id   clave primaria de la entidad en la base de datos
	 * @param hora Nuevo registro de hora pasada para la reserva
	 */
	@PatchMapping(value = "/reserva/{id}/{hora}")
	public void cambiarHora(@PathVariable("id") int id, @PathVariable("hora") LocalTime hora) {
		service.modificarHoraReserva(hora, id);
	}

}
