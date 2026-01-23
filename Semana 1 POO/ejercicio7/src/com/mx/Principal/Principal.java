package com.mx.Principal;

import com.mx.Polimorfismo.Automovil;
import com.mx.Polimorfismo.Deportivo;
import com.mx.Polimorfismo.PickUp;
import com.mx.Polimorfismo.Turismo;

public class Principal {

	public static void main(String[] args) {

		//generar array para almacenar los objtos
		Automovil[]veh = new Automovil [4];
		
		veh[0] = new Automovil("Honda", "civic", "Blanco", 2003);
		veh[1] = new Deportivo("Ford", "Scape", "Negro", 2003, 8);
		veh[2] = new Turismo("Mercedez", "Spinter", "Negro", 2003, 20);
		veh[3] = new PickUp("Toyota", "Tacoma", "Azul", 2003, 1000);
		
		for (Automovil auto : veh) {
			System.out.println(auto.mostrarDatos());
			System.out.println(auto);
		}

	}

}
