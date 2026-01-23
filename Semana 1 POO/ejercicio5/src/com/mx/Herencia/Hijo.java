package com.mx.Herencia;
//extends es herencia
public class Hijo extends Padre {
	
	//puede tener sus propios atributos
	private String colorOjos;
	private double altura;
	private String tez;
	
	public Hijo() {
		
	}

	public Hijo(String nombre, String apellido, int edad, String nacionalidas, String colorOjos, double altura,
			String tez) {
		super(nombre, apellido, edad, nacionalidas);
		this.colorOjos = colorOjos;
		this.altura = altura;
		this.tez = tez;
	}

	public String getColorOjos() {
		return colorOjos;
	}

	public void setColorOjos(String colorOjos) {
		this.colorOjos = colorOjos;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public String getTez() {
		return tez;
	}

	public void setTez(String tez) {
		this.tez = tez;
	}

	//metodo sirve para convertir un objeto a texto
	@Override
	public String toString() {
		return "Hijo [nombre=" + nombre + ", Apellido=" + Apellido + ", edad=" + edad + ", nacionalidas=" + nacionalidas
				+ ", colorOjos=" + colorOjos + ", altura=" + altura + ", tez=" + tez + "]";
	}
	
	

}
