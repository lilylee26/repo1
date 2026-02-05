package com.mx.ClientePedido.Controller;
import java.net.ResponseCache;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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

import com.mx.ClientePedido.Dominio.Cliente;
import com.mx.ClientePedido.Service.ClienteService;


@RestController
@RequestMapping(path = "api/Cliente")
@CrossOrigin
public class ClienteController {
	
	
	
	@Autowired
	private ClienteService service;


	@GetMapping("listar")
	
	//ResponseEntity es una extension que nos permite modificar el body y el sattus
	//de la respues http
	public ResponseEntity<?> listar(){
		List<Cliente> clientes = service.listar();
		if (clientes.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			
			return ResponseEntity.ok(clientes);
		}
	}
	
	@PostMapping("guardar")
	
	public ResponseEntity<String> guardar(@RequestBody Cliente cliente){
		
		Cliente encontrado = service.buscar(cliente.getIdCliente());
		if(encontrado ==null) {
			service.guardar(cliente);
			return ResponseEntity.status(HttpStatus.CREATED).body("El cliente se registro con exito");
		}else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Ese id no existe");
		}
	
	}
	
	
	@PutMapping("editar")
	public ResponseEntity<String> editar (@RequestBody Cliente cliente){
		Cliente encontrado = service.buscar(cliente.getIdCliente());
		if (encontrado == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El id que intentas editar, no existe");
			
		}else {
			service.editar(cliente);
			return ResponseEntity.ok("Edicion exitosa");
		}
		
	}
	
	@GetMapping("buscar/{idCliente}")
	//Pathvariable indica que solicitara un parametro para completar la url de comsumo
	public ResponseEntity<?> buscar(@PathVariable int idCliente){
		Cliente encontrado = service.buscar(idCliente);
		if(encontrado ==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe ese registro");
			
		}else {
			return ResponseEntity.ok(encontrado);
		}
		
	}
	
	
	@DeleteMapping("eliminar/{idCliente}")
	public ResponseEntity<String> eliminar (@PathVariable int idCliente){
		
		Cliente encontrado= service.buscar(idCliente);
		if(encontrado ==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se puede eliminar, porque no existe");
			
		}else {
			service.eliminar(idCliente);
			return ResponseEntity.ok("Eliminacion exitosa");
		}
	}
	
	@GetMapping("buscarPorCiudad/{ciudad}")
	public ResponseEntity<?> buscarPorCiudad(@PathVariable String ciudad){
		Cliente encontrado = service.buscarPorCiudad(ciudad);
		if(encontrado==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe esa ciudad");
			
		}else {
			return ResponseEntity.ok(encontrado);
		}
	}
	
	
	
	

}
