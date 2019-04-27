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
	private ScreenTemplate temp;
	
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
		
		AddButton addPatBut = new AddButton();
		addPatBut.setOnAction(e -> {
			AddPatientWindow addPat = new AddPatientWindow();
			Controller.getInstance().setScene(this.temp = new ScreenTemplate(addPat));
	
		});
		
		
		EditButton editPatBut = new EditButton();
		editPatBut.setOnAction(e -> {
			EditPatientWindow editPat = new EditPatientWindow();
			Controller.getInstance().setScene(this.temp = new ScreenTemplate(editPat));
		});
		
		
		DeleteButton deletePatBut = new DeleteButton();
		deletePatBut.setOnAction(e -> {
			DeletePatientWindow deletePat = new DeletePatientWindow();
			Controller.getInstance().setScene(this.temp = new ScreenTemplate(deletePat));
		});
		
		buttonBanner = new HBox();
		buttonBanner.getChildren().addAll(addPatBut, editPatBut, deletePatBut);
		this.patientListBox = new HBox();
		this.patientListBox.getChildren().add(patList);
		
		this.add(buttonBanner, 0, 0);
		this.add(patientListBox, 0, 1);
	
	}
	
	public void setPatientList() {
		ObservableList<Object> list = FXCollections.observableArrayList(Controller.getInstance().getPatients().getList());
		patList.setItems(list);
	}

}
