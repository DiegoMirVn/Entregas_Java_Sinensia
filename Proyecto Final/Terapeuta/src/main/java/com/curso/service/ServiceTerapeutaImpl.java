package com.curso.service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.curso.dao.DaoTerapeuta;
import com.curso.model.Terapeuta;

@Service
public class ServiceTerapeutaImpl implements ServiceTerapeuta {

	@Autowired
	DaoTerapeuta dao;

	@Override
	public List<Terapeuta> listarTerapeutas() {

		return dao.findAll();
	}

	@Override
	public Terapeuta listarPorId(int id) {

		return dao.findById(id).orElse(null);
	}

	public Terapeuta crearTerapeuta(Terapeuta terapeuta) {

		dao.save(terapeuta);

		return terapeuta;
	}

	/**
	 * Modificar el campo especialidad del terapeuta indicado segun el id
	 * 
	 * @param especialidad , valor nuevo del campo
	 * @param id  valor del identificador unico del terapeuta
	 */
	@Override
	public void actualizarEspecialidad(String especialidad, int id) {
		dao.actualizarEspecialidad(especialidad, id);
	}

	@Override
	public void actualizarTerapeuta(Terapeuta terapeuta) {
		dao.save(terapeuta);
	}

	public void borrarTerapeuta(int id) {
		dao.deleteById(id);
	}

	/**
	 * Metodo para obtener una lista de terapeuta en funcion del nombre que se le
	 * pasa
	 * 
	 * @param nombre a buscar dentro de la lista de terapeutas
	 * @return devuelve una lista de {@link Terapeuta}
	 */
	public List<Terapeuta> listarTerapeutasPorNombre(String nombre) {

		return dao.listarTerapeutasPorNombre(nombre);
	}

}
