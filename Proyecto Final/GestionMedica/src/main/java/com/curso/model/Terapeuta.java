package com.curso.model;




import java.time.LocalTime;
import java.util.Objects;




public class Terapeuta {

	private int idTerapeuta;
	private String nombre;
	private String apellidos;
	private String dni;
	private String especialidad;

	private LocalTime inicioIntervalo1;

	private LocalTime finIntervalo1;

	private LocalTime inicioIntervalo2;

	private LocalTime finIntervalo2;

	public Terapeuta() {
		super();

	}

	public Terapeuta(String nombre, String apellidos, String dni, String especialidad, LocalTime inicioIntervalo1,
			LocalTime finIntervalo1, LocalTime inicioIntervalo2, LocalTime finIntervalo2) {
		super();

		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.especialidad = especialidad;
		this.inicioIntervalo1 = inicioIntervalo1;
		this.finIntervalo1 = finIntervalo1;
		this.inicioIntervalo2 = inicioIntervalo2;
		this.finIntervalo2 = finIntervalo2;
	}

	public int getIdTerapeuta() {
		return idTerapeuta;
	}

	public void setIdTerapeuta(int idTerapeuta) {
		this.idTerapeuta = idTerapeuta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public LocalTime getInicioIntervalo1() {
		return inicioIntervalo1;
	}

	public void setInicioIntervalo1(LocalTime inicioIntervalo1) {
		this.inicioIntervalo1 = inicioIntervalo1;
	}

	public LocalTime getFinIntervalo1() {
		return finIntervalo1;
	}

	public void setFinIntervalo1(LocalTime finIntervalo1) {
		this.finIntervalo1 = finIntervalo1;
	}

	public LocalTime getInicioIntervalo2() {
		return inicioIntervalo2;
	}

	public void setInicioIntervalo2(LocalTime inicioIntervalo2) {
		this.inicioIntervalo2 = inicioIntervalo2;
	}

	public LocalTime getFinIntervalo2() {
		return finIntervalo2;
	}

	public void setFinIntervalo2(LocalTime finIntervalo2) {
		this.finIntervalo2 = finIntervalo2;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idTerapeuta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Terapeuta other = (Terapeuta) obj;
		return idTerapeuta == other.idTerapeuta;
	}

}
