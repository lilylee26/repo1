package Entidades;

public class Juguete {
	
	private long sku;//clave
	private String nombre;
	private String material;
	private String empresa;
	private String edades;
	
	public Juguete() {
		
	}

	public Juguete(long sku, String nombre, String material, String empresa, String edades) {
		super();
		this.sku = sku;
		this.nombre = nombre;
		this.material = material;
		this.empresa = empresa;
		this.edades = edades;
	}

	public long getSku() {
		return sku;
	}

	public void setSku(long sku) {
		this.sku = sku;
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

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getEdades() {
		return edades;
	}

	public void setEdades(String edades) {
		this.edades = edades;
	}

	@Override
	public String toString() {
		return "Juguete [sku=" + sku + ", nombre=" + nombre + ", material=" + material + ", empresa=" + empresa
				+ ", edades=" + edades + "\n]";
	}
	
	
	

}
