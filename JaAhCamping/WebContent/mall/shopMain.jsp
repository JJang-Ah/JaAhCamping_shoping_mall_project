<%@page import="java.util.*"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="manager.product.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title><%!  %>
<style>

/*상품 나열 */
.c_product { display: inline-block; width: 240px; height: 350px; margin: 10px; padding: 15px; position: relative;}
.c_p2 { font-weight: bold; display: inline; overflow: hidden;}
.c_p3_price { font-size: 1.1em; font-weight: bold;}
.s_p_discount { color: red; font-weight: bold; font-size: 0.8em;}

/* hover 했을 때 화면 구성 */
.c_product figcaption {
  position: absolute;
  /* 이미지 위에 올라가야하기 때문에 position:absolute, top:0, left:0 */
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  transition: .2s;
  opacity: 0;
}

.c_product:hover figcaption { opacity: 1;}

figcaption div {
  position: absolute;
  top: 40%;
  width: 220px;
  height: 250px;
  color: white;
  font-size: 18px;
  text-align: center;
  line-height: 30px;
}
figcaption div:hover {
  cursor: pointer;
}
.info {
  right: 11%;
  color: #fff;
}


</style>
<script>

</script>
<%

request.setCharacterEncoding("utf-8");

DecimalFormat df = new DecimalFormat("###,###,###");
String product_kind = request.getParameter("product_kind");
if(product_kind == null) product_kind = "110";




//################ 페이징(paging) 처리 
//페이징(paging) 처리를 위한 변수 선언
int pageSize = 12; // 1페이지에 12건의 게시글을 표시
String pageNum = request.getParameter("pageNum");
if(pageNum == null) pageNum = "1";

int currentPage = Integer.parseInt(pageNum); // 현재 페이지
int startRow = (currentPage -1) * pageSize + 1; // 현재 페이지의 첫번째 행
int endRow = currentPage * pageSize;    // 현재 페이지의 마지막 행

//################


ProductDAO productDAO = ProductDAO.getInstance();

//분류별 상품에 대한 페이징 처리
List<ProductDTO> productList = productDAO.getProductList(startRow, pageSize, product_kind);
int cnt = productDAO.getProductCount(product_kind);

%>
</head>
<body>
<div id="container">

	<div class="d_kind2">상품수: 총 <b class="s_kind21"><%=cnt %></b>건</div>
	<div class="d_kind3">
		<%for(ProductDTO product: productList) { %>
		<div class="c_product">		
			<a href="shopContent.jsp?product_id=<%=product.getProduct_id()%>">
				<div class="c_p1"><img src="/images/<%=product.getProduct_image()%>" width="250" height="280"></div>
				<div class="c_p2"><span title="<%=product.getProduct_name()%>"><%=product.getProduct_name() %></span></div>
<%-- 				<div class="c_p3"><span title="<%=product.getBrand()%>"><%=product.getBrand() %></span></div> --%>
				<div class="c_p3"><span class="c_p3_price" title="<%=product.getProduct_price()%>"><%=product.getProduct_price()/100*(100-product.getDiscount_rate()) %>원</span>
				  <span class="s_p_discount">(<span class="s_p_discount_1"><%=product.getDiscount_rate() %>%할인</span>)</span></div>
			</a>
			<figcaption>
				<a href="shopContent.jsp?product_id=<%=product.getProduct_id() %>"><div class="info"><%=product.getProduct_name() %></div></a>	
			</figcaption>
			
		</div><% } %>


	   <%-- 페이징 처리 --%>
	   <div id="paging">
	   <%
	   if(cnt > 0) {
	      // 전체 페이지수 계산
	      int pageCount = cnt / pageSize + (cnt%pageSize==0? 0 : 1);
	      int startPage = 1; //시작페이지 번호
	      int pageBlock = 3; //페이징의 개수 
	      
	      // 시작 페이지 설정
	      if(currentPage % 3 != 0) startPage = (currentPage/3)*3 +1;
	      else startPage = (currentPage/3 -1) * 3 +1;
	         
	      // 끝 페이지 설정
	      int endPage = startPage + pageBlock - 1;
	      if(endPage > pageCount) endPage = pageCount;
	      
	      // 맨처음 페이지 이동 처리
	      if(startPage > 3) {
	         out.print("<a href='shopAll.jsp?pageNum=1&product_kind="+product_kind+"#t_kind'><div id='pBox' class='pBox_b' title='첫 페이지'>"+"〈〈"+"</div></a>");
	      }
	      
	      // 이전 페이지 처리
	      if(startPage > 3 ) {
	         out.print("<a href='shopAll.jsp?pageNum="+(currentPage-3)+"&product_kind="+product_kind+"#t_kind'><div id='pBox' class='pBox_b' title='이전 3페이지'>"+"〈"+"</div></a>");
	      }
	      // 페이징 블럭 출력 처리
	      for(int i=startPage; i<=endPage; i++) {
	         if(currentPage == i) { // 선택된 페이지가 현재 페이지일 때
	            out.print("<div id='pBox' class='pBox_c'>"+i+"</div>");
	         } else {      // 선택된 페이지가 다른 페이지일 떄 -> 이동에 대한 링크 설정
	            out.print("<a href='shopAll.jsp?pageNum=" + i+"&product_kind="+product_kind +"#t_kind'><div id='pBox'>" + i + "</div></a>");   
	         }
	      }
	      
	      // 다음 페이지 처리 
	      if(endPage < pageCount) {
	         int movePage = currentPage + 3;
	         if(movePage > pageCount) movePage=pageCount;
	         out.print("<a href='shopAll.jsp?pageNum="+movePage+"&product_kind="+product_kind+"#t_kind'><div id='pBox' class='pBox_b' title='다음 3페이지'>"+"〉"+"</div></a>");
	      }
	      
	      // 맨 끝 페이지 이동처리
	      if(endPage < pageCount) {
	         out.print("<a href='shopAll.jsp?pageNum="+pageCount+"&product_kind="+product_kind+"#t_kind'><div id='pBox' class='pBox_b' title='끝 페이지'>"+"〉〉"+"</div></a>");
	      }
	   }
	   %>
	   </div>

</div>
</body>
</html>