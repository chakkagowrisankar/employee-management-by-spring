package com.jsp.employee_management.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Emp {
	private int id;
	private String fName;
	private String mName;
	private String lName;
	private String email;
	private long phoneNumber;
}
