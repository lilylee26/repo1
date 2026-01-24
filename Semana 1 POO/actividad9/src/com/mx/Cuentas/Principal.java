package com.mx.Cuentas;

public class Principal {
	
	public static void main(String[]args) {
		//instanciar completo
		CuentaAhorro cuenta = new CuentaAhorro("Martin", 3400.95, 20.0, 20);
		cuenta.mostrarInfo();
		//System.out.println("Nombre: " + cuenta.getTitular());
		//System.out.println("Cantidad actual: " + cuenta.getCantidad());
		System.out.println("Tasa de interes: " + cuenta.getTasaInteres());
		
		cuenta.calcularInteres();

		
		
		 

		
	}

}
