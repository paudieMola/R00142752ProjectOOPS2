package view;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class HomeScreen extends StackPane {
	
	HBox header = new HBox();
	VBox sidePanel = new VBox();
	BorderPane pane = new BorderPane();
	
	public HomeScreen() {
	header.setPadding(new Insets(15, 12, 15, 12));
	header.setSpacing(10);
	header.setAlignment(Pos.CENTER);
	Text headerText = new Text ("Gentle Dental");
	headerText.setId("main/headertext");
	
	ImageView tooth = new ImageView(new Image("view/tooth.jpg"));
	tooth.setFitHeight(30);
	tooth.setFitWidth(30);
	header.getChildren().addAll(tooth,headerText);
	pane.setTop(header);
	pane.setLeft(sidePanel);
	
	this.getChildren().addAll(pane);
	}

	public HBox getHeader() {
		return header;
	}

	public void setHeader(HBox header) {
		this.header = header;
	}

	public VBox getSidePanel() {
		return sidePanel;
	}

	public void setSidePanel(VBox sidePanel) {
		this.sidePanel = sidePanel;
	}

	public BorderPane getPane() {
		return pane;
	}

	public void setPane(BorderPane pane) {
		this.pane = pane;
	}
	
	
}