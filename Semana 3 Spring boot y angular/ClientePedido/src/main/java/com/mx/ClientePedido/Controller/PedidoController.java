package com.mx.ClientePedido.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mx.ClientePedido.Dominio.Pedido;
import com.mx.ClientePedido.Service.PedidoService;

@RestController
@RequestMapping(path = "api/Pedido")
@CrossOrigin

public class PedidoController {

	@Autowired
	private PedidoService service;

	@GetMapping
	public ResponseEntity<?> listar() {
		if (service.listar().isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(service.listar());
		}

	}

	@PostMapping("guardar")
	public ResponseEntity<?> guardar(@Validated @RequestBody Pedido pedido) {
	    try {
	        service.guardar(pedido); // aquí adentro se valida duplicado
	        return ResponseEntity.ok("Se guardo con exito");
	    } catch (RuntimeException e) {
	      
	        if (e.getMessage() != null && e.getMessage().toLowerCase().contains("duplicado")) {
	            return ResponseEntity.status(409).body(e.getMessage());
	        }

	        return ResponseEntity.badRequest().body(e.getMessage());
	    }
	}



	@PutMapping("editar") //
	public ResponseEntity<?> editar(@RequestBody Pedido pedido) {

		service.editar(pedido);
		;
		return ResponseEntity.ok("Se guardo con exito");

	}

	@DeleteMapping("/{idPedido}")
	public ResponseEntity<?> eliminar(@PathVariable int idPedido) {
		service.eliminar(idPedido);
		return ResponseEntity.ok("Eliminacion exitosa");

	}

	@GetMapping("/{idPedido}")

	public ResponseEntity<?> buscar(@PathVariable int idPedido) {
		return ResponseEntity.ok(service.buscar(idPedido));
	}

//	@GetMapping("listarPorFecha")
//	// la anotacion requestParam nos inidca wque la hacer la peticion solicitara
//	// un par de clave valor como parametro
//	public ResponseEntity<?> listarPorFecha(@RequestParam String fecha) {
//		return ResponseEntity.ok(service.listarPorFecha(fecha));
//
//	}
	
	
	@GetMapping("listarPorFecha/{fecha}")
	public ResponseEntity<?> listarPorFecha(@PathVariable String fecha){
	    return ResponseEntity.ok(service.listarPorFecha(fecha));
	}


}
