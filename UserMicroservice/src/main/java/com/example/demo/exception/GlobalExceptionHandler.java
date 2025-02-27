package com.example.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	
@ExceptionHandler(ResourceNotFoundException.class)
	
	public ResponseEntity<ErrorDetails> handleResourceNoFoundException(ResourceNotFoundException exception,
			WebRequest webRequest){
		
		ErrorDetails errorDetails=new ErrorDetails(
				LocalDateTime.now(),
				exception.getMessage(),
				webRequest.getDescription(false),
				"USER_NOT_FOUND");
		
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
	}
}