package classes;
import java.io.Serializable;
import java.util.Date;
import list.PaymentList;
import list.ProcedureList;

public class Invoice implements Serializable{
	//for invoice No and amount. Create a constructor taking in parameters from appointment
	
	static int INVOICENO = 1;
	private int invoiceNo;
	private Date invoiceDate;
	private double totalAmount;
	private double paymentsMade;
	private PaymentList payments;
	private ProcedureList procedures;
	private boolean paid = false;
	private String patientName;
	private int patientID;
	
	public Invoice(ProcedureList procedures, String patientName, int patientID) {
		this.procedures = procedures;
		this.patientName = patientName;
		this.patientID = patientID;
		this.invoiceNo = INVOICENO;
		Invoice.INVOICENO++;
	}
	
	//gets and sets
	public int getInvoiceNo() {return invoiceNo;}
	public Date getInvoiceDate() {return invoiceDate;}
	public void setInvoiceDate(Date invoiceDate) {this.invoiceDate = invoiceDate;}
	public double getTotalAmount() {return totalAmount;}
	public void setTotalAmount(int totalAmount) {this.totalAmount = totalAmount;}//add up prices here
	
	public void makePayment(double amountPaid) {//to add payments 
		Payment paymentMade = new Payment(amountPaid, patientID, invoiceNo);
		this.payments = new PaymentList();
		payments.add(paymentMade);
	}
	
}
