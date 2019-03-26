package start;

import controller.Controller;

public class StartUp {
	//kick off program and feed root to main
	
	private static StartUp instance;
	private static Controller controller;
	
	private StartUp() {
	}
	
	public synchronized static StartUp getInstance() {
		if (instance == null) {
			instance = new StartUp();
		}
		return instance;
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		StartUp.controller = controller;
	}
	
}
