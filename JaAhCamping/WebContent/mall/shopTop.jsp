<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">

<style>
#container { width: 1200px; margin: 20px auto;}
/* 상단 */
.title { text-align: center; font-family: 'Do Hyeon', sans-serif;}
#camping { width: 70px; height: 70px;}
#title_sub_go { font-size: 0.8em;}

/* 메뉴 */
.m_menu { list-style: none;}
.m_menu .m_m_list { display: inline-block; float: left; width: 150px; height: 60px; 
margin-right: 10px; border: 1px solid black; text-align: center; line-height: 60px;}
.m_menu > .m_m_list { position: relative;}
.m_menu a { text-decoration: none;}
.m_menu > .m_m_list:hover >.s_menu { display: block;}
.m_m_list > .s_menu { display: none; position: absolute; top: 60px; border: 1px solid black;}
.s_menu .s_m_list { text-align: left; width: 200px;}
</style>
</head>
<body>
<div id="container">
	<h1 class="title">자아캠핑&nbsp;<img alt="camping" src="../icons/camping.png" id="camping"></h1>
	
	<nav>
		<ul class="m_menu">
			<li class="m_m_list"><a href="#">텐트/타프</a>
				<div class="s_menu">
					<ul>
						<li class="s_m_list"><a>텐트</a></li>
						<li class="s_m_list"><a>텐트관련품</a></li>
						<li class="s_m_list"><a>타프</a></li>
						<li class="s_m_list"><a>폴대/펙/스트링/스토퍼</a></li>
						<li class="s_m_list"><a>공구</a></li>
						<li class="s_m_list"><a>기타(텐트/타프)</a></li>
					</ul>
				</div>
			</li>
			<li class="m_m_list"><a href="#">의자/테이블/침대</a>
				<div class="s_menu">
					<ul>
						<li class="s_m_list"><a>의자</a></li>
						<li class="s_m_list"><a>테이블</a></li>
						<li class="s_m_list"><a>선반/수납가구</a></li>
						<li class="s_m_list"><a>야전침대</a></li>
						<li class="s_m_list"><a>퍼니쳐</a></li>
						<li class="s_m_list"><a>기타(의자/테이블/침대)</a></li>
					</ul>
				</div>
			</li>
			<li class="m_m_list"><a href="#">버너/코펠/취사용품</a></li>
			<li class="m_m_list"><a href="#">랜턴/난로</a></li>
			<li class="m_m_list"><a href="#">화로/바베큐</a></li>
			<li class="m_m_list"><a href="#">침낭/매트/해먹</a></li>
		</ul>
	</nav>
</div>

</body>
</html>