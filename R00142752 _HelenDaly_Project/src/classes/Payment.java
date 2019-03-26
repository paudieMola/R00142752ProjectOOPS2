package classes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Payment {
	//for payments obv
	
	private int PatientID;
	private double amount;
	private String paymentDate;
	private int InvoiceNo;
	
	public Payment() {
		Date now = new Date();
		SimpleDateFormat dFormat = new SimpleDateFormat("EEEE, MMMM d, yyyy");
		this.paymentDate = dFormat.format(now);
	}
	
	public int getPatientID() {
		return PatientID;
	}
	public void setPatientID(int patientID) {
		PatientID = patientID;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public int getInvoiceNo() {
		return InvoiceNo;
	}
	public void setInvoiceNo(int invoiceNo) {
		InvoiceNo = invoiceNo;
	}
	
	
}
