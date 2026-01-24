package com.mx.Cuentas;

public class CuentaAhorro extends Cuenta {

    private double tasaInteres;
    private double interes;

    // constructor vacio
    public CuentaAhorro() {

    }
    // calcular interes
    public void calcularInteres() {
        interes = (getCantidad() * tasaInteres) / 100;
        System.out.println("Interes generado: " + interes);
    }

    // constructor parametrizado
    public CuentaAhorro(String titular, double cantidad, double tasaInteres, double interes) {
        super(titular, cantidad);
        this.tasaInteres = tasaInteres;
        this.interes = interes;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }
    public double interes() {
        return tasaInteres;
    }

    public void interes(double interes) {
        this.interes = interes;
    }

    @Override
    public String toString() {
        return "CuentaAhorro [titular=" + getTitular() + ", cantidad=" + getCantidad() + ", tasaInteres=" + tasaInteres 
        + ", interes=" + interes + "]";
    }

}
