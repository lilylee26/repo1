package com.mx.Empleados;

public class Principal {
	
	public static void main(String[]args) {
		//instanciar completo
		EmpleadoTiempoCompleto completo = new EmpleadoTiempoCompleto ("Martin", 34, 20000, "Desarrollador", "9 AM a 6PM", 20);
		System.out.println(completo);
		completo.calcularBono();
		System.out.println("Nombre: " + completo.getNombre());
		System.out.println("Edad: " + completo.getEdad());
		System.out.println("Salario: " + completo.getSalario());
		System.out.println("Bono: " + completo.getBono());
		
		//instanciar horas
		EmpleadoPorHoras horas = new EmpleadoPorHoras("Mariana", 29, 8000, "Desarrollador remoto", 10, 100);
		System.out.println(horas);
		horas.calcularBono();
		System.out.println("Nombre: " + horas.getNombre());
		System.out.println("Edad: " + horas.getEdad());
		System.out.println("Salario: " + horas.getSalario());
		System.out.println("Bono: " + horas.getBonoHora());
		
		
	}

}
