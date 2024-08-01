package com.jsp.employee_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.employee_management.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
