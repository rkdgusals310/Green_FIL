<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../inc/login_header.jsp"%>

<style>
.main {
	font-family: 'GmarketSansLight';
	margin: auto;
	padding: 125px;
}

#btnfont1 a, #btnfont2 a{
	color: white !important;
	font-weight: bold;
}

.tables {
	overflow: auto;
	border: 1px solid #eee;
	margin: 10px;
	height: 290px;
}

#adminPlus, #adminPlus_next {
	font-family: 'GmarketSansLight';
	background-color: aliceblue;
	position: absolute;
	width: 800px;
	height: 300px;
	top: 420px;
	left: 530px;
	padding: 40px;
	text-align: center;
}

#adminPlus h3, #adminPlus_next h3 {
	text-align: left;
	margin-left: 20px;
	font-weight: bold;
}

#adminPlus p, #adminPlus_next p {
	text-align: left;
	margin-left: 40px;
	font-size: 20px
}

#adminPlus input[type="text"], #adminPlus_next input[type="text"] {
	background-color: aliceblue;
	outline: none;
	border: none;
	border-bottom: 2px solid black;
	text-align: center;
	margin: 10px;
	font-weight: bold;
	font-size: 25px;
}

#adminPlus_next input[type="text"]{
	margin-top: 49px;
}


#plusbtns input[type="button"] {
	border: none;
	width: 190px;
	height: 50px;
	font-size: 20px;
	font-weight: bold;
	margin: 10px 20px;
}

#opnPlus {
	background-color: #00A3FFBD;
	color: white;
	font-weight: bold;
}
</style>

<script>
	$(function() {		
	
		$("#btnfont1").on("click", function(){
		let confirmed = confirm("해지하시겠습니까?");
			if(!confirmed){
				return false;
			}
		});
		$("#btnfont2").on("click", function(){
		let confirmed = confirm("해지하시겠습니까?");
			if(!confirmed){
				return false;
			}
		});
		
	});//end
</script>
<div class="main">
	<div>
		<h4>명소 리스트입니다.</h4>


	</div>
	<div class="tables">
		<table class="table table-bordered adminList">
			<caption>〈〈명소 LIST〉〉</caption>
			<thead>
				<tr>
					<th scope="col">번호</th>
					<th scope="col">이름</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="admin" items="${admin_list }" varStatus="status">
					<tr>
						<td>${admin.user_no }</td>
						<td>${admin.user_name }</td>
					</tr>
				</c:forEach> 
			</tbody>
		</table>
	</div>
			<div id="btnfont" class="text-right">
				<input type="button" id="btnfont2" value="삭제하기" class="btn" style="background-color: #FF6666ED;">
				<input type="button" value="추가하기" id="opnPlus" class="btn">
			</div>

 	
</div>
<%@ include file="../inc/footer.jsp"%>