package com.curso.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Paciente;

public interface DaoPaciente extends JpaRepository<Paciente, Integer>{

	 Paciente findByNombre(String nombre);
}
