package view;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Window;

public class DeletePatientWindow extends GridPane {
	public DeletePatientWindow() {
		super();
		setupWindow();
		addUIControls();
	}
	
	private void setupWindow() {
		// Position the pane at the center of the screen, both vertically and horizontally
	    this.setAlignment(Pos.CENTER);

	    // Set a padding of 20px on each side
	    this.setPadding(new Insets(40, 40, 40, 40));

	    // Set the horizontal gap between columns
	    this.setHgap(10);

	    // Set the vertical gap between rows
	    this.setVgap(10);

	    // Add Column Constraints

	    // columnOneConstraints will be applied to all the nodes placed in column one.
	    ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
	    columnOneConstraints.setHalignment(HPos.RIGHT);

	    // columnTwoConstraints will be applied to all the nodes placed in column two.
	    ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
	    columnTwoConstrains.setHgrow(Priority.ALWAYS);

	    this.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);
	    this.setBackground(null);
	    
	}
	private void addUIControls() {
	    // Add Header
	    Label headerLabel = new Label("Delete Patient");
	    headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
	    this.add(headerLabel, 0,0,2,1);
	    GridPane.setHalignment(headerLabel, HPos.CENTER);
	    GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

	    // Add Name Label
	    Label nameLabel = new Label("Patient ID : ");
	    this.add(nameLabel, 0,1);

	    // Add Name Text Field
	    TextField idField = new TextField();
	    idField.setPrefHeight(40);
	    this.add(idField, 1,1);

	    // Add Submit Button
	    Button submitButton = new Button("Delete");
	    submitButton.setPrefHeight(40);
	    submitButton.setDefaultButton(true);
	    submitButton.setPrefWidth(100);
	    submitButton.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	            
	            if(idField.getText().isEmpty()) {
	                showAlert(Alert.AlertType.ERROR, Controller.getInstance().getStage().getScene().getWindow(), 
	                "Form Error!", "Please enter an id");
	                return;
	            }

	            String id = idField.getText();
	            int idToBeDeleted = -1;
	            try {
	            	idToBeDeleted = Integer.parseInt(id);
	            }catch(Exception e) {
	            	showAlert(Alert.AlertType.ERROR, Controller.getInstance().getStage().getScene().getWindow(), 
	    	                "Form Error!", "Please enter a numeric id");
	    	                return;
	            }
	            Controller.getInstance().deletePatient(idToBeDeleted);
	            showAlert(Alert.AlertType.CONFIRMATION, Controller.getInstance().getStage().getScene().getWindow(), 
	    	            "Deletion Successful!", "Thanks");
	    	            
	        }
	    });
	    this.add(submitButton, 0, 4, 2, 1);//create my own submit button
	    this.setHalignment(submitButton, HPos.CENTER);
	    this.setMargin(submitButton, new Insets(20, 0,20,0));
	}
	
	private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
	    Alert alert = new Alert(alertType);
	    alert.setTitle(title);
	    alert.setHeaderText(null);
	    alert.setContentText(message);
	    alert.initOwner(owner);
	    alert.show();
	}
}
