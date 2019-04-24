package view;

import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

public class PatientsScreen extends StackPane {
	
	public PatientsScreen() {
		super();
		MyButton patBut = new MyButton("Patients");
		this.getChildren().addAll(patBut);
		//buildPScreen();
	}

	//private PatientsScreen buildPScreen() {
		
		//return this;
	//}

}
