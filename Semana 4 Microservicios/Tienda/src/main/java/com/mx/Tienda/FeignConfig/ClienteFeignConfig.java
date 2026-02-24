package com.mx.Tienda.FeignConfig;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
//esta es una anotacion de tipo configuracion que nos indica a nuestra clase como cliente http es decir
//vamos a realizar peticiones http al microservicio que vamos a indicar para poder consumir sus controladores
//a esto se le conoce como comunicacion sincrona entre microservicios
//solicita ek nombre del microservicio, y la url
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mx.Tienda.DTOs.ClienteDTO;


@FeignClient(name = "Client", url= "http://localhost:8001/C")
public interface ClienteFeignConfig {
	
	@GetMapping("listarPorTienda/{tiendaId}")
	public List<ClienteDTO> listarPorTienda(@PathVariable int tiendaId);
	
	
	
	

}
