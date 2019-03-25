package classes;

import java.util.Date;

public class Invoice extends Appointment{
	//for invoice No and amount. Create a constructor taking in parameters from appointment
	
	private int invoiceNo;
	private Date invoiceDate;
	private double totalAmount;
	
	public Invoice () {
		super();
	}

	public int getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(int invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
}
