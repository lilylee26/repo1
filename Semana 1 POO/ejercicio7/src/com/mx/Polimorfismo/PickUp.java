package com.mx.Polimorfismo;

public class PickUp extends Automovil{
	
	private int capacidadCarga;
	
	public String mostrarDatos() {
		return "Atomovil\n" + "Marca: " + this.marca + "\nSubmarca: " + this.subMarca + "\nColor: " + this.color 
				+"\nModelo: " + this.modelo + "\nCapacidad de carga: " + this.capacidadCarga;
	}
		
	public PickUp() {
		
	}

	public PickUp(String marca, String subMarca, String color, int modelo, int capacidadCarga) {
		super(marca, subMarca, color, modelo);
		this.capacidadCarga = capacidadCarga;
	}

	public int getCapacidadCarga() {
		return capacidadCarga;
	}

	public void setCapacidadCarga(int capacidadCarga) {
		this.capacidadCarga = capacidadCarga;
	}

	@Override
	public String toString() {
		return "PickUp [marca=" + marca + ", subMarca=" + subMarca + ", color=" + color + ", modelo=" + modelo
				+ ", capacidadCarga=" + capacidadCarga + "]";
	}
	
	

}
