package view;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ScreenTemplate {
	//does this have to be abstract to create a template screen
	
	StackPane base = new StackPane();
	
	public StackPane template() {
		return base;
	}
	

}
