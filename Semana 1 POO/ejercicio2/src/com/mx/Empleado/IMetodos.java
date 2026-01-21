package com.mx.Empleado;

public interface IMetodos {
	
	public void create(int indice, Empleado empleado);
	
	public void read();
	
	public void update(int indice, Empleado empleado);
	
	public void delete(int indice);
	
	public Empleado buscar (int indice);
	

}
