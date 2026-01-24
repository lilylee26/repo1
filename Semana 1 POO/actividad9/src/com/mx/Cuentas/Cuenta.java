package com.mx.Cuentas;

public class Cuenta {

	private String titular;
	private double cantidad;

	// metodo concreto
	public void mostrarInfo() {
		System.out.println("Titular: " + titular + ", Cantidad actual: " + cantidad);
	}

	// constructor vacio
	public Cuenta() {

	}

	// constructor parametrizado
	public Cuenta(String titular, double cantidad) {
		super();
		this.titular = titular;

		if (cantidad < 0) {
			this.cantidad = 0;
		} else {
			this.cantidad = cantidad;
		}
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public double getCantidad() {
		return cantidad;
	}

	// si cantidad es negativa se guarda como 0
	public void setCantidad(double cantidad) {
		if (cantidad <= 0) {
			this.cantidad = 0;
		} else {
			this.cantidad = cantidad;
		}
	}

	@Override
	public String toString() {
		return "Cuenta [titular=" + titular + ", cantidad=" + cantidad + "]";
	}

}
