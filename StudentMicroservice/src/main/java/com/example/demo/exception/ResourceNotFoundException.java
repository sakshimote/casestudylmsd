package com.example.demo.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	
	private String resourceName;
	private String fieldName;
	private Long fieldValue;
	
	public ResourceNotFoundException(String resourcName,String fieldName,Long fieldValue) {
		super(String.format("%s not found with  %s :'%s'", resourcName,fieldName,fieldValue));

		this.fieldName=fieldName;
		this.resourceName=resourcName;
		this.fieldValue=fieldValue;
}
}
