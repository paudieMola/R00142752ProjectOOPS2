package main;
	//
import controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;
import view.ScreenTemplate;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class Main extends Application {
	
	@Override   
	public void start(Stage primaryStage) {
		try {
			Controller.getInstance().setStage(primaryStage);
			Controller.getInstance().loadData();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
