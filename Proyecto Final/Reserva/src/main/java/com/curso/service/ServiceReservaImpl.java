package com.curso.service;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.curso.dao.DaoReserva;
import com.curso.model.Reserva;

@Service
public class ServiceReservaImpl implements ServiceReserva {
	@Autowired
	DaoReserva dao;

	@Override
	public List<Reserva> listarTodasReservas() {

		return dao.findAll();
	}

	@Override
	public void crearReserva(Reserva reserva) {
		dao.save(reserva);

	}

	@Override
	public void borrarReserva(int id) {
		dao.deleteById(id);

	}

	@Override
	public void modificarHoraReserva(LocalTime hora, int id) {
		dao.modificarHoraReserva(hora, id);
	}

	public List<Reserva> buscarReservaIdTerapeuta(int id) {
		return dao.buscarReservaIdTerapeuta(id);
	}

}
