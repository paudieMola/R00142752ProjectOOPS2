package list;

import classes.Payment;

public class PaymentList extends ObjectList {
	//list of payment objects
	public PaymentList() {
		super();
	}
	
	public void addPayment(Payment payment) {
		this.add(payment);
	}
}
