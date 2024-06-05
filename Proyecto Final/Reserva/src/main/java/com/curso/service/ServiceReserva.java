package com.curso.service;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import com.curso.model.Reserva;

public interface ServiceReserva {

	List<Reserva> listarTodasReservas();

	void crearReserva(Reserva reserva);

	void borrarReserva(int id);

	/**
	 * Actualizacion de hora de reserva para una reserva concreta por id de reserva
	 * 
	 * @param id   = identificador de reserva
	 * @param hora = valor de hora nuevo
	 */

	void modificarHoraReserva(LocalTime hora, int id);

	/**
	 * Metodo especial, que muestra todas las reservas de un terapeuta en concreto,
	 * buscandolo por nombre
	 * 
	 * @param id  Int que se le pasa al metodo para buscar por nombre
	 * @return Lista de reservas de un terapeuta concreto
	 */

	public List<Reserva> buscarReservaIdTerapeuta( int id);

}
