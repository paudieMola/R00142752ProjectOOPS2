package view;
//
import controller.Controller;
import exception.ButtonException;
import exception.LoginException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class HomeScreen extends BorderPane{
	//I wanted this to be the structure of all subsequent screens. A blank border Pane with buttons down the side. 
	//I wanted to put a login screen in the middle of this.
	HBox header = new HBox();
	VBox sidePanel = new VBox();
	StackPane centreScreen = new StackPane();
	public HomeScreen() {
	header.setPadding(new Insets(15, 12, 15, 12));
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
	try {
		buildHomeScreen();
	} catch (ButtonException e) {
	}
	}

	private void buildHomeScreen() throws ButtonException {
		MyButton homeButton = new MyButton("Home", sidePanel.getPrefHeight(), sidePanel.getPrefWidth());
		homeButton.setOnAction(e -> {
			FilledHomeScreen fhomeScreen = new FilledHomeScreen();
			setCentreScreen(fhomeScreen);
		});
		
		MyButton patientsButton = new MyButton("Patients",sidePanel.getPrefHeight(), sidePanel.getPrefWidth());
		patientsButton.setOnAction(e -> {

			PatientsScreen patScreen = new PatientsScreen();
			setCentreScreen(patScreen);
		});
		MyButton proceduresButton = new MyButton("Procedures");
		proceduresButton.setOnAction(e -> {
			ProceduresScreen procScreen = new ProceduresScreen();
			setCentreScreen(procScreen);
		});
		MyButton calendarButton = new MyButton("Calendar", sidePanel.getPrefHeight(), sidePanel.getPrefWidth());
		calendarButton.setOnAction(e -> {
			CalendarScreen calScreen = new CalendarScreen();
			setCentreScreen(calScreen);
		});
		sidePanel.getChildren().addAll(homeButton, patientsButton, proceduresButton, calendarButton);
	}

	public HBox getHeader() {
		return header;
	}

	public void setHeader(HBox header) {
		this.header = header;
	}

	public VBox getSidePanel() {
		return sidePanel;
	}

	public void setSidePanel(VBox sidePanel) {
		this.sidePanel = sidePanel;
	}

	public void setCentreScreen(StackPane centreScreen) {
		this.centreScreen = centreScreen;
	}
	
}