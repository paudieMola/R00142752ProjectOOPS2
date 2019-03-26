package controller;

import java.util.Scanner;

public class Controller {
	//create controller first time, and use singleton to persist data
	private static Controller instance;
	static Scanner in;
	
	private Controller() {	
		in = new Scanner(System.in);
	}
	
	public synchronized static Controller getInstance() {
		if (instance ==null) {
			instance = new Controller();
		}
		return instance;
	}
	
	public void handleHomeMenu() {
		
	}
}
