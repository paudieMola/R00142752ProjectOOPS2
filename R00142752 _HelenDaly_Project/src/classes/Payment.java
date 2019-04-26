package classes;
import java.io.Serializable;
//
import java.text.SimpleDateFormat;
import java.util.Date;

public class Payment implements Serializable {
	//for payments obv
	
	private int PatientID;
	private double amount;
	private String paymentDate;
	static int PAYMENTNO = 1;
	private int paymentNo;
	private int invoiceNo;
	
	public Payment(double amount, int PatientID, int invoiceNo) {
		this.amount = amount;
		this.PatientID = PatientID;
		this.invoiceNo = invoiceNo;
		this.paymentNo = PAYMENTNO;
		Payment.PAYMENTNO++;
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
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public int getInvoiceNo() {
		return invoiceNo;
	}

	
	
}
