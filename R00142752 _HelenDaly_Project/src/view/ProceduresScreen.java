package view;

import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class ProceduresScreen extends StackPane{
	
	private Text testText;
	private StackPane stack;
	
	public ProceduresScreen() {
		testText = new Text("procedures screen showing");
		stack = new StackPane();
		ObservableList list = stack.getChildren();
		list.addAll(testText);
	}

}
