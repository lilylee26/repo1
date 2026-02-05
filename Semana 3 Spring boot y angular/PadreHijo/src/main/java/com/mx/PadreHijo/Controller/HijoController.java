package com.mx.PadreHijo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import com.mx.PadreHijo.Dominio.Hijo;
import com.mx.PadreHijo.Dominio.Padre;
import com.mx.PadreHijo.Service.HijoService;

@RestController
@RequestMapping(path = "api/Hijo")
@CrossOrigin
public class HijoController {

	@Autowired
	private HijoService service;

	@GetMapping
	public ResponseEntity<?> listar() {
		if(service.listar().isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(service.listar());
		}
		
	}
	
	 @PostMapping("guardar")//
	public ResponseEntity<?> guardar (@RequestBody Hijo hijo){
		
		service.guardar(hijo);
		return ResponseEntity.ok("Se guardo con exito");
		
	}
	
	 @PutMapping("editar")//
	public ResponseEntity<?> editar(@RequestBody Hijo hijo){
		
		service.editar(hijo);;
		return ResponseEntity.ok("Se guardo con exito");
		
	}
	
	@DeleteMapping ("/{idHijo}")
	public ResponseEntity<?> eliminar(@PathVariable int idHijo){
		service.eliminar(idHijo);
		return ResponseEntity.ok("Eliminacion exitosa");
		
	}
	
	@GetMapping("/{idHijo}")
	
	public ResponseEntity<?> buscar(@PathVariable int idHijo){
		return ResponseEntity.ok(service.buscar(idHijo));
	}
	
	@GetMapping ("listarPorHobbie")
	//la anotacion requestParam nos inidca wque la hacer la peticion solicitara
	//un par de clave valor como parametro
	public ResponseEntity<?> listarPorHobbie(@RequestParam String hobbie){
		return ResponseEntity.ok(service.listarPorHobbie(hobbie));
		
	}
	
	
	
	

}
