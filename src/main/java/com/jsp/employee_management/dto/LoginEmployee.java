package com.jsp.employee_management.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginEmployee {
	private String email;
	private String password;
}
