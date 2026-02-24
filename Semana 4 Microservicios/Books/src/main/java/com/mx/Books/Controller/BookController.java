package com.mx.Books.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.Conflict;

import com.mx.Books.Entity.Book;

@RestController
@RequestMapping (path= "/api/books")

public class BookController {
	
	private List<Book> lista = new ArrayList<>();
	
	public BookController() {
		
		lista.add(new Book(1, "El principito", "Antoine de Saint-Exupéry", 15.5));
		lista.add(new Book(2, "Cien años de soledad", "Gabriel García Márquez", 25.0));
	}
	
	@GetMapping 
	public List<Book> listar(){
		
		return lista;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscar(@PathVariable int id){
		
		for (Book book:lista) {
			if (book.getId() == id) {
				return ResponseEntity.ok(book);
			}
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).body("Error libro no encontrado");
	}
	
	


}
