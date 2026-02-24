package com.mx.Computadora.Dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //esta anotacion indica que esta clase representa una entindad en la BD
@Table(name = "COMPUTADORA") //esta anotacion mapea a la tabla con el nombre especificad
//es decir jpa busca dentro de la conexion que le indique en properties, si la tabla existe
//si no existe, no podria realizar operaciones de persiones, pq no existiria el objeto en cuestion
//En dado caso de que el nombre la clase java no coincida con el nombre de tabla entoces 
//con e atributo name, especificaras el nombre de la tabla a a que se debe mapear las operacoones
//de persistencia
public class Computadora {
	
	@Id //mapea el atributo al id correcpodiente de la tabla
	private int idCompu;
	private String marca;
	private String modelo;
	private int ram;
	private String procesador;
	private int precio;
	
	public Computadora() {
		
	}

	public Computadora(int idCompu, String marca, String modelo, int ram, String procesador, int precio) {
		super();
		this.idCompu = idCompu;
		this.marca = marca;
		this.modelo = modelo;
		this.ram = ram;
		this.procesador = procesador;
		this.precio = precio;
	}

	public int getIdCompu() {
		return idCompu;
	}

	public void setIdCompu(int idCompu) {
		this.idCompu = idCompu;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public String getProcesador() {
		return procesador;
	}

	public void setProcesador(String procesador) {
		this.procesador = procesador;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Computadora [idComputadora=" + idCompu + ", marca=" + marca + ", modelo=" + modelo + ", ram="
				+ ram + ", procesador=" + procesador + ", precio=" + precio + "]";
	}
	
	
	
	

}
