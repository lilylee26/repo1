package com.mx.DetallePedido.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.DetallePedido.Entity.DetallePedido;
import com.mx.DetallePedido.Repository.DetallePedidoRepository;

@Service
public class DetallePedidoService {

	@Autowired
	private DetallePedidoRepository repo;

	public List<DetallePedido> listar() {
		return repo.findAll(Sort.by(Sort.Direction.ASC, "idDetalle"));
	}

	public void guardar(DetallePedido detalle) {
		repo.save(detalle);
	}

	public void editar(DetallePedido detalle) {
		repo.save(detalle);
	}

	public void eliminar(int idDetalle) {
		repo.deleteById(idDetalle);
	}

	public DetallePedido buscar(int idDetalle) {
		return repo.findById(idDetalle).orElse(null);
	}

	public List<DetallePedido> listarPorPedido(int idPedido) {
		return repo.findByIdPedido(idPedido);
	}

	public List<DetallePedido> listarPorProducto(int idProducto) {
		return repo.findByIdProducto(idProducto);
	}
	
	public List<DetallePedido> listarPorTienda(int tiendaId){
	    return repo.findByTiendaId(tiendaId);
	}

}
