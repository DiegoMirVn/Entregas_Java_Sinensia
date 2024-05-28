package com.curso.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.model.Curso;
import com.curso.model.Formacion;

@Service
public class ServiceFormacionImpl implements ServiceFormacion {

	@Autowired
	RestTemplate template;

	private String url = "http://localhost:8080/cursos";

	@Override
	public List<Formacion> mostrarTodo() {

		List<Curso> curso = Arrays.asList(template.getForObject(url, Curso[].class));
		List<Formacion> listaEditada = new ArrayList<Formacion>();

		for (Curso cu : curso) {

			if (cu.getDuracion() > 50) {

				Formacion form = new Formacion(cu.getNombre(), 10, cu.getPrecio());
				listaEditada.add(form);
			} else {
				Formacion form = new Formacion(cu.getNombre(), 5, cu.getPrecio());
				listaEditada.add(form);
			}
		}
		return listaEditada;
	}

	@Override
	public void altaCurso(Curso curso) {

	}

}
