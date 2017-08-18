package util;

public class ApplicationException extends Exception {
	private Throwable innerException;
	private String message;
	
	
	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public ApplicationException(Throwable e, String message){
		this.innerException=e;
		this.setMessage(message);
	}
}
