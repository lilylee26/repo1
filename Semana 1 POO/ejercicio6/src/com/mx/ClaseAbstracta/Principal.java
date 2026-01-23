package com.mx.ClaseAbstracta;

public class Principal {
	
	public static void main(String[]args) {
		//instanciar abogado
		Abogado abogado = new Abogado ("Martin", "Mendez", 34, 586546656, "UNAM",7, "Abogado Laboral", "DIF", 3000);
		System.out.println(abogado);
		abogado.trabajar();
		abogado.cobrar(abogado.getTipo(), abogado.getHonorarios());
		
		//instanciar medico
		Medico medico = new Medico("Mariana", "Montes", 28, 524546656, "IPN", 5, "Obstetra", "IMSS", 2500);
		System.out.println(medico);
		medico.trabajar();
		medico.cobrar(medico.getEspecialidad(), medico.getCostoConsulta());
		
		
	}

}
