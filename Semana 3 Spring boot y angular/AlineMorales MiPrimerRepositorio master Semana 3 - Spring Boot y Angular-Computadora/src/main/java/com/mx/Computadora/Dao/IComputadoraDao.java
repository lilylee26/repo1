package com.mx.Computadora.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mx.Computadora.Dominio.Computadora;

@Repository // es una anotacion que indica que mi interface es una clase de configuracion
//que me pude ayudar a configurar otrs clase y es es un tipo bean, por lo tanto pasa a ser 
//gestionada por el contenedor de beans de spring para despues ser inyectada
public interface IComputadoraDao extends JpaRepository<Computadora, Integer>{
	
	//consumir un procedimiento almacenado 
	//@Procedure nos ayuda a mapear a un procedimiento alojado dentro de la BD
	@Procedure(procedureName = "APLICAR_DESCUENTO")
	public void aplicarDescuento(@Param("P_DESCUENTO") Integer pDescuento);

}
