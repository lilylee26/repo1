package Principal;

public interface IMetodosLista {
	
	public void create (int index, Object object);
	public void read ();
	public void update (int index, Object object);
	public void delete(int index);
	public Object search(int index);

}
