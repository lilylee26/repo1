package com.mx.Pedidos.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.Pedidos.Entity.Pedido;
import com.mx.Pedidos.Repository.PedidoRepository;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository repo;

	public List<Pedido> listar(){
		return repo.findAll(Sort.by(Sort.Direction.ASC, "idPedido"));
	}

	public void guardar(Pedido pedido) {
		repo.save(pedido);
	}

	public void editar(Pedido pedido) {
		repo.save(pedido);
	}

	public void eliminar(int idPedido) {
		repo.deleteById(idPedido);
	}

	public Pedido buscar(int idPedido) {
		return repo.findById(idPedido).orElse(null);
	}

	public List<Pedido> listarPTienda(int tiendaId){
		return repo.findByTiendaId(tiendaId);
	}

	public List<Pedido> listarPCliente(int clienteId){
		return repo.findByClienteId(clienteId);
	}



}