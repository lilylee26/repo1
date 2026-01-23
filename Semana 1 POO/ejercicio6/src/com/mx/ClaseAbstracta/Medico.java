package com.mx.ClaseAbstracta;

public class Medico extends Profesionista {
	
	private String especialidad;
	private String cosultorio;
	private double costoConsulta;

	@Override
	public void trabajar() {
		System.out.println("Trabajo de 12AM a 4AM");
		
	}
	
	public Medico() { //inicializa la clase
		
	}

	public Medico(String nombre, String apellido, int edad, int cedula, String universidad, int experiencia,
			String especialidad, String cosultorio, double costoConsulta) {
		super(nombre, apellido, edad, cedula, universidad, experiencia);
		this.especialidad = especialidad;
		this.cosultorio = cosultorio;
		this.costoConsulta = costoConsulta;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getCosultorio() {
		return cosultorio;
	}

	public void setCosultorio(String cosultorio) {
		this.cosultorio = cosultorio;
	}

	public double getCostoConsulta() {
		return costoConsulta;
	}

	public void setCostoConsulta(double costoConsulta) {
		this.costoConsulta = costoConsulta;
	}

	@Override
	public String toString() {
		return "Medico [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", cedula=" + cedula
				+ ", universidad=" + universidad + ", experiencia=" + experiencia + ", especialidad=" + especialidad
				+ ", cosultorio=" + cosultorio + ", costoConsulta=" + costoConsulta + "]";
	}
	
	
	
	

}
