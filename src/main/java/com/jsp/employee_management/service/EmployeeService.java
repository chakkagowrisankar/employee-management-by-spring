package com.jsp.employee_management.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.employee_management.dao.EmployeeDao;
import com.jsp.employee_management.dto.Emp;
import com.jsp.employee_management.entity.Employee;
import com.jsp.employee_management.util.ResponseStructure;
@Service
public class EmployeeService {
	@Autowired
	ModelMapper mapper;
	@Autowired
	EmployeeDao dao;
	public ResponseEntity<ResponseStructure<Emp>> saveEmployee(Employee e){
		ResponseStructure rs = new ResponseStructure();
		rs.setStateCode(HttpStatus.CREATED.value());
		rs.setMessage("Employee details saved Sucessfully..!");
		Employee emp = dao.saveEmployee(e);
		Emp em =mapper.map(emp, Emp.class);
		rs.setData(em);
		return new ResponseEntity<ResponseStructure<Emp>>(rs,HttpStatus.CREATED);
	}
}
