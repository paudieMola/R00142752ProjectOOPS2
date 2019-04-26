package view;

import classes.Patient;
import controller.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import list.PatientList;

public class PatientsScreen extends GridPane {
	private transient ListView<Patient> patList;
	
	public PatientsScreen() {
		super();
		patScreenSetUp();
		
	}

	private void patScreenSetUp() {
		patList = new ListView<Patient>();
		this.setConstraints(patList, 1, 2);
		
		MyButton addPatBut = new MyButton("Add Patient");
		this.setConstraints(addPatBut, 1, 0);
		MyButton editPatBut = new MyButton("Edit Patient");
		this.setConstraints(editPatBut, 2, 0);
		MyButton deletePatBut = new MyButton("Delete Patient");
		this.setConstraints(deletePatBut, 3, 0);

		this.setPatientList();
		this.getChildren().addAll(addPatBut, editPatBut, deletePatBut, patList);
	}
	
	public void setPatientList() {
		ObservableList<Patient> list = FXCollections.observableArrayList(Controller.getInstance().getPatients().getList());
		patList.setItems(list);
	}

}
