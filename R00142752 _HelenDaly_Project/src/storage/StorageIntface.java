package storage;
//
public interface StorageIntface{//interface to switch between serialized and database
	
	public boolean save(Object o);
	public Object load();

}
