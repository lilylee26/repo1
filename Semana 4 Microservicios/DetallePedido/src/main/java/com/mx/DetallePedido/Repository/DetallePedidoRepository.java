package com.mx.DetallePedido.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.DetallePedido.Entity.DetallePedido;

@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Integer> {

	public List<DetallePedido> findByIdPedido(int idPedido);

	public List<DetallePedido> findByIdProducto(int idProducto);
	
	public List<DetallePedido> findByTiendaId(int tiendaId);

}
