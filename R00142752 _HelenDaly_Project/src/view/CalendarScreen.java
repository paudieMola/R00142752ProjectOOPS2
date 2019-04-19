package view;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class CalendarScreen extends StackPane{
	public CalendarScreen() {
		Text text = new Text("Calendar Screen");
		BorderPane test = new BorderPane(text);
	}
}
