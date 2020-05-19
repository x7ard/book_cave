package com.youcode.ecommerce.exceptions;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ApiExceptionHandler {

	public ResponseEntity<ApiErrorMessage> buildResponseEntity(ApiErrorMessage error) {
		return new ResponseEntity<>(error, error.getStatus());

	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ApiErrorMessage> notFound(Exception e) {
		return buildResponseEntity(new ApiErrorMessage(HttpStatus.NOT_FOUND, 404, "request page not found"));
	}

	@ExceptionHandler({ SQLException.class, DataAccessException.class })
	public ResponseEntity<ApiErrorMessage> databaseError(Exception e) {
		return buildResponseEntity(
				new ApiErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, 500, "an error occurred in database connection"));
	}

	@ExceptionHandler(IOException.class)
	public ResponseEntity<ApiErrorMessage> errorIO(Exception e) {
		return buildResponseEntity(
				new ApiErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, 500, "an error occurred in IO streams"));
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ApiErrorMessage> illegalArgumenterror(Exception e) {
		return buildResponseEntity(new ApiErrorMessage(HttpStatus.BAD_REQUEST, 400, e.getMessage()));
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiErrorMessage> errorHandler(Exception e) {
		return buildResponseEntity(new ApiErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, 500,
				e.getClass().getName() + " " + e.getMessage()));

	}

}
