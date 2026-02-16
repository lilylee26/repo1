package com.mx.Client.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.Client.Entity.Cliente;
import com.mx.Client.Repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired

	private ClienteRepository repo;

	public List<Cliente> listar() {
		return repo.findAll(Sort.by(Sort.Direction.ASC, "nombre"));

	}

	public void guardar(Cliente cliente) {

		repo.save(cliente);

	}

	public void editar(Cliente cliente) {

		repo.save(cliente);

	}
	
	public void eliminar(int idCliente) {
		repo.deleteById(idCliente);
	}
	
	public Cliente buscar(int idCliente) {
		return repo.findById(idCliente).orElse(null);
	}
	
	public boolean existeCliente(String nombre, String email) {
		
		return repo.existsByNombreAndEmailAllIgnoreCase(nombre, email);
	}
	
	public boolean existeTelefono(Long telefono) {
		return repo.existsByTelefono(telefono);
	}
	
	public List<Cliente>listarPorTienda(int idTienda){
		return repo.findByTiendaId(idTienda);
	}
	
	
	public boolean existeTelefonoEditar(long telefono, Integer idCliente) {
	    return repo.existsByTelefonoAndIdClienteNot(telefono, idCliente);
	}

	public boolean existeClienteEditar(String nombre, String email, Integer idCliente) {
	    return repo.existsByNombreAndEmailAllIgnoreCaseAndIdClienteNot(nombre, email, idCliente);
	}


}
