package com.sinensia.primera_entrega;

public abstract class Vehiculo implements Conducible {

	protected String marca;
	protected String modelo;
	protected String colorPintura;
	protected boolean encendido;
	protected boolean apagado;
	protected int velocidad;
	protected double velocidadMedia;
	protected Motorizacion motor;
	protected String MATRICULA;
	protected double posicion;

	/**
	 * Constructor con todos los parametros de vehiculo velocidad se autoinicializa
	 * a 0.
	 * 
	 * @param marca
	 * @param modelo
	 * @param colorPintura
	 * @param motor
	 * @param matricula
	 */
	protected Vehiculo(String marca, String modelo, String colorPintura, Motorizacion motor, String matricula) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.colorPintura = colorPintura;
		this.encendido = false;
		this.apagado = true;
		this.motor = motor;
		MATRICULA = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColorPintura() {
		return colorPintura;
	}

	public void setColorPintura(String colorPintura) {
		this.colorPintura = colorPintura;
	}

	public boolean isEncendido() {
		return encendido;
	}

	public void setEncendido(boolean encendido) {
		this.encendido = encendido;
	}

	public boolean isApagado() {
		return apagado;
	}

	public void setApagado(boolean apagado) {
		this.apagado = apagado;
	}

	public Motorizacion getMotor() {
		return motor;
	}

	public String getMATRICULA() {
		return MATRICULA;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public double getVelocidadMedia() {
		return velocidadMedia;
	}

	public void setVelocidadMedia(double velocidadMedia) {
		this.velocidadMedia = velocidadMedia;
	}

	public void setPosicion(double posicion) {
		this.posicion = posicion;
	}

	@Override
	public void encenderVehiculo() {
		this.apagado = false;
		this.encendido = true;

	}

	@Override
	public void apagarVehiculo() {
		this.encendido = false;
		this.apagado = true;

	}
/**
 * No 
 */
	
	@Override
	public void avanzar(int num) {

		this.posicion = posicion + num;
	}

	@Override
	public void parar() {
		this.velocidad = 0;

	}

	@Override
	public void aumentarVelocidad(int num) {
		this.velocidad = velocidad + num;
		// reducirTiempoViaje

	}

	@Override
	public void reducirVelocidad(int num) {
		if (this.velocidad > num) {
			this.velocidad = velocidad - num;
			// aumentarTiempoViaje
		} else {
			this.parar();
		}

	}


	/**
	 * Actualiza la posicion del vehiculo en base al tiempo transcurrido de viaje, y 
	 * la velocidad a la que iba el coche.La  velocidad llega en Km/h y se pasa a minutos. 
	 * @param velocidad
	 * @param trayecto
	 * @return posicion
	 */
	public double actualizarPosicionVehiculo(int velocidad, Trayecto trayecto) {
		this.posicion =  ((double)velocidad)/60 * (trayecto.minutosTranscurrido) ;
		
		return posicion;
	}

	@Override
	public String toString() {
		return "Vehiculo [marca=" + marca + ", modelo=" + modelo + ", colorPintura=" + colorPintura + ", encendido="
				+ encendido + ", apagado=" + apagado + ", velocidad=" + velocidad + ", velocidadMedia=" + velocidadMedia
				+ ", motor=" + motor + ", MATRICULA=" + MATRICULA + ", posicion=" + posicion + "]";
	}

}
