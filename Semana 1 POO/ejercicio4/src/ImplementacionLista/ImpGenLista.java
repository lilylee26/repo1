package ImplementacionLista;

import java.util.ArrayList;
import java.util.List;

import Principal.IMetodosLista;

public class ImpGenLista implements IMetodosLista {
	
	
	protected List<Object> lista = new ArrayList<Object>();
	
	@Override
	public void create(int index, Object object) {
		lista.add(object);
		
	}

	@Override
	public void read() {
		System.out.println (lista);
		
	}

	@Override
	public void update(int index, Object object) {
		lista.set(index, object);
		
	}

	@Override
	public void delete(int index) {
		lista.remove(index);
		
	}

	@Override
	public Object search(int index) {
		// TODO Auto-generated method stub
		return lista.get(index);
	}

}
