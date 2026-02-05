package com.mx.Auto.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.*;

import org.springframework.stereotype.*;

import com.mx.Auto.Dao.IAutoDao;
import com.mx.Auto.Dominio.Auto;
import com.mx.Auto.Service.IAutoService;

@Service //anotacion indica que a mi clase es una clase de servicios y que  esta contiene el modelo de 
//negocio y la configuracion importante que despues sera inyectada en otra clase
public class AutoServiceImp implements IAutoService{
	@Autowired //es la notacion que indica que voy a inyectar una clase o metodo
	//tipo  de patron de diseño, inyeccion de dependencias (D1)
	private IAutoDao dao;

	@Override
	public void guardar(Auto auto) {
		dao.save(auto);
		
	}

	@Override
	public void editar(Auto auto) {
		dao.save(auto);
		
	}

	@Override
	public void eliminar(Auto auto) {
		dao.delete(auto);
		
	}

	@Override
	public Auto buscar(Auto auto) {
		return dao.findById(auto.getIdAuto()).orElse(null);
	}

	@Override
	public List<Auto> mostrar() {
		return (List<Auto>) dao.findAll();
	}

}
