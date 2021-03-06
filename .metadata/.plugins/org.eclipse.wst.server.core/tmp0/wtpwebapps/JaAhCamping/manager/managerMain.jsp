<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰 관리자 페이지</title>
<style>
@import url('https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Hammersmith+One&family=Paytone+One&display=swap');
#container { width: 70%; margin: 20px auto;}
a { text-decoration: none; color: black;}

/* 상단 - 메인, 서브 타이틀 */
.m_title { font-family:'Paytone One', sans-serif; font-size: 3em; text-align: center;}
.s_title { font-family:'Do Hyeon', sans-serif; font-size: 2em; text-align: center; margin-bottom: 30px}
.c_logout { text-align: right; margin-bottom: 10px;}
.c_logout a { color: #705e7b;}

/* 테이블 메뉴 */
table { width: 500px; border: 1px solid black; border-collapse: collapse; margin: 0 auto; margin-bottom: 100px;
border-top: 3px solid black; border-bottom: 3px solid gray; border-left: hidden; border-right: hidden;}
table tr { height: 50px;}
table th { border: 1px solid black;}
.logout_row { background: #dddce9;}
.title_row { background: #aaaaaa; font-size: 1.1em;}
.a_row { background: #dddddd; opacity: 0.7; cursor: pointer;}
.a_row:hover{ color: black; font-weight: bold;}
</style>
</head>
<body>
<%
String managerId = (String)session.getAttribute("managerId");
if(managerId == null) {
	out.print("<script>location = 'logon/managerLoginForm.jsp';</script>");
}
%>
<div id="container">
	<div>
		<jsp:include page="../mall/shopTop.jsp"></jsp:include>
	</div>

	<div class="title"><a href="#">자아캠핑</a></div>
	<div class="s_title">관리자 페이지</div>
	<div class="c_logout"><a href="logon/managerLogout.jsp">로그아웃</a></div>
	<table class="m_table">
		<tr class="title_row"><th>상품 관리</th></tr>
		<tr class="a_row"><th><a href="product/productRegisterForm.jsp">상품 등록</a></th></tr>
		<tr class="a_row"><th><a href="product/productList.jsp">상품 목록(수정/삭제)</a></th></tr>
		<tr class="title_row"><th>주문 관리</th></tr>
		<tr class="a_row"><th><a href="">주문 목록(수정/삭제)</a></th></tr>
		<tr class="title_row"><th>회원 관리</th></tr>
		<tr class="a_row"><th><a href="">회원 목록(수정/삭제)</a></th></tr>
	</table>
	
	<jsp:include page="../mall/shopBottom.jsp"></jsp:include>
</div>

</body>
</html>