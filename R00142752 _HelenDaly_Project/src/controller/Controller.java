package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import classes.Patient;
import classes.Procedure;
//import application.Main;
import list.PatientList;
import list.ProcedureList;
import storage.SerialStorage;
import storage.StorageIntface;
import view.HomeScreen;
import view.Login;
import view.PatientsScreen;
import view.ScreenTemplate;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Controller implements Serializable {
	//create controller first time, and use singleton to persist data
	private static Controller instance;
	private Stage stage;
	private PatientList patients;
	private ProcedureList procedures;
	private ScreenTemplate temp;
	private HomeScreen home;
	private Login login;
	private StorageIntface store;
	private PatientsScreen patientsScreen;
	
	private Controller() {
		instance = this;
		store = new SerialStorage();
		patients = new PatientList();
		procedures = new ProcedureList();
		patientsScreen = new PatientsScreen();
	}
	
	public synchronized static Controller getInstance() {
		if (instance ==null) {
			instance = new Controller();
		}
		return instance;
	}
	
	public void setStage(Stage stage) {this.stage = stage;}
	
	public Stage getStage() {return this.stage;}
	
	public void setHomeScreen() {
		//this.home = new HomeScreen();
		this.temp = new ScreenTemplate((home = new HomeScreen()));
		this.getStage().setScene(temp);
	}
	
	public void setScene(Scene scene) {this.stage.setScene(scene);}
	
	public void saveController() {
		this.store.save(Controller.getInstance());
	}
	
	public void loadData() {
		Object o = store.load();
		if(o == null) {
			this.loadTempData();
		}
		else {
			instance = (Controller)o;
		}
		this.start();
	}
	
	private void loadTempData() {
		patients.add(new Patient("Liam","Daly",43,"Coom, Cobh, Co.Cork","021 4877026"));
		patients.add(new Patient("Trina","Daly",34,"Bridgestown, Inniscarra, Co. Cork","021 4877027"));
		patients.add(new Patient("John","Daly",49,"Coolmona, Donoughmore, Co Cork","021 4877028"));
		patients.add(new Patient("Denis","Daly",52,"34 The Rise, Bishopstown, Cork","021 4877029"));
		patients.add(new Patient("Kim","Daly",26,"52 Greenfields, Ballincollig, Co Cork","021 4877022"));
		procedures.add(new Procedure("Standard check up", 75.00, "Check Up"));
		procedures.add(new Procedure("Standard filling", 90.00, "Filling"));
		procedures.add(new Procedure("Standard scale and polish", 50.00, "Scale and Polish"));
	}
	
	private void start() {
		this.stage.setTitle("Welcome to Gentle Dental");
		login = new Login();
		temp = new ScreenTemplate(login);
		this.setScene(temp);
		temp.getStylesheets().add(main.Main.class.getResource("application.css").toExternalForm());
		this.stage.show();
	}

	public PatientList getPatients() {return patients;}
	public void setPatients(PatientList patients) {this.patients = patients;}
	public ProcedureList getProcedures() {return procedures;}
	public void setProcedures(ProcedureList procedures) {this.procedures = procedures;}
	
	public void addPatient(Patient p) {
		this.patients.add(p);
		this.patientsScreen.setPatientList();
		home = new HomeScreen();
		Controller.getInstance().setScene(this.temp = new ScreenTemplate(home));//change this to new blank AddPatientWindow and add an exit button to go back to home
	}
	
	public void deletePatient(int id) {
		Patient patient = null;
		for (Object p:patients.getList()) {
			if(((Patient)p).getPatientID()==id)
				patient = (Patient)p;
		}
		this.patients.getList().remove(id);
		System.out.println("Deleted"+patient.getPatientName());
		this.patientsScreen.setPatientList();
		home = new HomeScreen();
		Controller.getInstance().setScene(this.temp = new ScreenTemplate(home));
	}
	
}
