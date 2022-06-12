<%@page import="java.text.SimpleDateFormat"%>
<%@page import="manager.product.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세 보기</title>
<style>
@import url('https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Hammersmith+One&family=Paytone+One&display=swap');
#container { width: 550px; margin: 20px auto;}
a { text-decoration: none; color: black;}

/* 상단 - 메인, 서브 타이틀 */
.m_title { font-family:'Paytone One', sans-serif; font-size: 3em; text-align: center;}
.s_title { font-family:'Do Hyeon', sans-serif; font-size: 2em; text-align: center; margin-bottom: 30px}
a { text-decoration: none; font-size: 0.95em; font-weight: bold;}
.c_logout { text-align: right; margin-bottom: 10px;}
.c_logout a { color: #99424f;}

/* 중단 - 상품 등록 테이블*/
table { width: 100%; border: 1px solid gray; border-collapse: collapse;
border-top: 5px; border-bottom: 5px; border-left: hidden; border-right: hidden;}
tr { height: 50px;}
td, th { border: 1px solid #705e7b;}
th { background: #dee2e6;}
td { padding-left: 5px;}

/* 중단 - 테이블 안의 입력상자*/
.c_p_id, .c_p_reg_date { background: #dee2e6;}
.s_p_id, .s_p_reg_date { color: #f00; font-size: 0.8em; font-weight: bold; margin-left: 10px;}
.s_p_image { color: #00f; font-size: 0.8em;}
.s_p_content { color: #00f; font-size: 0.8em;}
input[type="number"] { width: 100px;}
textarea { margin-top: 5px;}

/* 하단 - 버튼 */
select { height: 24px;}
input::file-selector-button { width: 90px; height: 27px; background: #2f9e77; color: #fff;
 border: none; border-radius: 5px;}
.btns { text-align: center; margin-top: 10px;}
.btns input { width: 100px; height: 35px; border: none; background: #495057; color: #fff; 
font-weight: bold; margin: 5px; cursor: pointer; border-radius: 5px;}
.btns input:nth-child(1), .btns input:nth-child(2) { background: #2f9277;}
.btns input:nth-child(1):hover { border: 2px solid #2f9277; background: #fff; color: #2f9e77;
font-weight: bold;}
</style>
<script>

document.addEventListener("DOMContentLoaded", function() {
	let form = document.updateForm;
	let btn_update = document.getElementById("btn_update");
	
	// 상품 분류가 선택되도록 설정 ex) 자기계발이면 330
	let product_kind = form.product_kind; // select 
	let p_kind = form.p_kind;		// ex) 자기계발: 310이 있는 option
	for(let i=0; i<product_kind.length; i++) {
		if(p_kind.value == product_kind[i].value) {
			product_kind[i].selected = true;
			break;
		}
	}
	
	// 상품 수정 처리 페이지로 이동
	btn_update.addEventListener("click", function() {
			
		if(!form.product_name.value) {
			alert('상품 제목을 입력하시오.');
			return;
		}
		if(!form.product_price.value) {
			alert('상품 가격을 입력하시오.');
			return;
		}
		if(!form.product_count.value) {
			alert('상품 수량을 입력하시오.');
			return;
		}
		if(!form.author.value) {
			alert('저자를 입력하시오.');
			return;
		}
		if(!form.publishing_com.value) {
			alert('출판사를 입력하시오.');
			return;
		}
		if(!form.publishing_date.value) {
			alert('출판일을 입력하시오.');
			return;
		}
		if(!form.product_content.value) {
			alert('상품 내용을 입력하시오.');
			return;
		}
		if(!form.discount_rate.value) {
			alert('할인율을 입력하시오.');
			return;
		}
		form.submit();
	})
	
	// 상품 삭제 처리 페이지로 이동
	let product_id = form.product_id.value;
	let pageNum = form.pageNum.value;
	let btn_delete = document.getElementById("btn_delete");
	btn_delete.addEventListener("click", function() {
		location = 'productDeletePro.jsp?product_id=' + product_id + '&pageNum=' + pageNum;
	})
	
	//상품 목록 페이지로 이동
	let btn_list = document.getElementById("btn_list");
	btn_list.addEventListener("click", function() {
		location = "productList.jsp?pageNum=" + pageNum;
	})
	
	// 관리자 페이지로 이동
	let btn_main = document.getElementById("btn_main");
	btn_main.addEventListener("click", function() {
		location = "../managerMain.jsp";
	})
})

</script>
</head>
<body>
<%
String managerId = (String)session.getAttribute("managerId");
if(managerId == null) {
	out.print("<script>location='../logon/managerLoginForm.jsp';</script>");
}

SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일");

String pageNum = request.getParameter("pageNum");
int product_id = Integer.parseInt(request.getParameter("product_id"));

// DB 연결, 질의 
ProductDAO productDAO = ProductDAO.getInstance();
ProductDTO product = productDAO.getProduct(product_id);


%>
<div id="container">
	<div>
		<jsp:include page="../../mall/shopTop.jsp"></jsp:include>
	</div>

	<div class="title"><a href="../managerMain.jsp">자아캠핑</a></div>
	<div class="s_title">상품 정보 확인</div>
	
	<form action="productUpdatePro.jsp" method="post" name="updateForm" enctype="multipart/form-data">
	<%-- enctype="multipart/form-data" 파일 업로드하는 폼 >> 그래서 다른 프로퍼티들이 Pro로 넘어가지 않는다. --%>
		<input type="hidden" name="pageNum" value="<%=pageNum%>">
		<table>
		<tr>
			<th>상품번호</th>
			<td>
				<input type="text" name="product_id" value="<%=product.getProduct_id() %>" size="10" readonly class="c_p_id"> 
				<span class="s_p_id">상품번호는 변경불가</span>
			</td>
		</tr>
			<tr>
				<th>상품 분류</th>
				<td>
					<input type="hidden" name="p_kind" value="<%=product.getProduct_kind()%>">
					<select name="product_kind">
						<option value="1">------------------</option>				
						<option value="110">텐트</option>
						<option value="120">텐트관련품</option>
						<option value="130">타프</option>
						<option value="140">폴대/펙/스트링/스토퍼</option>
						<option value="150">공구</option>
						<option value="160">기타(텐트/타프)</option>
						<option value="1">------------------</option>	
						<option value="210">의자</option>
						<option value="220">테이블</option>
						<option value="230">선반/수납기구</option>
						<option value="240">야전침대</option>
						<option value="250">퍼니쳐</option>
						<option value="260">기타(의자/테이블/침대)</option>
						<option value="1">------------------</option>	
						<option value="310">버너</option>
						<option value="320">코펠</option>
						<option value="330">취사용품</option>
						<option value="340">식기류</option>
						<option value="350">기타(버너/코펠/취사용품)</option>	
						<option value="1">------------------</option>	
						<option value="310">버너</option>
						<option value="320">코펠</option>
						<option value="330">취사용품</option>
						<option value="340">식기류</option>
						<option value="350">기타(버너/코펠/취사용품)</option>	
						<option value="1">------------------</option>	
						<option value="410">랜턴</option>
						<option value="420">후레쉬</option>
						<option value="430">난로</option>
						<option value="440">액세서리</option>
						<option value="450">기타(랜턴/난로)</option>	
						<option value="1">------------------</option>	
						<option value="510">화로대</option>
						<option value="520">바베큐 그릴</option>
						<option value="530">토치</option>
						<option value="540">바베큐 소품</option>
						<option value="550">기타(화로/바베큐용품)</option>
						<option value="1">------------------</option>		
						<option value="610">침낭</option>
						<option value="620">베개/쿠션/방석</option>
						<option value="630">매트</option>
						<option value="640">해먹</option>
						<option value="650">커버</option>	
						<option value="610">기타(침낭/매트/해먹)</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>상품 이름</th>
				<td><input type="text" name="product_name" size="56" value="<%=product.getProduct_name()%>"></td>
			</tr>
			<tr>
				<th>상품 가격</th>
				<td><input type="number" name="product_price" min="1000" max="1000000" value="<%=product.getProduct_price()%>">원</td>
			</tr>
			<tr>
				<th>상품 수량</th>
				<td><input type="number" name="product_count" min="0" max="100000" value="<%=product.getProduct_count()%>">권</td>
			</tr>
			<tr>
				<th>브랜드</th>
				<td><input type="text" name="author" value="<%=product.getBrand()%>">
			</tr>
			<tr>
				<th>사이즈</th>
				<td><input type="text" name="product_size" value="<%=product.getProduct_size()%>"></td>
			</tr>
			<tr>
				<th>무게</th>
				<td><input type="text" name="product_weight" value="<%=product.getProduct_weight()%>"></td>
			</tr>
			<tr>
				<th>상품 이미지</th>
				<td>
					<input type="file" name="product_image"> <br>
					<span class="s_p_image">상품 이미지를 다시 선택해 주세요</span>
				</td>
				
				<%-- file타입은 보안상의 이유로 value값을 찍을수 없다. --%>
			</tr>
			<tr>
				<th>상품 내용</th>
				<td>
					<input type="file" name="product_content"><br>
					<span class="s_p_content">상품 내용을 다시 넣어 주세요</span>
				</td>
			</tr>
			<tr>
				<th>할인율</th>
				<td><input type="number" name="discount_rate" min="0" max="90" value="<%=product.getDiscount_rate()%>">%</td>
			</tr>
			<tr>
				<th>등록일</th>
				<td>
					<input type="text" name="reg_date" value="<%=sdf.format(product.getReg_date())%>" size="15" class="c_p_reg_date">
					<span class="s_p_reg_date">등록일은 변경불가</span>
				</td>
			</tr>
		</table>
		<div class="btns">
			<input type="button" value="상품 정보 수정" id="btn_update">
			<input type="button" value="상품 정보 삭제" id="btn_delete">
			<input type="button" value="상품 목록" id="btn_list">
			<input type="button" value="관리자 페이지" id="btn_main">
		</div>
	</form>
</div>


</body>
</html>