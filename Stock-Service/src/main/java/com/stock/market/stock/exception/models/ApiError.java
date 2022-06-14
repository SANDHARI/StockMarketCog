package com.stock.market.stock.exception.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

//@Getter
//@AllArgsConstructor
public class ApiError {

    private HttpStatus status;

    private String message;

    private List<String> errors;

    public ApiError(HttpStatus status, String message, String errors) {
        this.status = status;
        this.message = message;
        this.errors = Collections.singletonList(errors);
    }

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public ApiError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApiError(HttpStatus status, String message, List<String> errors) {
		super();
		this.status = status;
		this.message = message;
		this.errors = errors;
	}
	
    
    
}
