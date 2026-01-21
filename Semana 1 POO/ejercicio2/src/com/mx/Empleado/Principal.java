package com.mx.Empleado;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

	public static void main(String args[]) {

		// instanciar el objeto
		Empleado emp1 = new Empleado("David", "Gonzales", "Jimenez", 8527418754L, 58, 6500.13);
		Empleado emp2 = new Empleado("Jose", "Moreno", "Hernandez", 735818754L, 25, 2500.13);
		Empleado emp3 = new Empleado("Axel", "Garcia", "Oropeza", 5478620158L, 45, 30000.50);
		Empleado emp4 = new Empleado("Jose", "Ramirez", "Diaz", 5478764654L, 38, 9500.30);
		Empleado emp5 = new Empleado("Rafael", "Medina", "Lopez", 589503414L, 30, 29000.55);
		Empleado emp6 = new Empleado(" Jose", " Anaya ", " Sanchez", 7714043645L, 23, 15000);
		Empleado emp7 = new Empleado("Laura", "Hernandez", "Ruiz", 9982345678L, 32, 8200.50);
		// objeto auxiliar para valores de busqueda
		Empleado empAux = null;

		// instanciar la clase de implementacion para poder ocupar todos los metodos
		// declarados
		Implementacion imp = new Implementacion();

		// alamcenar todos los objetos en la lista
		imp.create(0, emp1);
		imp.create(1, emp2);
		imp.create(2, emp3);
		imp.create(3, emp4);
		imp.create(4, emp5);
		imp.create(5, emp6);
		imp.create(6, emp7);

		/*
		 * // mostrar imp.read();
		 * 
		 * // buscar empAux = imp.buscar(1); System.out.println("Elemento encontrado" +
		 * empAux);
		 * 
		 * // editar empAux = imp.buscar(1); empAux.setNombre("Julian");
		 * empAux.setSueldo(85); imp.update(1, emp2);
		 * System.out.println("Elemento editado" + empAux);
		 * 
		 * // eliminar imp.delete(2); imp.read();
		 * 
		 * // contar imp.contar();
		 */

		// declaracion de variables
		Scanner scan = new Scanner(System.in);
		int menuP = 0, menuE = 0, indice = 0;

		String nombre, apellidoP, apellidoM;
		Long telefono;
		int edad;
		double sueldo;

		do {

			System.out.println("********MENU********");
			System.out.println("1. Crear");
			System.out.println("2. Leer");
			System.out.println("3. Actualizar");
			System.out.println("4. Eliminar");
			System.out.println("5. Buscar");
			System.out.println("6. Contar");
			System.out.println("7. Salir");
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
					System.out.println("Ingrese los siguientes datos para registrar al empleado");

					System.out.println("Nombre del empleado: ");
					nombre = scan.nextLine();

					System.out.println("Apellido paterno");
					apellidoP = scan.nextLine();

					System.out.println("Apellido materno");
					apellidoM = scan.nextLine();

					System.out.println("Numero telefonico");
					telefono = scan.nextLong();
					scan.nextLine();

					System.out.println("Edad");
					edad = scan.nextInt();
					scan.nextLine();

					System.out.println("Sueldo");
					sueldo = scan.nextDouble();
					scan.nextLine();

					// instanciar con valores recibidos
					empAux = new Empleado(nombre, apellidoP, apellidoM, telefono, edad, sueldo);

					// gaurdar
					imp.create(indice, empAux);
					System.out.println("Se registro con exito");
					break;

				case 2:
					System.out.println("---------Leer---------");
					imp.read();
					break;

				case 3:
					System.out.println("---------Editar---------");
					imprimirDatos(imp);
					if (imp.lista.size() > 0) {
						System.out.println("Indique el indice que desea editar");
						indice = scan.nextInt();
						scan.nextLine();
						empAux = imp.buscar(indice);

						if (indice >= 0 && indice < imp.lista.size()) {
							do {
								System.out.println("MENU EDITAR");
								System.out.println("1. Nombre");
								System.out.println("2. Apellido paterno");
								System.out.println("3. Apellido materno");
								System.out.println("4. Numero de telefono");
								System.out.println("5. Edad");
								System.out.println("6. Sueldo");
								System.out.println("7. Regresar ak menu principal");
								System.out.println("Elige una opcion valida en el menu");
								menuE = scan.nextInt();
								scan.nextLine();

								switch (menuE) {
								case 1:
									System.out.println("Ingresa el nuevo nombre: ");
									nombre = scan.nextLine();
									empAux.setNombre(nombre);
									break;
								case 2:
									System.out.println("Ingresa el nuevo apellido paterno: ");
									apellidoP = scan.nextLine();
									empAux.setApellidoP(apellidoP);
									break;
								case 3:
									System.out.println("Ingresa el nuevo apellido materno: ");
									apellidoM = scan.nextLine();
									empAux.setApellidoM(apellidoM);
									break;
								case 4:
									System.out.println("Ingresa el nuevo telefono: ");
									telefono = scan.nextLong();
									empAux.setTelefono(telefono);
									break;
								case 5:
									System.out.println("Ingresa la nueva edad: ");
									edad = scan.nextInt();
									empAux.setEdad(edad);
									break;
								case 6:
									System.out.println("Ingresa el nuevo sueldo: ");
									sueldo = scan.nextDouble();
									empAux.setSueldo(sueldo);
									break;

								case 7:
									System.out.println("Regresando al menu principal ");
									break;
								default:
									System.out.println("Indice fuera de rango, intente de nuevo ");
								}
							} while (menuE != 7);
						} else {
							System.out.println("El indice no esta dentro de la lista ");
						}
					}
					break;

				case 4:
					System.out.println("-----------Eliminar------------ ");
					imprimirDatos(imp);
					if (imp.lista.size() > 0) {
						System.out.println("Indica el indice que deseas eliminar: ");
						indice = scan.nextInt();
						if (indice >= 0 && indice < imp.lista.size()) {
							imp.delete(indice);
							System.out.println("Eliminacion exitosa ");
						} else {
							System.out.println("El indice que intenta elimnar no existe ");
						}
					}
					break;

				case 5:
					System.out.println("-------Buscar---------");
					imprimirDatos(imp);
					if (imp.lista.size() > 0) {
						System.out.println("Indique el indice que busca");
						indice = scan.nextInt();
						if (indice >= 0 && indice < imp.lista.size()) {
							empAux = imp.buscar(indice);
							System.out.println("Informacion completa del empleado " + empAux);
						} else {
							System.out.println("El indice que intenta buscar no existe ");
						}
					}
					break;

				case 6:
					System.out.println("----------Contar-----------");
					imp.contar();
					break;
				case 7:
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
		System.out.println("Empleados registrados");
		if (imp.lista.size() > 0) {
			for (int i = 0; i < imp.lista.size(); i++) {
				System.out.println("El empleado [" + i + "] de nombre" + imp.lista.get(i).getNombre());
			}
		} else {
			System.out.println("No hay empleados registrados");
		}

	}

}// cierr de clase
