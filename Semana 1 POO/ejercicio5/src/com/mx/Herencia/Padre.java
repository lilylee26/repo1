package com.mx.Herencia;

public class Padre {

	protected String nombre;
	protected String Apellido;
	protected int edad;
	protected String nacionalidas;
	
	public Padre () {
		//constructor vacio
		
	}

	//constructor con parametros
	public Padre(String nombre, String apellido, int edad, String nacionalidas) {
		super();
		this.nombre = nombre;
		Apellido = apellido;
		this.edad = edad;
		this.nacionalidas = nacionalidas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNacionalidas() {
		return nacionalidas;
	}

	public void setNacionalidas(String nacionalidas) {
		this.nacionalidas = nacionalidas;
	}

	@Override
	public String toString() {
		return "Padre [nombre=" + nombre + ", Apellido=" + Apellido + ", edad=" + edad + ", nacionalidas="
				+ nacionalidas + "]";
	}
	
	//metodo personalizado
	public void trabajar() {
		System.out.println("Trabajo de 8AM a 4PM");
	}
	
}
