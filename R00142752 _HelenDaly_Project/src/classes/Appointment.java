package classes;
//
import java.util.ArrayList;
import java.util.Date;

public class Appointment {
	//for dentistName, startTime, endTime
	private Dentist dentistName;
	private Patient patientName;
	private double startTime;
	private double endTime;
	private Date date;
	private ArrayList <Procedure> procedures;
	//private indexof
	
	//getters and setters
	public Dentist getDentistName() {return dentistName;}
	public void setDentistName(Dentist dentistName) {this.dentistName = dentistName;}
	public Patient getPatientName() {return patientName;}
	public void setPatientName(Patient patientName) {this.patientName = patientName;}
	public double getStartTime() {return startTime;}
	public void setStartTime(double startTime) {this.startTime = startTime;}
	public double getEndTime() {return endTime;}
	public void setEndTime(double endTime) {this.endTime = endTime;}
	public Date getDate() {return date;}
	public void setDate(Date date) {this.date = date;}
	public ArrayList<Procedure> getProcedures() {return procedures;}
	public void setProcedures(ArrayList<Procedure> procedures) {this.procedures = procedures;}
	
	private void addProcedure(Procedure procedure) {
		this.procedures.add(procedure);
	}
	
	private void deleteProcedure() {
		//this.procedures.remove();I have to correct this what variable do i choose to delete./
	}

}
