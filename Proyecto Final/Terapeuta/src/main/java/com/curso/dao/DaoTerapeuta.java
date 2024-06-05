package com.curso.dao;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.curso.model.Terapeuta;

public interface DaoTerapeuta extends JpaRepository<Terapeuta, Integer> {

	/**
	 * Realiza un actualizacion del valor del campo especialidad de Terapeuta
	 * 
	 * @param especialidad String que va ser la nueva especialidad
	 * @param id           Numero de identificacion del Terapeuta
	 */
	@Transactional
	@Modifying
	@Query("UPDATE Terapeuta t SET t.especialidad = :esp WHERE t.idTerapeuta = :id")
	public void actualizarEspecialidad(@Param("esp") String especialidad, @Param("id") int id);

	/**
	 * Obtiene la lista de Terapeutas filtrando por nombre
	 * 
	 * @param nombre String que busca dentro de la base de datos
	 * @return Una lista de objetos {@link Terapeuta} 
	 */
	@Query("SELECT t FROM Terapeuta t WHERE t.nombre = :nombre")
	public List<Terapeuta> listarTerapeutasPorNombre(@Param("nombre") String nombre);


}
