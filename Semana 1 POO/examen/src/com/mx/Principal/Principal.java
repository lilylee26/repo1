package com.mx.Principal;
import com.mx.Renta.*;

public class Principal {
	
	public static void main(String[]args) {
		

        Serie[] series = new Serie[5];
        series[0] = new Serie("The walkind Dead", 11, "Terror", "Netflix");
        series[1] = new Serie("HTTYD", 3, "Comedia", "DreamWork");
        series[2] = new Serie("Como se traduce este amor", 1, " Romance", "CoreaInk");
        series[3] = new Serie("Mi adorable demonio", 1, " Romance", "CoreaInk");
        series[4] = new Serie("Dark", 3, "Ssuspenso", "AMC");
        
        Videojuego[] videojuegos = new Videojuego[5];
        videojuegos[0] = new Videojuego("Mario Kart", 10, "Aventura", "Nintendo");
        videojuegos[1] = new Videojuego("COD", 10, "Aventura", "PS5");
        videojuegos[2] = new Videojuego("Silent Hill", 80, "Sandbox", "PS5");
        videojuegos[3] = new Videojuego("God of Waar", 20, "Accion", "Nintendo");
        videojuegos[4] = new Videojuego("Minecraft", 30, "Accion", "XBOX one");
        
        int contSeries = 0;
        int contVideojuegos = 0;

        // Entregar algunos videojuegos y series
        series[1].entregar();
        series[4].entregar();
        //series[0].entregar();
        videojuegos[0].entregar();
        videojuegos[2].entregar();
        videojuegos[4].entregar();
        

        // Contar video y series entregados y devolverlos
        for (Serie se : series) {
            if (se.isEntregado()) {
                contSeries++;
                se.devolver();
            }
           
        }
        System.out.println("Las series entregadas son : " + contSeries);

        for (Videojuego vi : videojuegos) {
            if (vi.isEntregado()) {
                contVideojuegos++;
                vi.devolver();
            }
            
        }
        System.out.println("Los videojuegos entregados: " + contVideojuegos);
       
        
        // Serie con más temporadas
        Serie mayorSerie = series[0];
        for (Serie s : series) {
            if (s.compareTo(mayorSerie) >= 0) {
                mayorSerie = s;
            }
        }
        
        System.out.println("\nLa serie con más temporadas es :");
        System.out.println(mayorSerie);

        // Videojuego con más horas
        Videojuego mayorJuego = videojuegos[0];
        for (Videojuego v : videojuegos) {
            if (v.compareTo(mayorJuego) >= 0) {
                mayorJuego = v;
            }
        }
        
        System.out.println("\nEl videojuego con más horas es :");
        System.out.println(mayorJuego);
    }
}

