<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>BASIC001</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Lato"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet" type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<style>
#main {
	font-family: 'GmarketSansMedium';
}

#logincheck {
    color: crimson;
    font-size: 15px;
    text-align: left;
    margin-left: 105px;
    font-weight: bold;

}
</style>
<body>
	<script>
		$(function() {
			$(".btn").click(function(){
				match();
			})
			$("#login").submit(function() {
				if ($("#userid").val() == "") {
					$("#logincheck").text("아이디를 입력해주세요.")
					return false
				}
				if ($("#userpw").val() == "") {
					$("#logincheck").text("비밀번호를 입력해주세요.")
					return false
				}
			});
		});
		
	/* 	function match(){
			$.ajax({
				url:"login_match.js",
				type:"POST",
				dataType:"json",
				contentType: "application/json;charset=UTF-8",
				headers: {"Accept": "application/json"},
				data:{"user_email":$("#userid").val(), "user_pass":$("#userpw").val()},
				error:function(xhr, status, msg){
					alert(status+"/"+msg);},
				success:function(json){
					alert(json.result);
					$("#logincheck").html(json.result);
				}
			});
		} */
	</script>
	<main id="main">
		<div
			style="background-color: white; text-align: center; margin: 20px; padding: 20px; height: 1000px; margin: auto;">
			<p style="text-align: center">
				<a href="home.js"> <img src="resources/image/logo2.png"
					style="vertical-align: middle; margin: auto; padding: 40px; width: 370px;">
				</a>
			</p>
			<form action="login.js" method="post"
				style="width: 700px; height: 350px; margin: auto; margin-top: 50px;"
				id="login">
				<fieldset>
					<legend>LOGIN</legend>
					<div style="margin: 10px;">
						<input type="text" id="userid" name="user_email" placeholder="아이디"
							style="width: 500px; height: 50px; border-radius: 10px; padding: 20px;">
					</div>
					<div style="margin: 10px;">
						<input type="password" id="userpw" name="user_pass"
							placeholder="비밀번호"
							style="width: 500px; height: 50px; border-radius: 10px; padding: 20px;">
						<div id="logincheck"></div>
					</div>
					<div class="text-left"
						style="display: flex; align-items: flex-start; margin: 20px 0px 20px 110px;">
						<div>
							<input type="checkbox" id="idcheck"> <label for="idcheck">아이디
								기억하기</label>
						</div>
					</div>
					<div>
						<input type="submit" class="btn " value="로그인"
							style="width: 500px; background-color: #2CA6C7; color: white; height: 50px; border: 1px solid; font-weight: bold; font-size: 20px;">
					</div>

				</fieldset>
			</form>
			<div
				style="display: flex; flex-direction: row; align-content: stretch; flex-wrap: nowrap; justify-content: space-evenly; width: 300px; margin: auto; padding: 20px;">
				<p>
					<a href="findid.js">아이디찾기</a>
				</p>
				<p>
					<a href="findpass.js">비밀번호찾기</a>
				</p>
				<p>
					<a href="sign_agree.js">회원가입</a>
				</p>
			</div>
			<div
				style="display: flex; justify-content: center; flex-direction: row; flex-wrap: nowrap;">
				<div style="margin-right: 10px;">
					<p>
						<a href="" title="KAKAO LOGIN"><img
							src="resources/image/kakao_login.png" alt="login"
							style="width: 180px; height: 40px;"></a>
					</p>
					<p>
						<a href="#" title="naver login"><img
							src="resources/image/naverLogin.png"
							style="width: 180px; height: 40px;"></a>
					</p>
				</div>
				<div>
					<p>
						<a href="#" title="naver login"><img
							src="resources/image/appleLogin.png"
							style="width: 180px; height: 40px;"></a>
					</p>
					<p>
						<a href="#" title="google login"><img
							src="resources/image/googleLogin.png"
							style="width: 180px; height: 40px;"></a>
					</p>
				</div>

			</div>





		</div>

	</main>
</body>

</html>