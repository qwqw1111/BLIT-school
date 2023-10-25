package com.binarySchool.school.exception;
import java.time.LocalDateTime;

//would be a record, but it's java 14+
/*
public record ApiError(
		String path,
		
		String message,
		
		int errorCode,
		
		LocalDateTime timestamp
		)
*/
public class ApiError {
	
	String path;
	String message;
	int errorCode;
	LocalDateTime timestamp;
	
	
	
	public ApiError(String path, String message, int errorCode, LocalDateTime timestamp) {
		super();
		this.path = path;
		this.message = message;
		this.errorCode = errorCode;
		this.timestamp = timestamp;
	}
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "ApiError [path=" + path + ", message=" + message + ", errorCode=" + errorCode + ", timestamp="
				+ timestamp + "]";
	}
	
	
}