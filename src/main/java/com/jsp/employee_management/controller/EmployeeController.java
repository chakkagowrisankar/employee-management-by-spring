package com.jsp.employee_management.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jsp.employee_management.dao.EmployeeDao;
import com.jsp.employee_management.dto.Emp;
import com.jsp.employee_management.dto.LoginEmployee;
import com.jsp.employee_management.entity.Education;
import com.jsp.employee_management.entity.Employee;
import com.jsp.employee_management.entity.Experience;
import com.jsp.employee_management.service.EmployeeService;
import com.jsp.employee_management.util.ResponseStructure;

import jakarta.mail.MessagingException;


@RestController
public class EmployeeController {
	@Autowired
	EmployeeService service;

	@Autowired
	EmployeeDao dao;

	@PostMapping("/saveEmployee")
	public ResponseEntity<ResponseStructure<Emp>> saveEmployee(@RequestBody Employee emp) throws MessagingException {
		return service.saveEmployee(emp);
	}

	@GetMapping("/login")
	public ResponseEntity<ResponseStructure<Emp>> LoginEmployee(@RequestBody LoginEmployee login) {
		return service.loginEmployee(login);
	}

	@GetMapping("/findById")
	public ResponseEntity<ResponseStructure<Emp>> findById(@RequestParam int id) {
		return service.findById(id);
	}

	@DeleteMapping("deleteById")
	public ResponseEntity<ResponseStructure<Emp>> deleteById(@RequestParam int id) {
		return service.deleteById(id);
	}

	@PutMapping("/image")
	public ResponseEntity<ResponseStructure<Emp>> saveImage(@RequestParam int id, @RequestParam MultipartFile file)
			throws IOException {
		return service.saveImageById(id, file);
	}

	@GetMapping("/fetchImage")
	public ResponseEntity<byte[]> findById1(@RequestParam int id) {
		return service.fetchImage(id);
	}
	@PostMapping("/saveEducation")
	public ResponseEntity<ResponseStructure<Emp>> saveEducationDetails (@RequestParam int id,@RequestBody Education ed) throws MessagingException{
		
		return service.addEductionDetails(id, ed);
	}
	@PostMapping("/saveExperience")
	public ResponseEntity<ResponseStructure<Emp>> saveExperienceDetails(@RequestParam int id ,@RequestBody Experience ex){
		return service.saveExperienceDetails(id,ex);
	}
}
