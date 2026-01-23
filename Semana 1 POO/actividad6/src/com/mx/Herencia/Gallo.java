package com.mx.Herencia;

public class Gallo extends Animal {

	// puede tener sus propios atributos
	private String color2;
	private double tamano2;
	private String viveEn2;

	public Gallo() {

	}

	public Gallo(String nombre, String especie, int edad, double peso, String color2, double tamano2, String viveEn2) {
		super(nombre, especie, edad, peso);
		this.color2 = color2;
		this.tamano2 = tamano2;
		this.viveEn2 = viveEn2;
	}

	public String getColor2() {
		return color2;
	}

	public void setColor2(String color2) {
		this.color2 = color2;
	}

	public double getTamano2() {
		return tamano2;
	}

	public void setTamano2(double tamano2) {
		this.tamano2 = tamano2;
	}

	public String getViveEn2() {
		return viveEn2;
	}

	public void setViveEn2(String viveEn2) {
		this.viveEn2 = viveEn2;
	}

	@Override
	public String toString() {
		return "Gallo [nombre=" + nombre + ", especie=" + especie + ", edad=" + edad + ", peso=" + peso + ", color2="
				+ color2 + ", tamano2=" + tamano2 + ", viveEn2=" + viveEn2 + "]";
	}

	
	   @Override
	    public void hacerSonido() {
	        System.out.println("El gallo hace kikirikííí");
	    }
	
	
}
