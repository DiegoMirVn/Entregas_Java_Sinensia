package com.curso.service;

import java.util.List;

import com.curso.model.Reserva;

public interface ServiceGestionMedica {

	/**
	 * Verifica si el terapeuta puede atender a la hora indicada en la reserva, primero si esta 
	 * dentro de su horario y luego si esa hora esta vacia sin otra reserva. Si todo esta correcto 
	 * insertar la cita en la base de datos
	 * @param reserva Datos sobre la reserva que se le pasan por el cuerpo
	 * @return devuelve la reserva cuando se produjo correctamente
	 */
	Reserva crearReservaVerificada(Reserva reserva);
/**
 * Obtiene una lista de reservas que estan a nombre del mismo terapeuta
 * @param nombre Valor que le pasas para que haga coincidencia contra la base de datos
 * @return lista de reservas bajo ese nombre
 */
	List<Reserva> listarReservasPorNombreTerapeuta(String nombre);
}
