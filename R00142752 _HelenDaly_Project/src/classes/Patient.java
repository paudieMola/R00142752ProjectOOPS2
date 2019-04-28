package classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import list.AppointmentList;
import list.InvoiceList;
import list.PaymentList;

public class Patient implements Serializable {
	
	
	//class to hold patient contact details and patient records.
	static int PATIENTID = 1;
	private int ID, age;
	private String address, phoneNo;
	private AppointmentList appointments;
	//private PaymentList payments;
	private InvoiceList invoices;
	private String patientName;
	private String first_name;
	private String last_name;
	
	public Patient(String first_name, String last_name, int age, String address, String phoneNo) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.age = age;
		this.address = address;
		//this.addressLine2 = addressLine2;
		//this.city = city;
		this.phoneNo = phoneNo;
		this.appointments = new AppointmentList();
		//this.payments = new PaymentList();
		this.invoices = new InvoiceList();
		this.patientName = this.getFirstName()+" "+this.getLastName();
		this.ID = this.PATIENTID;
		this.PATIENTID++;
	}
	
	public int getPatientID() {return ID;}
	public String getAddress() {return address;}
	public void setAddress(String address) {this.address = address;}
	public void setFirstName(String first_name) {this.first_name = first_name;}
	public String getFirstName() {return first_name;}
	public void setLastName(String last_name) {this.last_name = last_name;}
	public String getLastName() {return last_name;}
	public void setAge(int age) {this.age = age;}
	public int getAge() {return age;}
	public String getPhoneNo() {return phoneNo;}
	public void setPhoneNo(String phoneNo) {this.phoneNo = phoneNo;}
	public String getPatientName(){return patientName;}
	public AppointmentList getAppointments() {return appointments;}
	public void setAppointments(AppointmentList appointments) {this.appointments = appointments;}
	//public PaymentList getPayments() {return payments;}
	//public void setPayments(PaymentList payments) {this.payments = payments;}
	public InvoiceList getInvoices() {return invoices;}
	public void setInvoices(InvoiceList invoices) {this.invoices = invoices;}
	
	/*public void print() {
		System.out.println(toString());
	}

	public String toString() {
		return "Patient ID and Name: "
				+this.ID+" "
				+this.patientName+" "
				+"Address: "
				+this.addressLine1+", "
				+this.addressLine2+", "
				+this.city+", "
				+this.country+", "
				+"Phone No: "
				+this.phoneNo+" ";
	}*/

}