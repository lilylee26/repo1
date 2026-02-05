package com.mx.Auto.Service;

import java.util.List;
import com.mx.Auto.Dominio.Auto;

public interface IAutoService {
	
	public void guardar(Auto auto);
	public void editar(Auto auto);
	public void eliminar(Auto auto);
	public Auto buscar(Auto auto);
	public List<Auto> mostrar();

}
