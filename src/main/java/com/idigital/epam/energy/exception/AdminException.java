package com.idigital.epam.energy.exception;

public class AdminException extends Exception{
	private String message;

	public AdminException() {

	}

	public AdminException(String message) {
		super(message);
		this.message=message;
	}

	public AdminException(String message,Exception e) {
		super(message,e);
		this.message=message;
	}

	@Override
	public String toString() {
		return "AdminException [message=" + message + "]";
	}

	public String getMessage() {
		return message;
	}



}
