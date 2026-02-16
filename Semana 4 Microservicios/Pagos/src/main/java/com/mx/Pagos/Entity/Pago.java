package com.mx.Pagos.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Pago {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPago;
	private Integer idPedido;
	private Integer tiendaId;
	private String metodo;
	private LocalDateTime fechaPago;
	private Integer monto;
	@Enumerated(EnumType.STRING)
	private eEstadoPago estado;

	public Pago() {
	}

	public Pago(Integer idPago, Integer idPedido, Integer tiendaId, String metodo, LocalDateTime fechaPago,
			Integer monto, eEstadoPago estado) {
		super();
		this.idPago = idPago;
		this.idPedido = idPedido;
		this.tiendaId = tiendaId;
		this.metodo = metodo;
		this.fechaPago = fechaPago;
		this.monto = monto;
		this.estado = estado;
	}

	public Integer getIdPago() {
		return idPago;
	}

	public void setIdPago(Integer idPago) {
		this.idPago = idPago;
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public Integer getTiendaId() {
		return tiendaId;
	}

	public void setTiendaId(Integer tiendaId) {
		this.tiendaId = tiendaId;
	}

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	public LocalDateTime getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDateTime fechaPago) {
		this.fechaPago = fechaPago;
	}

	public Integer getMonto() {
		return monto;
	}

	public void setMonto(Integer monto) {
		this.monto = monto;
	}

	public eEstadoPago getEstado() {
		return estado;
	}

	public void setEstado(eEstadoPago estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Pago [idPago=" + idPago + ", idPedido=" + idPedido + ", tiendaId=" + tiendaId + ", metodo=" + metodo
				+ ", fechaPago=" + fechaPago + ", monto=" + monto + ", estado=" + estado + "]";
	}
}
