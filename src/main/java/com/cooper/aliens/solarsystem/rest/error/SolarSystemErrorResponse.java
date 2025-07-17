package com.cooper.aliens.solarsystem.rest.error;

public class SolarSystemErrorResponse extends ErrorResponse {

	public SolarSystemErrorResponse() {
		super();
	}

	public SolarSystemErrorResponse(int status, String message, long timestamp) {
		super(status, message, timestamp);
	}

}
