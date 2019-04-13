package storage;
//
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerialStorage implements StorageIntface{
	
	@Override
	public Object save(String fileName){
		Object o = null;
		FileInputStream fileIn;
		ObjectInputStream in;
		try {
			fileIn = new FileInputStream(fileName);
			in = new ObjectInputStream(fileIn);
			o = in.readObject();
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
		} finally {
			///in.close();
		}
		return o;
	};
	
	@Override
	public Object load(Object o, String fileName) {
		boolean success = true;
		try {
			FileOutputStream fileOut = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(o);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
			success = false;
		}
		return success;
	}	
	
}
