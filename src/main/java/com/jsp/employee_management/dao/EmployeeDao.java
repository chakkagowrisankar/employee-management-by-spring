package com.jsp.employee_management.dao;

import java.util.Optional;

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
	public Employee findByEmail(String email) {
		return repoEmp.findByEmail(email);
	}
	public Employee findById(int id) {
		Optional<Employee> e = repoEmp.findById(id);
		if(e.isPresent()) {
			return e.get();
		}else {
			return null;
		}
	}
	public void deleteById(Employee e) {
		repoEmp.delete(e);
	}
	public Employee updateEmployee(Employee e) {
		return repoEmp.save(e);
	}
}
