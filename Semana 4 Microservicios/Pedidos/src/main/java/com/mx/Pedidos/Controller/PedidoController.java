package com.mx.Pedidos.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Pedidos.Entity.Pedido;
import com.mx.Pedidos.Service.PedidoService;

@RestController
@RequestMapping(path= "/PP")
@CrossOrigin
public class PedidoController {

	@Autowired

	private PedidoService service;

	@GetMapping
	public ResponseEntity<?> listar(){
		if(service.listar().isEmpty()) {
			return ResponseEntity.noContent().build();

		}else {
			return ResponseEntity.ok(service.listar());

		}
	}


	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody Pedido pedido){
	    service.guardar(pedido);
	    return ResponseEntity.ok("Guardado");
	}


	@PutMapping
	public ResponseEntity<?> editar(@RequestBody Pedido pedido){
	    if(service.buscar(pedido.getIdPedido()) == null){
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El registro no existe");
	    } else {
	        service.editar(pedido);
	        return ResponseEntity.ok("Editado");
	    }
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> eliminar(@PathVariable int idPedido){
	    if(service.buscar(idPedido) == null){
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El registro no existe");
	    } else {
	        service.eliminar(idPedido);
	        return ResponseEntity.ok("Eliminado");
	    }
	}

	@GetMapping(path = "/{idPedido}")
	public ResponseEntity<?> buscar(@PathVariable int idPedido){

	    if(service.buscar(idPedido) == null){
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El registro no existe");
	    } else {
	        return ResponseEntity.ok(service.buscar(idPedido));
	    }
	}

	@GetMapping(path = "listarPTienda/{tiendaId}")
	public ResponseEntity<?> listarPTienda(@PathVariable int tiendaId){
	    return ResponseEntity.ok(service.listarPTienda(tiendaId));
	}

	@GetMapping(path = "listarPCliente/{clienteId}")
	public ResponseEntity<?> listarPCliente(@PathVariable int clienteId){
	    return ResponseEntity.ok(service.listarPCliente(clienteId));
	}




}
