package view;

import controller.Controller;
import exception.LoginException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Login extends GridPane {

	private Text scenetitle;
	private Label userName, pw;
	private TextField userTextField;
	private PasswordField pwBox;
	private HBox hbBtn;
	private Button btn;
	private Controller control;

	private final Text actiontarget = new Text();//to display sucess or fail message

	public Login() {//align on scene and create padding and gaps 
		this.setAlignment(Pos.CENTER);
		this.setHgap(10);
		this.setVgap(10);
		this.setPadding(new Insets(25, 25, 25, 25));
		this.setupLogin();//kick off the method
	}

	private void setupLogin() {
		scenetitle = new Text("Welcome to Gentle Dental");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		this.add(scenetitle, 0, 0, 2, 1);
		userName = new Label("User Name:");
		this.add(userName, 0, 1);
		userTextField = new TextField();
		userTextField.setPromptText("User Name");
		this.add(userTextField, 1, 1);
		pw = new Label("Password:");
		this.add(pw, 0, 2);
		pwBox = new PasswordField();
		this.add(pwBox, 1, 2);

		btn = new Button("Sign in");
		hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		this.add(hbBtn, 1, 4);

		this.add(actiontarget, 1, 6);

		btn.setOnAction(e -> {
			try {
				String username = this.userTextField.getText();//check login details
				String password = this.pwBox.getText();
				checkLogin(username, password);
			} catch (LoginException ex) {
				ex.printStackTrace();
			}
		});
	}

	private void checkLogin(String username, String password) throws LoginException {
		//create an arraylist of login names and passwords here
		if (username.toLowerCase().equals("helen") && password.equals("pass")) {//change this to get the dentist helen and compare the password
			actiontarget.setFill(Color.GREEN);
			actiontarget.setText("Login Success");
			control = Controller.getInstance();
			this.control.setHomeScreen();
		} else {
			actiontarget.setFill(Color.FIREBRICK);
			actiontarget.setText("Sign Failed");
			throw new LoginException("Bad Login");
		}
	}


}
