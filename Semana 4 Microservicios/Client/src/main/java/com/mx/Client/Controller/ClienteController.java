package com.mx.Client.Controller;

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


import com.mx.Client.Entity.Cliente;
import com.mx.Client.Service.ClienteService;

@RestController
@RequestMapping(path = "/C")
@CrossOrigin
public class ClienteController {

	@Autowired
	private ClienteService service;




	@GetMapping
	public ResponseEntity<?> listar() {
		if (service.listar().isEmpty()) {
			return ResponseEntity.noContent().build();

		} else {
			return ResponseEntity.ok(service.listar());
		}
	}

	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody Cliente cliente) {

		boolean existeTelefono = service.existeTelefono(cliente.getTelefono());
		if (existeTelefono) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("El telefono ya existe");
		}
		boolean existeCliente = service.existeCliente(cliente.getNombre(), cliente.getEmail());
		if (existeCliente) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Ese cliente ya existe");

		} else {

			service.guardar(cliente);
			return ResponseEntity.status(HttpStatus.CREATED).body("Se registro con exito");

		}
	}

	@GetMapping("/{idCliente:\\d+}")
	public ResponseEntity<?> buscarPorCliente(@PathVariable Integer idCliente) {
	    Cliente cliente = service.buscar(idCliente);
	    if (cliente == null) {
	        return ResponseEntity.status(HttpStatus.CONFLICT).body("No existe el cliente");
	    }
	    return ResponseEntity.ok(cliente);
	}


	@PutMapping
	public ResponseEntity<?> editar(@RequestBody Cliente cliente) {

		// verificar que exista
		Cliente existente = service.buscar(cliente.getIdCliente());
		if (existente == null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("No existe el cliente para editar");
		}

		// validar cliente duplicado nombre + email
		boolean clienteDuplicado = service.existeClienteEditar(cliente.getNombre(), cliente.getEmail(),
				cliente.getIdCliente());

		if (clienteDuplicado) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Ese cliente ya existe");
		} else {

			service.editar(cliente);
			return ResponseEntity.ok("Editado con exito");
		}
	}

	@DeleteMapping("/{idCliente}")
	public ResponseEntity<?> eliminar(@PathVariable Integer idCliente) {

		Cliente cliente = service.buscar(idCliente);

		if (cliente == null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("No existe el cliente");
		} else {

			service.eliminar(idCliente);
			return ResponseEntity.ok("Eliminado con exito");
		}
	}

	
	@GetMapping("/listarPorTienda/{idTienda}")
	public ResponseEntity<?> listarPorTienda(@PathVariable Integer idTienda) {

	    if (service.listarPorTienda(idTienda).isEmpty()) {
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.ok(service.listarPorTienda(idTienda));
	    }
	}

	
	
	@GetMapping("/tienda/{idTienda}")
	public ResponseEntity<?> buscarPorTienda(@PathVariable Integer idTienda) {

		if (service.listarPorTienda(idTienda).isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {

			return ResponseEntity.ok(service.listarPorTienda(idTienda));
		}
	}

}
