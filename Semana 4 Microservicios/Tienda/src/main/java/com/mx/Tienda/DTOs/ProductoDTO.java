package com.mx.Tienda.DTOs;

import lombok.Data;

@Data
public class ProductoDTO {
	
    private Integer idProducto;
    private String nombre;
    private String descripcion;
    private double precio;
    private Integer stock=0;
    private Integer tiendaId;

}
