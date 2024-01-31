<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../inc/login_header.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/mypage.css">
<!-- HEADER -->
<!-- HEADER -->
<style>
.margin_left {
	margin-left: 83px;
}

.required {
	color: crimson;
}

.title {
	display: flex;
	margin: 10px;
	align-items: baseline;
}

.input {
	width: 150px;
	outline: none;
	font-size: 20px;
	border: none;
	background-color: #fff;
	border-bottom: 0.5px solid gray;
	height: 20px;
	border-bottom: 0.5px solid gray;
	background-color: #fff;
	border: none;
	font-size: 20px;
	outline: none;
	font-size: 20px;
	border: none;
	background-color: #fff;
	border-bottom: 0.5px solid gray;
	height: 20px;
	margin-left: 70px;
	font-size: 20px;
	border: none;
	background-color: #fff;
	border-bottom: 0.5px solid gray;
	height: 20px;
	border-bottom: 0.5px solid gray;
	background-color: #fff;
	border: none;
	font-size: 20px;
	outline: none;
	font-size: 20px;
	border: none;
	background-color: #fff;
	border-bottom: 0.5px solid gray;
	height: 20px;
}

#editbtn {
	font-size: 18px;
    font-weight: bold;
    cursor: pointer;
    outline: none;
    width: 300px;
    height: 40px;
    border: none;
    color: white;
    background-color: #2F95B1;
    border-radius: 8px;
    font-family: 'GmarketSansMedium';
}

input[type=text], input[type=password] {
	width: 200px;
	height: 25px;
	outline: none;
	border: none;
	border-bottom: 1px solid black;
	background-color: #eee;
}

input[type=radio] {
	margin: 0px 38px;
}
#pwcheck{
	color: crimson;
    font-size: 10px;
    text-align: right;
}
</style>
<main style="font-weight:bold">
	<div id="wrapper" style="margin-left:50px;">
		<h2 style=" font-weight:bold;">프로필 수정</h2>

		<div id="edit">
			<div id="circle">
				<img
					src="${pageContext.request.contextPath}/resources/image/cat_girl.png"
					alt="프로필 사진" />
			</div>
		</div>

		<div class="box">
			<div class="pull" style="height: 80px;">
				안녕하세요! 사용자님 <br> 오늘도 feel in like를 방문해주셔서 감사합니다😊
			</div>
		</div>


		<div id="account">
			<h4 style="font-weight: bold;">내 정보</h4>
			<form action="mypage_edit.js?user_no=${myinfo.user_no }" method="post" id="myedit">
			<fieldset>
			<legend class="myhidden">정보수정</legend>
			<div style="display: flex; align-items: baseline; margin: 10px;">
				<label for="myid">아이디<strong class="required">*</strong></label> 
				<input type="text" id="myid" value="${myinfo.user_email }" class="input" style="width: 200px; height: 25px; font-size: 15px;" readonly>
			</div>
			<div class="title">
			<label for="user_name">이름<strong class="required">*</strong></label>
			<input type="text" id="user_name" name="user_name" value="${myinfo.user_name }" readonly class="margin_left">
			</div>
			<div class="title">
			<label for="user_pass">비밀번호<strong class="required">*</strong></label>
			<input type="password" id="user_pass" name="user_pass" style="margin-left:57px" placeholder="비밀번호는 영어와 숫자를 포함해주세요">
			</div>
			<div class="title">
			<label for="user_passcheck">비밀번호 재확인<strong class="required">*</strong></label>
			<input type="password" id="user_passcheck" name="user_passcheck" style="margin-left:12px" placeholder="비밀번호는 영어와 숫자를 포함해주세요">
			<p id="pwcheck"></p>
			</div>
			<c:choose>
			<c:when test="${myinfo.user_sex eq'm' }">
			<div class="title">
			<p style="margin-right:80px"><strong>성별</strong> <strong class="required">*</strong></p>
				<label for="m">남자</label> 
				<input type="radio" id="m" name="user_sex" value="m" checked> 
				<label for="w">여자</label> 
				<input type="radio" id="w" name="user_sex" value="w">
			</div>
			</c:when>			
			<c:when test="${myinfo.user_sex eq'w' }">
			<div class="title">
			<p style="margin-right:80px"><strong>성별</strong> <strong class="required">*</strong></p>
				<label for="m">남자</label> 
				<input type="radio" id="m" name="user_sex" value="m" > 
				<label for="w">여자</label> 
				<input type="radio" id="w" name="user_sex" value="w" checked>
			</div>
			</c:when>			
			
			</c:choose>
			<div class="title">
			<label for="user_mobile">휴대폰번호 <strong class="required">*</strong></label>
				<input type="text" id="user_mobile" name="user_mobile" value="${myinfo.user_mobile }" style="margin-left:38px"> 
			</div>
			<div class="title">
			<label for="user_birth">생년월일 <strong class="required">*</strong></label>
			<input type="date" id="user_birth" name="user_birth" value="${myinfo.user_birth }" style="margin-left:52px">
				
			</div>

		<br />

		<div style="text-align:center; margin:10px; padding: 40px;">
			<input type="submit" value="수정하기" id="editbtn">
		</div>
			</fieldset>
			</form>
		</div>
	</div>
	<script>
		$(function(){
			let regpass = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]*$/;
			let regmobile= /^010\d{4}\d{4}$/
			$("#myedit").on("submit", function(){
					if($("#user_pass").val() == "" || $("#user_passcheck").val()=="" || !(regpass.test($("#user_pass").val()))|| !(regpass.test($("#user_passcheck").val())))
					{
						alert("비밀번호를 확인해주세요!");
						return false
					}	
					if(!($("#user_pass").val()==$("#user_passcheck").val())){
						$("#pwcheck").text("비밀번호가 다릅니다.");
						return false
					}
					if($("#user_mobile").val()==""||!(regmobile.test($("#user_mobile").val()))){
						alert("휴대번호를 확인해주세요!");
						return false
					}
			});
		});
	</script>
</main>

<!-- Footer -->
<!-- Footer -->
<%@ include file="../inc/footer.jsp"%>