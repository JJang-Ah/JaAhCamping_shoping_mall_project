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

#product_kindName { text-align: center; margin-bottom: 20px; font-size: 40px; font-weight: bold;}
.d_kind2 { text-align: center; margin-bottom: 20px;}
/*상품 나열 */
.c_product { display: inline-block; width: 240px; height: 380px; margin: 10px; padding: 15px; position: relative; float: left;}
.c_p2 { font-weight: bold; display: inline;}
.c_p2 span {overflow: hidden;}
.c_p3 { position: absolute; bottom: 20px;}
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


/* 하단 - 페이징 영역*/
#paging { text-align: center; margin-top: 20px;}
#pBox { display: inline-block; width: 22px; height: 22px; padding: 5px; margin: 5px;}
#pBox:hover { background: #495057; color: white; font-weight: bold; border-radius: 10px;}
.pBox_c { background: #495057; color: white; font-weight: bold; border-radius: 10px;}
.pBox_b { font-weight: 900;}

.clear_bar { clear: both;}


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


String product_kindName = "";
switch(product_kind) {
case "110": product_kindName = "텐트"; break;
case "120": product_kindName = "텐트관련품"; break;
case "130": product_kindName = "타프"; break;
case "140": product_kindName = "폴대/펙/스트링/스토퍼"; break;
case "150": product_kindName = "공구"; break;
case "160": product_kindName = "기타(텐트/타프)"; break;
case "210": product_kindName = "의자"; break;
case "220": product_kindName = "테이블"; break;
case "230": product_kindName = "선반/수납기구"; break;
case "240": product_kindName = "야전침대"; break;
case "250": product_kindName = "퍼니쳐"; break;
case "260": product_kindName = "기타(의자/테이블/침대)"; break;

case "310": product_kindName = "버너"; break;
case "320": product_kindName = "코펠"; break;
case "330": product_kindName = "취사용품"; break;
case "340": product_kindName = "식기류"; break;
case "350": product_kindName = "기타(버너/코펠/취사용품)"; break;

case "410": product_kindName = "랜턴"; break;
case "420": product_kindName = "후레쉬"; break;
case "430": product_kindName = "난로"; break;
case "440": product_kindName = "액세서리"; break;
case "450": product_kindName = "기타(랜턴/난로)"; break;
case "460": product_kindName = "기타(의자/테이블/침대)"; break;

case "510": product_kindName = "화로대"; break;
case "520": product_kindName = "바베큐 그릴"; break;
case "530": product_kindName = "토치"; break;
case "540": product_kindName = "바베큐 소품"; break;
case "550": product_kindName = "기타(화로/바베큐)"; break;

case "610": product_kindName = "침낭"; break;
case "620": product_kindName = "베개/쿠션/방석"; break;
case "630": product_kindName = "매트"; break;
case "640": product_kindName = "해먹"; break;
case "650": product_kindName = "커버"; break;
case "660": product_kindName = "기타(침낭/매트/해먹)"; break;
}
%>
</head>
<body>
<div id="container">
	<div id="product_kindName">
		<span><%=product_kindName %></span>
	</div>
	<div class="d_kind2">상품수: 총 <b class="s_kind21"><%=cnt %></b>건</div>
	<div class="d_kind3">
		<%for(ProductDTO product: productList) { %>
		<div class="c_product">		
			<a href="shopContent.jsp?product_id=<%=product.getProduct_id()%>">
				<div class="c_p1"><img src="/images/<%=product.getProduct_image()%>" width="250" height="280"></div>
				<div class="c_p2"><span title="<%=product.getProduct_name()%>"><%=product.getProduct_name() %></span></div>
				<div class="c_p3"><span class="c_p3_price" title="<%=product.getProduct_price()%>"><%=df.format(product.getProduct_price()/100*(100-product.getDiscount_rate())) %>원</span>
				  <span class="s_p_discount">(<span class="s_p_discount_1"><%=product.getDiscount_rate() %>%할인</span>)</span></div>
			</a>
			<figcaption>
				<a href="shopContent.jsp?product_id=<%=product.getProduct_id() %>"><div class="info"><%=product.getProduct_name() %></div></a>	
			</figcaption>
			
		</div><% } %>
	</div>
	<hr class="clear_bar">

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