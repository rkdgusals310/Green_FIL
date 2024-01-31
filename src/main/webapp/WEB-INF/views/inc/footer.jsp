<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- prefix -->
<!-- Footer -->
<!-- Footer -->
	<footer>
		<div id="footer">
			<p>이진승 강현민</p>
		</div>
	</footer>
  	
	<div class="modal">
		<div class="modal_content">
			<span class="modal_closebtn">&times;</span>
			<h1 class="modal_title">로그인</h1>
			<form action="login.feel" method="POST" class="login_form" autocomplete="off">
				<label></label>
				<input type="text" name="uid" placeholder="아이디" required />
				<label></label>
				<input type="password" name="upass" placeholder="비밀번호" required />
				<label></label>
				<input type="submit" id="submitBtn" value="로그인"/>
			</form>
			<div class="forget_content">
				<a href="#" class="forget">비밀번호를 잊어버리셨나요?</a>
			</div>
			<div class="signup_content">
				<span class="signup"><a href="terms.feel">회원가입</a></span>
			</div>
		</div>
	</div>
			

</body>


</html>