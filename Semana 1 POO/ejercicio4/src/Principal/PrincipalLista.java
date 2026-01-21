package Principal;

import Entidades.Fruta;
import ImplementacionLista.ImpFrutaL;
import Implementacion.ImpFruta;

public class PrincipalLista {
	public static void main(String[] args) {

		// instanciar fruta
		Fruta f1 = new Fruta("Mango", " Amarillo", 1, 35, "Verano");
		Fruta f2 = new Fruta("Melon", " Naranja", 3, 75, "Primavera");
		Fruta f3 = new Fruta("Piña", "Amarillo", 1, 50, "Verano");
		Fruta f4 = new Fruta("kiwi", "verde", 2, 45, "otoño");
		Fruta f5 = new Fruta("Manzana", "Rojo", 3, 24, "Verano");
		Fruta f6 = new Fruta("Fresa", "Rojo", 1, 60, "Verano");
		Fruta f7 = new Fruta("Sandia ", " Roja ", 2, 42, "Verano");

		// auxiliar
		Fruta auxF = null;
		// implementacion de fruta
		ImpFrutaL impF = new ImpFrutaL();
		
		//guardar
		
		impF.create(0, f1);
		impF.create(1, f2);
		impF.create(2, f3);
		
		//mostrar
		impF.read();
		

	}

}
