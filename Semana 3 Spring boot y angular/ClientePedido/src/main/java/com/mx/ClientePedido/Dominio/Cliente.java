package com.mx.ClientePedido.Dominio;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;


@Entity
@Table(
   name = "CLIENTE",
   uniqueConstraints = {
       @UniqueConstraint(
           name = "UK_CLIENTE_NOMBRE_CIUDAD",
           columnNames = {"NOMBRE","CIUDAD"}
       )
   }
)
public class Cliente {
	
	
	@Id
	
	private int idCliente;
	
	private String nombre;
	private String ciudad;
	
	
	@OneToMany(mappedBy = "clienteId", cascade = CascadeType.ALL)
	
	//mappendby es para indicar el atributo de la clase hijo que hace referencia a mi clase padre
	//cascade es para indicar como se vera reflejadas las operaciones de persistencia de la clase padre
	//en la clase hijo
	List<Pedido> lista = new ArrayList<>(); //para relacionar que el padre pueda tenr una lista de hijps
	
	
	public Cliente() {
		
	}


	public Cliente(int idCliente, String nombre, String ciudad) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.ciudad = ciudad;
		
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





	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", ciudad=" + ciudad
				+ "]";
	}
	

}
