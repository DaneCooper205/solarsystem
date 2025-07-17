package com.cooper.aliens.solarsystem.rest.exception;

public class SolarSystemNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -656339441870453387L;

	public SolarSystemNotFoundException(String message) {
		super(message);
	}

	public SolarSystemNotFoundException(Throwable cause) {
		super(cause);
	}

	public SolarSystemNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	
}
