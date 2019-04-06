package controller;

import java.util.Scanner;
import list.PatientList;
import view.HomeScreen;
import view.ScreenTemplate;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Controller {
	//create controller first time, and use singleton to persist data
	private static Controller instance;
	static Scanner in;
	private Stage stage;
	private PatientList patients;//if i have a separate patientlist class I'll have to do something about this
	private ScreenTemplate temp;
	private HomeScreen home;
	
	private Controller(Stage primaryStage) {
		primaryStage.setTitle("Welcome to Gentle Dental");
		in = new Scanner(System.in);
		setStage(primaryStage);
		this.home = new HomeScreen();
		this.temp = new ScreenTemplate(home, 800, 600, Color.rgb(49, 196, 232));
		getStage().setScene(temp);
		this.stage.show();
	}
	
	//public Controller() {
		 //TODO Auto-generated constructor stub
	//}

	public synchronized static Controller getInstance(Stage primaryStage) {
		if (instance ==null) {
			instance = new Controller(primaryStage);
		}
		return instance;
	}
	
	public void setStage(Stage stage) {this.stage = stage;}
	
	public Stage getStage() {return this.stage;}
	
	
	public void handleHomeMenu() {
		
	}
}
