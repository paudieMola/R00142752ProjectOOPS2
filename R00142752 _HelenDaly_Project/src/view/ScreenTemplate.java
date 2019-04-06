package view;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class ScreenTemplate extends Scene
{
	StackPane base = new StackPane();
	VBox header = new VBox();
	
	
	public ScreenTemplate(Parent root, int height, int width, Paint fill) {
		super(root, height, width, fill);
	}

	
	//public StackPane template() {
		//return base;Color.rgb(49, 196, 232)
	//}
	

}
