package com.mx.Empleados;

public class EmpleadoPorHoras extends Empleado {

	private String puesto;
	private int horas;
	private double bonoHora;

	@Override
	public void calcularBono() {
		if (edad > 25) {
			bonoHora = (edad - 25) * 100;
		} else {
			bonoHora = 0;
		}

	}

	public EmpleadoPorHoras() { // inicializa la clase

	}

	public EmpleadoPorHoras(String nombre, int edad, double salario, String puesto, int horas, double bonoHora) {
		super(nombre, edad, salario);
		this.puesto = puesto;
		this.horas = horas;
		this.bonoHora = bonoHora;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public double getBonoHora() {
		return bonoHora;
	}

	public void setBonoHora(double bonoHora) {
		this.bonoHora = bonoHora;
	}

	@Override
	public String toString() {
		return "EmpleadoPorHoras [nombre=" + nombre + ", edad=" + edad + ", salario=" + salario + ", puesto=" + puesto
				+ ", horas=" + horas + ", bonoHora=" + bonoHora + "]";
	}

}
