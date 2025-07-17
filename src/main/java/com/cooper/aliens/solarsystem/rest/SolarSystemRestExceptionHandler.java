package com.cooper.aliens.solarsystem.rest;

import com.cooper.aliens.solarsystem.rest.error.SolarSystemErrorResponse;
import com.cooper.aliens.solarsystem.rest.exception.SolarSystemDuplicateException;
import com.cooper.aliens.solarsystem.rest.exception.SolarSystemInvalidRequestException;
import com.cooper.aliens.solarsystem.rest.exception.SolarSystemNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SolarSystemRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<SolarSystemErrorResponse>handleException( SolarSystemNotFoundException exc){
		SolarSystemErrorResponse error = new SolarSystemErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<SolarSystemErrorResponse>handleException( SolarSystemDuplicateException exc){
		SolarSystemErrorResponse error = new SolarSystemErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler
	public ResponseEntity<SolarSystemErrorResponse>handleException( SolarSystemInvalidRequestException exc){
		SolarSystemErrorResponse error = new SolarSystemErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
