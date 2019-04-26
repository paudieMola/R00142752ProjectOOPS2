package list;

import java.io.Serializable;
import java.util.ArrayList;

public class ObjectList implements Serializable {
	//generic list for any object
	
	private ArrayList<Object> list;
	
	public ObjectList() {
		list = new ArrayList<Object>();
	}
	
	public void add(Object obj) {
			this.list.add(obj);
	}
	
	public int getSize() {
		return this.list.size();
	}
	
	public void remove(int i) {
		this.list.remove(i);
	}
	
	public Object get(int i) {
		return this.list.get(i);
	}
	
	public ArrayList<Object> getList(){
		return this.list;
	}
}
