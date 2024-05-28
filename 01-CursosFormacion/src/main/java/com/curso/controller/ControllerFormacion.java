package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Formacion;
import com.curso.service.ServiceFormacionImpl;

@RestController
public class ControllerFormacion {

	@Autowired
	ServiceFormacionImpl service;

	@GetMapping(value = "mostrar", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Formacion> mostrar() {

		return service.mostrarTodo();

	}
}
