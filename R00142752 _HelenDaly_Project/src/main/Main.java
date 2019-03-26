package main;
	
import controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;
import start.StartUp;
import view.ScreenTemplate;
import javafx.scene.Scene;
import javafx.scene.paint.Color;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		Controller.getInstance().handleHomeMenu();
		
		primaryStage.setTitle("Welcome to Gentle Dental");
		ScreenTemplate template = new ScreenTemplate();
		Scene scene = new Scene(template.template(), 800,600, Color.rgb(49, 196, 232));
		primaryStage.setScene(scene);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
