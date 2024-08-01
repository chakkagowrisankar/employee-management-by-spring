package com.jsp.employee_management.util;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class ResponseStructure<T> {
	private int stateCode;
	private String message;
	private T data;
	private LocalDateTime time = LocalDateTime.now();
}
