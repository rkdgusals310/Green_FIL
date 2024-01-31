package com.company.api;

public class Random {
	public String random_code() {
		String code="";
		for(int i=0; i<4; i++) {			
			String random = String.valueOf((int)Math.floor(Math.random()*10));
			code+=random;
		}
		System.out.println(code);
		return code;
	}
}
