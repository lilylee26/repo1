package com.mx.Farmacia.Dominio;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // esta anotacion indica que esta clase representa una entindad en la BD
@Table(name = "MEDICAMENTO") // esta anotacion mapea a la tabla con el nombre especificad
//es decir jpa busca dentro de la conexion que le indique en properties, si la tabla existe
//si no existe, no podria realizar operaciones de persiones, pq no existiria el objeto en cuestion
//En dado caso de que el nombre la clase java no coincida con el nombre de tabla entoces 
//con e atributo name, especificaras el nombre de la tabla a a que se debe mapear las operacoones
//de persistencia
public class Medicamento {

	@Id // mapea el atributo al id
	private int idMed;
	private String nombre;
	private String laboratorio;
	private int precio;
	private int stock;

	public Medicamento() {

	}

	public Medicamento(int idMed, String nombre, String laboratorio, int precio, int stock) {
		super();
		this.idMed = idMed;
		this.nombre = nombre;
		this.laboratorio = laboratorio;
		this.precio = precio;
		this.stock = stock;
	}

	public int getIdMed() {
		return idMed;
	}

	public void setIdMed(int idMed) {
		this.idMed = idMed;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Medicamento [idMed=" + idMed + ", nombre=" + nombre + ", laboratorio=" + laboratorio + ", precio="
				+ precio + ", stock=" + stock + "]";
	}
	
	

}
