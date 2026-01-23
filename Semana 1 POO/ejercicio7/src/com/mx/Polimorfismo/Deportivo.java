package com.mx.Polimorfismo;

public class Deportivo extends Automovil {
	
	private int noCilindro;
	
	public String mostrarDatos() {
		return "Atomovil\n" + "Marca: " + this.marca + "\nSubmarca: " + this.subMarca + "\nColor: " + this.color 
				+"\nModelo: " + this.modelo + "\nNum de cilindro: " + this.noCilindro;
	}
		
	public Deportivo() {
		
	}

	public Deportivo(String marca, String subMarca, String color, int modelo, int noCilindro) {
		super(marca, subMarca, color, modelo);
		this.noCilindro = noCilindro;
	}

	public int getNoCilindro() {
		return noCilindro;
	}

	public void setNoCilindro(int noCilindro) {
		this.noCilindro = noCilindro;
	}

	@Override
	public String toString() {
		return "Deportivo [marca=" + marca + ", subMarca=" + subMarca + ", color=" + color + ", modelo=" + modelo
				+ ", noCilindro=" + noCilindro + "]";
	}
	
	

}
