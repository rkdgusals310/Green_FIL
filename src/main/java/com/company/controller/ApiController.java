package com.company.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.api.Api_Mail;
import com.company.api.Kakao_login;
import com.company.api.Naver_login;
import com.company.api.Random;
import com.company.api.SeoulApi;
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
	@Autowired SeoulApi seoul;
	
	@PostMapping("mail_user.js")
	@ResponseBody
	public String mail_user(UserDto dto) {
		Random random=new Random(); 
		String randomCode=random.random_code();
		String sub="[날씨의 일기] 회원가입 인증 코드입니다.";
		String content="인증코드 : ";
		mail.sendMail(dto, randomCode, sub, content);
		return randomCode;
	}
	
	@PostMapping("mail_pass.js")
	@ResponseBody
	public String mail_pass(UserDto dto) {
		Random random=new Random(); 
		String randomCode=random.random_code();
		String sub="";
		String content="";
		mail.sendMail(dto, randomCode, sub, content);
		return randomCode;
	}
	
	@PostMapping("mail_admin.js")
	@ResponseBody
	public String mail_admin(UserDto dto) {
		Random random=new Random(); 
		String randomCode=random.random_code();
		String sub="";
		String content="";
		mail.sendMail(dto, randomCode, sub, content);
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
		  String name=(String) userinfo.get("nickname");
		  String gender=(String) userinfo.get("gender");
		  
		  request.setAttribute("name", name);
		  request.setAttribute("gender", gender);
		  request.setAttribute("email", email);
		  
		  return "signup_api";
		
		}
	}
	
	@RequestMapping("naver.js")
	public String naverLogin(@RequestParam String code,Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		/*
		 * request.setCharacterEncoding("UTF-8");
		 * response.setContentType("text/html, charset=UTF-8");
		 */
		log.info("code@@@@:"+code);
		String token=naver.naverLogin(code);
		log.info("token@@@:"+token);
		Map<String, Object> userinfo=naver.getUserInfo(token);
		log.info("userinfo@@@@@: "+userinfo);
		session=request.getSession();
		UserDto dto= new UserDto();
		
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
		  
		  request.setAttribute("mobile", mobile);
		  request.setAttribute("name", name);
		  request.setAttribute("gender", gender);
		  request.setAttribute("birth", birth);
		  request.setAttribute("email", email);
		  return "signup_api";
		}

	}
	
	@GetMapping("historyTour.js")
	public String Tour_Api() throws Exception {
		Map<String, Object> seoulInfo=seoul.historyTour();
		List<Map<String, Object>> seoulInfoList= (List<Map<String, Object>>) seoulInfo.get("seoulInfo");
		int index=0;
		for(Map<String, Object> map: seoulInfoList) {
			String No = map.get("No").toString();
			String Title = map.get("Title").toString();
			String Content = map.get("Content").toString();
			
			System.out.println(No);
		}
		System.out.println(index);
		System.out.println();
		return "redirect:/home.js";
	}
	
}
