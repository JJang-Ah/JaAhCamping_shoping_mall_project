<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 폼</title>
<style>
@import url('https://fonts.googleapis.com/css2?family=Hammersmith+One&family=Paytone+One&display=swap');
#container { width: 1200px; margin: 0 auto;}
/* 상단 - 메인, 서브 타이틀 */
.t_title { font-family: 'Hammersmith One', sans-serif; font-size: 2.2em; text-align: center; margin: 30px 0;}

/* 중단 - 입력창 */
.f_input { width: 450px; text-align: center; border: 1px solid #ccc; padding: 10px; margin: 30px auto; border-radius: 10px;}
.f_input .c_id, .f_input .c_pwd { height: 45px; margin-top: 20px; padding-left: 5px;}
.f_input .f_chk { text-align: left; margin-top: 10px; font-size: 0.9em; color: gray;}
.f_input #btn_Login { width: 425px; height: 47px; margin-top: 25px; background: gray; color: white;
 font-size: 16px; font-weight: bold; cursor: pointer; margin-top: 25px; margin-bottom: 10px; border-radius: 10px;}
 
 /* 하단 - 비밀번호 찾기, 아이디 찾기, 회원가입 */
 .f_a { text-align: center; margin-top: 30px; font-size: 0.9em;}
 .f_a a {color: gray;}
 .t_line { border: 1px solid #e9ecef; margin: 20px 0;}
 

</style>

<script>
	document.addEventListener("DOMContentLoaded", function() {
		let form = document.loginForm;
		// 로그인 버튼을 클릭했을 때 유효성 검사 (공백 유무)
		let btn_Login = document.getElementById("btn_Login");
		btn_Login.addEventListener("click", function() {
			if(!form.id.value) {
				alert('아이디를 입력하시오.!');
				form.id.focus();
				return;
			}
			
			if(!form.pwd.value) {
				alert('비밀번호를 입력하시오.!');
				form.pwd.focus();
				return;
			}

			// 아이디 기억하기
			let now = new Date(); // 오늘 날짜
			let name = "cookieId"; // 쿠키 이름
			let value = form.id.value; // 쿠키 값
			
			if(form.chk.checked == true) { // 체크박스를 체크했을 때 -> 쿠키 생성
				// 만료시간: 지금으로부터 7일 후로 설정, 만료시간으로 사용
				now.setDate(now.getDate() + 7); 
			} else { // 체크박스를 해제했을 때 -> 쿠키 삭제
				// 만료시간: 지금 시간으로 설정
				now.setDate(now.getDate() + 0);
			}
			
			// 쿠키 생성시에 필요한 정보 - 쿠키의 이름과 값, 위치, 만료시간
			// ;path=/;expires= : 현재 페이지의 위치
			document.cookie = name + "=" + escape(value) + ";path=/;expires=" +now.toGMTString() + ";";
			
			form.submit();
		})	
		
		
		// 쿠키가 생성되어 있을 때 쿠키에 저장된 값인 아이디를 아이디 입력상자에 놓도록 하는 작업
		// 쿠키 확인 - 쿠키가 존재한다면 
		if(document.cookie.length > 0) {
			var search = "cookieId=";
			var idx = document.cookie.indexOf(search); // 쿠키 중에서 cookieId=이 나오는 위치
			if(idx != -1) { // cookieId값이 존재한다면
				idx += search.length;
				var end = document.cookie.indexOf(';', idx);
				
				if(end == -1) {
					end = document.cookie.length;
				}
				
				form.id.value = document.cookie.substring(idx, end);
				form.chk.checked = true;
			}
		}
	})
</script>
</head>
<body>

<div id="container">
	<jsp:include page="../mall/shopTop.jsp"></jsp:include>
	<div class="t_title">LOGIN</div>
	
	<form action="memberLoginPro.jsp" method="post" name="loginForm">
		<div class="f_input">
			<div class="f_id"><input type="text" id="id" name="id" class="c_id" placeholder="아이디" size="55"></div>
			<div class="f_pwd"><input type="password" id="pwd" name="pwd" class="c_pwd" placeholder="비밀번호" size="55"></div>
			<div class="f_chk">
				<input type="checkbox" id="chk" class="c_chk" size="55" name="chk">&nbsp;
				<label for="chk">아이디 기억</label>
			</div>
			<div class="f_submit"><input type="button" value="로그인" id="btn_Login"></div>
		</div>
		<div class="f_a">
			<a href="#">비밀번호 찾기</a>&emsp;|&emsp;
			<a href="#">아이디 찾기</a>&emsp;|&emsp;
			<a href="../member/memberJoinForm.jsp">회원가입</a>
		</div>
	</form>
	<hr class="t_line">
	<jsp:include page="../mall/shopBottom.jsp"></jsp:include>
</div>

</body>
</html>