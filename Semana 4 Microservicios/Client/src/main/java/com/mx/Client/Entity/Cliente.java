package com.mx.Client.Entity;
import jakarta.persistence.*;

@Entity
@Table

public class Cliente {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;
    private String nombre;
    private String email;
    private long telefono;
    private String direccion;
    private Integer tiendaId;
    
    
    
    public Cliente() {
    	
    }



	public Cliente(Integer idCliente, String nombre, String email, long telefono, String direccion, Integer tiendaId) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.direccion = direccion;
		this.tiendaId = tiendaId;
	}



	public Integer getIdCliente() {
		return idCliente;
	}



	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public long getTelefono() {
		return telefono;
	}



	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public Integer getTiendaId() {
		return tiendaId;
	}



	public void setTiendaId(Integer tiendaId) {
		this.tiendaId = tiendaId;
	}



	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", email=" + email + ", telefono=" + telefono
				+ ", direccion=" + direccion + ", tiendaId=" + tiendaId + "]";
	}
    
    
    
    
}
