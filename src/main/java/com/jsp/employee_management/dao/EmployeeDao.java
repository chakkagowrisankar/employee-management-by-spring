package com.jsp.employee_management.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.employee_management.entity.Employee;
import com.jsp.employee_management.repo.EmployeeRepo;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepo repoEmp;
	public Employee saveEmployee(Employee emp) {
		return repoEmp.save(emp);
	}
	public Employee findByEmail(String email,String password) {
		return repoEmp.findByEmail(email, password);
	}
	public String[] findAll(){
		String[] s=repoEmp.find();
		return s;
	}
}
