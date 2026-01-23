package com.mx.Empleados;

//las clases abstractas no se instancian, solo se heredan
public abstract class Empleado {

	protected String nombre;
	protected int edad;
	protected double salario;


	// metodo concreto
	public void cobrar(String nombre, double sueldo) {
		//System.out.println("Soy: " + nombre + "Edad: " + edad + "salario: " + salario );
	}

	// metodo abstracto
	public abstract void calcularBono();

	// declaracion de los constructores
	public Empleado() {
			
		}

	public Empleado(String nombre, int edad, double salario) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.salario = salario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", edad=" + edad + ", salario=" + salario + "]";
	}
	
	

}
