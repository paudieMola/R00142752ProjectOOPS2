package classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import list.AppointmentList;
import list.InvoiceList;
import list.PaymentList;

public class Patient extends Person implements Serializable {
	
	
	//class to hold patient contact details and patient records.
	static int PATIENTID = 1;
	private int ID;
	private String addressLine1, addressLine2, city, country, phoneNo;
	private AppointmentList appointments;
	private PaymentList payments;
	private InvoiceList invoices;
	private String patientName;
	
	public Patient(String first_name, String last_name, int age, String addressLine1, String addressLine2, String city, String country, String phoneNo) {
		super(first_name, last_name, phoneNo);
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.country = country;
		this.phoneNo = phoneNo;
		this.appointments = new AppointmentList();
		this.payments = new PaymentList();
		this.invoices = new InvoiceList();
		this.patientName = this.getFirst_name()+" "+this.getLast_name();
		this.ID = Patient.PATIENTID;
		Patient.PATIENTID++;
	}
	
	public int getPatientID() {return ID;}
	public String getAddressLine1() {return addressLine1;}
	public void setAddressLine1(String addressLine1) {this.addressLine1 = addressLine1;}
	public String getAddressLine2() {return addressLine2;}
	public void setAddressLine2(String addressLine2) {this.addressLine2 = addressLine2;}
	public String getCity() {return city;}
	public void setCity(String city) {this.city = city;}
	public String getCountry() {return country;}
	public void setCountry(String country) {this.country = country;}
	public String getPhoneNo() {return phoneNo;}
	public void setPhoneNo(String phoneNo) {this.phoneNo = phoneNo;}
	public String getPatientName(){return patientName;}
	public AppointmentList getAppointments() {return appointments;}
	public void setAppointments(AppointmentList appointments) {this.appointments = appointments;}
	public PaymentList getPayments() {return payments;}
	public void setPayments(PaymentList payments) {this.payments = payments;}
	public InvoiceList getInvoices() {return invoices;}
	public void setInvoices(InvoiceList invoices) {this.invoices = invoices;}
	

	public void print() {
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
	}

}