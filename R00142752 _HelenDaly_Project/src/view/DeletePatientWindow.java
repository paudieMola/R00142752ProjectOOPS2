package view;

import classes.Patient;
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
	private Patient p;
	
	public DeletePatientWindow(Patient p) {
		super();
		this.p = p;
		this.setBackground(null);
		setupWindow();//kick it off 
		addUIControls(p);//add details
	}
	
	private void setupWindow() {
		// Position the pane at the center of the screen, set padding etc
	    this.setAlignment(Pos.CENTER);
	    this.setPadding(new Insets(40, 40, 40, 40));
	    this.setHgap(10);
	    this.setVgap(10);

	    // Add Column Constraints

	    ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
	    columnOneConstraints.setHalignment(HPos.RIGHT);
	    ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
	    columnTwoConstrains.setHgrow(Priority.ALWAYS);

	    this.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);
	    this.setBackground(null);
	    
	}
	private void addUIControls(Patient p) {
	    Controller.getInstance().showAllDetails(p);

	    // Add Delete Button
	    DeleteButton delBut = new DeleteButton();
	    delBut.setPrefHeight(40);
	    delBut.setDefaultButton(true);
	    delBut.setPrefWidth(100);
	    delBut.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	            
	            if(p == null) {
	                showAlert(Alert.AlertType.ERROR, Controller.getInstance().getStage().getScene().getWindow(), //check
	                "Error!", "Please choose an Patient to delete");
	                Controller.getInstance().showPatientsScreen();
	    			return;
	            }

	            int id = p.getID();
	            int idToBeDeleted = -1;
	            try {
	            	idToBeDeleted = (id);
	            }catch(Exception e) {
	            	showAlert(Alert.AlertType.ERROR, Controller.getInstance().getStage().getScene().getWindow(), //check
	    	                "Error!", "There was a problem with this deletion. Please try again");
	    	                return;
	            }
	            Controller.getInstance().deletePatient(idToBeDeleted);
	            showAlert(Alert.AlertType.CONFIRMATION, Controller.getInstance().getStage().getScene().getWindow(), //check
	    	            "Deletion Successful!", "Thanks");
	    	            
	        }
	    });
	    this.add(delBut, 0, 4, 2, 1);//create my own submit button
	    this.setHalignment(delBut, HPos.CENTER);
	    this.setMargin(delBut, new Insets(20, 0,20,0));
	}
	
	private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
	    Alert alert = new Alert(alertType);//change to MyAlert
	    alert.setTitle(title);
	    alert.setHeaderText(null);
	    alert.setContentText(message);
	    alert.initOwner(owner);
	    alert.show();
	}
}
