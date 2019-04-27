package classes;

import java.io.Serializable;

//
public class Dentist implements Serializable{
	//Dentist object
	private String first_name, last_name, password;
	private int staffID;
	static int STAFFID = 1;//to allow persistent autoincrement staffID
	
	public Dentist(String first_name, String last_name, String phoneNo) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.staffID = Dentist.STAFFID;
		Dentist.STAFFID++;
	}
	
	//gets and sets
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	public int getStaffID() {return staffID;}
	
}
