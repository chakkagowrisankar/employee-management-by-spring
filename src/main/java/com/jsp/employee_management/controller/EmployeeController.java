package com.jsp.employee_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.employee_management.dto.Emp;
import com.jsp.employee_management.entity.Employee;
import com.jsp.employee_management.service.EmployeeService;
import com.jsp.employee_management.util.ResponseStructure;

import jakarta.mail.MessagingException;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService service;
	@PostMapping("/saveEmployee")
	public ResponseEntity<ResponseStructure<Emp>> saveEmployee(@RequestBody Employee emp){
		return service.saveEmployee(emp);
	}
	@PostMapping("/mail")
	public void  sendEmail() throws MessagingException {
		service.sendEmail();
		
	}
}
