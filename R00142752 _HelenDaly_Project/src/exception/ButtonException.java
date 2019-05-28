package exception;

import javafx.scene.control.Alert.AlertType;
import view.MyAlert;
import view.MyAlertEnum;

public class ButtonException extends Exception {//not used as yet. 
	public ButtonException(String exceptionText) {
		super(exceptionText);
		new MyAlert(AlertType.ERROR,
				"You must have a valid password to login!",
				MyAlertEnum.Show);

	}
}
