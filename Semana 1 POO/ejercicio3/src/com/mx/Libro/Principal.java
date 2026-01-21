package com.mx.Libro;

public class Principal {

	public static void main(String[] args) {
		// instanciar libro
		Libro l1= new Libro(458445454,"Java basico" , "Juan perez" ,"Editorial Alfa" , 450);
		Libro l2 = new Libro(123456789, "Balada de pájaros" , "Suzanne Collins", "Editorial Scholastic", 1000);
		Libro l3= new Libro(525444434,"100 años de soledad" , "Juan de la Barrera" ,"Editorial Porrua" , 250);
		Libro l4= new Libro(879542555,"Macbeth","William Shakespeare","Porrua",250);
		Libro l5 = new Libro(852234232, "Python para principiantes", "Flor hernandez", "Editorial Panamericana", 650);
		Libro l6= new Libro(12547896,"El Principito" , "Antoine de Saint Exupery" ,"Editorial Porrua" , 400);
		Libro l7= new Libro(83893270, " Alas de sanngre", " Rebaca yarros", " Editorial Planeta", 300);
		Libro l8= new Libro(596854526, " Persona Normal", "Benito Taibo", " Editorial Porrua", 250);
	
		//objeto auxiliar
		Libro auxLibro = null;
		
		//instanciar implementacion
		ImpLibro imp = new ImpLibro();
		
		
		//guardar elementos en el hash
		imp.create(l1);
		imp.create(l2);
		imp.create(l3);
		imp.create(l4);
		imp.create(l5);
		imp.create(l6);
		imp.create(l7);
		imp.create(l8);
		
		//mostrar los libros que existen en el hash
		imp.read();
		
		//buscar
		auxLibro =  new Libro(525444434);
		auxLibro = imp.search(auxLibro);
		System.out.println("Libro encontrado: " + auxLibro);
		
		//editar
		auxLibro = new Libro(83893270);
		auxLibro = imp.search(auxLibro);
		auxLibro.setAutor("Rebecca Yarr");
		imp.update(auxLibro);
		System.out.println("Libro actualizado: " + auxLibro);
		
		//Eliminar
		auxLibro = new Libro(596854526);
		imp.delete(auxLibro);
		System.out.println("Lista actualizada: \n ");
		imp.read();
		
		//Contar
		imp.contar();
		
	}
	

}
