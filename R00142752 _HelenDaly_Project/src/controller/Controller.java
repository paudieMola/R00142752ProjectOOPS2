package controller;

import java.util.Scanner;

//import application.Main;
import list.PatientList;
import storage.SerialStorage;
import view.HomeScreen;
import view.Login;
import view.ScreenTemplate;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Controller {
	//create controller first time, and use singleton to persist data
	private static Controller instance;
	private Stage stage;
	private PatientList patients;//if i have a separate patientlist class I'll have to do something about this
	private ScreenTemplate temp;
	private HomeScreen home;
	private Login login;
	
	private Controller(Stage primaryStage) {
		instance = this;
		primaryStage.setTitle("Welcome to Gentle Dental");
		setStage(primaryStage);
		this.login = new Login(this);
		this.temp = new ScreenTemplate(login);
		this.getStage().setScene(temp);
		this.temp.getStylesheets().add(main.Main.class.getResource("application.css").toExternalForm());
		this.stage.show();
	}
	
	public synchronized static Controller getInstance(Stage primaryStage) {
		if (instance ==null) {
			instance = new Controller(primaryStage);
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
	
	public void saveController() {
		//try {//load controller object from file and continue from last save
			//this.getInstance = (this.getInstance(primaryStage))SerialStorage.save("storage.ser"); 
		//}
		//catch(Exception e) {//I don't need a try catch cos it already exists. 
			//control = new HotelController();
		//}	
	}
	
}
