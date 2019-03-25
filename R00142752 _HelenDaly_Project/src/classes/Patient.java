package classes;

import list.AppointmentList;
import list.InvoiceList;
import list.PaymentList;

public class Patient extends Person{
	//class to hold ID, address, appoint[] payments[] invoices[] and phoneNo
	public Patient() {
		super ();
	}
	
	private int patientID;
	private String addressLine1, addressLine2, city, country, phoneNo;
	private AppointmentList appointmentList;
	private PaymentList paymentList;
	private InvoiceList invoiceList;
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
	public AppointmentList getAppointmentList() {
		return appointmentList;
	}
	public void setAppointmentList(AppointmentList appointmentList) {
		this.appointmentList = appointmentList;
	}
	public PaymentList getPaymentList() {
		return paymentList;
	}
	public void setPaymentList(PaymentList paymentList) {
		this.paymentList = paymentList;
	}
	public InvoiceList getInvoiceList() {
		return invoiceList;
	}
	public void setInvoiceList(InvoiceList invoiceList) {
		this.invoiceList = invoiceList;
	}
	

}