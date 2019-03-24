package list;

import classes.Invoice;

public class InvoiceList extends ObjectList {
	//list to hold invoices
	public InvoiceList() {
		super();//I'm not sure this would apply here. Check it out
	}
	
	public void addInvoice (Invoice invoice) {
		this.add(invoice);
	}
	
}
