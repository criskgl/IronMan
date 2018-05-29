package agc.exceptions;

public class AGCException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;
	
	// Effort spent: 1.5 minutos
	public AGCException (String message){
		
		this.message = message;
	}
	
	// Effort spent: 1.5 minutos	
	public String getMessage(){
		
		return this.message;
	}
	
}
