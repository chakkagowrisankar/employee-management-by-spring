package com.jsp.employee_management.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String fName;
	private String mName;
	private String lName;
	@Column(unique = true,nullable = false)
	private String email;
	private String password;
	private String gender;
	private int age;
	@Column(unique = true,nullable = false)
	private long phoneNumber;
	private Date dateOfBirth;
	@Lob
	@Column(columnDefinition = "LONGBLOB",length = Integer.MAX_VALUE)
	private byte[] image ;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Education> ed;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Experience> ex;
	public Employee(String fName, String mName, String lName, String email, String password, String gender, int age,
			long phoneNumber, Date dateOfBirth, byte[] image, List<Education> ed, List<Experience> ex) {
		super();
		this.fName = fName;
		this.mName = mName;
		this.lName = lName;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.image = image;
		this.ed = ed;
		this.ex = ex;
	}
	public Employee(String fName, String mName, String lName, String email, String password, String gender, int age,
			long phoneNumber, Date dateOfBirth) {
		super();
		this.fName = fName;
		this.mName = mName;
		this.lName = lName;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
	}
	public Employee(String fName, String mName, String lName, String email, String password, long phoneNumber) {
		super();
		this.fName = fName;
		this.mName = mName;
		this.lName = lName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}
}
