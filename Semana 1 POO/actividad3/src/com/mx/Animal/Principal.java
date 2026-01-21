package com.mx.Animal;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

	public static void main(String args[]) {

		// instanciar el objeto
		Animal a1 = new Animal("Gúera", "Perro", "Hembra", 2, 30);
		Animal a2 = new Animal("Oso", "Perro", "Macho", 3, 40);
		Animal a3 = new Animal("Zeus", "Gato", "Macho", 1, 8);
		Animal a4 = new Animal("Teva", "Gato", "Hembra", 5, 7);
		Animal a5 = new Animal("Caramelo", "Cotorro", "Macho", 2, 1);
		Animal a6 = new Animal(" Rex", " Tortuga ", " Hembra", 7, 23);
		Animal a7 = new Animal("Dalila", "Iguana", "Hembra", 9, 11);
		// objeto auxiliar para valores de busqueda
		Animal aniAux = null;

		// instanciar la clase de implementacion para poder ocupar todos los metodos
		// declarados
		Implementacion imp = new Implementacion();

		// alamcenar todos los objetos en la lista
		imp.create(0, a1);
		imp.create(1, a2);
		imp.create(2, a3);
		imp.create(3, a4);
		imp.create(4, a5);
		imp.create(5, a6);
		imp.create(6, a7);

		/*
		 * // mostrar imp.read();
		 * 
		 * // buscar aniAux = imp.buscar(4); System.out.println("Animal encontrado" +
		 * aniAux);
		 * 
		 * // editar aniAux = imp.buscar(1); aniAux.setNombre("Panfilo");
		 * aniAux.setEspecie("Ave"); aniAux.setEdad(100); aniAux.setPeso(80);
		 * imp.update(1, a2); System.out.println("Animal editado" + aniAux);
		 * 
		 * // eliminar imp.delete(2); imp.read();
		 * 
		 * // contar imp.contar();
		 */

		// declaracion de variables
		Scanner scan = new Scanner(System.in);
		int menuP = 0, menuE = 0, indice = 0;

		String nombre, especie, sexo;
		int edad;
		double peso;

		do {

			System.out.println("********MENU********");
			System.out.println("1. Crear");
			System.out.println("2. Leer");
			System.out.println("3. Actualizar");
			System.out.println("4. Eliminar");
			System.out.println("5. Buscar por indice");
			System.out.println("6. Buscar por atributo");
			System.out.println("7. Contar");
			System.out.println("8. Salir");
			System.out.println("Elige una opcion valida del menu*");

			// declaracion del bloque try catch para evitar que el programa se detenga si el
			// usuario
			// el usuario introduce valores no numericos

			try {

				menuP = scan.nextInt();
				scan.nextLine();
				// inicia bloque switch

				switch (menuP) {
				case 1:
					System.out.println("---------Crear---------");
					System.out.println("Ingrese los siguientes datos para registrar al animal");

					System.out.println("Nombre del animal: ");
					nombre = scan.nextLine();

					System.out.println("Especie del animal: ");
					especie = scan.nextLine();

					System.out.println("Sexo del animal: ");
					sexo = scan.nextLine();

					System.out.println("Edad del animal: ");
					edad = scan.nextInt();
					scan.nextLine();

					System.out.println("Peso del animal: ");
					peso = scan.nextDouble();
					scan.nextLine();

					// instanciar con valores recibidos
					aniAux = new Animal(nombre, especie, sexo, edad, peso);

					// gaurdar
					imp.create(indice, aniAux);
					System.out.println("Se registro con exito ");
					break;

				case 2:
					System.out.println("---------Leer---------");

					if (imp.lista.size() > 0) {
						imp.read();
					} else {
						System.out.println("No hay animales registrados para mostrar ");
					}

					break;

				case 3:
					System.out.println("---------Editar---------");
					imprimirDatos(imp);
					if (imp.lista.size() > 0) {
						System.out.println("Indique el indice que desea editar: ");
						indice = scan.nextInt();
						scan.nextLine();
						aniAux = imp.buscar(indice);

						if (indice >= 0 && indice < imp.lista.size()) {
							do {
								System.out.println("MENU EDITAR");
								System.out.println("1. Nombre: ");
								System.out.println("2. Especie: ");
								System.out.println("3. Sexo: ");
								System.out.println("4. Edad: ");
								System.out.println("5. Peso: ");
								System.out.println("6. Regresar al menu principal ");
								System.out.println("Elige una opcion valida en el menu");
								menuE = scan.nextInt();
								scan.nextLine();

								switch (menuE) {
								case 1:
									System.out.println("Ingresa el nuevo nombre: ");
									nombre = scan.nextLine();
									aniAux.setNombre(nombre);
									break;
								case 2:
									System.out.println("Ingresa la nueva especie del animal: ");
									especie = scan.nextLine();
									aniAux.setEspecie(especie);
									break;
								case 3:
									System.out.println("Ingresa el nuevo sexo del animal: ");
									sexo = scan.nextLine();
									aniAux.setSexo(sexo);
									break;
								case 4:
									System.out.println("Ingresa la nueva edad del animal: ");
									edad = scan.nextInt();
									aniAux.setEdad(edad);
									break;
								case 5:
									System.out.println("Ingresa el nuevo peso del animal: ");
									peso = scan.nextDouble();
									aniAux.setPeso(peso);
									break;
								case 6:
									System.out.println("Regresando al menu principal ");
									break;
								default:
									System.out.println("Indice fuera de rango, intente de nuevo ");
								}
							} while (menuE != 6);
						} else {
							System.out.println("El indice no esta dentro de la lista ");
						}
					}
					break;

				/*
				 * case 4: System.out.println("-----------Eliminar------------ ");
				 * imprimirDatos(imp); if (imp.lista.size() > 0) {
				 * System.out.println("Indica el indice que deseas eliminar: "); indice =
				 * scan.nextInt(); if (indice >= 0 && indice < imp.lista.size()) {
				 * imp.delete(indice); System.out.println("Eliminacion exitosa "); } else {
				 * System.out.println("El indice que intenta elimnar no existe "); } } break;
				 * 
				 */
				case 4:
					System.out.println("-----------Eliminar------------ ");
					imprimirDatos(imp);

					if (imp.lista.size() > 0) {

						System.out.println("1. Eliminar por indice");
						System.out.println("2. Eliminar todo");
						System.out.println("3. Regresar");
						System.out.println("Elige una opcion valida: ");
						menuE = scan.nextInt();
						scan.nextLine();

						if (menuE == 1) {
							System.out.println("Indica el indice que deseas eliminar: ");
							indice = scan.nextInt();
							scan.nextLine();

							if (indice >= 0 && indice < imp.lista.size()) {
								imp.delete(indice);
								System.out.println("Eliminacion exitosa ");
							} else {
								System.out.println("El indice que intenta eliminar no existe ");
							}

						} else if (menuE == 2) {

							// VALIDACION LISTA VACIA (ya sabemos que no está vacía por el if, pero igual
							// queda claro)
							if (imp.lista.size() == 0) {
								System.out.println("No se puede eliminar nada, la lista esta vacia ");
							} else {
								imp.deleteAll();
								System.out.println("Se eliminaron todos los animales correctamente ");
							}

						} else if (menuE == 3) {
							System.out.println("Regresando al menu principal ");
						} else {
							System.out.println("Opcion invalida ");
						}

					} else {
						System.out.println("No se puede eliminar nada, la lista esta vacia ");
					}
					break;

				case 5:
					System.out.println("-------Busca por indicer---------");
					imprimirDatos(imp);
					if (imp.lista.size() > 0) {
						System.out.println("Indique el indice que busca");
						indice = scan.nextInt();
						if (indice >= 0 && indice < imp.lista.size()) {
							aniAux = imp.buscar(indice);
							System.out.println("Informacion completa del animal: " + aniAux);
						} else {
							System.out.println("El indice que intenta buscar no existe ");
						}
					}
					break;

				case 6:
					System.out.println("-------Buscar por atributo---------");
					imprimirDatos(imp);

					if (imp.lista.size() > 0) {

						System.out.println("MENU BUSCAR");
						System.out.println("1. Nombre");
						System.out.println("2. Especie");
						System.out.println("3. Sexo");
						System.out.println("4. Edad");
						System.out.println("5. Peso");
						System.out.println("Elige una opcion valida: ");
						menuE = scan.nextInt();
						scan.nextLine();

						System.out.println("Ingresa el valor a buscar: ");
						String valor = scan.nextLine();

						// usamos tu auxiliar aniAux (como pediste) para imprimir resultados uno por uno
						java.util.List<Animal> encontrados = imp.buscarPorAtributo(menuE, valor);

						if (encontrados.size() > 0) {
							System.out.println("Se encontraron " + encontrados.size() + " coincidencias: ");

							for (int i = 0; i < encontrados.size(); i++) {
								aniAux = encontrados.get(i);
								System.out.println("Animal encontrado: " + aniAux);
							}

						} else {
							System.out.println("No se encontraron animales con ese atributo ");
						}

					} else {
						System.out.println("No hay animales registrados para buscar ");
					}
					break;

				case 7:
					System.out.println("----------Contar-----------");
					imp.contar();
					break;
				case 8:
					System.out.println("Saliendo del menu, hasta luego!!! ");
					break;
				default:
					System.out.println("Indice fuera de rango, intenta con uno dentro del menu ");
					break;
				}

			} catch (InputMismatchException e) {
				System.out.println("Entrada invalida, porfavor ingresa un valor numerico ");
				scan.nextLine();
			} catch (Exception e) {
				System.out.println("Ocurrio un error inesperado ");
			}
		} while (menuP != 7);

	}// main
		// miembro estatico asociado a la clase y este nos permite poder usarlo en
		// cualquier parte
		// siempre y cuando este dentro de la clase

	private static void imprimirDatos(Implementacion imp) {
		System.out.println("Animales registrados ");
		if (imp.lista.size() > 0) {
			for (int i = 0; i < imp.lista.size(); i++) {
				System.out.println("El animal [" + i + "] de nombre" + imp.lista.get(i).getNombre());
			}
		} else {
			System.out.println("No hay animales registrados");
		}

	}

}// cierre de clase
