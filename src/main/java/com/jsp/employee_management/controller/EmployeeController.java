package com.jsp.employee_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.employee_management.dto.Emp;
import com.jsp.employee_management.dto.LoginEmployee;
import com.jsp.employee_management.entity.Employee;
import com.jsp.employee_management.service.EmployeeService;
import com.jsp.employee_management.util.ResponseStructure;

import jakarta.mail.MessagingException;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService service;
	@PostMapping("/saveEmployee")
	public ResponseEntity<ResponseStructure<Emp>> saveEmployee(@RequestBody Employee emp) throws MessagingException{
		return service.saveEmployee(emp);
	}
	@GetMapping("/login")
	public ResponseEntity<ResponseStructure<Emp>> LoginEmployee(@RequestBody LoginEmployee login){
		return service.loginEmployee(login);
	}
	@GetMapping("/findById")
	public ResponseEntity<ResponseStructure<Emp>> findById(@RequestParam int id){
		return service.findById(id);
	}
	@DeleteMapping("deleteById")
	public ResponseEntity<ResponseStructure<Emp>> deleteById(@RequestParam int id){
		return service.deleteById(id);
	}
	
}
