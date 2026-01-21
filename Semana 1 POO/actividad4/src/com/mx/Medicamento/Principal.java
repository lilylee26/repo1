package com.mx.Medicamento;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// instanciar libro
		Medicamento m1 = new Medicamento(45454, "Jarabe de tos", "Sanfer", "13 de enero 2028", 150);
		Medicamento m2 = new Medicamento(16789, "Paracetamol", "Pfizer", "25 de mayo 2026c", 20);
		Medicamento m3 = new Medicamento(44434, "Ibuprofeno", "Mavel", "30 de septiembre del 2029", 60);
		Medicamento m4 = new Medicamento(42555, "Estomaquil", "PiSA", "28 de febrero del 2027", 130);
		Medicamento m5 = new Medicamento(64232, "Antigripal", "Levic", "26 de marzo del 2028", 230);
		Medicamento m6 = new Medicamento(47896, "Antibiotico", "Farmater", "11 de diciembre del 2026", 210);
		Medicamento m7 = new Medicamento(89327, "Aspirina", " Bayer", " 14 de febrero del 2030", 70);
		Medicamento m8 = new Medicamento(68526, " TinitusForte", "Marzam", " 26 de mayo del 2027", 650);

		// objeto auxiliar
		Medicamento auxMedicamento = null;

		// instanciar implementacion
		ImpMedicamento imp = new ImpMedicamento();

		// guardar elementos en el hash
		imp.create(m1);
		imp.create(m2);
		imp.create(m3);
		imp.create(m4);
		imp.create(m5);
		imp.create(m6);
		imp.create(m7);
		imp.create(m8);

		// mostrar los libros que existen en el hash
		imp.read();

		// buscar
		auxMedicamento = new Medicamento(16789); //2
		auxMedicamento = imp.search(auxMedicamento);
		System.out.println("Medicamento encontrado: " + auxMedicamento);

		// editar
		auxMedicamento = new Medicamento(68526);//8
		auxMedicamento = imp.search(auxMedicamento);
		auxMedicamento.setDistribuidor("Drogueria SA");
		imp.update(auxMedicamento);
		System.out.println("Medicamento actualizado: " + auxMedicamento);

		// Eliminar
		auxMedicamento = new Medicamento(42555);//4
		imp.delete(auxMedicamento);
		System.out.println("Lista actualizada: \n ");
		imp.read();

		// Contar
		imp.contar();

	}

}
