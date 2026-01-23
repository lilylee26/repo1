package com.mx.Diccionario;

import java.util.HashMap;

public class Diccionario {

    // atributo
    private HashMap<String, String> palabra;//clave y valor

    // constructor vacio
    public Diccionario() {
        palabra = new HashMap<>();//hasMap
    }

    
    
    public HashMap<String, String> getPalabra() {
        return palabra;
    }

    public void setPalabras(HashMap<String, String> palabra) {
        this.palabra = palabra;
    }

    // agregar 
    public void agregarPalabra(String ingles, String espanol) {
        palabra.put(ingles, espanol);
    }

    // buscar
    public void buscarPalabra(String ingles) {
        if (palabra.containsKey(ingles)) {
            System.out.println("Traduccion: " + palabra.get(ingles));
        } else {
            System.out.println("La palabra no existe");
        }
    }

    // mostrar todas las traducciones
    public void mostrarPalabras() {
        if (palabra.isEmpty()) {
            System.out.println("No hay palabras registradas");
        } else {
            for (String clave : palabra.keySet()) {
                System.out.println(clave + " = " + palabra.get(clave));
            }
        }
    }

    @Override
    public String toString() {
        return "Diccionario [Palabras=" + palabra + "]";
    }
}
