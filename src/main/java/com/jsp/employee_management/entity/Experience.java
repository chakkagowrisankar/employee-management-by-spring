package com.jsp.employee_management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Experience {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String companyName;
	private double yearOfExperience;
	private double lengthOfExperience;
	private String designation;
	public Experience(String companyName, double yearOfExperience, double lengthOfExperience, String designation) {
		super();
		this.companyName = companyName;
		this.yearOfExperience = yearOfExperience;
		this.lengthOfExperience = lengthOfExperience;
		this.designation = designation;
	}
}
