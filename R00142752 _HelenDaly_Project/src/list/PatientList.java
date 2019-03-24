package list;

import classes.Patient;

public class PatientList extends ObjectList{
	//list of Patients
	public PatientList() {
		super();
	}
	
	public void addPatient(Patient patient) {
		this.add(patient);
	}

}
