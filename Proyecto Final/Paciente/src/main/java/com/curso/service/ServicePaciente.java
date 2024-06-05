package com.curso.service;

import java.util.List;

import com.curso.model.Paciente;

public interface ServicePaciente {

	void crearPaciente(Paciente paciente);

	List<Paciente> listarPacientes();

	Paciente actualizarPaciente(Paciente paciente);

	void eliminarPaciente(int id);
	
	
	
}
