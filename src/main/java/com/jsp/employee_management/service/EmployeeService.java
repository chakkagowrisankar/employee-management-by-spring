package com.jsp.employee_management.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.employee_management.config.EmailConfig;
import com.jsp.employee_management.dao.EmployeeDao;
import com.jsp.employee_management.dto.Emp;
import com.jsp.employee_management.dto.LoginEmployee;
import com.jsp.employee_management.entity.Employee;
import com.jsp.employee_management.exception.NotFoundException;
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

	public ResponseEntity<ResponseStructure<Emp>> loginEmployee(LoginEmployee login) {
		Employee e = dao.findByEmail(login.getEmail());
		if(e!=null) {
			if(login.getPassword().equals(e.getPassword())) {
				ResponseStructure<Emp> rs = new ResponseStructure<Emp>();
				rs.setStateCode(HttpStatus.CONTINUE.value());
				rs.setMessage("Login sucessfully...!");
				rs.setData(mapper.map(e, Emp.class));
				return new ResponseEntity<ResponseStructure<Emp>>(rs,HttpStatus.CONTINUE);
			}else {
				throw new NotFoundException("password is not found exception");
			}
		}else {
			throw new NotFoundException("email is not found exception");
		}
	}
	
	public ResponseEntity<ResponseStructure<Emp>> findById(int id) {
		Employee emp=dao.findById(id);
		if(emp!=null) {
			ResponseStructure<Emp> rs = new ResponseStructure<Emp>();
			rs.setStateCode(HttpStatus.FOUND.value());
			rs.setMessage("Login sucessfully...!");
			rs.setData(mapper.map(emp, Emp.class));
			return new ResponseEntity<ResponseStructure<Emp>>(rs,HttpStatus.FOUND);
		}else {
			throw new NotFoundException("id is not found exception");
		}
		
	}

	public ResponseEntity<ResponseStructure<Emp>> deleteById(int id) {
		Employee emp=dao.findById(id);
		if(emp!=null) {
			dao.deleteById(emp);
			ResponseStructure<Emp> rs = new ResponseStructure<Emp>();
			rs.setStateCode(HttpStatus.ACCEPTED.value());
			rs.setMessage("deleted  sucessfully...!");
			rs.setData(mapper.map(emp, Emp.class));
			return new ResponseEntity<ResponseStructure<Emp>>(rs,HttpStatus.ACCEPTED);
		}else {
			throw new NotFoundException("id is not found exception");
		}
	}

	
}
