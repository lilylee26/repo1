package com.mx.Polimorfismo;

public class Turismo extends Automovil {
	
	private int noAsientos;
	
	public String mostrarDatos() {
		return "Atomovil\n" + "Marca: " + this.marca + "\nSubmarca: " + this.subMarca + "\nColor: " + this.color 
				+"\nModelo: " + this.modelo + "\nNum de asiento: " + this.noAsientos;
	}
		
	public Turismo() {
		
	}

	public Turismo(String marca, String subMarca, String color, int modelo, int noAsientos) {
		super(marca, subMarca, color, modelo);
		this.noAsientos = noAsientos;
	}

	public int getNoAsientos() {
		return noAsientos;
	}

	public void setNoAsientos(int noAsientos) {
		this.noAsientos = noAsientos;
	}

	@Override
	public String toString() {
		return "Turismo [marca=" + marca + ", subMarca=" + subMarca + ", color=" + color + ", modelo=" + modelo
				+ ", noAsientos=" + noAsientos + "]";
	}


	

}
