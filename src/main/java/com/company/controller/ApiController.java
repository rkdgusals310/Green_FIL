package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.api.Api_Mail;
import com.company.api.Random;
import com.company.dto.UserDto;

@Controller
public class ApiController {
	@Autowired Api_Mail mail;
	
	@PostMapping("mail.js")
	@ResponseBody
	public String mail(UserDto dto) {
		Random random=new Random(); 
		String randomCode=random.random_code();
		mail.sendMail(dto, randomCode);
		return randomCode;
		
	}

	
}
