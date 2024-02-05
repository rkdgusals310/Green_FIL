package com.company.api;

import org.springframework.stereotype.Component;

@Component
public class Random {
	public String random_code() {
		String code="";
		for(int i=0; i<4; i++) {			
			String random = String.valueOf((int)(Math.random()*10));
			code+=random;
		}
		System.out.println(code);
		return code;
	}
	
	public String random_mobile() {
		String code="010";
		for(int i=0; i<8; i++) {
			
			String random=String.valueOf((int)(Math.random()*10));
			code+=random;
		}
		System.out.println("@@@@"+code);
		
		return code;
	}
}
