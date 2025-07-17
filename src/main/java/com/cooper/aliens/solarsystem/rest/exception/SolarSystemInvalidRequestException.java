package com.cooper.aliens.solarsystem.rest.exception;

public class SolarSystemInvalidRequestException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8948435296883918435L;

	public SolarSystemInvalidRequestException(String message) {
		super(message);
	}

	public SolarSystemInvalidRequestException(Throwable cause) {
		super(cause);
	}

	public SolarSystemInvalidRequestException(String message, Throwable cause) {
		super(message, cause);
	}


}
