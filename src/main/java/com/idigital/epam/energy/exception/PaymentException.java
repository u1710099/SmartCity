package com.idigital.epam.energy.exception;
public class PaymentException extends Exception{

private static final long serialVersionUID = 1L;
	
	private String message;

	public PaymentException() {
		
	}

	public PaymentException(String message) {
		super(message);
		this.message=message;
	}
	
	public PaymentException(String message,Exception e) {
		super(message,e);
		this.message=message;
	}

	@Override
	public String toString() {
		return "PaymentException [message=" + message + "]";
	}

	public String getMessage() {
		return message;
	}
	
	
}
