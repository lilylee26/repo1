package com.mx.Computadora.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mx.Computadora.Dominio.Computadora;

@Repository //es una anotacion que indica que mi interface es una clase de confiiiguracion
//que me puede ayudar a configurar otras clases y es gestionada, y es un tipo de bean, por lo tanto pasa a ser gestionada por el contenedor de beans de spring 
//para despues ser int¿yectada
public interface IComputadoraDao extends JpaRepository<Computadora, Integer>{
	
	//consumir un procedimiento almacenado
	@Procedure (procedureName = "APLICAR_DESCUENTO")
	//nos ayuda a mapear a un procedimineto alojado dentro de la db
	public void aplicarDescuento(@Param("P_DESCUENTO")Integer pDescuento);
	
	

}
