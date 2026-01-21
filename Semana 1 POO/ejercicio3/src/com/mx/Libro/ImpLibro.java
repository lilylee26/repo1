package com.mx.Libro;

import java.util.HashMap;

public class ImpLibro implements IMetodosLibro {
	
	//declaracion de hashmap
	//sintaxis
	/*HashMap <Clave, Valor> hash = new HashMap <Clave, Valor>();   
	 * HashMap es una libreria de java.util
	 * <> se le conoce como operador diamante
	 * clave (KeyDataType) clase contenedora del dat primitivo de mi clave
	 * valor (ValueDataType) el nombre de la clase
	 * nombre(hash) definido por el programador
	 * new palabra reservada para invocar al constructor y lo llama por defecto
	 * 
	 *  */
	
	//declarar el hashMap para el objeto libro
	
	HashMap<Integer, Libro> hash = new HashMap<Integer, Libro>();

	@Override
	public void create(Libro libro) {
		
		hash.put(libro.getIsbn(), libro);
		
	}

	@Override
	public void read() {
		System.out.println(hash);
		
	}

	@Override
	public void update(Libro libro) {
		//hashMap no ofrece como tal un metodo para editar pero el put no permite valores duplicados
		//se utliza porque cuando identifica una clave identifica, remplaza los valores anteriores
		//dejando la clave igual
		
		hash.put(libro.getIsbn(), libro);
		
	}

	@Override
	public void delete(Libro libro) {
		hash.remove(libro.getIsbn());
		
	}

	@Override
	public Libro search(Libro libro) {
		
		return hash.get(libro.getIsbn());
	}
	
	//metodo personalizado
	public void contar() {
		
		System.out.println("El hash contiene " + hash.size() + " libros registrados");
	}

}
