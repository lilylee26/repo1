package com.mx.ClientePedido.Dominio;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table

public class Cliente {
	
	
	@Id
	private int idCliente;
	private String nombre;
	private String ciudad;
	
	
	@OneToMany(mappedBy = "clienteId", cascade = CascadeType.ALL)
	@JsonIgnore
	//mappendby es para indicar el atributo de la clase hijo que hace referencia a mi clase padre
	//cascade es para indicar como se vera reflejadas las operaciones de persistencia de la clase padre
	//en la clase hijo
	List<Pedido> lista = new ArrayList<>(); //para relacionar que el padre pueda tenr una lista de hijps
	
	
	public Cliente() {
		
	}


	public Cliente(int idCliente, String nombre, String ciudad, List<Pedido> lista) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.lista = lista;
	}


	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCiudad() {
		return ciudad;
	}


	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	public List<Pedido> getLista() {
		return lista;
	}


	public void setLista(List<Pedido> lista) {
		this.lista = lista;
	}


	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", ciudad=" + ciudad + ", lista=" + lista
				+ "]";
	}
	

}
