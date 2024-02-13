<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include  file="../inc/login_header.jsp" %>
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


JSONParser jsonParser = new JSONParser();
JSONObject jsonObject = (JSONObject)jsonParser.parse(sb);
<%@ include  file="../inc/footer.jsp" %>
