package com.mx.PadreHijo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.PadreHijo.Dao.IHijoDao;
import com.mx.PadreHijo.Dominio.Hijo;

@Service
public class HijoService {
	
	@Autowired
	private IHijoDao dao;
	
	public void guardar(Hijo hijo) {
		dao.save(hijo);
	}
	
	public List<Hijo> listar(){
		return dao.findAll(Sort.by(Sort.Direction.ASC, "idHijo"));
		
	}
	
	public void editar(Hijo hijo) {
		dao.save(hijo);
		
	}
	
	public Hijo buscar(int idHijo) {
		
		return dao.findById(idHijo).orElse(null);
	}
	
	public void eliminar(int idHijo) {
		dao.deleteById(idHijo);
	}

	//metodo personalizado para listar hijos por hobbie
	public List<Hijo> listarPorHobbie(String Hobbie){
		
		return dao.findByHobbie(Hobbie);
	}
	
	
	
	
}
