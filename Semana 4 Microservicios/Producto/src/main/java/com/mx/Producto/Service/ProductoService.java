package com.mx.Producto.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.Producto.Entity.Producto;
import com.mx.Producto.Repository.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository repo;

    public List<Producto> listar() {
        return repo.findAll(Sort.by(Sort.Direction.ASC, "nombre"));
    }

    public void guardar(Producto producto) {
        repo.save(producto);
    }

    public void editar(Producto producto) {
        repo.save(producto);
    }

    public void eliminar(int idProducto) {
        repo.deleteById(idProducto);
    }

    public Producto buscar(int idProducto) {
        return repo.findById(idProducto).orElse(null);
    }

    public List<Producto> listarPorTienda(int idTienda) {
        return repo.findByTiendaId(idTienda);
    }

    public boolean existeProducto(String nombre, Integer tiendaId) {
        return repo.existsByNombreIgnoreCaseAndTiendaId(nombre, tiendaId);
    }

    public boolean existeProductoEditar(String nombre, Integer tiendaId, Integer idProducto) {
        return repo.existsByNombreIgnoreCaseAndTiendaIdAndIdProductoNot(nombre, tiendaId, idProducto);
    }
    
    
    public String ajustarStock(Integer idProducto, int cambio) {
        Producto p = buscar(idProducto);

        if (p == null) return "No existe";

        int nuevoStock = p.getStock() + cambio;

        if (nuevoStock < 0) return "Stock insuficiente";

        p.setStock(nuevoStock);
        repo.save(p);

        return "Stock actualizado";
    }

}
