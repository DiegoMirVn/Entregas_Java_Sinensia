package com.curso.dao;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.curso.model.Reserva;

public interface DaoReserva extends JpaRepository<Reserva, Integer> {

	/**
	 * Query especifica para actualizar la hora de una reserva segun el parametro
	 * que se le pasa en hora
	 * 
	 * @param hora nuevo valor de hora para la reserva
	 * @param id   valor identificativo de cada reserva
	 */
	@Transactional
	@Modifying
	@Query("UPDATE Reserva r SET r.hora = :hora WHERE r.idReserva = :id")
	public void modificarHoraReserva(@Param("hora") LocalTime hora, @Param("id") int id);

	/**
	 * Query que obtiene una lista de terapeutas que coinciden con el id que se le
	 * pasa
	 * 
	 * @param id valor unico identificativo de cada terapeuta
	 * @return devuelve una lista de {@link Terapeuta}
	 */
	@Query("SELECT r FROM Reserva r  WHERE r.idTerapeuta = :id")
	public List<Reserva> buscarReservaIdTerapeuta(@Param("id") int id);
}
