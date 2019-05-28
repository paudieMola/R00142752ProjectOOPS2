package classes;

import java.io.Serializable;

public class Procedure implements Serializable {
	//to hold procedure details and prices
	static int PROCID = 1;
	private int procID;
	private String description;
	private double price;
	private String name;
	
	public Procedure(String description, double price, String name) {
		this.description = description;
		this.price = price;
		this.name = name;
		this.procID = this.PROCID;
		this.PROCID++;
	}

	public int getProcID() {return procID;}
	public void setProcID(int procID) {this.procID = procID;}
	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}
	public double getPrice() {return price;}
	public void setPrice(double price) {this.price = price;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public void print() {
		System.out.println(toString());
	}

	public String toString() {
		return this.procID+" "
				+this.name+" "
				+this.description+" "
				+this.price+" ";
	}
}
