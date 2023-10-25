package com.binarySchool.school.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DefaultExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleException(ResourceNotFoundException e, HttpServletRequest request){
		ApiError apiError = new ApiError(
				request.getRequestURI(),
				e.getMessage(),
				HttpStatus.NOT_FOUND.value(),
				LocalDateTime.now()
				);
		return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
	}
}
