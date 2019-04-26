package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import classes.Patient;
//import application.Main;
import list.PatientList;
import storage.SerialStorage;
import storage.StorageIntface;
import view.HomeScreen;
import view.Login;
import view.ScreenTemplate;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Controller implements Serializable {
	//create controller first time, and use singleton to persist data
	private static Controller instance;
	private Stage stage;
	private PatientList patients;//
	private ScreenTemplate temp;
	private HomeScreen home;
	private Login login;
	private StorageIntface store;
	
	private Controller() {
		instance = this;
		store = new SerialStorage();
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
		for(int i = 0; i < 5; i++) {
			Patient p = new Patient("Patient"+i, "Patient"+i, i, "AddressL1"+i, "AddressL2"+i,"City"+i, "Country"+i, "Phone"+i);
			patients = new PatientList();
			patients.getList().add(p);
			this.saveController();
		}
	}
	
	private void start() {
		this.stage.setTitle("Welcome to Gentle Dental");
		login = new Login();
		temp = new ScreenTemplate(login);
		this.setScene(temp);
		temp.getStylesheets().add(main.Main.class.getResource("application.css").toExternalForm());
		this.stage.show();
	}

	public PatientList getPatients() {
		return patients;
	}

	public void setPatients(PatientList patients) {
		this.patients = patients;
	}
	
	
	
}
