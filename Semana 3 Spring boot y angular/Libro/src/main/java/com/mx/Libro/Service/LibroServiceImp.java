package com.mx.Libro.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.*;

import org.springframework.stereotype.*;

import com.mx.Libro.Dao.ILibroDao;
import com.mx.Libro.Dominio.Libro;

@Service //anotacion indica que a mi clase es una clase de servicios y que  esta contiene el modelo de 
//negocio y la configuracion importante que despues sera inyectada en otra clase

public class LibroServiceImp implements ILibroService{

	@Autowired //es la notacion que indica que voy a inyectar una clase o metodo
	//tipo  de patron de diseño, inyeccion de dependencias (D1)
	private ILibroDao dao;
	
	@Override
	public void guardar(Libro libro) {
		
		dao.save(libro);
		
	}

	@Override
	public void editar(Libro libro) {
		dao.save(libro);
		
		
	}

	@Override
	public void eliminar(Libro libro) {
		dao.delete(libro);
		
	}

	@Override
	public Libro buscar(Libro libro) {
		
		return dao.findById(libro.getIdLibro()).orElse(null);
	}

	@Override
	public List<Libro> mostrar() {
		
		return (List<Libro>) dao.findAll();
	}
	
}
