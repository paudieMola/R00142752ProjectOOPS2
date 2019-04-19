package view;
//
import javafx.scene.Parent;
import javafx.scene.Scene;

import controller.Controller;
import exception.EmailException;
import exception.LoginException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
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
	private Label userName, pw, cw;
	private TextField userTextField;
	private TextField codeField;
	private PasswordField pwBox;
	private HBox hbBtn;
	private Button btn;
	private Controller control;

	private final Text actiontarget = new Text();

	public Login() {
		this.setAlignment(Pos.CENTER);
		this.setHgap(10);
		this.setVgap(10);
		this.setPadding(new Insets(25, 25, 25, 25));
		this.setupLogin();
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
				String username = this.userTextField.getText();
				String password = this.pwBox.getText();

				//if (!checkCodeField(this.codeField.getText())) {
					//System.out.println("Code field has to be numeric and 4 digits in length");
				//} else {
					//checkUsernameEmail(username);
					checkLogin(username, password);
				//}
				// Open new window
					//} catch (EmailException ex) {
				// ex.printStackTrace();
			} catch (LoginException ex) {
				// ex.printStackTrace();
			}
		});
	}

	private void checkLogin(String username, String password) throws LoginException {
		
		//create an arraylist of login names and passwords here
		if (username.toLowerCase().equals("helen") && password.equals("pass")) {//change this to get the dentist helen and compare the password
			actiontarget.setFill(Color.GREEN);									//get the object within the method to save memory
			actiontarget.setText("Login Success");
			this.control.setHomeScreen();//has to change to display home screen
		} else {
			actiontarget.setFill(Color.FIREBRICK);
			actiontarget.setText("Sign Failed");
			//this.control.LoginFail();//have to change this to display 
			throw new LoginException("Bad Login");
		}
	}

	//private void checkUsernameEmail(String email) throws EmailException {

		//if (!email.contains("@"))
			//throw new EmailException("Invalid Email");
	//}

	//private boolean checkCodeField(String code) {
		//if (code.length() != 4)
			//return false;

		//try {
			//int codeNum = Integer.parseInt(code);
		//} catch (Exception e) {
			//return false;
		//}

		//return true;
	//}

}
