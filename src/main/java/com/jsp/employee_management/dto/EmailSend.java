package com.jsp.employee_management.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;
@Component
@Data
@NoArgsConstructor
public class EmailSend {
	private String[] to;
	private String subject;
	private String body;
	private String attachment;
	@Value("gowrisankar2223@gmail.com")
	private String from;
	public EmailSend(String body, String attachment, String from) {
		super();
		this.body = body;
		this.attachment = attachment;
		this.from = from;
	}
	public EmailSend(String body) {
		super();
		this.body = body;
	}
	
}
