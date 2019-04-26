package classes;
import java.io.Serializable;
//
import java.util.ArrayList;
import java.util.Date;

import list.ProcedureList;

public class Appointment implements Serializable {
	//for dentistName, startTime, endTime
	private Dentist dentistName;
	private String patientName;
	private int patientID;
	private double startTime;
	private double endTime;
	private String dateofApt;
	private ProcedureList procedures;
	private Boolean invoiced = false;
	
	public Appointment(String dentistName, String patientName, Double startTime, Double endTime, String dateofApt, int patientID) {
	}
	//getters and setters
	public Dentist getDentistName() {return dentistName;}
	public void setDentistName(Dentist dentistName) {this.dentistName = dentistName;}
	public String getPatientName() {return patientName;}
	public void setPatientName(String patientName) {this.patientName = patientName;}
	public double getStartTime() {return startTime;}
	public void setStartTime(double startTime) {this.startTime = startTime;}
	public double getEndTime() {return endTime;}
	public void setEndTime(double endTime) {this.endTime = endTime;}
	public String getDate() {return dateofApt;}
	public void setDate(String date) {this.dateofApt = dateofApt;}
	public ProcedureList getProcedures() {return procedures;}
	public void setProcedures(ProcedureList procedures) {this.procedures = procedures;}
	public int getPatientID() {return patientID;}
	
	public void print() {
		System.out.println(toString());
	}
	
	/*public Invoice createInvoice() {
		Invoice aptInvoice = new Invoice(this.procedures, this.patientName, this.patientID);
		invoiced = true;
		return aptInvoice;//does this object live here or 
							I'll change this to a method in patient?
	}*/
	
	public String toString() {
		return "Patient Name: "+this.patientName+" ";
	}

}
