package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Reserva;
import com.curso.service.ServiceGestionMedica;

@RestController
public class ControllerGestionMedica {

	@Autowired
	ServiceGestionMedica service;

	/**
	 * Peticion del servicio gestor para insertar una reserva en la base de datos reserva comprobando previamente
	 * que se puede hacer
	 * @param objeto reserva que se le pasa en el cuerpo de la peticion
	 * @return devuelve un objeto {@link Reserva}
	 */
	@PostMapping(value = "/gestion", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Reserva crearReservaVerificada(@RequestBody Reserva reserva) {

		return service.crearReservaVerificada(reserva);

	}
/**
 * Peticion del servidor gestor para traer todas las reservas que contienen el id del terapapeuta que se
 * le pasa el nombre por parametro
 * @param nombre del terapeuta que recibe por parametro
 * @return devuelve una lista de {@link Reserva}
 */
	@GetMapping(value = "/gestion/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Reserva> listarReservasPorNombreTerapeuta(@PathVariable("nombre") String nombre) {
		return service.listarReservasPorNombreTerapeuta(nombre);

	}

}
