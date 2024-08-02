package com.jsp.employee_management.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.employee_management.config.EmailConfig;
import com.jsp.employee_management.dao.EmployeeDao;
import com.jsp.employee_management.dto.Emp;
import com.jsp.employee_management.entity.Employee;
import com.jsp.employee_management.util.ResponseStructure;

import jakarta.mail.MessagingException;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao dao;
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	EmailConfig config;

	public ResponseEntity<ResponseStructure<Emp>> saveEmployee(Employee e) throws MessagingException {
		ResponseStructure<Emp> rs = new ResponseStructure<Emp>();
		rs.setStateCode(HttpStatus.CREATED.value());
		rs.setMessage("Employee details saved Sucessfully..!");
		rs.setData(mapper.map(dao.saveEmployee(e), Emp.class));
		config.sendEmail(e.getEmail());
		return new ResponseEntity<ResponseStructure<Emp>>(rs, HttpStatus.CREATED);
	}

	
}
