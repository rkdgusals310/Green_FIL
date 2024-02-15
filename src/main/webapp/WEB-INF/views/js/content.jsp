<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../inc/login_header.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/mypage.css">
<!-- HEADER -->
<!-- HEADER -->
<style>
.recommend {
	background-color: #F9F2B9;
	width: 1300px;
	height: 500px;
	padding: 48px;
	margin:auto;
}

.recommend_list {
	display: flex;
    justify-content: space-around;
    text-align: center;
    font-size: 20px;
    margin-top: 30px;
    background: floralwhite;
    height: 330px;
    line-height: 330px;

}

.recommend_title {
	text-align: center;
}
</style>
<main style="font-weight: bold">

	<div class="recommend">
		<h2 class="recommend_title">오늘의 추천 명소</h2>
		<div class="recommend_main">
			<div class="recommend_list">
				<c:forEach var="recommend" items="${title}" varStatus="recommendIndex">
					<p>
						<a href="${list[recommendIndex.index]}">| ${recommend } |</a>
					</p>
				</c:forEach>
			</div>
		</div>
	</div>
</main>

<!-- Footer -->
<!-- Footer -->
<%@ include file="../inc/footer.jsp"%>