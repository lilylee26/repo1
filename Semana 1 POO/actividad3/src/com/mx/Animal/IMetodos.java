package com.mx.Animal;

import java.util.List;

public interface IMetodos {
	
	public void create(int indice, Animal animal);
	
	public void read();
	
	public void update(int indice, Animal animal);
	
	public void delete(int indice);
	
	public Animal buscar (int indice);
	
	// metodos
    public void deleteAll();

    public List<Animal> buscarPorAtributo(int op, String valor);
	

}