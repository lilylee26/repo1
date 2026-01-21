package Principal;

public interface IMetodos {
	
	public void create(Object key, Object value);
	
	public void read();
	
	public void update(Object key, Object value);
	
	public void delete(Object key);
	
	public Object search(Object key);
	

}
