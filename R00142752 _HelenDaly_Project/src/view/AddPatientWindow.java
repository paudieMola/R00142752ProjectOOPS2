package view;

import controller.Controller;
import classes.Patient;
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

public class AddPatientWindow extends GridPane{
	public AddPatientWindow() {
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
	    this.setBackground(null);

	    // Add Column Constraints

	    // columnOneConstraints will be applied to all the nodes placed in column one.
	    ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
	    columnOneConstraints.setHalignment(HPos.RIGHT);

	    // columnTwoConstraints will be applied to all the nodes placed in column two.
	    ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
	    columnTwoConstrains.setHgrow(Priority.ALWAYS);

	    this.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);
	    
	}
	private void addUIControls() {
	    // Add Header
	    Label headerLabel = new Label("New Patient");
	    headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
	    this.add(headerLabel, 0,0,2,1);
	    GridPane.setHalignment(headerLabel, HPos.CENTER);
	    GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

	    // Add Name Label
	    Label nameLabel = new Label("Full Name : ");
	    this.add(nameLabel, 0,1);

	    // Add Name Text Field
	    TextField nameField = new TextField();
	    nameField.setPrefHeight(40);
	    this.add(nameField, 1,1);


	    // Add Email Label
	    Label emailLabel = new Label("Age: ");
	    this.add(emailLabel, 0, 2);

	    // Add Email Text Field
	    TextField ageField = new TextField();
	    ageField.setPrefHeight(40);
	    this.add(ageField, 1, 2);

	    // Add address Label
	    Label addressLabel = new Label("Address : ");
	    this.add(addressLabel, 0, 3);

	    // Add address Field
	    TextField addressField = new TextField();
	    addressField.setPrefHeight(40);
	    this.add(addressField, 1, 3);
	    
	    // Add phoneNo Label
	    Label phoneNo = new Label("Phone No : ");
	    this.add(phoneNo, 0, 4);

	    // Add address Field
	    TextField phoneNoField = new TextField();
	    phoneNoField.setPrefHeight(40);
	    this.add(phoneNoField, 1, 4);

	    // Add Submit Button
	    AddButton submitButton = new AddButton();
	    submitButton.setPrefHeight(40);
	    submitButton.setDefaultButton(true);
	    submitButton.setPrefWidth(100);
	    submitButton.setOnAction(new EventHandler<ActionEvent>() {
	        @Override//must change the Alerts to myAlert
	        public void handle(ActionEvent event) {
	            if(nameField.getText().isEmpty()) {//check this next line. I don't have a getWindow method
	                showAlert(Alert.AlertType.ERROR, Controller.getInstance().getStage().getScene().getWindow(), 
	                "Form Error!", "Please enter your name");
	                return;
	            }
	            if(ageField.getText().isEmpty()) {
	                showAlert(Alert.AlertType.ERROR, Controller.getInstance().getStage().getScene().getWindow(), 
	                "Form Error!", "Please enter your age");
	                return;
	            }
	            if(addressField.getText().isEmpty()) {
	                showAlert(Alert.AlertType.ERROR, Controller.getInstance().getStage().getScene().getWindow(), 
	                "Form Error!", "Please enter an address");
	                return;
	            }
	            
	            if(phoneNo.getText().isEmpty()) {
	                showAlert(MyAlert.AlertType.ERROR, Controller.getInstance().getStage().getScene().getWindow(), 
	                "Form Error!", "Please enter an address");
	                return;
	            }
	            //must change to 
	            showAlert(Alert.AlertType.CONFIRMATION, Controller.getInstance().getStage().getScene().getWindow(), 
	            "Registration Successful!", "Welcome " + nameField.getText());
	            String name = nameField.getText();
	            String[] data = name.split(" ");
	            Patient p = new Patient(data[0],data[1],Integer.parseInt(ageField.getText()),addressField.getText(), phoneNoField.getText());
	            Controller.getInstance().addPatient(p);
	            System.out.println(Controller.getInstance().getPatients().getSize());
	        }
	    });
	    this.add(submitButton, 0, 5, 2, 1);
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
