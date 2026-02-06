package com.mx.Farmacia.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mx.Farmacia.Dominio.Medicamento;

@Repository // es una anotacion que indica que mi interface es una clase de confiiiguracion
//que me puede ayudar a configurar otras clases y es gestionada, y es un tipo de bean, por lo tanto pasa a ser gestionada por el contenedor de beans de spring 
//para despues ser int¿yectada
public interface IMedicamentoDao extends JpaRepository<Medicamento, Integer> {

	// consumir un procedimiento almacenado
	@Procedure(procedureName = "AUM_STOCK")
	// nos ayuda a mapear a un procedimineto alojado dentro de la db
	public void aumStock(@Param("P_ID_MED") Integer pIdMed, @Param("P_CANTIDAD") Integer pCantidad);

	@Procedure(procedureName = "VEN_MEDICAMENTO")
	// nos ayuda a mapear a un procedimineto alojado dentro de la db
	public void venMedicamento(@Param("P_ID_MED") Integer pIdMed, @Param("P_CANTIDAD") Integer pCantidad);

	@Procedure(procedureName = "ELIMINAR_MED")
	void eliminarMed(@Param("P_ID_MED") Integer pIdMed);

	
	@Procedure (procedureName = "DESC_LAB")
	//nos ayuda a mapear a un procedimineto alojado dentro de la db
	public void descLab(@Param("P_LAB") String pLab, @Param("P_DESCUENTO") Integer pDescuento);
	
	
	
}
