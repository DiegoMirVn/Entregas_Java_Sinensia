package com.sinensia.primera_entrega;

import java.util.ArrayList;

public class Tacografo {

	private double velocidad;
	private double kmRecorridos;
	private ArrayList<Double> registroVelocidad;
	private ArrayList<Double> registroKmRecorridos;

	public Tacografo() {
		super();

	}

	public double getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}

	public double getKmRecorridos() {
		return kmRecorridos;
	}

	public void setKmRecorridos(double kmRecorridos) {
		this.kmRecorridos = kmRecorridos;
	}

	public ArrayList getRegistroVelocidad() {
		return registroVelocidad;
	}

	public void setRegistroVelocidad(double velo) {
		this.registroVelocidad.add(velo);
	}

	public ArrayList getRegistroKmRecorridos() {
		return registroKmRecorridos;
	}

	public void setRegistroKmRecorridos(double kmReco) {
		this.registroKmRecorridos.add(kmReco);
	}

	@Override
	public String toString() {
		return "Tacografo [velocidad=" + velocidad + ", kmRecorridos=" + kmRecorridos + ", registroVelocidad="
				+ registroVelocidad + ", registroKmRecorridos=" + registroKmRecorridos + "]";
	}

	
	
}
