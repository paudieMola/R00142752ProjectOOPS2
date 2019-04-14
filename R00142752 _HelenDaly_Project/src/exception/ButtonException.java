package exception;

import javafx.scene.control.Alert.AlertType;
import view.MyAlert;
import view.MyAlertEnum;

public class ButtonException extends Exception {
	public ButtonException(String exceptionText) {
		super(exceptionText);
		new MyAlert(AlertType.ERROR,
				"You must have a valid email to login!",
				MyAlertEnum.Show);

	}
}
