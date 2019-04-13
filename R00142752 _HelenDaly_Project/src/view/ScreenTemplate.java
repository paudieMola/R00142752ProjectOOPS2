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
	//I should really be binding everything to this
	
	public ScreenTemplate(Parent root, double width, double height) {
		super(root, width, height);
		Rectangle baseColor = new Rectangle();
		baseColor.setFill(Color.rgb(49, 196, 232));
		baseColor.setHeight(height);
		baseColor.setWidth(width);
	}
}
