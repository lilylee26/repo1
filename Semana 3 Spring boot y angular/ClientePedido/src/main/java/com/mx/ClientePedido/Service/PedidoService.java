package com.mx.ClientePedido.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.ClientePedido.Dao.IPedidoDao;
import com.mx.ClientePedido.Dominio.Pedido;



@Service
public class PedidoService {
	
	@Autowired
	private IPedidoDao dao;
	
	public void guardar(Pedido pedido) {

        // no permitir pedido duplicado
        Integer idCliente = pedido.getClienteId().getIdCliente();

        boolean duplicado = dao.existsByFechaAndMontoAndClienteId_IdCliente(
                pedido.getFecha(),
                pedido.getMonto(),
                idCliente
        );

        if (duplicado) {
            throw new RuntimeException("Pedido duplicado: mismo cliente, fecha y monto");
        }

        dao.save(pedido);
    }


	
	public List<Pedido> listar(){
		return dao.findAll(Sort.by(Sort.Direction.ASC, "idPedido"));
		
	}
	
	public void editar(Pedido pedido) {
		dao.save(pedido);
		
	}
	
	public Pedido buscar(int idPedido) {
		
		return dao.findById(idPedido).orElse(null);
	}
	
	public void eliminar(int idPedido) {
		dao.deleteById(idPedido);
	}

	//metodo personalizado para listar hijos por hobbie
	public List<Pedido> listarPorFecha(String Fecha){
		
		return dao.findByFecha(Fecha);
	}
	
	
	

}
