<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../inc/login_header.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/mypage.css">
<!-- HEADER -->
<!-- HEADER -->
<style>
.margin_left {
	margin-left: 80px;
}

.required {
	color: crimson;
}

.title {
	display: flex;
	margin: 10px;
}

.input {
	width: 150px;
	outline: none; font-size : 20px; border : none; background-color : #fff;
	border-bottom : 0.5px solid gray; height : 20px; border-bottom : 0.5px
	solid gray; background-color : #fff; border : none; font-size : 20px;
	outline : none; font-size : 20px; border : none; background-color :
	#fff; border-bottom : 0.5px solid gray; height : 20px;
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
	line-height:45px;
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
				안녕하세요! ${login.user_name }님, <br> 오늘도 feel in like를 방문해주셔서 감사합니다😊
			</div>
		</div>


		<div id="account">
			<h4 style="font-weight: bold;">내 정보</h4>
			<div style="display: flex; align-items: baseline; margin: 10px;">
				<label for="myid">아이디<strong class="required">*</strong></label> <input
					type="text" id="myid" value="${myinfo.user_email }" class="input" readonly style="width: 250px;
    height: 25px;
    font-size: 15px;">
			</div>
			<div class="title">
				<p>
					이름 <strong class="required">*</strong>
				</p>
				<p class="margin_left">${myinfo.user_name }</p>
			</div>
			<div class="title">
				<p>
					성별 <strong class="required">*</strong>
				</p>
				<p class="margin_left">${myinfo.user_sex }</p>
			</div>
			<div class="title">
				<p>
					휴대폰번호 <strong class="required">*</strong>
				</p>
				<p style="margin-left: 38px">${myinfo.user_mobile }</p>
			</div>
			<div class="title">
				<p>
					생년월일 <strong class="required">*</strong>
				</p>
				<p style="margin-left: 50px">${myinfo.user_birth }</p>
			</div>
		</div>

		<br />


		<div
			style="padding-top: 112px; display: flex; align-items: baseline; margin: auto; width: 500px">
			<h4>더 이상 feel in like를 이용하지 않는다면?</h4>

			<div id="signout_check">
				<a href="delete_user.js">회원탈퇴</a>
			</div>
		</div>
		<div style="text-align:center; margin:10px">
			<input type="button" value="수정하기" id="editbtn">
		</div>
	</div>
	<script>
	$(function(){
		$("#editbtn").on("click", function(){
		location.href="mypage_edit.js?user_no=${myinfo.user_no}";
			
			
		});
	});
	</script>
</main>

<!-- Footer -->
<!-- Footer -->
<%@ include file="../inc/footer.jsp"%>