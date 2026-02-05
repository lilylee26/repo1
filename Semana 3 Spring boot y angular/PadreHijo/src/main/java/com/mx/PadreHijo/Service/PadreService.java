package com.mx.PadreHijo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.PadreHijo.Dao.IPadreDao;
import com.mx.PadreHijo.Dominio.Padre;

@Service
public class PadreService {

	@Autowired 
	private IPadreDao dao;
	
	public void guardar (Padre padre) {
		dao.save(padre);
	}
	
	public List<Padre> listar(){
		return dao.findAll(Sort.by(Sort.Direction.ASC , "idPadre"));
	}
	
	public void editar(Padre padre) {
		dao.save(padre);
	}
	
	public Padre buscar(int idPadre) {
		return dao.findById(idPadre).orElse(null);
	}
	
	public void eliminar(int idPadre) {
		dao.deleteById(idPadre);
	}
	
	//metodo personalizado para buscar un padre por su nombre
	public Padre buscarPorNombre(String nombre) {
		return dao.findByNombreAllIgnoringCase(nombre);
	}
	
	
	
}
