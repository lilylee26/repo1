package com.mx.Libro.Service;

import java.util.List;

import com.mx.Libro.Dominio.Libro;

public interface ILibroService {
	
	public void guardar(Libro libro);
	public void editar(Libro libro);
	public void eliminar(Libro libro);
	public Libro buscar(Libro libro);
	public List<Libro> mostrar();
	

}
