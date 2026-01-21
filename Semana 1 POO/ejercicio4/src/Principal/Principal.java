package Principal;

import Entidades.Fruta;
import Implementacion.ImpFruta;

public class Principal {
	
	public static void main(String[] args) {
		//instanciar fruta
		Fruta f1 = new Fruta("Mango", " Amarillo", 1, 35 , "Verano");
		Fruta f2 = new Fruta("Melon", " Naranja", 3, 75 , "Primavera");
		Fruta f3 = new Fruta("Piña", "Amarillo", 1, 50, "Verano");
		Fruta f4 = new Fruta("kiwi", "verde",2 , 45, "otoño");
		Fruta f5 = new Fruta("Manzana", "Rojo", 3, 24, "Verano");
		Fruta f6 = new Fruta ("Fresa", "Rojo", 1, 60, "Verano");
		Fruta f7 = new Fruta("Sandia ", " Roja ", 2, 42,"Verano" );
		
		//auxiliar
		Fruta auxF= null;
		//implementacion de fruta
		ImpFruta impF = new ImpFruta();
		//agregar
		impF.create(f1.getNombre(), f1);
		impF.create(f2.getNombre(), f2);
		impF.create(f3.getNombre(), f3);
		impF.create(f4.getNombre(), f4);
		impF.create(f5.getNombre(), f5);
		impF.create(f6.getNombre(), f6);
		impF.create(f7.getNombre(), f7);
		
		//mostrar
		impF.read();
		
		//buscar
		//casteo : cambio de datos
		auxF = (Fruta) impF.search(f1.getNombre());
		System.out.println("Encontrada: " + auxF);
		
		//eliminar
		impF.delete(f4.getNombre());
		impF.read();
		
		//contar
		impF.contar();
		
		
		
		
		
		

		
		
	}

}
