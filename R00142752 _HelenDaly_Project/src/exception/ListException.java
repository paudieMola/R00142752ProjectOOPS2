package exception;



public class ListException extends Exception {
	public ListException(String exceptionText) {
		super("Cannot add to the list");
	}
}
