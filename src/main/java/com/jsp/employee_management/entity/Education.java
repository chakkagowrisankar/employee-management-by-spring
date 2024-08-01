package com.jsp.employee_management.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Education {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String CollageName;
	private String degree;
	private String stream;
	private Date yearOfPassOut;
	private double percentage;
	public Education(String collageName, String degree, String stream, Date yearOfPassOut, double percentage) {
		super();
		CollageName = collageName;
		this.degree = degree;
		this.stream = stream;
		this.yearOfPassOut = yearOfPassOut;
		this.percentage = percentage;
	}
}
