package com.mx.Pagos.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.Pagos.Entity.Pago;
import com.mx.Pagos.Repository.PagoRepository;

@Service
public class PagoService {

	@Autowired
	private PagoRepository repo;

	public List<Pago> listar() {
		return repo.findAll(Sort.by(Sort.Direction.ASC, "idPago"));
	}

	public void guardar(Pago pago) {
		repo.save(pago);
	}

	public void editar(Pago pago) {
		repo.save(pago);
	}

	public void eliminar(int idPago) {
		repo.deleteById(idPago);
	}

	public Pago buscar(int idPago) {
		return repo.findById(idPago).orElse(null);
	}

	public List<Pago> listarPorPedido(int idPedido) {
		return repo.findByIdPedido(idPedido);
	}

	public List<Pago> listarPorTienda(int tiendaId) {
		return repo.findByTiendaId(tiendaId);
	}
}
