package list;

import classes.Appointment;

public class AppointmentList extends ObjectList {

	public AppointmentList() {
		super();
	}
	
	public void addAppointment(Appointment appointment) {
		this.add(appointment);
	}
}
