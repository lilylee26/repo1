package com.mx.Libro.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mx.Libro.Dominio.Libro;

@Repository //anotacion que nos indica que es un repositorio y 
//contiene datos o metodos que nos ayudaran a la configuracion de otra clase
//se entiend como bean y pasa a ser administrado por el contenerdor de beans de spring y puede ser inyectado despues

public interface ILibroDao extends CrudRepository<Libro, Integer>{
	

}
