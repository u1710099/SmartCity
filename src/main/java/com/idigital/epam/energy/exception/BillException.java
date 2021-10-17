package com.idigital.epam.energy.exception;
public class BillException extends Exception{

private static final long serialVersionUID = 1L;
	
	private String message;

	public BillException() {
		
	}

	public BillException(String message) {
		super(message);
		this.message=message;
	}
	
	public BillException(String message,Exception e) {
		super(message,e);
		this.message=message;
	}

	@Override
	public String toString() {
		return "BillException [message=" + message + "]";
	}

	public String getMessage() {
		return message;
	}
	
	
	
}