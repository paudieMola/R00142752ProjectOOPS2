package view;

import javafx.scene.control.Button;

//to create my own buttons
public class MyButton extends Button{
	
	public MyButton(String buttonText, double wid,double heig) {

		super(buttonText);
		this.setHeight(heig);
		this.setWidth(wid);
		
	}
}
