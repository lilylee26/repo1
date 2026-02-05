package com.mx.ClientePedido.Dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Pedido {
	
	@Id
	private int idPedido;
	@Column(name = "FECHA")
	private String fecha;
	private int monto;
	
	@ManyToOne(fetch = FetchType.EAGER)//cada que realice una consulta de hijo la informacion de padre 
	//igual se cargara
	@JoinColumn (name ="CLIENTE_ID")//esta anotacion indica el campo en la db que hace referncia a la tabla padre, y nos ayuda a evitar
	//la creacion de tablas no necesarias
	private Cliente clienteId;

	
	public Pedido() {
		
	}


	public Pedido(int idPedido, String fecha, int monto, Cliente clienteId) {
		super();
		this.idPedido = idPedido;
		fecha = fecha;
		this.monto = monto;
		this.clienteId = clienteId;
	}


	public int getIdPedido() {
		return idPedido;
	}


	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		fecha = fecha;
	}


	public int getMonto() {
		return monto;
	}


	public void setMonto(int monto) {
		this.monto = monto;
	}


	public Cliente getClienteId() {
		return clienteId;
	}


	public void setClienteId(Cliente clienteId) {
		this.clienteId = clienteId;
	}


	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", Fecha=" + fecha + ", monto=" + monto + ", clienteId=" + clienteId
				+ "]";
	}
	
	

}
