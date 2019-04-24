package storage;
//
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerialStorage implements StorageIntface, Serializable {
	
	@Override
	public boolean save(Object o){
		boolean success = true;
		try {
			FileOutputStream fileOut = new FileOutputStream("gentleDental.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(o);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data saved");
		} catch (IOException i) {
			i.printStackTrace();
			success = false;
		}
		return success;
	};
	
	@Override
	public Object load() {
		Object o = null;
		try {
			FileInputStream fileIn = new FileInputStream("gentleDental.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			o = in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			//i.printStackTrace();
		} catch (ClassNotFoundException c) {
			System.out.println("class not found");
		}
		
		return o;
	}	
	
}
