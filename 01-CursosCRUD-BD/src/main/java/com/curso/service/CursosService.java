package com.curso.service;

import java.util.List;

import com.curso.model.Curso;

public interface CursosService {


	List<Curso> cursos();
	
	List<Curso> altaCursos(Curso curso);

	List<Curso> eliminarCursos(int codigo);

	void actualizarCursos(int codigo, int horas);

	Curso buscarCursos(int codigo);

	List<Curso> listarCursosEntrePrecios(double min, double max);

}
