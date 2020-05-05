package com.pedro.resources.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class ValidationError extends StandardError {

	private static final long serialVersionUID = 1L;
	
	private List<FieldMessage> errors = new ArrayList<>();

	public ValidationError(Integer status, String message, Long timestamp, MethodArgumentNotValidException e) {
		super(status, message, timestamp);
		for(FieldError x: e.getBindingResult().getFieldErrors()) {
			addError(x.getField(), x.getDefaultMessage());
		}
	}
	
	public void addError(String fieldName, String message) {
		errors.add(new FieldMessage(fieldName, message));
	}
	
	public void setErrors(List<FieldMessage> list) {
		this.errors = list;
	}
	
	public List<FieldMessage> getErrors() {
		return errors;
	}
}
