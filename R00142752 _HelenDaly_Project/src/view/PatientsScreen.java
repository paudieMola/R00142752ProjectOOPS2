package view;

import classes.Patient;
import controller.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class PatientsScreen extends GridPane {
	private  TableView<Object> patList;
	private HBox buttonBanner;
	private HBox patientListBox;
	private ScreenTemplate temp;
	
	public PatientsScreen() {
		super();
		patScreenSetUp();	
	}

	private void patScreenSetUp() {
		//set up the screen 
		this.setHgap(10);
        this.setVgap(5); 
		
		patList = new TableView<Object>();//create a table of patients
		//set up the table columns
		TableColumn<Object,String> idCol = new TableColumn<Object,String>("ID");
		TableColumn<Object,String> fullName = new TableColumn<Object,String>("Name");
		TableColumn<Object, String> dob = new TableColumn<Object, String>("Date of birth");
		TableColumn<Object,String> phone = new TableColumn<Object, String>("Tel");
		TableColumn<Object, String> address = new TableColumn<Object, String>("Address");
		//get the details from Patient
		idCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
		fullName.setCellValueFactory(new PropertyValueFactory<>("patientName"));
		dob.setCellValueFactory(new PropertyValueFactory<>("DOB"));
		phone.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));
		address.setCellValueFactory(new PropertyValueFactory<>("address"));
		
		patList.getColumns().addAll(idCol, fullName, dob,phone, address);
		this.setPatientList();
		this.getChildren().add(patList);


		//create buttons for add, edit,delete
		MyButton addPatBut = new MyButton("Add");
		addPatBut.setOnAction(e -> {
			AddPatientWindow addPat = new AddPatientWindow();
			Controller.getInstance().setScene(this.temp = new ScreenTemplate(addPat));
	
		});
		
		
		EditButton editPatBut = new EditButton();//change this to create a new Add patient screen and give p as the parameter
		editPatBut.setOnAction(e -> {
			Patient p = (Patient) patList.getSelectionModel().getSelectedItem();
			EditPatientWindow EditPat = new EditPatientWindow(p);
			Controller.getInstance().setScene(this.temp = new ScreenTemplate(EditPat));
		});
		
		
		DeleteButton deletePatBut = new DeleteButton();
		deletePatBut.setOnAction(e -> {
			Patient p = (Patient) patList.getSelectionModel().getSelectedItem();
			DeletePatientWindow deletePat = new DeletePatientWindow(p);
			Controller.getInstance().setScene(this.temp = new ScreenTemplate(deletePat));
		});
		
		buttonBanner = new HBox();//box to display buttons
		buttonBanner.getChildren().addAll(addPatBut, editPatBut, deletePatBut);
		this.patientListBox = new HBox();
		this.patientListBox.getChildren().add(patList);
		
		this.add(buttonBanner, 0, 0);
		this.add(patientListBox, 0, 1);
	
	}
	
	public void setPatientList() {//observable list of patients
		ObservableList<Object> list = FXCollections.observableArrayList(Controller.getInstance().getPatients().getList());
		patList.setItems(list);
	}

}
