package com.company.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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
import com.company.api.Naver_login;
import com.company.api.Random;
import com.company.dto.UserDto;
import com.company.service.UserService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class ApiController {
	@Autowired Api_Mail mail;
	@Autowired Kakao_login kakao;
	@Autowired Naver_login naver;
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
	public String kakaoLogin(@RequestParam String code, Model model, HttpServletRequest request, HttpSession session ) throws Exception {
		log.info("@@@@@code@@@@"+code);
		String token = kakao.kakaoToken(code);
		log.info("@@@@@@"+token);
		Map<String, Object> userinfo=kakao.getUserInfo(token);
		//model.addAttribute("code", code);
		//model.addAttribute("userinfo", userinfo);
		log.info("userinfo@@@@@@@@@@@@@@"+userinfo);
		
		session=request.getSession();
		UserDto dto=new UserDto();
		String profile_image=(String) userinfo.get("profile_image");
		String email=(String) userinfo.get("email");
		String id=(String) userinfo.get("id");
		
		dto.setUser_email(email);
		UserDto list=service.loginInfo(dto);
		if(list!=null) {
			
		
		String birth=list.getUser_birth();
		String mobile=list.getUser_mobile();
		String user_pass=list.getUser_pass();
		String user_sex=list.getUser_sex();
		String user_name=list.getUser_name();
		
		dto.setUser_birth(birth);
		dto.setUser_mobile(mobile);
		dto.setUser_pass(user_pass);
		dto.setUser_sex(user_sex);
		dto.setUser_name(user_name);
		dto.setUser_login(id);
		service.insert_api(dto);
		if(service.loginUser(dto)!=null) {
			session.setAttribute("login", service.loginUser(dto) );
			return "redirect:/home.js";
			}else {
				return "login";
			}
		}
		else {
			Random random = new Random();
	  String random_mobile=random.random_mobile();
	  String nickname=(String) userinfo.get("nickname");
	  String birthday="2024"+(String) userinfo.get("birthday");
	  String gender=(String) userinfo.get("gender");
	  
		dto.setUser_mobile(random_mobile);
		dto.setUser_email(email);
		dto.setUser_pass(id);
		dto.setUser_name(nickname);
		dto.setUser_birth(birthday);
		dto.setUser_sex(gender);
			
		if(service.loginUser(dto)==null) {
		service.insert_api(dto);
		} 
			if(service.loginUser(dto)!=null) {
			session.setAttribute("login", service.loginUser(dto) );
			return "redirect:/home.js";
			}else {
				return "login";
			}
		}
	}
	
	@RequestMapping("naver.js")
	public String naverLogin(@RequestParam String code,Model model, HttpServletRequest request, HttpSession session) throws Exception {
		log.info("code@@@@:"+code);
		String token=naver.naverLogin(code);
		log.info("token@@@:"+token);
		Map<String, Object> userinfo=naver.getUserInfo(token);
		log.info("userinfo@@@@@: "+userinfo);
		session=request.getSession();
		UserDto dto= new UserDto();
		
		String profile_image=(String) userinfo.get("profile_image");
		String id=(String) userinfo.get("id");
		String email=(String) userinfo.get("email");

		dto.setUser_email(email);
		UserDto list=service.loginInfo(dto);
		if(list != null) {			
			String birth=list.getUser_birth();
			String mobile=list.getUser_mobile();
			String user_pass=list.getUser_pass();
			String user_sex=list.getUser_sex();
			String user_name=list.getUser_name();
			
			dto.setUser_birth(birth);
			dto.setUser_mobile(mobile);
			dto.setUser_pass(user_pass);
			dto.setUser_sex(user_sex);
			dto.setUser_name(user_name);
			dto.setUser_login(id);
			service.insert_api(dto);
			if(service.loginUser(dto)!=null) {
				session.setAttribute("login", service.loginUser(dto) );
				return "redirect:/home.js";
				}else {
					return "login";
				}
		}
		else {
			
		  String birthday=(String) userinfo.get("birthday"); 
		  String gender=(String) userinfo.get("gender");
		  String birthyear=(String) userinfo.get("birthyear");
		  String name=(String) userinfo.get("name"); 
		  String mobile=(String) userinfo.get("mobile"); 
		  mobile=mobile.replaceAll("[^0-9]", ""); 
		  String birth=birthyear+"-"+birthday;
		  dto.setUser_pass(id);
		  dto.setUser_mobile(mobile);
		  dto.setUser_name(name);
		  dto.setUser_sex(gender);
		  dto.setUser_birth(birth);
		 
		  service.insert_user(dto);
	
			if(service.loginUser(dto)!=null) {
			session.setAttribute("login", service.loginUser(dto) );
			return "redirect:/home.js";
			}else {
				return "login";
			}
			//alter table user modify user_pass varchar(100) not null;
			//delete from user where user_no order by user_no desc limit 1;
			//delete from user where user_no=(select user_no from user order by user_no desc limit 1)l
			//alter table user modify user_login varchar(10) default 'basic'; 
		}

	}
	
}
