package com.mx.PadreHijo.Controller;

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

import com.mx.PadreHijo.Dominio.Padre;
import com.mx.PadreHijo.Service.HijoService;
import com.mx.PadreHijo.Service.PadreService;

@RestController
@RequestMapping(path = "api/Padre")
@CrossOrigin
public class PadreController {

    //private final Service.HijoService hijoService;
	
	@Autowired
	private PadreService service;

//    PadreController(Service.HijoService hijoService) {
//        this.hijoService = hijoService;
//    }
	
	@GetMapping("listar")
	
	//ResponseEntity es una extension que nos permite modificar el body y el sattus
	//de la respues http
	public ResponseEntity<?> listar(){
		List<Padre> padres = service.listar();
		if (padres.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			
			return ResponseEntity.ok(padres);
		}
	}
	
	@PostMapping("guardar")
	
	public ResponseEntity<String> guardar(@RequestBody Padre padre){
		
		Padre encontrado = service.buscar(padre.getIdPadre());
		if(encontrado ==null) {
			service.guardar(padre);
			return ResponseEntity.status(HttpStatus.CREATED).body("El padre se registro con exito");
		}else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Ese id no existe");
		}
	
	}
	
	
	@PutMapping("editar")
	public ResponseEntity<String> editar (@RequestBody Padre padre){
		Padre encontrado = service.buscar(padre.getIdPadre());
		if (encontrado == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El id que intentas editar, no existe");
			
		}else {
			service.editar(padre);
			return ResponseEntity.ok("Edicion exitosa");
		}
		
	}
	
	@GetMapping("buscar/{idPadre}")
	//Pathvariable indica que solicitara un parametro para completar la url de comsumo
	public ResponseEntity<?> buscar(@PathVariable int idPadre){
		Padre encontrado = service.buscar(idPadre);
		if(encontrado ==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe ese registro");
			
		}else {
			return ResponseEntity.ok(encontrado);
		}
		
	}
	
	
	@DeleteMapping("eliminar/{idPadre}")
	public ResponseEntity<String> eliminar (@PathVariable int idPadre){
		
		Padre encontrado= service.buscar(idPadre);
		if(encontrado ==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se puede eliminar, porque no existe");
			
		}else {
			service.eliminar(idPadre);
			return ResponseEntity.ok("Eliminacion exitosa");
		}
	}
	
	@GetMapping("buscarPorNombre/{nombre}")
	public ResponseEntity<?> buscarPorNombre(@PathVariable String nombre){
		Padre encontrado = service.buscarPorNombre(nombre);
		if(encontrado==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe el nombre");
			
		}else {
			return ResponseEntity.ok(encontrado);
		}
	}
	
	
	
	
	
	
	

}
