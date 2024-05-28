package com.curso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


public class Formacion {
	
	private String curso;
	private int asignatura;
	private double precio;

	public Formacion() {
		super();

	}

	public Formacion(String curso, int asignatura, double precio) {
		super();
		this.curso = curso;
		this.asignatura = asignatura;
		this.precio = precio;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(int asignatura) {
		this.asignatura = asignatura;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

}
