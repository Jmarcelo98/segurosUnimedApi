package com.example.api.config.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.api.handlers.BusinessException;
import com.example.api.handlers.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<Object> handleBusinessException(BusinessException ex, WebRequest request) {

		var headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		var status = HttpStatus.BAD_REQUEST;
		var body = new ResponseError();

		body.setCode(status.value());
		body.setDescription(ex.getMessage());
		return handleExceptionInternal(ex, body, headers, status, request);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {

		var headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		var status = HttpStatus.NOT_FOUND;
		var body = new ResponseError();

		body.setCode(status.value());
		body.setDescription(ex.getMessage());
		return handleExceptionInternal(ex, body, headers, status, request);
	}

}