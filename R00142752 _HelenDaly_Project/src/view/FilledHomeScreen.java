package view;

import java.io.Serializable;

import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class FilledHomeScreen extends StackPane implements Serializable {

	public FilledHomeScreen () {
		super();
		setup();
	
	}

	private void setup() {
		Text welcome = new Text("Welcome to Gentle Dental");
		DropShadow ds = new DropShadow();
		welcome.setEffect(ds);
		welcome.setCache(true);
		welcome.setFill(Color.WHITE);
		welcome.setFont(Font.font(null, FontWeight.BOLD, 32));
		this.getChildren().add(welcome);
		return;
	}
}
