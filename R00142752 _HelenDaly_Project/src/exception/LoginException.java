package exception;

import javafx.scene.control.Alert.AlertType;
import view.MyAlert;
import view.MyAlertEnum;


public class LoginException extends Exception{

	public LoginException(String exceptionText) {
		super(exceptionText);
		new MyAlert(AlertType.ERROR,
						"Invalid Login",
						MyAlertEnum.Timed);
		
	}
}

