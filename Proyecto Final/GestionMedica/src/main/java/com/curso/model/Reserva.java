package com.curso.model;

import java.time.LocalDate;

import java.time.LocalTime;
import java.util.Objects;

public class Reserva {

	private int idReserva;
	private int idPaciente;
	private String nombrePaciente;
	private int idTerapeuta;
	private LocalDate fecha;
	private LocalTime hora;

	public Reserva() {
		super();

	}

	public Reserva(int idReserva, int idPaciente, String nombrePaciente, int idTerapeuta, LocalDate fecha,
			LocalTime hora) {
		super();
		this.idReserva = idReserva;
		this.idPaciente = idPaciente;
		this.nombrePaciente = nombrePaciente;
		this.idTerapeuta = idTerapeuta;
		this.fecha = fecha;
		this.hora = hora;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getNombrePaciente() {
		return nombrePaciente;
	}

	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}

	public int getIdTerapeuta() {
		return idTerapeuta;
	}

	public void setIdTerapeuta(int idTerapeuta) {
		this.idTerapeuta = idTerapeuta;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idReserva);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		return idReserva == other.idReserva;
	}

	@Override
	public String toString() {
		return "Reserva [idReserva=" + idReserva + ", idPaciente=" + idPaciente + ", nombrePaciente=" + nombrePaciente
				+ ", idTerapeuta=" + idTerapeuta + ", fecha=" + fecha + ", hora=" + hora + "]";
	}

}
