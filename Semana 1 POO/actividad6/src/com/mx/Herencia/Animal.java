package com.mx.Herencia;

public abstract class Animal {

	protected String nombre;
	protected String especie;
	protected int edad;
	protected double peso;

	public Animal() {
		// constructor vacio

	}

	public Animal(String nombre, String especie, int edad, double peso) {
		super();
		this.nombre = nombre;
		this.especie = especie;
		this.edad = edad;
		this.peso = peso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Animal [nombre=" + nombre + ", especie=" + especie + ", edad=" + edad + ", peso=" + peso + "]";
	}

	// metodo personalizado

	public abstract void hacerSonido();

}