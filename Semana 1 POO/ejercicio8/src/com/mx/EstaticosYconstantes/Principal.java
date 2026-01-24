package com.mx.EstaticosYconstantes;

public class Principal {
	
	//miembro estatico metodos o atributos que se asocian a un clase en lugar de una instancia
	//miembro constante son variabkes que durante la ejecucion nos cambia
	
	//ejemplos
	//miembro estatico: variable que se asocia a la clase
	public static String frase1 = "Miembro estatico";
	
	//constante o variable final: no cambia despues de la inicializacion
	public final String frase2 ="Variable final constante";
	
	//constante estatica: varaible final asociada a una clase
	public static final String frase3 = "Variable final estatica";
	
	//ejemplificacion de como funcionan las variables estaticas
	public static void main (String[] args) {
		//acceso a miembros estaticos directamente desde mi clase
		System.out.println(frase1);
		System.out.println(frase3);
		
		
		//ejemplo con un metodo que calcula el area de un circulo
		float radio = 5;
		double area = calcularAreaCirculo(radio);
		System.out.println("El area del circulo con radio de: " + radio + " es de: " + area);
		
	}//main metodo
	
	public static double calcularAreaCirculo(float radio) {
		return Math.PI *(radio * radio);
		
	}

}
