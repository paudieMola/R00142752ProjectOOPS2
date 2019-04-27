package view;

import java.util.ArrayList;

import classes.Patient;
import controller.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import list.PatientList;

public class PatientsScreen extends GridPane {
	private  TableView<Object> patList;
	private HBox buttonBanner;
	private HBox patientListBox;
	
	public PatientsScreen() {
		super();
		patScreenSetUp();
		
	}

	private void patScreenSetUp() {
		
		this.setHgap(10);
        this.setVgap(5); 
		
		patList = new TableView<Object>();
		//this.setConstraints(patList, 1, 2);
		
		TableColumn<Object,String> idCol = new TableColumn<Object,String>("ID");
		TableColumn<Object,String> fullName = new TableColumn<Object,String>("Name");
		TableColumn<Object, String> age = new TableColumn<Object, String>("Age");
		TableColumn<Object,String> phone = new TableColumn<Object, String>("Tel");
		TableColumn<Object, String> address = new TableColumn<Object, String>("Address");
		
		idCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
		fullName.setCellValueFactory(new PropertyValueFactory<>("patientName"));
		age.setCellValueFactory(new PropertyValueFactory<>("age"));
		phone.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));
		
		patList.getColumns().addAll(idCol, fullName, age,phone, address);
		this.setPatientList();
		this.getChildren().add(patList);
		
		MyButton addPatBut = new MyButton("Add Patient");
		//this.setConstraints(addPatBut, 1, 0);
		MyButton editPatBut = new MyButton("Edit Patient");
		//this.setConstraints(editPatBut, 2, 0);
		MyButton deletePatBut = new MyButton("Delete Patient");
		//this.setConstraints(deletePatBut, 3, 0);
		buttonBanner = new HBox();
		buttonBanner.getChildren().addAll(addPatBut, editPatBut, deletePatBut);
		//this.setConstraints(buttonBanner, 0, 0);
		patientListBox = new HBox();
		patientListBox.getChildren().add(patList);
		//this.setConstraints(patientListBox, 0, 1);
		
		this.add(buttonBanner, 0, 0);
		this.add(patientListBox, 0, 1);
		
		//this.getChildren().addAll(addPatBut, editPatBut, deletePatBut, patList);
	}
	
	public void setPatientList() {
		ObservableList<Object> list = FXCollections.observableArrayList(Controller.getInstance().getPatients().getList());
		patList.setItems(list);
	}

}
