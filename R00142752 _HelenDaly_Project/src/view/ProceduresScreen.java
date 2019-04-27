package view;

import controller.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class ProceduresScreen extends GridPane{
	
	private TableView<Object> procList;
	private HBox buttonBanner;
	private HBox procedureListBox;
	
	public ProceduresScreen() {
		super();
		procScreenSetUp();
	}

	private void procScreenSetUp() {
		
		this.setHgap(10);
		this.setVgap(5);
		
		procList = new TableView<Object>();
		TableColumn<Object,String> idCol = new TableColumn<Object,String>("ID");
		TableColumn<Object,String> name = new TableColumn<Object,String>("Name");
		TableColumn<Object, String> description = new TableColumn<Object, String>("Description");
		TableColumn<Object,String> price = new TableColumn<Object, String>("Price");
		
		idCol.setCellValueFactory(new PropertyValueFactory<>("procID"));
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		description.setCellValueFactory(new PropertyValueFactory<>("description"));
		price.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		procList.getColumns().addAll(idCol, name, description, price);
		this.setprocList();
		this.getChildren().add(procList);
		
		AddButton addProcBut = new AddButton();
		EditButton editProcBut = new EditButton();
		DeleteButton deleteProcBut = new DeleteButton();
		buttonBanner = new HBox();
		buttonBanner.getChildren().addAll(addProcBut, editProcBut, deleteProcBut);
		procedureListBox = new HBox();
		procedureListBox.getChildren().add(procList);
		
		this.add(buttonBanner, 0, 0);
		this.add(procedureListBox, 0, 1);
	}

	private void setprocList() {
		ObservableList<Object> plist = FXCollections.observableArrayList(Controller.getInstance().getProcedures().getList());
		procList.setItems(plist);
	}
}
