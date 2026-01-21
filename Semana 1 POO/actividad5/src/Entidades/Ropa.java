package Entidades;

public class Ropa {

	private long codigo;// clave
	private String nombre;
	private String material;
	private String talla;
	private double precio;

	public Ropa() { // constructor vacio

	}

	public Ropa(long codigo, String nombre, String material, String talla, double precio) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.material = material;
		this.talla = talla;
		this.precio = precio;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Ropa [codigo=" + codigo + ", nombre=" + nombre + ", material=" + material + ", talla=" + talla
				+ ", precio=" + precio + "]";
	}

}
