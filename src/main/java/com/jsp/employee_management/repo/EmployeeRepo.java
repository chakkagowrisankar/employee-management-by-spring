package com.jsp.employee_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.employee_management.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	@Query("select a from Employee a where email=?1 and password=?2")
	Employee findByEmail(String email,String password);
}
