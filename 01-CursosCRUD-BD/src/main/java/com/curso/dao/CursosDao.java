package com.curso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.curso.model.Curso;

public interface CursosDao extends JpaRepository<Curso, Integer> {

	/**
	 * Obtiene una lista de cursos que estan entre un precio minimo y maximo, 
	 * se podria mapear con ?1 y pasarle los aprametros por orden, 
	 * pero es mas claro con :min y @Param("min") en el metodo.
	 * @param min
	 * @param max
	 * @return
	 */
	

 	@Query("SELECT c FROM Curso c WHERE c.precio > :min AND c.precio < :max")
	List<Curso> listarCursosEntrePrecios(@Param("min") double min, @Param("max") double max);
	
 
	

}
