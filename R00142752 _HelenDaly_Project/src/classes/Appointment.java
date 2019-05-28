package classes;
import java.io.Serializable;
//
import java.util.ArrayList;
import java.util.Date;

import list.ProcedureList;

public class Appointment implements Serializable {
	//for dentistName, startTime, endTime, procedures
	private String dentistName;
	private String patientName;
	private int patientID;
	private double startTime;
	private double endTime;
	private Date dateofApt;
	private ProcedureList procedures;
	private Boolean invoiced = false;//flag to search for uninvoiced appointments
	
	public Appointment(String dentistName, String patientName, Double startTime, Double endTime, Date dateofApt, int patientID) {
		this.dentistName = dentistName;
		this.patientName = patientName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.dateofApt = dateofApt;
		this.patientID = patientID;	
	}
	
	//getters and setters
	public String getDentistName() {return dentistName;}
	public void setDentistName(String dentistName) {this.dentistName = dentistName;}
	public String getPatientName() {return patientName;}
	public void setPatientName(String patientName) {this.patientName = patientName;}
	public double getStartTime() {return startTime;}
	public void setStartTime(double startTime) {this.startTime = startTime;}
	public double getEndTime() {return endTime;}
	public void setEndTime(double endTime) {this.endTime = endTime;}
	public Date getDate() {return dateofApt;}
	public void setDate(Date dateofApt) {this.dateofApt = dateofApt;}
	public ProcedureList getProcedures() {return procedures;}
	public void setProcedures(ProcedureList procedures) {this.procedures = procedures;}
	public int getPatientID() {return patientID;}
	
	public void print() {
		System.out.println(toString());
	}
	
	public String toString() {
		return this.patientName+" "
				+this.dateofApt+" "
				+this.startTime+""
				+" Dentist: "
				+this.dentistName;
	}
}
