package com.mx.Pedidos.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.Pedidos.Entity.Pedido;
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {


	public List<Pedido> findByTiendaId(int tiendaId);
	public List<Pedido> findByClienteId(int clienteId);


}
