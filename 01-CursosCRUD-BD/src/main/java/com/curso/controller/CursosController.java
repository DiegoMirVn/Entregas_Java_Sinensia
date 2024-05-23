package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Curso;
import com.curso.service.CursosService;

@RestController
public class CursosController {

	@Autowired
	CursosService service;
	@GetMapping(value = "cursos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> libros() {
		return service.cursos();
	}
	
	@PostMapping(value = "cursos", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> altaCursos(@RequestBody Curso curso) {
		return service.altaCursos(curso);
	}

	@DeleteMapping(value = "cursos/{codigo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> eliminarCursos(@PathVariable int codigo) {

		return service.eliminarCursos(codigo);
	}

	@PutMapping(value = "cursos/{codigo}/{horas}", produces=MediaType.APPLICATION_JSON_VALUE)
	public void actualizarCursos(@PathVariable int codigo, @PathVariable int horas) {

		service.actualizarCursos(codigo, horas);

	}

	@GetMapping(value = "cursos/{codigo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Curso buscarCursos(@PathVariable("codigo") int codigo) {

		return service.buscarCursos(codigo);
	}

	@GetMapping(value = "cursos/{min}/{max}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> listarCursosEntrePrecios(@PathVariable double min, @PathVariable double max) {

		return service.listarCursosEntrePrecios(min, max);

	}
}
