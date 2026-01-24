package com.mx.Principal;

import java.util.ArrayList;
import java.util.List;

import com.mx.Entidad.Alumno;

public class Principal {

	public static void main(String[] args) {
		// definir lista
		List<Alumno> lista = new ArrayList<Alumno>();

		// instanciar
		lista.add(new Alumno(1651554, "David", "Dominguez", "Diaz", 21, "Lic. Medicina", "Buap"));
		lista.add(new Alumno(5841554, "Sebastian", "Ramirez", "Flores", 26, "Ing. Sistemas", "UNAM"));
		lista.add(new Alumno(5889867, "Mario", "Gonzalez", "Gomez", 24, "ing. Sistemas", "UNAM"));
		lista.add(new Alumno(4323444, "Jose", "Contreras", "Garcia", 26, "Lic. Arquitectura", "UPT"));
		lista.add(new Alumno(2111215, "Ana ", "Gonzalez", "Casas", 22, "ing.Mecatronica", "IPN"));

		/*
		 * Sintaxis de expresiones lambda (funciones de flecha (args
		 * ->(cuerpo)(tipo1,tipo2 args2) .>(otro) funcion lambda para imprimir los
		 * nombres de los alumnos
		 * 
		 */
		lista.forEach(
				// expresion lamba
				(alumno) -> {
					System.out.println("Nombre del alumno: " + alumno.getNombre());
				});

		// imprimir el detalle de los alumnos
		System.out.println("\n------------Detalle alumnos-----------\n");
		// mostrar el detalle de los alumnos usando un filtro solo muestra los alumnos
		// de la unam
		lista.stream().filter(arg -> arg.getUniversidad().equalsIgnoreCase("unam"))
				.forEach(alumno -> System.out.println(
						"Nombre: " + alumno.getNombre() + " " + alumno.getaPaterno() + " estudia la carrera de: "
								+ alumno.getCarrera() + " en la universidad: " + alumno.getUniversidad()));

		// funciones lambda con interfaces funcionales

		ISaludo mensaje = (saludo, despedida) -> saludo + " y " + despedida;
		System.out.println(mensaje.saludar("Hola con expresiones lambda", "Hasta luego"));

		// filtrar edad mayor a 22
		System.out.println("\n----------- Alumnos mayores o igual a 22 años------------");
		lista.stream().filter(arg -> arg.getEdad() >= 22)
				.forEach(alumno -> System.out.println("Nombre: " + alumno.getNombre() 
				+ " tiene: " + alumno.getEdad()));

		// filtrar nombre comienza con la letra "A"
		System.out.println("\n-------- Alumnos inicien con A ---------------");
		lista.stream().filter(arg -> arg.getNombre().startsWith("A"))
				.forEach(alumno -> System.out.println(alumno.getNombre()));

		// ordenar los alumnos por su nombre (A a Z)
		System.out.println("\n------------ Alumnos ordenados por nombre  de A a Z -------------");
		lista.stream().sorted((arg, arg1) -> arg.getNombre().compareToIgnoreCase(arg1.getNombre()))
				.forEach(alumno -> System.out.println("Nombre:" + alumno.getNombre()));

		// ontar los alumnos de la carrera de medicina
		System.out.println("\n------------- Alumnos de Medicina --------------");
		   double medicina = lista.stream().filter(arg -> arg.getCarrera().toLowerCase()
				.contains("medicina")).count();
					System.out.println("Alumnos de Medicina: " + medicina);
					
					
		// mapear los nombres a mayúsculas
		 System.out.println("\n----------- Nombres en mayuscula --------------");
					lista.stream()
						.map(arg -> arg.getNombre().toUpperCase())
						.forEach(nombre -> System.out.println(nombre));
					
					
	   // calcular el promedio
		 System.out.println("\n------------- Promedio de edades ----------------");
					double promedio = lista.stream().mapToInt(arg -> arg.getEdad()).average().orElse(0);
					System.out.println("Promedio de edad: " + promedio);



	}

}
