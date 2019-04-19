package view;

import javafx.scene.control.Button;

//to create my own buttons
public class MyButton extends Button{
	
	public MyButton(String buttonText, double height, double width) {

		super(buttonText);
		this.prefHeight(height);
		this.prefWidth(width);
		
	}
}
