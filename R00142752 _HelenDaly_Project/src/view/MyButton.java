package view;

import javafx.scene.control.Button;

//to create my own buttons
public class MyButton extends Button{//for buttons down the side of home screen
	
	public MyButton(String buttonText) {
		super(buttonText);
		this.setMaxWidth(Double.MAX_VALUE);
	}
}
