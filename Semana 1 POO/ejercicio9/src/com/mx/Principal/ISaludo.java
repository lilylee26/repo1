package com.mx.Principal;
@FunctionalInterface //este es un marcador(anotacion) especial para indicar que esta interface es una
//interfaz funcional
//una interface funcional es una interface con un solo metodo abstracto y se utilizan con funciones lambda

public interface ISaludo {
	
	public String saludar(String saludo, String despido);
	
}



