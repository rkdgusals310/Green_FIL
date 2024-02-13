package com.company.using002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.api.Random;
import com.company.dto.UserDto;
import com.company.dto.UserVoDto;
import com.company.service.UserService;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


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
	 
	@Test @Ignore
	public void test3() {
		Random random= new Random();
		
		System.out.println(random.random_code());
	}
	@Test //@Ignore
	public void test88() throws IOException {
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=a984mZ0ZgsZHKbw2kSM1f4SU7fXWjOvnmDah0hIkAlX%2BtNc0hZv0RK7Vgs36dQ7yXjoK8ZBn%2FcZ9dJecwiHKcA%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1000", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("XML", "UTF-8")); /*요청자료형식(XML/JSON) Default: XML*/
        urlBuilder.append("&" + URLEncoder.encode("base_date","UTF-8") + "=" + URLEncoder.encode("20240213", "UTF-8")); /*‘21년 6월 28일 발표*/
        urlBuilder.append("&" + URLEncoder.encode("base_time","UTF-8") + "=" + URLEncoder.encode("0600", "UTF-8")); /*06시 발표(정시단위) */
        urlBuilder.append("&" + URLEncoder.encode("nx","UTF-8") + "=" + URLEncoder.encode("55", "UTF-8")); /*예보지점의 X 좌표값*/
        urlBuilder.append("&" + URLEncoder.encode("ny","UTF-8") + "=" + URLEncoder.encode("127", "UTF-8")); /*예보지점의 Y 좌표값*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
        System.out.println("안녕하세요");
	}
	
	@Test @Ignore
	public void test4() throws Exception {
		StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088"); /*URL*/
		urlBuilder.append("/" +  URLEncoder.encode("51524b696573657534304b4f424c58","UTF-8") ); /*인증키 (sample사용시에는 호출시 제한됩니다.)*/
		urlBuilder.append("/" +  URLEncoder.encode("json","UTF-8") ); /*요청파일타입 (xml,xmlf,xls,json) */
		urlBuilder.append("/" + URLEncoder.encode("tbHanyangPoi","UTF-8")); /*서비스명 (대소문자 구분 필수입니다.)*/
		urlBuilder.append("/" + URLEncoder.encode("1","UTF-8")); /*요청시작위치 (sample인증키 사용시 5이내 숫자)*/
		urlBuilder.append("/" + URLEncoder.encode("3","UTF-8")); /*요청종료위치(sample인증키 사용시 5이상 숫자 선택 안 됨)*/
		// 상위 5개는 필수적으로 순서바꾸지 않고 호출해야 합니다.
		
		// 서비스별 추가 요청 인자이며 자세한 내용은 각 서비스별 '요청인자'부분에 자세히 나와 있습니다.
		//urlBuilder.append("/" + URLEncoder.encode("KORN_TTL","UTF-8")); /* 서비스별 추가 요청인자들*/
		
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/xml");
		System.out.println("Response code: " + conn.getResponseCode()); /* 연결 자체에 대한 확인이 필요하므로 추가합니다.*/
		BufferedReader rd;

		// 서비스코드가 정상이면 200~300사이의 숫자가 나옵니다.
		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
				sb.append(line);
		}
		rd.close();
		conn.disconnect();
		String infoResult=sb.toString();
		System.out.println("@@@@@@@@"+ infoResult);
		
		JsonParser parser=new JsonParser();
		JsonObject job=(JsonObject) parser.parse(infoResult);
		JsonArray read=(JsonArray) job.getAsJsonObject("tbHanyangPoi").getAsJsonArray("row");
		System.out.println(read);
		List<Map<String, Object>> result=new ArrayList<>();
			for(JsonElement one : read) {
			JsonObject read_one=one.getAsJsonObject();
			String ITRST_BRNCH_NO=read_one.get("ITRST_BRNCH_NO").getAsString();
			String KORN_TTL=read_one.get("KORN_TTL").getAsString();
			String KORN_CONTS=read_one.get("KORN_CONTS").getAsString();
			Map<String, Object> map=new HashMap<>();
						
			map.put("ITRST_BRNCH_NO", ITRST_BRNCH_NO);
			map.put("KORN_TTL", KORN_TTL);
			map.put("KORN_CONTS", KORN_CONTS);
			result.add(map);
			}
		System.out.println("last@@@@ : "+result.get(0).get("ITRST_BRNCH_NO"));
	}
		
	
}
