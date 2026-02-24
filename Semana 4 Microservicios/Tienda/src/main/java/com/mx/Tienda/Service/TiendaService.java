package com.mx.Tienda.Service;
import com.mx.Tienda.DTOs.ProductoDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.mx.Tienda.DTOs.ClienteDTO;
import com.mx.Tienda.DTOs.PedidoDTO;
import com.mx.Tienda.DTOs.ProductoDTO;
import com.mx.Tienda.Entity.Tienda;
import com.mx.Tienda.FeignConfig.ClienteFeignConfig;
import com.mx.Tienda.FeignConfig.PedidoFeignConfig;
import com.mx.Tienda.Repository.TiendaRepository;

import feign.FeignException;

@Service
public class TiendaService {
	
	@Autowired
	private TiendaRepository repo;
	
	@Autowired
	private PedidoFeignConfig PedidoFC;

	
	public void guardar(Tienda tienda) {
		repo.save(tienda);
	}
	
	public void editar(Tienda tienda) {
		repo.save(tienda);	
	}
	
	public void eliminar(int tiendaId) {
		repo.deleteById(tiendaId);	
	}
	
	public Tienda buscar(int tiendaId) {
		return repo.findById(tiendaId).orElse(null);
		
	}
	
	public List<Tienda> listar(){
		return repo.findAll(Sort.by(Sort.Direction.ASC, "idTienda"));
		
	}
	
	//metodo para consumirCliente
	@Autowired
	private ClienteFeignConfig ClienteFC;
	
	public List<ClienteDTO> listarClientes(Integer tiendaId) {
		return ClienteFC.listarPorTienda(tiendaId);
	}
	
	
	//metodo para consumir pedido usando RestTemplate
	@Autowired
	RestTemplate restTemplate;
	@SuppressWarnings("unchecked")
	public List<PedidoDTO> listarPedidos(Integer tiendaId){
		
	    List<PedidoDTO> pedidos = restTemplate.getForObject("http://localhost:8004/PP/listarPTienda/" + tiendaId, List.class);
	    return pedidos;
	}

	
	@SuppressWarnings("unchecked")
	public List<ProductoDTO>listarProductos(Integer tiendaId) {

	    List<ProductoDTO> productos = restTemplate.getForObject("http://localhost:8003/P/tienda/" + tiendaId,List.class);

	    return productos;
	}

	
	//listar la infromacion de tiened con todos su clientes y pedidos
	public Map<String,Object> listarTodo(int tiendaId){
		Map<String, Object> resultado = new HashMap<>();
		//validar si tienda existe
		Tienda tiendita=repo.findById(tiendaId).orElse(null);
		if(tiendita ==null) {
			resultado.put("Tienda mensaje", "No existe la tienda");
		}else {
			resultado.put("La informacion de la tienda:" , tiendita);
			//validar si existe o jo(validar si esta disponible 
			try {//servira para el manejo si el sevicio de clientes esta disponible o no
				List<ClienteDTO> clientes = listarClientes(tiendaId);
				if(clientes.isEmpty()) {
					resultado.put("Cliente mesnaje", "No existen clientes");					
				}else {
					resultado.put("Clientes asosciados", clientes);
				}				
			}catch(FeignException e){
				resultado.put("Clientes conexion error", "El servicio de cliente no esta disponible");
			}
			//imprimir la informacion de pedidos (validacion si hay ) y verificar si el servicio esta disponible o no
			try {
				List<PedidoDTO> pedidos = listarPedidos(tiendaId);
				if (pedidos.isEmpty()) {
					resultado.put("Pedidos mesnaje: ", "No existen pedidos");
				}else {
					resultado.put("Pedidos resgistrados", pedidos);					
				}					
				}catch(Exception e) {
					resultado.put("Pedidos conexion error", "El servicio de pedidos no esta disponible");
					
			}
			
			
			// PRODUCTOS
			try {
			    List<ProductoDTO> productos = listarProductos(tiendaId);

			    if (productos.isEmpty()) {
			        resultado.put("Productos mensaje", "No existen productos");
			    } else {
			        resultado.put("Productos registrados", productos);
			    }

			} catch (Exception e) {
			    resultado.put("Productos conexion error", "El servicio de productos no esta disponible");
			}

			
			
			
			
		}
		return resultado;
	}
	
	
	

	

}
