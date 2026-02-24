package com.mx.Tienda.DTOs;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class PedidoDTO {
	private Integer idPedido;
	private Integer clienteId;
	private LocalDateTime fechaPedido;
	private Integer total;
	private String estado; 
	private Integer tiendaId;


}
