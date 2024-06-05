package com.curso.service;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.curso.model.Terapeuta;

public interface ServiceTerapeuta {

	List<Terapeuta> listarTerapeutas();

	Terapeuta listarPorId(int id);

	Terapeuta crearTerapeuta(Terapeuta terapeuta);

	void actualizarEspecialidad(String especialidad, int id);

	void actualizarTerapeuta(Terapeuta terapeuta);

	void borrarTerapeuta(int id);

	public List<Terapeuta> listarTerapeutasPorNombre(String nombre);

}
