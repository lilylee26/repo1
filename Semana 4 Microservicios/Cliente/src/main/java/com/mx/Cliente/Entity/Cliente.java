package com.mx.Cliente.Entity;
import jakarta.persistence.*;

@Entity
@Table

public class Cliente {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;
    private String nombre;
    private String email;
    private long telefono;
    private String direccion;
    private int tiendaId;
    
    
    
    public Cliente() {
    	
    }



	public Cliente(int idCliente, String nombre, String email, long telefono, String direccion, int tiendaId) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.direccion = direccion;
		this.tiendaId = tiendaId;
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



	public int getTiendaId() {
		return tiendaId;
	}



	public void setTiendaId(int tiendaId) {
		this.tiendaId = tiendaId;
	}



	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", email=" + email + ", telefono=" + telefono
				+ ", direccion=" + direccion + ", tiendaId=" + tiendaId + "]";
	}
    
    
    
    
}
