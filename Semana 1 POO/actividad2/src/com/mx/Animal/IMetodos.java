package com.mx.Animal;

public interface IMetodos {
	
	public void create(int indice, Animal animal);
	
	public void read();
	
	public void update(int indice, Animal animal);
	
	public void delete(int indice);
	
	public Animal buscar (int indice);
	

}