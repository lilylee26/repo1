package com.mx.Pedidos.Entity;


import java.sql.Date;
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
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer idPedido;
		private Integer clienteId;
		private LocalDateTime fechaPedido;
		private Integer total;
		@Enumerated (EnumType.STRING)
		private eEstados estado;
		private Integer tiendaId;



		public Pedido() {


		}



		public Pedido(Integer idPedido, Integer clienteId, LocalDateTime fechaPedido, Integer total, eEstados estado, Integer tiendaId) {
			super();
			this.idPedido = idPedido;
			this.clienteId = clienteId;
			this.fechaPedido = fechaPedido;
			this.total = total;
			this.estado = estado;
			this.tiendaId = tiendaId;
		}



		public Integer getIdPedido() {
			return idPedido;
		}



		public void setIdPedido(Integer idPedido) {
			this.idPedido = idPedido;
		}



		public Integer getClienteId() {
			return clienteId;
		}



		public void setClienteId(Integer clienteId) {
			this.clienteId = clienteId;
		}



		public LocalDateTime getFechaPedido() {
			return fechaPedido;
		}



		public void setFechaPedido(LocalDateTime fechaPedido) {
			this.fechaPedido = fechaPedido;
		}



		public Integer getTotal() {
			return total;
		}



		public void setTotal(Integer total) {
			this.total = total;
		}



		public eEstados getEstado() {
			return estado;
		}



		public void setEstado(eEstados estado) {
			this.estado = estado;
		}



		public Integer getTiendaId() {
			return tiendaId;
		}



		public void setTiendaId(Integer tiendaId) {
			this.tiendaId = tiendaId;
		}



		@Override
		public String toString() {
			return "Pedido [idPedido=" + idPedido + ", clienteId=" + clienteId + ", fechaPedido=" + fechaPedido
					+ ", total=" + total + ", estado=" + estado + ", tiendaId=" + tiendaId + "]";
		}




}
