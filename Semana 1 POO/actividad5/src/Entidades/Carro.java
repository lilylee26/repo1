package Entidades;

public class Carro {

	private String niv; // clave
	private String modelo;
	private String color;
	private int anio;
	private double precio;

	public Carro() {// constructor vacio

	}

	public Carro(String niv, String modelo, String color, int anio, double precio) {
		super();
		this.niv = niv;
		this.modelo = modelo;
		this.color = color;
		this.anio = anio;
		this.precio = precio;
	}

	public String getNiv() {
		return niv;
	}

	public void setNiv(String niv) {
		this.niv = niv;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Carro [niv=" + niv + ", modelo=" + modelo + ", color=" + color + ", anio=" + anio + ", precio=" + precio
				+ "]";
	}

}
