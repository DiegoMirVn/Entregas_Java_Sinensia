package com.curso.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.CursosDao;
import com.curso.model.Curso;

@Service
public class CursosServiceImpl implements CursosService {

	@Autowired
	CursosDao dao;

	/**
	 * Recibe en el cuerpo un JSON con los datos del curso, lo inserta en la base de
	 * datos y devuelve los cursos que hay dados de alta
	 */
	@Override
	public List<Curso> altaCursos(Curso curso) {
		dao.save(curso);
		return dao.findAll();
	}

	/**
	 * Recibe el codigo de curso y elimina el curso con ese id, luego muestra los
	 * cursos restantes
	 */
	@Override
	public List<Curso> eliminarCursos(int codigo) {
		dao.deleteById(codigo);
		return dao.findAll();
	}

	@Override
	/**
	 * Recibe el codigo del curso y la nueva duracion en horas y actualiza el
	 * registro en la base de datos
	 */
	public void actualizarCursos(int codigo, int horas) {

		Curso cursoAct = dao.findById(codigo).orElse(null);
		cursoAct.setDuracion(horas);
		dao.save(cursoAct);

	}

	/**
	 * Recibe un codigo de curso, y muestra datos de ese curso
	 */
	@Override
	public Curso buscarCursos(int codigo) {

		return dao.findById(codigo).orElse(null);
	}

	/**
	 * Recibe dos precios min y max y muestra aquellos cursos que esten entre esos
	 * dos precios
	 */
	@Override
	public List<Curso> listarCursosEntrePrecios(double min, double max) {
		
		return dao.listarCursosEntrePrecios(min, max);


		
	}

	@Override
	public List<Curso> cursos() {
		return dao.findAll();
	}

}
