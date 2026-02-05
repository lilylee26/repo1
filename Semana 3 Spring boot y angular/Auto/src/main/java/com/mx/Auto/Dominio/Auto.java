package com.mx.Auto.Dominio;
import jakarta.persistence.*;

@Entity // esta anotacion indica que esta clase es una entidad de la base de datos
@Table(name = "automovil")//esta anotacion mapea la clase con la tabla (nos sirve para indicar a que tabla 
//nos referimos con la clase, opcional:no es necario especificar el nombre de la tabla
//si el nombre de la clase es igual al de la tabla, enotnces no es necesario colocar el name
public class Auto {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idAuto;
	private String marca;
	private String modelo;
	private int anio;
	private String color;
	@Column(name = "n_Serie")
	private String nSerie;
	private String tipo;
	private int precio;
	
	public Auto() {
		
	}

	public Auto(int idAuto, String marca, String modelo, int anio, String color, String nSerie, String tipo,
			int precio) {
		super();
		this.idAuto = idAuto;
		this.marca = marca;
		this.modelo = modelo;
		this.anio = anio;
		this.color = color;
		this.nSerie = nSerie;
		this.tipo = tipo;
		this.precio = precio;
	}

	public int getIdAuto() {
		return idAuto;
	}

	public void setIdAuto(int idAuto) {
		this.idAuto = idAuto;
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

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getnSerie() {
		return nSerie;
	}

	public void setnSerie(String nSerie) {
		this.nSerie = nSerie;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Auto [idAuto=" + idAuto + ", marca=" + marca + ", modelo=" + modelo + ", anio=" + anio + ", color="
				+ color + ", nSerie=" + nSerie + ", tipo=" + tipo + ", precio=" + precio + "]";
	}
	

}
