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
	private Boolean edit = false;
	private Patient p;
	
	public AddPatientWindow() {
		super();
		setupWindow();
		addUIControls();
	}
	
	public AddPatientWindow(Patient patient) {
		super();
		this.p = patient;
		edit = true;
		setupWindow();
		
		//addUIControls();
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
	    if(edit) {
        	nameField.setText(p.getPatientName());}
	    this.add(nameField, 1,1);
	  

	    // Add Age Label
	    Label ageLabel = new Label("Age: ");
	    this.add(ageLabel, 0, 2);

	    // Add Age Text Field
	    TextField ageField = new TextField();
	    ageField.setPrefHeight(40);
	    if(edit) {
        	ageField.setText(String.valueOf(p.getAge()));}
	    this.add(ageField, 1, 2);

	    // Add address Label
	    Label addressLabel = new Label("Address : ");
	    this.add(addressLabel, 0, 3);

	    // Add address Field
	    TextField addressField = new TextField();
	    if(edit) {
        	addressField.setText(p.getAddress());}
	    addressField.setPrefHeight(40);
	    this.add(addressField, 1, 3);
	    
	    // Add phoneNo Label
	    Label phoneNo = new Label("Phone No : ");
	    this.add(phoneNo, 0, 4);

	    // Add phoneNo Field
	    TextField phoneNoField = new TextField();
	    phoneNoField.setPrefHeight(40);
	    if(edit) {
	    	phoneNoField.setText(p.getPhoneNo());}
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
	                "Form Error!", "Please enter a phone number");
	                return;
	            }
	            //must change to 
	            showAlert(Alert.AlertType.CONFIRMATION, Controller.getInstance().getStage().getScene().getWindow(), 
	            "Registration Successful!", "Welcome " + nameField.getText());
	            
	            
	            String name = nameField.getText();
	            String[] data = name.split(" ");
	            if(edit) {
	            	p.setFirstName(data[0]);
	            	p.setLastName(data[1]);
	            	p.setAge(Integer.parseInt(ageField.getText()));
	            	p.setAddress(addressField.getText());
	            	p.setPhoneNo(phoneNoField.getText());
	            }
	            else{p = new Patient(data[0],data[1],Integer.parseInt(ageField.getText()),addressField.getText(), phoneNoField.getText());
	            Controller.getInstance().addPatient(p);}
	            System.out.println(Controller.getInstance().getPatients().getSize());//take this out after I know its working
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
