package com.mx.Medicamento;

public interface IMetodoMedicamento {

	public void create(Medicamento medicamento);

	public void read();

	public void update(Medicamento medicamento);

	public void delete(Medicamento medicamento);

	public Medicamento search(Medicamento medicamento);

}
