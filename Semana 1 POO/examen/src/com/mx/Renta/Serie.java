package com.mx.Renta;

import com.mx.Principal.Entregable;

public class Serie implements Entregable {

    private String titulo;
    private int numeroTemporadas = 3;
    private boolean entregado = false;
    private String genero;
    private String creador;

    // Constructor vacio
    public Serie() {
    	
    }
    
    // Constructor con titulo y creador
    public Serie(String titulo, String creador) {
        this.titulo = titulo;
        this.creador = creador;
    }

    // Constructor sin entregado
    public Serie(String titulo, int numeroTemporadas, String genero, String creador) {
		super();
		this.titulo = titulo;
		this.numeroTemporadas = numeroTemporadas;
		this.genero = genero;
		this.creador = creador;
	}


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNumeroTemporadas() {
        return numeroTemporadas;
    }

    public void setNumeroTemporadas(int numeroTemporadas) {
        this.numeroTemporadas = numeroTemporadas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    @Override
	public String toString() {
		return "Serie [titulo=" + titulo + ", numeroTemporadas=" + numeroTemporadas + ", entregado=" + entregado
				+ ", genero=" + genero + ", creador=" + creador + "]";
	}
    
    // Métodos de Entregable
    @Override
    public void entregar() {
        entregado = true;
    }

    @Override
    public void devolver() {
        entregado = false;
    }

    @Override
    public boolean isEntregado() {
        return entregado;
    }

    @Override
    public int compareTo(Object a) {
        Serie s = (Serie) a;
        return this.numeroTemporadas - s.numeroTemporadas;
    }

    
    
}
