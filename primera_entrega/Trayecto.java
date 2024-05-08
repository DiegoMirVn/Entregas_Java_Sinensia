package com.sinensia.primera_entrega;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Clase para crear los viajes entre las dos ciudades. Contiene los datos de
 * inicio y final de viaje, asi como el tiempo del viaje y la ciudad desde donde
 * comienza el viaje.
 * 
 * @author 6003070
 * 
 */


public class Trayecto implements TiempoViaje {

	protected int salida;
	protected String salidaNombre;
	protected int destino;
	protected Ciudades ciudadPasada;
	protected double minutosViajeTotal;
	protected double minutosTranscurrido;

	public Trayecto(Ciudades ciudad) {
		this.salida = ciudad.getPuntoPartida();
		this.salidaNombre = ciudad.name();
		this.destino = ciudad.getPuntoDestino();
		this.ciudadPasada = ciudad;

	}

	public int getSalida() {
		return salida;
	}

	public void setSalida(int salida) {
		this.salida = salida;
	}

	public int getDestino() {
		return destino;
	}

	public void setDestino(int destino) {
		this.destino = destino;
	}

	public double getMinutosViajeTotal() {
		return minutosViajeTotal;
	}

	public void setMinutosViajeTotal(double d) {
		this.minutosViajeTotal = d;
	}

	public double getMinutosTranscurrido() {
		return minutosTranscurrido;
	}

	public void setMinutosTranscurrido(double tiempoTranscurrido) {
		this.minutosTranscurrido = tiempoTranscurrido;
	}

	@Override
	public double calcularMinutosViaje(int velocidad, int distancia) {
		double horas = ((double) distancia / (double) velocidad);
		double minutos = horas*60;
		return minutos;

	}
	public void actualizarTiempoTrasncurrido(double min) {
		this.setMinutosTranscurrido(min);
		
	}
	
	/**
	 * Crea dos listas con las ciudades del enum, y compara la posicion del vehiculo
	 * con las de las ciudades para ver si ya ha llegado a ellas. Lo hace en orden
	 * inverso tambien. Escribe una frase para mostrar por donde va.
	 * 
	 * @param ciudadPasada
	 * @param vehiculo
	 * @return
	 */
	public String visitarCiudad(Ciudades ciudadPasada, Vehiculo vehiculo) {

		String frase = "";

		List<Ciudades> rutaOriginal = new ArrayList<Ciudades>();
		List<Ciudades> rutaReves = new ArrayList<Ciudades>();
		for (Ciudades ciudad : Ciudades.values()) {
			rutaOriginal.add(ciudad);
		}

		if (ciudadPasada.name() == "CANGAS") {
			for (Ciudades ciudad : Ciudades.values()) {
				if (vehiculo.posicion < ciudad.getPuntoPartida()) {
					frase += "Aun no has llegado a " + ciudad.name() + "\n";

				} else if (vehiculo.posicion == ciudad.getPuntoPartida()) {
					frase += "Estas en " + ciudad.name() + "\n";
				} else if (vehiculo.posicion > ciudad.getPuntoPartida()) {
					frase += "Has pasado por " + ciudad.name() + "\n";
				}
			}
		} else {

			rutaReves = rutaOriginal;
			Collections.reverse(rutaReves);

			for (Ciudades ciudad : rutaReves) {
				if (vehiculo.posicion < ciudad.getPuntoDestino()) {
					frase += "Aun no has llegado a " + ciudad.name() + "\n";

				} else if (vehiculo.posicion == ciudad.getPuntoDestino()) {
					frase += "Estas en " + ciudad.name() + "\n";
				} else if (vehiculo.posicion > ciudad.getPuntoDestino()) {
					frase += "Has pasado por " + ciudad.name() + "\n";
				}
			}
		}

		return frase;

	}

	@Override
	public String toString() {
		return "Trayecto [salida=" + salida + ", salidaNombre=" + salidaNombre + ", destino=" + destino
				+ ", ciudadPasada=" + ciudadPasada + ", minutosViajeTotal=" + minutosViajeTotal
				+ ", minutosTranscurrido=" + minutosTranscurrido + "]";
	}

}
