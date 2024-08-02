package com.jsp.employee_management.config;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.jsp.employee_management.dto.EmailSend;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Component
public class EmailConfig {
	
	
	@Autowired
	JavaMailSender sender;
	@Autowired
	EmailSend es;

	public void sendEmail(String email) throws MessagingException {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper messages = new MimeMessageHelper(message, true);
		messages.setTo(email);
		message.setSubject("Registraion successfull😊");
		String htmlContent = "<h1>This is a test Spring Boot email</h1>"
				+ "<p>It can contain <strong>HTML</strong> content.</p>";
		message.setContent(htmlContent, "text/html; charset=utf-8");

		//messages.setText(es.getBody());
		FileSystemResource file = new FileSystemResource(new File("ComposeCamp.png"));
		messages.addAttachment("ComposeCamp.png", file);

		sender.send(message);
	}
	
	

}
