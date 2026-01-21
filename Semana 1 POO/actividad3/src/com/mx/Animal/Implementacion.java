package com.mx.Animal;
//para implementar una interfaz se ocupa la palabra reservada implement

import java.util.ArrayList;
import java.util.List;

public class Implementacion implements IMetodos {

	// declaracion de una lista para agregar un comportamiento a los metodos
	// declarados
	List<Animal> lista = new ArrayList<Animal>();

	@Override // sobreescritura de metodos, cambia el comportamiento inicial de un metodo
	public void create(int indice, Animal animal) {

		lista.add(animal);

	}

	@Override
	public void read() {
		System.out.println(lista);

	}

	@Override
	public void update(int indice, Animal animal) {
		lista.set(indice, animal);

	}

	@Override
	public void delete(int indice) {
		lista.remove(indice);

	}

	@Override
	public Animal buscar(int indice) {

		return lista.get(indice);
	}

	// eliminar todo
	@Override
	public void deleteAll() {
		lista.clear();
	}

	// buscar por atributo (nombre, especie, sexo, edad, peso)
	@Override
	public List<Animal> buscarPorAtributo(int op, String valor) {

		List<Animal> encontrados = new ArrayList<Animal>();

		for (Animal animal : lista) {
			if (op == 1) { // nombre
				if (animal.getNombre().equalsIgnoreCase(valor)) {
					encontrados.add(animal);
				}
			} else if (op == 2) { // especie
				if (animal.getEspecie().equalsIgnoreCase(valor)) {
					encontrados.add(animal);
				}
			} else if (op == 3) { // sexo
				if (animal.getSexo().equalsIgnoreCase(valor)) {
					encontrados.add(animal);
				}
			} else if (op == 4) { // edad
				if (String.valueOf(animal.getEdad()).equals(valor)) {
					encontrados.add(animal);
				}
			} else if (op == 5) { // peso
				if (String.valueOf(animal.getPeso()).equals(valor)) {
					encontrados.add(animal);
				}
			}
		}

		return encontrados;
	}

	// metodos personalizados
	public void contar() {
		System.out.println("Existen" + lista.size() + " Animal registrados");

	}

}
