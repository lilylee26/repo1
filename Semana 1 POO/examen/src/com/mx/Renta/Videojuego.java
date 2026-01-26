package com.mx.Renta;
import com.mx.Principal.Entregable;

public class Videojuego implements Entregable{
	
	private String titulo;
    private int horasEstimadas = 10;
    private boolean entregado = false;
    private String genero;
    private String compania;
    
    //constructor vacio
    public Videojuego() {
    	
    }

	public Videojuego(String titulo, int horasEstimadas) {
		super();
		this.titulo = titulo;
		this.horasEstimadas = horasEstimadas;
	}

	public Videojuego(String titulo, int horasEstimadas, String genero, String compania) {
		super();
		this.titulo = titulo;
		this.horasEstimadas = horasEstimadas;
		this.genero = genero;
		this.compania = compania;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getHorasEstimadas() {
		return horasEstimadas;
	}

	public void setHorasEstimadas(int horasEstimadas) {
		this.horasEstimadas = horasEstimadas;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}

	@Override
	public String toString() {
		return "Videojuego [titulo=" + titulo + ", horasEstimadas=" + horasEstimadas + ", entregado=" + entregado
				+ ", genero=" + genero + ", compania=" + compania + "]";
	}
    
    public void entregar() {
    	entregado=true;
    	
    }
    
	@Override
    public void devolver() {
    	entregado=false;
    	
    }
    
    @Override
    public  boolean isEntregado() {
    	return entregado;
    	
    }
    
    @Override
    public int compareTo(Object a) {
    	Videojuego v=(Videojuego) a;
    	return this.horasEstimadas - v.horasEstimadas;
    }
    

}
