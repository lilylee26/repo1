package com.mx.Herencia;

public class Principal {
	
	public static void main(String[] args) {
		
		Delfin de1=new Delfin("Felipe", "Acuatico", 12, 5.50, "Gris", 2.50, "Mar");
		Gallo ga1=new Gallo("Jose", "Terrestre", 1, 1.50, "Rojo", 1.10, "Granja");
		
		//delfin
		System.out.println(de1);
		de1.setEdad(21);
		de1.setEspecie("Espacial");
		System.out.println("Actualizado \n" + de1);
		de1.hacerSonido(); //delfin
		
		
		//gallo
		System.out.println(ga1);
		ga1.setEdad(6);
		ga1.setEspecie("De otro mundo");
		System.out.println("Actualizado \n" + ga1);
		ga1.hacerSonido(); //gallo
	}

}
