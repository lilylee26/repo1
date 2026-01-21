package Entidades;

public class Telefono {

	private int imei; // clave
	private String marca;
	private String nombre;
	private int anio;
	private double precio;

	public Telefono() {// constructor vacio

	}

	public Telefono(int imei, String marca, String nombre, int anio, double precio) {
		super();
		this.imei = imei;
		this.marca = marca;
		this.nombre = nombre;
		this.anio = anio;
		this.precio = precio;
	}

	public int getImei() {
		return imei;
	}

	public void setImei(int imei) {
		this.imei = imei;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
		return "Telefono [imei=" + imei + ", marca=" + marca + ", nombre=" + nombre + ", anio=" + anio + ", precio="
				+ precio + "]";
	}

}
