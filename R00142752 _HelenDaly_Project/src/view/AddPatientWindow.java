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
	
	public AddPatientWindow() {// for creating a new patient
		super();
		setupWindow();
		addUIControls();
	}

	private void setupWindow() {
		// Position the pane at the center of the screen, both vertically and horizontally
	    this.setAlignment(Pos.CENTER);
	    this.setPadding(new Insets(40, 40, 40, 40));
	    this.setHgap(10);
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
	    Label headerLabel = new Label("Patient");
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
        //nameField.setText(p.getPatientName());
	    this.add(nameField, 1,1);

	    // Add Age Label
	    Label DOBLabel = new Label("Date of Birth:");
	    this.add(DOBLabel, 0, 2);

	    // Add Age Text Field
	    TextField DOBField = new TextField();
	    DOBField.setPrefHeight(40);
        	//DOBField.setText(String.valueOf(p.getDOB()));
	    this.add(DOBField, 1, 2);

	    // Add address Label
	    Label addressLabel = new Label("Address : ");
	    this.add(addressLabel, 0, 3);

	    // Add address Field
	    TextField addressField = new TextField();
        	//addressField.setText(p.getAddress());
	    addressField.setPrefHeight(40);
	    this.add(addressField, 1, 3);
	    
	    // Add phoneNo Label
	    Label phoneNo = new Label("Phone No : ");
	    this.add(phoneNo, 0, 4);

	    // Add phoneNo Field
	    TextField phoneNoField = new TextField();
	    phoneNoField.setPrefHeight(40);
	    	//phoneNoField.setText(p.getPhoneNo());
	    this.add(phoneNoField, 1, 4);

	    // Add Submit Button
	    MyButton submitButton = new MyButton("Add");
	    submitButton.setPrefHeight(40);
	    submitButton.setDefaultButton(true);
	    submitButton.setPrefWidth(100);
	    submitButton.setOnAction(new EventHandler<ActionEvent>() {
	        @Override//must change the Alerts to myAlert
	        public void handle(ActionEvent event) {
	            if(nameField.getText().isEmpty()) {
	                showAlert(Alert.AlertType.ERROR, Controller.getInstance().getStage().getScene().getWindow(), 
	                "Form Error!", "Please enter your name");
	                return;
	            }
	            if(DOBField.getText().isEmpty()) {
	                showAlert(Alert.AlertType.ERROR, Controller.getInstance().getStage().getScene().getWindow(), //check this out
	                "Form Error!", "Please enter your date of birth");
	                return;
	            }
	            if(addressField.getText().isEmpty()) {
	                showAlert(Alert.AlertType.ERROR, Controller.getInstance().getStage().getScene().getWindow(),//check this out
	                "Form Error!", "Please enter an address");
	                return;
	            }
	            
	            if(phoneNo.getText().isEmpty()) {
	                showAlert(MyAlert.AlertType.ERROR, Controller.getInstance().getStage().getScene().getWindow(), //check this
	                "Form Error!", "Please enter a phone number");
	                return;
	            }
	            
	            String name = nameField.getText();
	            String[] data = name.split(" ");//split name into first and last
	            
	            if(data.length<2) {
	                showAlert(MyAlert.AlertType.ERROR, Controller.getInstance().getStage().getScene().getWindow(), //check this
	                "Error","Please enter a first and last name.");
	                return;
	            }
	            //must change to MuAlert
	            showAlert(Alert.AlertType.CONFIRMATION, Controller.getInstance().getStage().getScene().getWindow(), 
	            "Registration Successful!", "Welcome " + nameField.getText());
	           
	            Patient p = new Patient(data[0],data[1],DOBField.getText(),addressField.getText(), phoneNoField.getText());
	            Controller.getInstance().addPatient(p);//if its a new one just create a whole new patient
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
