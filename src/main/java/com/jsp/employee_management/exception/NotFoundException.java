package com.jsp.employee_management.exception;

import lombok.Data;

@Data
public class NotFoundException extends RuntimeException{
	public NotFoundException(String massage) {
		super(massage);
	}
}
