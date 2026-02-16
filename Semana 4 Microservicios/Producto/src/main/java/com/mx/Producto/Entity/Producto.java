package com.mx.Producto.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRODUCTO")
public class Producto {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
    private Integer idProducto;
    private String nombre;
    private String descripcion;
    private double precio;
    private Integer stock=0;
    private Integer tiendaId;

    public Producto() {
    	
    }

	public Producto(Integer idProducto, String nombre, String descripcion, double precio, Integer stock,
			Integer tiendaId) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.tiendaId = tiendaId;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getTiendaId() {
		return tiendaId;
	}

	public void setTiendaId(Integer tiendaId) {
		this.tiendaId = tiendaId;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", precio=" + precio + ", stock=" + stock + ", tiendaId=" + tiendaId + "]";
	}

	
    

}
