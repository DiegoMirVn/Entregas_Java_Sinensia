package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.DaoPaciente;
import com.curso.model.Paciente;

@Service
public class ServicePacienteImpl implements ServicePaciente {

	@Autowired
	DaoPaciente dao;

	@Override
	public void crearPaciente(Paciente paciente) {
		dao.save(paciente);

	}

	@Override
	public List<Paciente> listarPacientes() {

		return dao.findAll();
	}

	@Override
	public Paciente actualizarPaciente(Paciente paciente) {

		return dao.save(paciente);
	}

	@Override
	public void eliminarPaciente(int id) {

		dao.deleteById(id);

	}
	
	public Paciente findByNombre(String nombre) {
        return dao.findByNombre(nombre);
    }

}
