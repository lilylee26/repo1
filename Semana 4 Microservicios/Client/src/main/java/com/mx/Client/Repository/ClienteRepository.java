package com.mx.Client.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.Client.Entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	//metodo personalizado
	//validar que el cliente no se duplique
	public boolean existsByNombreAndEmailAllIgnoreCase(String nombre, String email);
	public boolean existsByTelefono(Long tekefono);
	
	// 👇 para EDITAR (duplicado pero ignorando el mismo id)
    public boolean existsByTelefonoAndIdClienteNot(long telefono, Integer idCliente);

    public boolean existsByNombreAndEmailAllIgnoreCaseAndIdClienteNot(String nombre, String email, Integer idCliente);
    
	public List<Cliente> findByTiendaId(Integer tiendaId);
	
}
