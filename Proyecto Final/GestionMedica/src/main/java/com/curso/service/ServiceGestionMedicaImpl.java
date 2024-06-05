package com.curso.service;

import java.sql.Array;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.model.Reserva;
import com.curso.model.Terapeuta;

@Service
public class ServiceGestionMedicaImpl implements ServiceGestionMedica {

	@Autowired
	RestTemplate template;

	private final String urlTerapeuta = "http://localhost:8080/terapeuta";
	private final String urlReserva = "http://localhost:7000/reserva";

	/**
	 * Inserta una reserva en la base de datos de reserva, que previamente ha
	 * verificado que se pueda insertar. Llama a los metodos que verifican si esta
	 * dentro del horario del terapeuta, y si existe alguna reserva para la misma
	 * hora.
	 * 
	 * @param reserva Objeto reserva que se le pasa en el cuerpo de la peticion
	 * @return el objeto de la reserva
	 * @author 6003070
	 * 
	 */
	@Override
	public Reserva crearReservaVerificada(Reserva reserva) {
		Reserva reservaConfirmada = null;

		if (comprobarHorarioTrabajo(reserva)) {
			if (comprobarHoraReserva(reserva)) {
				template.postForObject(urlReserva, reserva, Reserva.class);

				System.out.println("Reserva Confirmada");
			} else {
				System.out.println("Hora no disponible");
			}

		} else {
			System.out.println("La hora no esta en el horario del terapeuta");
		}

		return reservaConfirmada;
	}

	/**
	 * Busca las reservas asociadas a un terapeuta que se le pasa el nombre por la
	 * url, llamando por restTemplate a otros get de terapeuta y de reserva
	 * 
	 * @param nombre  El nombre del terapeuta que le pasamos a la url
	 * @return Lista de Reserva que están a nombre del terapeuta indicado
	 */
	@Override
	public List<Reserva> listarReservasPorNombreTerapeuta(String nombre) {

		Terapeuta[] teraArray = template.getForObject(urlTerapeuta + "/lista/" + nombre, Terapeuta[].class);
		List<Terapeuta> lista = Arrays.asList(teraArray);
		List<Terapeuta> listaTerapeutasCorrectos = lista.stream()
				.filter(tera -> tera.getNombre().equalsIgnoreCase(nombre)).collect(Collectors.toList());

		List<Reserva> listaReserva = new ArrayList<>();

		for (Terapeuta terapeuta : listaTerapeutasCorrectos) {
			int idTera = terapeuta.getIdTerapeuta();
			Reserva[] reservaIdTera = template.getForObject(urlReserva + "/lista/" + idTera, Reserva[].class);

			if (reservaIdTera != null) {
				listaReserva.addAll(Arrays.asList(reservaIdTera));
			}
		}

		return listaReserva;
	}

	/**
	 * Obtiene los datos de terapeuta con una llamada mediante RestTemplate al
	 * microservicio de terapeuta, para obtener los horarios laborales del terapeuta
	 * de la reserva que se le pasa.
	 * 
	 * @param reserva Datos ofrecidos a traves del body de la peticion post
	 * @return boolean si esta o no esta la hora de la reserva dentro del horario
	 *         del terapeuta
	 * @author 6003070
	 */
	public Boolean comprobarHorarioTrabajo(Reserva reserva) {

		boolean dentroHorario = false;

		int idTerapeuta = reserva.getIdTerapeuta();
		LocalTime horaReserva = reserva.getHora();

		Terapeuta terapeuta = template.getForObject(urlTerapeuta + "/" + idTerapeuta, Terapeuta.class);

		LocalTime horaInicioIntervalo1 = terapeuta.getInicioIntervalo1();
		LocalTime horaFinIntervalo1 = terapeuta.getFinIntervalo1();
		LocalTime horaInicioIntervalo2 = terapeuta.getInicioIntervalo2();
		LocalTime horaFinIntervalo2 = terapeuta.getFinIntervalo2();

		if (horaReserva.isBefore(horaFinIntervalo1) && horaReserva.isAfter(horaInicioIntervalo1)
				|| (horaReserva.isBefore(horaFinIntervalo2) && horaReserva.isAfter(horaInicioIntervalo2))) {
			dentroHorario = true;

		}

		return dentroHorario;
	}

	/**
	 * Comprueba que la hora pasada en la reserva esta disponible dentro de la base
	 * de datos de reserva, consultando primero con RestTemplate el conjunto de
	 * reservas luego filtrandolas por si la hora de reserva coincide con la hora de
	 * reserva y la fecha de la reserva de alguna de las que ya existen en la base
	 * de datos
	 * 
	 * @param reserva Objeto que se le pasa por el body de la peticion
	 * @return boolean verdadero o falso si la hora y fecha de reserva esta
	 *         disponible o no.
	 * @author 6003070
	 */
	public Boolean comprobarHoraReserva(Reserva reserva) {

		LocalTime horaReserva = reserva.getHora();
		LocalDate fechaReserva = reserva.getFecha();

		Reserva[] arrayReservas = template.getForObject(urlReserva + "/lista", Reserva[].class);

		List<Reserva> listaReservas = Arrays.asList(arrayReservas);

		boolean horaDisponible = listaReservas.stream()
				.noneMatch(res -> res.getHora().equals(horaReserva) && res.getFecha().equals(fechaReserva));

		return horaDisponible;

	}

}
