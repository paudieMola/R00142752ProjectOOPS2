
package view;
import java.io.Serializable;

import controller.Controller;
import exception.ButtonException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class HomeScreen extends BorderPane implements Serializable {
	//I wanted this to be the structure of all subsequent screens. A blank border Pane with buttons down the side. 
	HBox header = new HBox();
	VBox sidePanel = new VBox();
	ScreenTemplate screen;
	
	public HomeScreen() {
		try {
			buildHomeScreen();//kick off the method
		} catch (ButtonException e) {
			e.printStackTrace();
		}
	}

	private void buildHomeScreen() throws ButtonException {
		header.setPadding(new Insets(15, 12, 15, 12));//set up panels in borderPane as basis for all other screens
		header.setSpacing(10);
		sidePanel.setPadding(new Insets(15, 12, 15, 12));
		sidePanel.setSpacing(10);
		Text headerText = new Text ("Gentle Dental");
		this.setBackground(null);
		ImageView tooth = new ImageView(new Image("Main/tooth.jpg"));
		tooth.setFitHeight(30);
		tooth.setFitWidth(30);
		header.getChildren().addAll(tooth,headerText);
		this.setTop(header);
		header.setAlignment(Pos.CENTER);
		this.setLeft(sidePanel);
		
		Text welcome = new Text("Welcome to Gentle Dental");
		DropShadow ds = new DropShadow();
		welcome.setEffect(ds);
		welcome.setCache(true);
		welcome.setX(10.0f);
		welcome.setY(270.0f);
		welcome.setFill(Color.WHITE);
		welcome.setFont(Font.font(null, FontWeight.BOLD, 32));
		this.setCenter(welcome);
		
		MyButton homeButton = new MyButton("Home");//button for changing to middle display home screen
		homeButton.setOnAction(e -> {
			FilledHomeScreen fhomeScreen = new FilledHomeScreen();
			this.setCenter(fhomeScreen);
		});
		
		MyButton patientsButton = new MyButton("Patients");//button to change middle display to display patients
		patientsButton.setOnAction(e -> {
			PatientsScreen patScreen = new PatientsScreen();
			this.setCenter(patScreen);
		});
		
		MyButton proceduresButton = new MyButton("Procedures");//button to change middle display to procedures scene
		proceduresButton.setOnAction(e -> {
			ProceduresScreen procScreen = new ProceduresScreen();
			this.setCenter(procScreen);
		});
		
		MyButton calendarButton = new MyButton("Appointments");//button to change middle to a calendar displaying appointments
		calendarButton.setOnAction(e -> {
			CalendarScreen calScreen = new CalendarScreen();
			this.setCenter(calScreen);
		});
		
		MyButton logoutButton = new MyButton("Log Out");//button to change middle to a calendar displaying appointments
		logoutButton.setOnAction(e -> {
		Controller.getInstance().start();
		});
		
		sidePanel.getChildren().addAll(homeButton, patientsButton, proceduresButton, calendarButton, logoutButton);//add buttons to side of borderPane
		return ;
		
	}

	//getters and setters if i need them later
	public HBox getHeader() {return header;}
	public void setHeader(HBox header) {this.header = header;}
	public VBox getSidePanel() {return sidePanel;}
	public void setSidePanel(VBox sidePanel) {this.sidePanel = sidePanel;}
	
}