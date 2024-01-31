package com.company.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.dto.UserDto;
import com.company.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService service;

	@GetMapping("/home.js")
	public String home() {
		return "start";
	}

	@GetMapping("/login.js")
	public String login_view() {
		return "login";
	}

	@PostMapping("/login.js")
	public String login(UserDto dto, HttpServletRequest request, HttpSession session) {
		session = request.getSession();
		if (service.loginUser(dto) != null) {
			session.setAttribute("login", service.loginUser(dto));
			return "redirect:/home.js";
		} else {
			return "login";
		}

	}

	/*
	  @PostMapping(value = "/login_match.js", produces =
	  "application/json;charset=UTF-8")
	  
	  @ResponseBody public Map<String, String> login_match(UserDto dto){
	  System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+dto.
	  getUser_email());
	  System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+dto.
	  getUser_pass()); Map<String, String> result=new HashMap<>();
	  
	  if(service.loginUser(dto) == null) { result.put("result", "abcdefg");
	 System.out.println(result); };
	  
	  return result; }
	 */
	@GetMapping("/logout.js")
	public String logout(HttpSession session) {
		session.invalidate();
		return "start";
	}

	@RequestMapping(value = "/mypage.js", method = { RequestMethod.GET, RequestMethod.POST })
	public String mypage_view(Model model, UserDto dto) {
		model.addAttribute("myinfo", service.select_user(dto));
		return "mypage";
	}

	@RequestMapping(value = "/mypage_edit.js", method = RequestMethod.GET)
	public String mypage_edit_view(Model model, UserDto dto) {
		model.addAttribute("myinfo", service.select_user(dto));
		return "mypage_edit";
	}

	@RequestMapping(value = "/mypage_edit.js", method = RequestMethod.POST)
	public String mypage_edit(Model model, UserDto dto) {
		service.update_user(dto);
		return "redirect:/mypage.js?user_no=" + dto.getUser_no();
	}

	@GetMapping("/sign_agree.js")
	public String sign_agree() {
		return "sign_agree";
	}

	@GetMapping("/signup.js")
	public String sign_view() {
		return "signup";
	}

	@RequestMapping(value = "/signup_2.js", method = { RequestMethod.GET, RequestMethod.POST })
	public String sign() {

		return "signup_2";
	}

	@PostMapping("signinsert.js")
	public String sign_insert(UserDto dto) {
		service.insert_user(dto);

		return "login";
	}
	
	@GetMapping("adminpage_list.js")
	public String adminpage_list_view(Model model) {
		model.addAttribute("list", service.readAll());
		model.addAttribute("admin_list", service.select_admin());
		return "adminpage_list";
	}

	/*
	 * @RequestMapping(value = "ex_adminpage_list.js", // produces =
	 * "application/json", headers = { "Content-type=application/json" }, method = {
	 * RequestMethod.GET, RequestMethod.POST })
	 * 
	 * @ResponseBody public Map<String, Object> readAll() { Map<String, Object>
	 * result = new HashMap<>(); result.put("result", service.select_admin());
	 * return result; }
	 */

	@GetMapping("admin_plus.js")
	
	public String admin_plus(UserDto dto) {
		service.admin_plus(dto);
		service.delete_myconetent(dto);
		return "redirect:/adminpage_list.js";
	}

	@RequestMapping(value = "ex_admin_plus.js",
			headers = { "Content-type=application/json" }, method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> ex_admin_plus(String user_email) {
		// System.out.println("............" + user_email);
		UserDto dto = new UserDto();
		dto.setUser_email(user_email);
		// System.out.println("............" + dto);
		Map<String, Object> result = new HashMap<>();
		int process = service.admin_plus(dto);
		result.put("result", service.admin_plus(dto));

		System.out.println("............process >>>>>>>>>>" + process);
		return result;
	}

	@GetMapping("admin_delete.js")
	public String admin_delete(UserDto dto) {
		service.admin_delete(dto);
		return "redirect:/adminpage_list.js";
	}

	@GetMapping("/findid.js")
	public String findid_view() {

		return "findid";
	}

	@PostMapping("/findid_2.js")
	public String findid(UserDto dto, Model model) {

		model.addAttribute("id", service.find_id(dto));
		return "findid_2";
	}

	@GetMapping("/findpass.js")
	public String findpass_view() {
		return "findpass";
	}

	@PostMapping("/findpass_2.js")
	public String findpass(UserDto dto, Model model) {
		model.addAttribute("pass", service.find_pass(dto));
		return "findpass_2";
	}

	@GetMapping("/delete_user.js")
	public void delete_user_view() {
	}

	@PostMapping("/delete_user.js")
	public String delete_user(UserDto dto, HttpSession session) {
		service.delete_user(dto);
		session.invalidate();
		return "delete_finish";
	}

	@GetMapping("/kill_user.js")
	public String delete_user(UserDto dto) {
		service.delete_user(dto);
		return "redirect:/adminpage_list.js";
	}  
}
