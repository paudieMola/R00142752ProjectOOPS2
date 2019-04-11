package controller;

import java.util.Scanner;

//import application.Main;
import list.PatientList;
import view.HomeScreen;
import view.Login;
import view.ScreenTemplate;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Controller {
	//create controller first time, and use singleton to persist data
	private static Controller instance;
	public static Scanner in;
	private Stage stage;
	private PatientList patients;//if i have a separate patientlist class I'll have to do something about this
	private ScreenTemplate temp;
	private HomeScreen home;
	private Login login;
	
	private Controller(Stage primaryStage) {
		primaryStage.setTitle("Welcome to Gentle Dental");
		in = new Scanner(System.in);
		setStage(primaryStage);
		this.login = new Login(this);
		this.temp = new ScreenTemplate(login, 800, 600);
		this.temp.getStylesheets().add(main.Main.class.getResource("application.css").toExternalForm());
		getStage().setScene(temp);
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
		this.temp = new ScreenTemplate((home = new HomeScreen()), 800, 600);
		getStage().setScene(temp);
	}
	
}
