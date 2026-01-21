package com.mx.Animal;

public class Animal {
	
	//declaracion de atributos
	private String nombre;
	private String especie;
	private String sexo;
	private int edad;
	private double peso;
	
	//constructor por defecto
	public Animal() {
		
	}

	public Animal(String nombre, String especie, String sexo, int edad, double peso) {
		super();
		this.nombre = nombre;
		this.especie = especie;
		this.sexo = sexo;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
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
		return "Animal [nombre= " + nombre + ", especie= " + especie + ", sexo= " + sexo + ", edad= " + edad + ", peso= "
				+ peso + "\n]";
	}
	
	
	

}