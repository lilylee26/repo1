package Principal;

import Entidades.Carro;
import Entidades.Telefono;
import Implementacion.ImpCarro;
import Implementacion.ImpTelefono;
import Implementacion.ImpRopa;
import Entidades.Ropa;

public class Principal {

	public static void main(String[] args) {
		// instanciar CARRO
		Carro c1 = new Carro("TR215646RE", " SEAT TOLEDO", "ROJO", 2018, 170000);
		Carro c2 = new Carro("ZE546486TE", " NISSAN MARCH", "VERDE", 2015, 140000);
		Carro c3 = new Carro("WA545465YU", "CHEVROLET AVEO", "BLANCO", 2017, 110000);
		Carro c4 = new Carro("UT566225OI", "FORD FIESTA", "AZUL", 2008, 66000);
		Carro c5 = new Carro("OP268456PA", "TOYOTA COROLLA", "NEGRO", 2016, 184000);
		Carro c6 = new Carro("UI154545QA", "NISSAN TIIDA", "ROSA", 2011, 99000);
		Carro c7 = new Carro("LI545454NA", "SEAT IBIZA ", "AMARILLO", 2009, 105000);

		// instanciar TELEFONO
		Telefono t1 = new Telefono(5464665, "SAMSUNG", " S25", 2018, 17000);
		Telefono t2 = new Telefono(9896515, "APPLE", " 15 PRO MAX", 2015, 14000);
		Telefono t3 = new Telefono(4878451, "MOTOROLA", "E67", 2017, 11000);
		Telefono t4 = new Telefono(8785626, "POCO", "F3", 2008, 6600);
		Telefono t5 = new Telefono(5448451, "REDMI", "NOTE 3", 2016, 18400);
		Telefono t6 = new Telefono(8795231, "VIVO", "GAL1", 2011, 9900);
		Telefono t7 = new Telefono(5646865, "LG", "J458", 2009, 10500);

		// instanciar ROPA
		Ropa r1 = new Ropa(2865465, "Zarita", " Camisa", "M", 170);
		Ropa r2 = new Ropa(9896511, "Bershko", "Pantalon", "CH", 140);
		Ropa r3 = new Ropa(4878451, "Cuidado con el gato", "Chamarra", "CH", 110);
		Ropa r4 = new Ropa(8785626, "Luis Boton", "Abrigo", "CH", 660);
		Ropa r5 = new Ropa(5448451, "Calvo kien", "Falda", "G", 184);
		Ropa r6 = new Ropa(8795231, "Dinamo", "Sueter", "EXG", 99);
		Ropa r7 = new Ropa(5646865, "Lacosta", "Jeans", "XCH", 105);

		// auxiliar
		Carro auxC = null;
		Telefono auxT = null;
		Ropa auxR = null;
		
		
		// implementacion de carro
		ImpCarro impC = new ImpCarro();
		// implementacion de telefono
		ImpTelefono impT = new ImpTelefono();
		// implementacion de ropa
		ImpRopa impR = new ImpRopa();

		// agregar carro
		impC.create(c1.getNiv(), c1);
		impC.create(c2.getNiv(), c2);
		impC.create(c3.getNiv(), c3);
		impC.create(c4.getNiv(), c4);
		impC.create(c5.getNiv(), c5);
		impC.create(c6.getNiv(), c6);
		impC.create(c7.getNiv(), c7);

		// agregar telefono
		impT.create(t1.getImei(), t1);
		impT.create(t2.getImei(), t2);
		impT.create(t3.getImei(), t3);
		impT.create(t4.getImei(), t4);
		impT.create(t5.getImei(), t5);
		impT.create(t6.getImei(), t6);
		impT.create(t7.getImei(), t7);

		// agregar ropa
		impR.create(r1.getCodigo(), r1);
		impR.create(r2.getCodigo(), r2);
		impR.create(r3.getCodigo(), r3);
		impR.create(r4.getCodigo(), r4);
		impR.create(r5.getCodigo(), r5);
		impR.create(r6.getCodigo(), r6);
		impR.create(r7.getCodigo(), r7);

		// mostrar CARRO
		impC.read();
		// mostrar TELEFONO
		impT.read();
		// mostrar ROPA
		impT.read();

		// buscar CARRO
		// casteo : cambio de datos
		auxC = (Carro) impC.search(c3.getNiv());
		System.out.println("Encontrada: " + auxC);

		// buscar TELEFONO
		// casteo : cambio de datos
		auxT = (Telefono) impT.search(t3.getImei());
		System.out.println("Encontrada: " + auxT);

		
		// buscar ropa
				// casteo : cambio de datos
				auxR = (Ropa) impR.search(r3.getCodigo());
				System.out.println("Encontrada: " + auxR);
		
		
		
		
		
		// eliminar
		impC.delete(c7.getNiv());
		impC.read();

		// contar
		impC.contar();

	}

}
