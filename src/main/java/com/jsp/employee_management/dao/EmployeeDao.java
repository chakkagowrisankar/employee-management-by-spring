package com.jsp.employee_management.dao;

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
}
