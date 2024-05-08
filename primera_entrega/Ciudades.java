package com.sinensia.primera_entrega;

/**
 * Enum para contener ciudades y sus datos
 * @author 6003070
 * 
 */
public enum Ciudades {

	CANGAS(0, 126), VIGO(28, 98), PORRINO(44, 82), CANIZA(79, 47), RIBADAVIA(97, 29), OURENSE(126, 0);

	private int puntoPartida;
	private int puntoDestino;

	Ciudades(int partida, int destino) {
		this.puntoPartida = partida;
		this.puntoDestino = destino;
	}

	public int getPuntoPartida() {
		return puntoPartida;
	}

	public void setPuntoPartida(int puntoPartida) {
		this.puntoPartida = puntoPartida;
	}

	public int getPuntoDestino() {
		return puntoDestino;
	}

	public void setPuntoDestino(int puntoDestino) {
		this.puntoDestino = puntoDestino;
	}

}
