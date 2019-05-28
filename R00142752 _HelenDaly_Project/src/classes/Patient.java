package classes;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import controller.Controller;
import list.AppointmentList;
import list.InvoiceList;

public class Patient implements Serializable {
	
	//class to hold patient contact details and patient records.
	static int PATIENTID = 1;
	private int ID;
	private String dob;
	private String address, phoneNo;
	private AppointmentList appointments;
	private InvoiceList invoices;
	private String patientName;
	private String first_name;
	private String last_name;
	
	public Patient(String first_name, String last_name, String dob, String address, String phoneNo) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.dob = dob;
		this.address = address;
		this.phoneNo = phoneNo;
		this.appointments = new AppointmentList();
		this.invoices = new InvoiceList();
		this.patientName = this.getFirstName()+" "+this.getLastName();
		this.ID=PATIENTID;
		PATIENTID++;
	}
	
	public static int getPATIENTID() {return PATIENTID;}
	public static void setPATIENTID(int pATIENTID) {PATIENTID = pATIENTID;}
	public int getID() {return ID;}
	public void setID(int iD) {ID = iD;}
	public String getFirst_name() {return first_name;}
	public void setFirst_name(String first_name) {this.first_name = first_name;}
	public String getLast_name() {return last_name;}
	public void setLast_name(String last_name) {this.last_name = last_name;}
	public void setPatientName(String patientName) {this.patientName = patientName;}
	public int getPatientID() {return ID;}
	public String getAddress() {return address;}
	public void setAddress(String address) {this.address = address;}
	public void setFirstName(String first_name) {this.first_name = first_name;}
	public String getFirstName() {return first_name;}
	public void setLastName(String last_name) {this.last_name = last_name;}
	public String getLastName() {return last_name;}
	public void setDOB(String dob) {this.dob = dob;}
	public String getDOB() {return dob;}
	public String getPhoneNo() {return phoneNo;}
	public void setPhoneNo(String phoneNo) {this.phoneNo = phoneNo;}
	public String getPatientName(){return patientName;}
	public AppointmentList getAppointments() {return appointments;}
	public void setAppointments(AppointmentList appointments) {this.appointments = appointments;}
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
				+this.address+", "
				+"Phone No: "
				+this.phoneNo+" ";
	}
}