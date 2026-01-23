package com.mx.Empleados;

public class EmpleadoTiempoCompleto extends Empleado {

	private String cargo;
	private String horario;
	private int bono;

	@Override
	public void calcularBono() {
		bono = (int) (salario * 0.20);

	}

	public EmpleadoTiempoCompleto() {

	}

	public EmpleadoTiempoCompleto(String nombre, int edad, double salario, String cargo, String horario, int bono) {
		super(nombre, edad, salario);
		this.cargo = cargo;
		this.horario = horario;
		this.bono = bono;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public int getBono() {
		return bono;
	}

	public void setBono(int bono) {
		this.bono = bono;
	}

	@Override
	public String toString() {
		return "EmpleadoTiempoCompleto [nombre=" + nombre + ", edad=" + edad + ", salario=" + salario + ", cargo="
				+ cargo + ", horario=" + horario + ", bono=" + bono + "]";
	}

}
