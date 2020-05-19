package com.youcode.ecommerce.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 5158636503884298713L;

	public ResourceNotFoundException() {
		super();
	}

	public ResourceNotFoundException(String message, Throwable error) {
		super(message, error);
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}

}
