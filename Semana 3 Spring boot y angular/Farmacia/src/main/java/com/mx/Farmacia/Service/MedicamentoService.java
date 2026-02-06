package com.mx.Farmacia.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.Farmacia.Dao.IMedicamentoDao;
import com.mx.Farmacia.Dominio.Medicamento;

@Service // es una anotacion que indica que esta clase es una clase de configuracion
//y que me puede ayudar a configurar otras clases, es un tipo bean y por lo tanto para ser gestionada
//por el contenedor de beans se spring para despues ser inyectada
public class MedicamentoService {

	@Autowired // es una anotacion que indica la inyeccion de otra clase para la configuracion
				// de esta clase
	private IMedicamentoDao dao;

	public void guardar(Medicamento medicamento) {
		dao.save(medicamento);
	}

	public List<Medicamento> listar() {
		return dao.findAll(Sort.by(Sort.Direction.ASC, "idMed"));
	}

	// metodo que consultara al procedimeinto almacenado de aumentar stock
	public void aumStock(Integer pIdMed, Integer pCantidad) {
		dao.aumStock(pIdMed, pCantidad);

	}

	// metodo que consultara al procedimeinto almacenado de descontar stock
	public void venMedicamento(Integer pIdMed, Integer pCantidad) {
		dao.venMedicamento(pIdMed, pCantidad);

	}

	// eliminar medicamento por id
	public void eliminarMed(Integer pIdMed) {

		if (pIdMed == null) {
			throw new IllegalArgumentException("El id es obligatorio");
		}

		dao.eliminarMed(pIdMed);
	}

	// descuednto por laaboratorio
	public void descLab(String pLab, Integer pDescuento) {
		if (pLab == null || pLab.isBlank()) {
			throw new IllegalArgumentException("Laboratorio obligatorio");
		}
		if (pDescuento == null || pDescuento < 0 || pDescuento > 100) {
			throw new IllegalArgumentException("El descuento debe estar entre 0 y 100");
		}
		dao.descLab(pLab, pDescuento);
	}

}
