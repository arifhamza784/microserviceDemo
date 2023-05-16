package com.backend.app.ws.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.backend.app.ws.ui.model.response.ErrorMessage;

@ControllerAdvice
public class AppExceptionsHandler {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> handleAnyException(Exception e, WebRequest request){
		
		String errorMessageDescription = e.getLocalizedMessage();
		if(errorMessageDescription == null) errorMessageDescription = e.toString();
		
		ErrorMessage error = new ErrorMessage(new Date(), errorMessageDescription);
		
		return new ResponseEntity<Object>(error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = {UserserviceException.class, NullPointerException.class})
	public ResponseEntity<Object> handleSpecificException(Exception e, WebRequest request){

		String errorMessageDescription = e.getLocalizedMessage();
		if(errorMessageDescription == null) errorMessageDescription = e.toString();

		ErrorMessage error = new ErrorMessage(new Date(), errorMessageDescription );

		return new ResponseEntity<Object>(error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
