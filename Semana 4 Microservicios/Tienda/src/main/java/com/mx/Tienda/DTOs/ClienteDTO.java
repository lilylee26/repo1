package com.mx.Tienda.DTOs;

import lombok.Data;

//DTO : Data transfer Object, nos permite manejar la infromacion de una entidad sin ncesidad de modificarla y tampoco confundir a la aplicacion
//de que manejo otras entidades, aparte de la principal
@Data
public class ClienteDTO {
	
    private Integer idCliente;
    private String nombre;
    private String email;
    private long telefono;
    private String direccion;
    private Integer tiendaId;
    
    
    
    
    

}
