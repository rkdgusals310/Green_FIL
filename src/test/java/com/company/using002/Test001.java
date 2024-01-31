package com.company.using002;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.dto.MainContentDto;
import com.company.dto.UserDto;
import com.company.dto.UserVoDto;
import com.company.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
public class Test001 {

	@Autowired
	ApplicationContext context;

	@Autowired
	UserService service;

	@Autowired
	
	@Test 
	public void test0() {
		System.out.println(context);
	}

	@Test  @Ignore
	public void test1() {
		   UserVoDto vodto = new UserVoDto();
		   vodto.setUser_no(1000);
		   vodto.setGroup_no(1);
	        System.out.println("!!!!!!!!!!!"+vodto.getUser_no());
	        System.out.println("!!!!!!!!!!!"+vodto.getGroup_no());
	        System.out.println("@@@@@@"+service.contentList(vodto));
	}
	
	@Test @Ignore
	public void test2() {
		//System.out.println(service.select_admin());
		//System.out.println(service.readAll());
		UserDto dto=new UserDto();
		//dto.setUser_email("test22@naver.com");
		//System.out.println(service.admin_plus(dto));
		dto.setUser_email("admin@gmail.com");
		dto.setUser_pass("a456");
		
	}
}
