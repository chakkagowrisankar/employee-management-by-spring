package com.jsp.employee_management.service;

import java.io.File;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.aot.generate.FileSystemGeneratedFiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.jsp.employee_management.dao.EmployeeDao;
import com.jsp.employee_management.dto.EmailSend;
import com.jsp.employee_management.dto.Emp;
import com.jsp.employee_management.entity.Employee;
import com.jsp.employee_management.util.ResponseStructure;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao dao;
	@Autowired
	ModelMapper mapper;

	public ResponseEntity<ResponseStructure<Emp>> saveEmployee(Employee e) {
		ResponseStructure rs = new ResponseStructure();
		rs.setStateCode(HttpStatus.CREATED.value());
		rs.setMessage("Employee details saved Sucessfully..!");
		Employee emp = dao.saveEmployee(e);
		Emp em = mapper.map(emp, Emp.class);
		rs.setData(em);
		return new ResponseEntity<ResponseStructure<Emp>>(rs, HttpStatus.CREATED);
	}

	@Autowired
	JavaMailSender sender;
	@Autowired
	EmailSend es;

	public void sendEmail() throws MessagingException {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper messages = new MimeMessageHelper(message, true);
		messages.setTo(dao.findAll());
		message.setSubject("Test email from Spring");
		String htmlContent = "<h1>This is a test Spring Boot email</h1>"
				+ "<p>It can contain <strong>HTML</strong> content.</p>";
		message.setContent(htmlContent, "text/html; charset=utf-8");

		//messages.setText(es.getBody());
		FileSystemResource file = new FileSystemResource(new File("ComposeCamp.png"));
		messages.addAttachment("ComposeCamp.png", file);

		sender.send(message);
	}
}
