package view;
//
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
	//provides a the scene to be displayed on the stage.
	//I think I should bind everything to this
	
	public ScreenTemplate(Parent root) {
		super(root, 800, 600, Color.rgb(49, 196, 232));

	}

}
