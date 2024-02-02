package com.company.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.api.Api_Mail;
import com.company.api.Kakao_login;
import com.company.api.Random;
import com.company.dto.UserDto;
import com.company.service.UserService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class ApiController {
	@Autowired Api_Mail mail;
	@Autowired Kakao_login kakao;
	@Autowired UserService service;
	@PostMapping("mail.js")
	@ResponseBody
	public String mail(UserDto dto) {
		Random random=new Random(); 
		String randomCode=random.random_code();
		mail.sendMail(dto, randomCode);
		return randomCode;
	}
	
	
	@RequestMapping("kakao.js")
	public String kakaoLogin(@RequestParam String code, Model model, HttpSession session) throws Exception {
		log.info("@@@@@code@@@@"+code);
		String token = kakao.kakaoToken(code);
		log.info("@@@@@@"+token);
		Map<String, Object> userinfo=kakao.getUserInfo(token);
		//model.addAttribute("code", code);
		//model.addAttribute("userinfo", userinfo);
		System.out.println("userinfo@@@@@@@@@@@@@@"+userinfo);
		UserDto dto=new UserDto();
		String email=(String) userinfo.get("email");
		String id=(String) userinfo.get("id");
		String nickname=(String) userinfo.get("nickname");
		String profile_image=(String) userinfo.get("profile_image");
		String birthday="1994"+(String) userinfo.get("birthday");
		String gender=(String) userinfo.get("gender");
		
		dto.setUser_email(email);
		dto.setUser_pass(id);
		dto.setUser_name(nickname);
		dto.setUser_birth(birthday);
		dto.setUser_sex(gender);
		
		service.insert_kakao(dto);
	
		//session.setAttribute("", userinfo);
		return "redirect:/home.js";
	}
	
}
