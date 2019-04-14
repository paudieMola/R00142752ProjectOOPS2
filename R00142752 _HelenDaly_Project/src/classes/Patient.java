package classes;

import java.util.ArrayList;

import list.AppointmentList;
import list.InvoiceList;
import list.PaymentList;

public class Patient extends Person{
	
	
	//class to hold ID, address, appoint[] payments[] invoices[] and phoneNo
	static int PATIENTID = 1;
	private int ID;
	private String addressLine1, addressLine2, city, country, phoneNo;
	private ArrayList<Appointment> appointments;
	private ArrayList<Payment> payments;
	private ArrayList<Invoice> invoices;
	
	public Patient(String first_name, String last_name, int age, String addressLine1, String addressLine2, String city, String country, String phoneNo) {
		super(first_name, last_name, phoneNo);
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.country = country;
		this.appointments = new ArrayList<Appointment>();
		this.payments = new ArrayList<Payment>();
		this.invoices = new ArrayList<Invoice>();
		this.ID = Patient.PATIENTID;
		Patient.PATIENTID++;
	}
	
	public int getPatientID() {
		return ID;
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

}