package Entidades;

public class Fruta {
	
	private String nombre; //clave
	private String color;
	private int peso;
	private double precio;
	private String temporada;
	
	public Fruta () {//constructor vacio
		
		
	}

	//constructor parametrizado
	public Fruta(String nombre, String color, int peso, double precio, String temporada) {
		super();
		this.nombre = nombre;
		this.color = color;
		this.peso = peso;
		this.precio = precio;
		this.temporada = temporada;
	}

	//getters and setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getTemporada() {
		return temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	@Override
	public String toString() {
		return "Fruta [nombre=" + nombre + ", color=" + color + ", peso=" + peso + ", precio=" + precio + ", temporada="
				+ temporada + "\n]";
	}

}
