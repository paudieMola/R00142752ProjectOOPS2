package view;

import javafx.animation.PauseTransition;
import javafx.scene.control.Alert;
import javafx.util.Duration;

public class MyAlert extends Alert {

	public MyAlert(AlertType arg0, String text, MyAlertEnum type) {
		super(arg0);
		this.setContentText(text);
		this.setType(type);
	}

	private void setType(MyAlertEnum i) {
		switch (i) {
		case Show:
			this.showAndWait();
			break;
		case Timed:
			this.show();
			this.showAndClose(5);
			break;

		}
	}

	public void showAndClose(int seconds) {
		PauseTransition delay = new PauseTransition(Duration.seconds(seconds));
		delay.setOnFinished(event -> this.close());
		delay.play();
	}
	
}
