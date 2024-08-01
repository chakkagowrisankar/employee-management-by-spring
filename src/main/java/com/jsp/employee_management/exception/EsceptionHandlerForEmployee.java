package com.jsp.employee_management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.employee_management.util.ResponseStructure;

@RestControllerAdvice
public class EsceptionHandlerForEmployee {
	@ExceptionHandler(java.sql.SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<ResponseStructure<String>> SQLIntegrityConstraintViolationException(
			java.sql.SQLIntegrityConstraintViolationException e) {
		ResponseStructure<String> rs = new ResponseStructure<String>();
		rs.setStateCode(HttpStatus.BAD_REQUEST.value());
		rs.setData(e.getMessage());
		rs.setMessage("can't perform operation");
		return new ResponseEntity<ResponseStructure<String>>(rs, HttpStatus.BAD_REQUEST);
	}
}
