package com.mx.Herencia;

public class Delfin extends Animal {

	// puede tener sus propios atributos
	private String color;
	private double tamano;
	private String viveEn;

	public Delfin() {

	}

	public Delfin(String nombre, String especie, int edad, double peso, String color, double tamano, String viveEn) {
		super(nombre, especie, edad, peso);
		this.color = color;
		this.tamano = tamano;
		this.viveEn = viveEn;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getTamano() {
		return tamano;
	}

	public void setTamano(double tamano) {
		this.tamano = tamano;
	}

	public String getViveEn() {
		return viveEn;
	}

	public void setViveEn(String viveEn) {
		this.viveEn = viveEn;
	}

	@Override
	public String toString() {
		return "Delfin [nombre=" + nombre + ", especie=" + especie + ", edad=" + edad + ", peso=" + peso + ", color="
				+ color + ", tamano=" + tamano + ", viveEn=" + viveEn + "]";
	}
	
	
	 @Override
	    public void hacerSonido() {
	        System.out.println("El delfín hace iiiiii iiiiii");
	    }

}
