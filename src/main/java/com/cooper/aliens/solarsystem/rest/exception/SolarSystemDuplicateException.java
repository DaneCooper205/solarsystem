package com.cooper.aliens.solarsystem.rest.exception;

public class SolarSystemDuplicateException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7443905277925355280L;

	public SolarSystemDuplicateException(String message) {
		super(message);
	}

	public SolarSystemDuplicateException(Throwable cause) {
		super(cause);
	}

	public SolarSystemDuplicateException(String message, Throwable cause) {
		super(message, cause);
	}

}
