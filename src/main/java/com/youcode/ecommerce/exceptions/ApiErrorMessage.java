package com.youcode.ecommerce.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ApiErrorMessage {

	private HttpStatus status;
	private int error;
	private String message;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyy hh:mm:ss")
	private LocalDateTime timestamp;

	public ApiErrorMessage() {
		this.timestamp = LocalDateTime.now();
	}

	public ApiErrorMessage(HttpStatus status, int error, String message) {
		this();
		this.status = status;
		this.error = error;
		this.message = message;
	}

	public ApiErrorMessage(String message) {
		super();
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "ApiErrorMessage [status=" + status + ", error=" + error + ", message=" + message + ", timestamp="
				+ timestamp + "]";
	}

}
