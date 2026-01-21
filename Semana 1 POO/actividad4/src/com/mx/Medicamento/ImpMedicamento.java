package com.mx.Medicamento;

import java.util.HashMap;

public class ImpMedicamento implements IMetodoMedicamento {

	HashMap<Integer, Medicamento> hash = new HashMap<Integer, Medicamento>();

	@Override
	public void create(Medicamento medicamento) {

		hash.put(medicamento.getrSanitario(), medicamento);

	}

	@Override
	public void read() {
		System.out.println(hash);

	}

	@Override
	public void update(Medicamento medicamento) {
		// hashMap no ofrece como tal un metodo para editar pero el put no permite
		// valores duplicados
		// se utliza porque cuando identifica una clave identifica, remplaza los valores
		// anteriores
		// dejando la clave igual

		hash.put(medicamento.getrSanitario(), medicamento);

	}

	@Override
	public void delete(Medicamento medicamento) {
		hash.remove(medicamento.getrSanitario());

	}

	@Override
	public Medicamento search(Medicamento medicamento) {

		return hash.get(medicamento.getrSanitario());
	}

	// metodo personalizado
	public void contar() {

		System.out.println("El hash contiene " + hash.size() + " medicamentos registrados");
	}

}
