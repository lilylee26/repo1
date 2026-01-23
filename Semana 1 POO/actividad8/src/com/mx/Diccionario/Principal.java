package com.mx.Diccionario;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner scan = null; //se utiliza para leer la entrada de un usuario
		Diccionario diccionario = new Diccionario();
		int menu = 0;

		do {
			System.out.println("--------- DICCIONARIO ---------");
			System.out.println("1. Agregar palabra");
			System.out.println("2. Buscar palabra");
			System.out.println("3. Mostrar todas");
			System.out.println("4. Salir");
			System.out.print("Opcion: ");
			
			scan =new Scanner(System.in);
			menu = scan.nextInt();
			scan.nextLine(); // limpiar buffer
			
			/*Metodo swicth o case: estructura de control de flujo que nos permite ejecutar diferentes
			 * bloques de codigo en el valor de una expresion, tambien conocidos como metodo case
			 * porque dentro del switch se utilizan diferntes case paea manejar los diferenres casos
			 * de una expresion
			 * */
			switch (menu) {

			case 1:
				System.out.print("Palabra en ingles: ");
				scan =new Scanner (System.in);
				String ing = scan.nextLine();

				System.out.print("Palabra en español: ");
				scan =new Scanner (System.in);
				String esp = scan.nextLine();

				diccionario.agregarPalabra(ing, esp);
				System.out.println("Se guardo la palabra");
				break;

			case 2:
				System.out.print("Palabra que desea buscar: ");
				scan =new Scanner (System.in);
				String buscar = scan.nextLine();
				diccionario.buscarPalabra(buscar);
				break;

			case 3:
				System.out.println("Mostrar palabras ");
				scan = new Scanner(System.in);
				diccionario.mostrarPalabras();				
				break;

			case 4:
				System.out.println("Saliendo del menu, hasta luego!!!");
				break;

			default:
				System.out.println("Opcion invalida, intente un indice dentro del menu");
			}

		}while (menu != 4);
		
	}
}
