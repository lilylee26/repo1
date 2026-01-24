package com.mx.EstaticosYconstantes;

public class Prueba {

	public static void main(String[] args) {
		//varaibles finales: se deben instanciar y una vez instanciada el valor ya no deberia de cmabiar
		
		//instanciar principal
		Principal obj = new Principal();
		
		//acceder a los miembros
		System.out.println(obj.frase2); //miembro de instancia
		System.out.println(Principal.frase3); //miembro atravez de una clase
		
		
		
	}

}
