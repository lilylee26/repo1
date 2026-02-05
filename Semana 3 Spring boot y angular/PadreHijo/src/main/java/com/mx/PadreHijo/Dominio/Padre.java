package com.mx.PadreHijo.Dominio;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Padre {

	@Id
	private int idPadre;
	private String nombre;
	private String apellido;
	private int edad;
	private String trabajo;
	
	@OneToMany(mappedBy = "padreId", cascade = CascadeType.ALL)
	//mappendby es para indicar el atributo de la clase hijo que hace referencia a mi clase padre
	//cascade es para indicar como se vera reflejadas las operaciones de persistencia de la clase padre
	//en la clase hijo
	List<Hijo> lista = new ArrayList<>(); //para relacionar que el padre pueda tenr una lista de hijps
	
	
	public Padre() {
		
	}


	public Padre(int idPadre, String nombre, String apellido, int edad, String trabajo) {
		super();
		this.idPadre = idPadre;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.trabajo = trabajo;
	}


	public int getIdPadre() {
		return idPadre;
	}


	public void setIdPadre(int idPadre) {
		this.idPadre = idPadre;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getTrabajo() {
		return trabajo;
	}


	public void setTrabajo(String trabajo) {
		this.trabajo = trabajo;
	}


	@Override
	public String toString() {
		return "Padre [idPadre=" + idPadre + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad
				+ ", trabajo=" + trabajo + "]";
	}
	
	
	
	
}
