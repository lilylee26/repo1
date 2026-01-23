package com.mx.Herencia;

public class Principal {

	public static void main(String[] args) {
		
		Hijo hijo1=new Hijo("Roberto", "Rodriguez", 12, "Mexicana", "Cafe", 1.20, "Morena");
		System.out.println(hijo1);
		
		hijo1.setEdad(21);
		hijo1.setAltura(1.75);
		System.out.println("Actualizado \n" + hijo1);
		
		
		hijo1.trabajar();

	}

}
