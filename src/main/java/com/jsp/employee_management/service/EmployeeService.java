package com.jsp.employee_management.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jsp.employee_management.config.EmailConfig;
import com.jsp.employee_management.dao.EmployeeDao;
import com.jsp.employee_management.dto.Emp;
import com.jsp.employee_management.dto.LoginEmployee;
import com.jsp.employee_management.entity.Education;
import com.jsp.employee_management.entity.Employee;
import com.jsp.employee_management.entity.Experience;
import com.jsp.employee_management.exception.NotFoundException;
import com.jsp.employee_management.util.ResponseStructure;

import jakarta.mail.MessagingException;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao dao;
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	EmailConfig config;

	public ResponseEntity<ResponseStructure<Emp>> saveEmployee(Employee e) throws MessagingException {
		ResponseStructure<Emp> rs = new ResponseStructure<Emp>();
		rs.setStateCode(HttpStatus.CREATED.value());
		rs.setMessage("Employee details saved Sucessfully..!");
		rs.setData(mapper.map(dao.saveEmployee(e), Emp.class));
		config.sendEmail(e.getEmail());
		return new ResponseEntity<ResponseStructure<Emp>>(rs, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Emp>> loginEmployee(LoginEmployee login) {
		Employee e = dao.findByEmail(login.getEmail());
		if(e!=null) {
			if(login.getPassword().equals(e.getPassword())) {
				ResponseStructure<Emp> rs = new ResponseStructure<Emp>();
				rs.setStateCode(HttpStatus.CONTINUE.value());
				rs.setMessage("Login sucessfully...!");
				rs.setData(mapper.map(e, Emp.class));
				return new ResponseEntity<ResponseStructure<Emp>>(rs,HttpStatus.CONTINUE);
			}else {
				throw new NotFoundException("password is not found exception");
			}
		}else {
			throw new NotFoundException("customer email "+login.getEmail()+"not found");
		}
	}
	
	public ResponseEntity<ResponseStructure<Emp>> findById(int id) {
		Employee emp=dao.findById(id);
		if(emp!=null) {
			ResponseStructure<Emp> rs = new ResponseStructure<Emp>();
			rs.setStateCode(HttpStatus.FOUND.value());
			rs.setMessage("Login sucessfully...!");
			rs.setData(mapper.map(emp, Emp.class));
			return new ResponseEntity<ResponseStructure<Emp>>(rs,HttpStatus.FOUND);
		}else {
			throw new NotFoundException("id is not found exception");
		}
		
	}

	public ResponseEntity<ResponseStructure<Emp>> deleteById(int id) {
		Employee emp=dao.findById(id);
		if(emp!=null) {
			dao.deleteById(emp);
			ResponseStructure<Emp> rs = new ResponseStructure<Emp>();
			rs.setStateCode(HttpStatus.ACCEPTED.value());
			rs.setMessage("deleted  sucessfully...!");
			rs.setData(mapper.map(emp, Emp.class));
			return new ResponseEntity<ResponseStructure<Emp>>(rs,HttpStatus.ACCEPTED);
		}else {
			throw new NotFoundException("id is not found exception");
		}
	}

	public ResponseEntity<ResponseStructure<Emp>> saveImageById(int id, MultipartFile file) throws IOException {
		Employee emp = dao.findById(id);
		if(emp!=null) {
			emp.setImage(file.getBytes());
			ResponseStructure<Emp> rs = new ResponseStructure<Emp>();
			rs.setStateCode(HttpStatus.ACCEPTED.value());
			rs.setMessage("image save sucessfully...!");
			rs.setData(mapper.map(dao.updateEmployee(emp), Emp.class));
			return new ResponseEntity<ResponseStructure<Emp>>(rs,HttpStatus.ACCEPTED);
		}else {
			throw new NotFoundException("id is not found exception");
		}
		
	}
	
	public ResponseEntity<byte[]>fetchImage(int id){
		Employee emp = dao.findById(id);
       if(emp!=null) {
    	   byte[]data=emp.getImage();
    	   if(data!=null) {
    		   HttpHeaders headers=new HttpHeaders();
    	   		headers.setContentType(MediaType.IMAGE_JPEG);
    	   		return new ResponseEntity<byte[]>(data,headers,HttpStatus.FOUND);
    	   	
    	   }
    	   else
        	   throw new NotFoundException("id is not found exception");

   		
       }else
    	   throw new NotFoundException("id is not found exception");
	}

	public ResponseEntity<ResponseStructure<Emp>> addEductionDetails(int id, Education ed) throws MessagingException {
		Employee emp = dao.findById(id);
		if(emp.getEd()==null) {
			List<Education> l = new ArrayList<Education>();
			l.add(ed);
			emp.setEd(l);
		}else {
			List<Education> l = emp.getEd();
			l.add(ed);
			emp.setEd(l);
		}
		ResponseStructure<Emp> rs = new ResponseStructure<Emp>();
		rs.setStateCode(HttpStatus.CREATED.value());
		rs.setMessage("Education details saved Sucessfully..!");
		rs.setData(mapper.map(dao.saveEmployee(emp), Emp.class));
		return new ResponseEntity<ResponseStructure<Emp>>(rs, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Emp>> saveExperienceDetails(int id, Experience ex) {
		Employee emp = dao.findById(id);
		if(emp.getEd()==null) {
			List<Experience> l = new ArrayList<Experience>();
			l.add(ex);
			emp.setEx(l);
		}else {
			List<Experience> l = emp.getEx();
			l.add(ex);
			emp.setEx(l);
		}
		ResponseStructure<Emp> rs = new ResponseStructure<Emp>();
		rs.setStateCode(HttpStatus.CREATED.value());
		rs.setMessage("Experience details saved Sucessfully..!");
		rs.setData(mapper.map(dao.saveEmployee(emp), Emp.class));
		return new ResponseEntity<ResponseStructure<Emp>>(rs, HttpStatus.CREATED);
	}

	
}
