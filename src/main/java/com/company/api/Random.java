package com.company.api;

import java.util.ArrayList;
import java.util.List;

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
	
	public List<String> random_api(List<String> list) {
		List<String> randomList=new ArrayList<>();
		for(int i=0; i<3; i++) {
			int random=((int)(Math.random()*list.size()));
			System.out.println(list.get(random)); 
			randomList.add(list.get(random));
		}
		
		return randomList;
	}
}
