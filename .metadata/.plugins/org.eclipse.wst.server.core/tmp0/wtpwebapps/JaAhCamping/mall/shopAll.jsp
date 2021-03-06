<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="manager.product.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자아캠핑</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<link href="/JaAhCamping/icons/camping_small.png" rel="shortcut icon" type="image/x-icon">

<style>

.new_items {text-align: center;}
.new_items div { margin: 10px auto;}
.new_items img { width: 200px; height: 250px;}
.add_list { margin-top: 40px; margin-bottom: 20px; height: 380px; padding-left: 100px;}
.add_list img { float: left;}
.clear { clear: both; visibility: hidden;}
</style>
<script>

//슬라이더(slider), 카로섹(carosel)
$(document).ready(function(){
	$('.slider').bxSlider({
	     autoControls: true, 	// 기본값:false, 재생/정지 컨트롤 버튼 유무
	     stopAutoOnclick: true, 	// 기본값:false, 불릿을 누르고나면 슬라이드 정지
	     auto: true, 			// 기본값: false, 자동 슬라이드 전환
	     autoHover: true, 		// 기본값: false, 마우스 위에 올렸을때 슬라이드 정지
	     speed: 2000, 			// 화면 전환 속도
	     pause: 3000,  			// 화면전환 시간 + 전환 지연시간 > 1초+1초 = 2초
	     // 중요한 속성
	     slideWidth: 200, 		// 이미지의 너비
	     slideHeight: 320, 		// 이미지의 높이
	     maxSlides: 5, 			// 이미지의 최대 노출 개수
	     minSlides: 2, 			// 이미지의 최소 노출 개수
	     moveSides: 2, 			// 슬라이드 이동 분할 개수
	     slideMargin: 20, 		// 슬라이드 사이의 마진
	     touchEnabled: false, 	// 웹 화면의 touch 이벤트를 제거
	});
});

</script>
</head>
<body>
<%

ProductDAO productDAO = ProductDAO.getInstance();
List<ProductDTO> goodProductList = productDAO.getGoodProductList();

%>
<div id="container">
	<%-- 상단 --%>
	<div>
		<jsp:include page="shopTop.jsp"/>
	</div>
	
	<%-- 메인(본문) --%>
	<div>
		<main> <%-- 메인1: 100번대와 200번대에서 신상품을 3개씩 가져와서 bx-slider로 노출 --%>
			
			<div class="new_items">
				<h3>전체 신상품</h3>
				<div class="slider" id="slider">
				<%for(ProductDTO product : goodProductList) {%>
					<a href="shopContent.jsp?product_id=<%=product.getProduct_id()%>"><img src="/images/<%=product.getProduct_image()%>" class="c_new_img"></a>
				<%}%>
				</div>
			</div>
		</main>
					
		<div class="add_list">
			<a href="/JaAhCamping/mall/shopContent.jsp?product_id=15"><img src="/JaAhCamping/add/all_add01.jpg"></a>
			<a href="/JaAhCamping/mall/shopContent.jsp?product_id=45"><img src="/JaAhCamping/add/all_add02.jpg"></a>
			<a href="/JaAhCamping/mall/shopContent.jsp?product_id=47"><img src="/JaAhCamping/add/all_add04.jpg"></a>
			<a href="/JaAhCamping/mall/shopContent.jsp?product_id=46"><img src="/JaAhCamping/add/all_add03.jpg"></a>
			<a href="/JaAhCamping/mall/shopContent.jsp?product_id=48"><img src="/JaAhCamping/add/all_add05.png"></a>
		</div>	
		<hr class="clear">
			
		<jsp:include page="shopMain.jsp"></jsp:include>
	</div>
	
	<%-- 하단 --%>
	<div>
		<jsp:include page="shopBottom.jsp"/>
	</div>
</div>

</body>
</html>