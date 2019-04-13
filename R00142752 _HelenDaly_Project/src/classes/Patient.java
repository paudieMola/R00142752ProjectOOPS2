package classes;
//
import java.util.ArrayList;

import list.AppointmentList;
import list.InvoiceList;
import list.PaymentList;

public class Patient extends Person{
	//class to hold ID, address, appoint[] payments[] invoices[] and phoneNo
	private int patientID;
	private String addressLine1, addressLine2, city, country, phoneNo;
	private ArrayList<Appointment> appointments;
	private ArrayList<Payment> payments;
	private ArrayList<Invoice> invoices;
	
	public Patient() {
		this.appointments = new ArrayList<Appointment>();
		this.payments = new ArrayList<Payment>();
		this.invoices = new ArrayList<Invoice>();
	}
	
	public int getPatientID() {
		return patientID;
	}
	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	/*these getters and setters are inherited the ObjectList class
	public ArrayList<Appointment> getAppointmentList() {
		return appointments;
	}
	public void setAppointmentList(Appointment appointments) {
		this.appointments = appointments;
	}
	public ArrayList<Payment> getPayments() {
		return payments;
	}
	public void setPayments(ArrayList<Payment> payments) {
		this.payments = payments;
	}
	public ArrayList<Invoice> getInvoices() {
		return invoices;
	}
	public void setInvoices(ArrayList<Invoice> invoices) {
		this.invoices = invoices;
	}*/
	

}