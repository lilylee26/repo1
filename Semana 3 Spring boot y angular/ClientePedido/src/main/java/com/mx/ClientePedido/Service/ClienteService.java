package com.mx.ClientePedido.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.ClientePedido.Dao.IClienteDao;
import com.mx.ClientePedido.Dominio.Cliente;

@Service
public class ClienteService {
	
	@Autowired 
	private IClienteDao dao;
	
	public void guardar(Cliente cliente) {

	    if (dao.existsById(cliente.getIdCliente())) {
	        throw new RuntimeException("Ese ID ya existe, usa otro ID o usa editar");
	    }

	   
	    dao.findByNombreIgnoreCaseAndCiudadIgnoreCase(cliente.getNombre(), cliente.getCiudad())
	       .ifPresent(x -> { throw new RuntimeException("Ese cliente ya existe"); });

	    dao.save(cliente);
	}

	
	public List<Cliente> listar(){
		return dao.findAll(Sort.by(Sort.Direction.ASC , "idCliente"));
	}
	
	public void editar(Cliente cliente) {

	    // Si el ID NO existe, no se puede editar
	    if (!dao.existsById(cliente.getIdCliente())) {
	        throw new RuntimeException("Ese ID no existe, no se puede editar");
	    }

	    dao.save(cliente);
	}

	
	public Cliente buscar(int idCliente) {
		return dao.findById(idCliente).orElse(null);
	}
	
	public void eliminar(int idCliente) {
		dao.deleteById(idCliente);
	}
	
	//metodo personalizado para buscar un padre por su nombre
	public Cliente buscarPorCiudad(String ciudad) {
		return dao.findByCiudadAllIgnoringCase(ciudad);
	}
	
	

}
