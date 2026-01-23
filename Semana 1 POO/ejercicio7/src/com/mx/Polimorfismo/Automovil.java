package com.mx.Polimorfismo;

public class Automovil {
	
	protected String marca;
	protected String subMarca;
	protected String color;
	protected int modelo;
	
	//metodo personalizado
	public String mostrarDatos() {
		return "Atomovil\n" + "Marca: " + this.marca + "\nSubmarca: " + this.subMarca + "\nColor: " + this.color 
				+"\nModelo: " + this.modelo;
	}
		
	public Automovil() {
		
	}

	public Automovil(String marca, String subMarca, String color, int modelo) {
		super();
		this.marca = marca;
		this.subMarca = subMarca;
		this.color = color;
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getSubMarca() {
		return subMarca;
	}

	public void setSubMarca(String subMarca) {
		this.subMarca = subMarca;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getModelo() {
		return modelo;
	}

	public void setModelo(int modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "Automovil [marca=" + marca + ", subMarca=" + subMarca + ", color=" + color + ", modelo=" + modelo + "]";
	}
	
	

}
