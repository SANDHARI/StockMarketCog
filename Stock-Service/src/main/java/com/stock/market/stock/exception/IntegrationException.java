package com.stock.market.stock.exception;


public class IntegrationException extends RuntimeException {

	private String userMessage;
	
	private int status;
	
	public IntegrationException(String message, String userMessage, int status) {
		super(message);
		this.userMessage = userMessage;
		this.status = status;
	}

	public IntegrationException(String message, Exception e) {
		super(message, e);
	}

	public String getUserMessage() {
		return userMessage;
	}

	public int getStatus() {
		return status;
	}
	
}
