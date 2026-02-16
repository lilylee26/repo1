package com.mx.DetallePedido.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class DetallePedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDetalle;

	private Integer idPedido;
	private Integer idProducto;
	private Integer cantidad;
	private Integer precioUnitario;
	private Integer tiendaId;

	public DetallePedido() {
		
		
	}

	public DetallePedido(Integer idDetalle, Integer idPedido, Integer idProducto, Integer cantidad,
			Integer precioUnitario, Integer tiendaId) {
		super();
		this.idDetalle = idDetalle;
		this.idPedido = idPedido;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.tiendaId = tiendaId;
	}

	public Integer getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(Integer idDetalle) {
		this.idDetalle = idDetalle;
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Integer precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public Integer getTiendaId() {
		return tiendaId;
	}

	public void setTiendaId(Integer tiendaId) {
		this.tiendaId = tiendaId;
	}

	@Override
	public String toString() {
		return "DetallePedido [idDetalle=" + idDetalle + ", idPedido=" + idPedido + ", idProducto=" + idProducto
				+ ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + ", tiendaId=" + tiendaId + "]";
	}

	

}
