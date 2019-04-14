package classes;
//
public abstract class Person {
	//interface to hold name of Person
	private String first_name, last_name;
	private String phoneNo;
	
	public Person(String first_name, String last_name, String phoneNo) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.phoneNo = phoneNo;
	}
	
	public String getFirst_name() {return first_name;}
	public void setFirst_name(String first_name) {this.first_name = first_name;}
	public String getLast_name() {return last_name;}
	public void setLast_name(String last_name) {this.last_name = last_name;}
	public String getPhoneNo() {return phoneNo;}
	public void setPhoneNo(String phoneNo) {this.phoneNo = phoneNo;}

	public String toString() {
		return "Name: "+first_name+" "+last_name+"\t Phone Number:"+phoneNo;
	}
	
}
