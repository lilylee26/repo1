package com.mx.Medicamento;

public class Medicamento {

	private int rSanitario; // clave
	private String nombre;
	private String distribuidor;
	private String caducidad;
	private double precio;

	public Medicamento() {

	}

	public Medicamento(int rSanitario, String nombre, String distribuidor, String caducidad, double precio) {
		super();
		this.rSanitario = rSanitario;
		this.nombre = nombre;
		this.distribuidor = distribuidor;
		this.caducidad = caducidad;
		this.precio = precio;
	}

	// realizar una sobrecarga de constructores con uno que nos permita inicilizar
	// con un solo valor
	public Medicamento(int rSanitario) {
		this.rSanitario = rSanitario;
	}

	public int getrSanitario() {
		return rSanitario;
	}

	public void setrSanitario(int rSanitario) {
		this.rSanitario = rSanitario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDistribuidor() {
		return distribuidor;
	}

	public void setDistribuidor(String distribuidor) {
		this.distribuidor = distribuidor;
	}

	public String getCaducidad() {
		return caducidad;
	}

	public void setCaducidad(String caducidad) {
		this.caducidad = caducidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Medicamento [rSanitario=" + rSanitario + ", nombre=" + nombre + ", distribuidor=" + distribuidor
				+ ", caducidad=" + caducidad + ", precio=" + precio + "\n]";
	}

}
