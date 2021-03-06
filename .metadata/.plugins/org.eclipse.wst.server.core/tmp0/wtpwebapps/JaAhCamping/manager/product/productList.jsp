<%@page import="java.text.*"%>
<%@page import="manager.product.*"%>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
<style>
@import url('https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Hammersmith+One&family=Paytone+One&display=swap');
#container { width: 1200px; margin: 0 auto;}
a { text-decoration: none; color: black;}

/* 상단 - 메인, 서브 타이틀 */
.m_title { font-family:'Paytone One', sans-serif; font-size: 3em; text-align: center;}
.s_title { font-family:'Do Hyeon', sans-serif; font-size: 2em; text-align: center; margin-bottom: 30px}

/* 상단 - 전체 상품수, 아이디, 로그아웃, 상품등록*/
.top_info { margin-bottom: 10px; text-align: right;}
.c_cnt { float: left;}
.c_cnt, .c_managerId { color: #59637f; font-size: 0.95em; font-weight: bold;}
.c_managerId { clear: both;}
.c_logout a { color: #99424f;}

/* 상단 - 검색 */
.top_search { margin-bottom: 10px;}
.c_select { width: 155px; height: 25px;}
.c_input { width: 200px; height: 20px;}
.c_submit { width: 82px; height: 27px; border: none; background: #000; color: #fff;
    font-size: 0.8em; border-radius: 5px; font-weight: bold; cursor: pointer;}
.c_submit:hover { background: #fff; color: #000; border: 1px solid black;}
/* 중단 - 상품 정보 테이블 */
.a_table { width: 100%; border: 1px solid lightgray; border-collapse: collapse; font-size: 0.9em; border-radius: 10px;}
tr { height: 150px;}
#a_table_top { height: 70px;}
/* tr:nth-child(2n) { background: #e9ecef;} */
tr:nth-child(2n+1) { background: #f8f9fa;}
th, td { border: 1px solid lightgray;}
th { background: #dee2e6;}
.center { text-align: center;}
.left { text-align: left; padding-left: 2px;}
.right { text-align: right; padding-right: 5px;}
.img_update:hover { content: url('../../icons/update2.png');}
.img_delete:hover { content: url('../../icons/delete2.png');}
.f_row { text-align: center; font-weight: bold; color: #c84557;}

/* 하단 - 페이징 영역*/
#paging { text-align: center; margin-top: 20px;}
#pBox { display: inline-block; width: 22px; height: 22px; padding: 5px; margin: 5px;}
#pBox:hover { background: #495057; color: white; font-weight: bold; border-radius: 10px;}
.pBox_c { background: #495057; color: white; font-weight: bold; border-radius: 10px;}
.pBox_b { font-weight: 900;}

</style>
<script>

</script>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");

String managerId = (String)session.getAttribute("managerId");
if(managerId == null) {
   out.print("<script>location='../logon/managerLoginForm.jsp';</script>");
}

SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
DecimalFormat df = new DecimalFormat("#,###,###");
String product_kindName = "";


//################ 페이징(paging) 처리 
//페이징(paging) 처리를 위한 변수 선언
int pageSize = 10; // 1페이지에 10건의 게시글을 표시
String pageNum = request.getParameter("pageNum");
if(pageNum == null) pageNum = "1";

int currentPage = Integer.parseInt(pageNum); // 현재 페이지
int startRow = (currentPage -1) * pageSize + 1; // 현재 페이지의 첫번째 행
int endRow = currentPage * pageSize;    // 현재 페이지의 마지막 행

//################

// 검색 서치 - 검색일떄는 search가 1이고, 검색이 아닐떄는 search가 0
String search = request.getParameter("search");
String s_search = "";
String i_search = "";
if(search == null) {
   search = "0";
} else {
   s_search = request.getParameter("s_search");
   i_search = request.getParameter("i_search");
}



// DB 연결, 질의 처리
ProductDAO productDAO = ProductDAO.getInstance();

// 전체 상품수 조회
int cnt = 0;

// 전체 상품 조회 - paging 처리한 상품 목록, 검색 처리(search가 1이면 검색, search가 0이면 검색이 아님)
List<ProductDTO> productList = null;
if(search.equals("1")) {
   productList = productDAO.getProductList(startRow, pageSize, s_search, i_search);
   cnt = productDAO.getProductCount(s_search, i_search);
} else if(search.equals("0")){
   productList = productDAO.getProductList(startRow, pageSize);
   cnt = productDAO.getProductCount();
}

//매 페이지마다 전체 상품수에 대한 역순 번호
int number = cnt - ((currentPage-1) * pageSize); 
%>
<div id="container">
	<div>
		<jsp:include page="../../mall/shopTop.jsp"></jsp:include>
	</div>

   <%-- 상단: 타이틀 --%>
   <div class="title"><a href="../managerMain.jsp">자아캠핑 관리자 페이지</a></div>
   <div class="s_title"><a href="productList.jsp">상품 목록</a></div>
   
   <%-- 상단: 아이디, 로그아웃, 상품등록 --%>
   <div class="top_info">
      <span class="c_cnt">전체 상품수: <%=cnt %>개</span>
      <span class="c_managerId"><%=managerId %>님(관리자)</span>&emsp;|&emsp;
      <span class="c_logout"><a href="../logon/managerLogout.jsp">로그아웃</a></span>&emsp;|&emsp;
      <span class="c_register_product"><a href="productRegisterForm.jsp">상품등록</a></span>
   </div>
   
   <%-- 상단: 검색 --%>
   <div class="top_search">
      <form action="productList.jsp" method="post" name="searchForm">
      <input type="hidden" name="search" value="1">
      <span class="s_search1">
         <select name="s_search" class="c_select">
            <option selected>이름</option>
            <option>브랜드</option>
         </select>
      </span>
      <span class="s_search2"><input type="text" name="i_search" class="c_input"></span>
      <span class="s_search3"><input type="submit" class="c_submit" value="검색"></span>
      </form>
   </div>
   
   <%-- 중단: 상품 테이블 --%>
   <table id="a_table">
      <tr id="a_table_top">
         <th width="4%">No</th>
         <th width="9%">분류</th>
         <th width="5%">사진</th>
         <th width="20%">이름</th>
         <th width="7%">가격</th>
         <th width="5%">재고</th>
         <th width="12%">브랜드</th>
         <th width="12%">사이즈</th>
         <th width="7%">무게</th>
         <th width="4%">할인율</th>
         <th width="7%">등록일</th>
         <th width="8%">수정|삭제</th>
      </tr>
      <% if(cnt == 0) { // 등록된 글이 없을 때  
         out.print("<tr><td colspan='13' class='f_row'>등록된 글이 없습니다.</td></tr>");
      } else {      // 등록된 글이 있을 때
         for(ProductDTO product : productList) {
            switch(product.getProduct_kind()) {
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
      <tr>
         <td class="center"><%=number-- %></td>   
         <td class="center"><%=product_kindName %></td>   
         <td class="center">
            <a href="productContent.jsp?product_id=<%=product.getProduct_id()%>&pageNum=<%=pageNum%>">
               <img src=<%="/images/" + product.getProduct_image()%> width="35px" height="50px">
            </a>
         </td>   
         <td class="left">
            <a href="productContent.jsp?product_id=<%=product.getProduct_id()%>&pageNum=<%=pageNum%>"><%=product.getProduct_name() %></a>
         </td>   
         <td class="right"><%=df.format(product.getProduct_price()) %>원</td>
         <td class="right"><%=df.format(product.getProduct_count()) %>개</td>
         <td class="center"><%=product.getBrand() %></td>  
         <td class="center"><%=product.getProduct_size() %></td>   
         <td class="center"><%=product.getProduct_weight() %></td>
         <td class="center"><%=product.getDiscount_rate() %>%</td>   
         <td class="center"><%=sdf.format(product.getReg_date()) %></td>   
         <td class="center">
            <a href="productContent.jsp?product_id=<%=product.getProduct_id() %>&pageNum=<%=pageNum%>"><img src="../../icons/update1.png" width="30" class="img_update"></a>&nbsp;&nbsp;
            <a href="productDeletePro.jsp?product_id=<%=product.getProduct_id() %>&pageNum=<%=pageNum%>"><img src="../../icons/delete1.png" width="30" class="img_delete"></a>
         </td>   
      </tr>
      <%} }%>
   </table>
   
   <%-- 페이징 처리 --%>
   <div id="paging">
   <%
   if(cnt > 0) {
      // 전체 페이지수 계산
      int pageCount = cnt / pageSize + (cnt%pageSize==0? 0 : 1);
      int startPage = 1; //시작페이지 번호
      int pageBlock = 10; //페이징의 개수 
      
      // 시작 페이지 설정
      if(currentPage % 10 != 0) startPage = (currentPage/10)*10 +1;
      else startPage = (currentPage/10 -1) * 10 +1;
         
      // 끝 페이지 설정
      int endPage = startPage + pageBlock - 1;
      if(endPage > pageCount) endPage = pageCount;
      
      // 맨처음 페이지 이동 처리
      if(startPage > 10) {
         out.print("<a href='productList.jsp?pageNum=1&search="+search+"&s_search="+s_search+"&i_search="+i_search+"'><div id='pBox' class='pBox_b' title='첫 페이지'>"+"〈〈"+"</div></a>");
      }
      
      // 이전 페이지 처리
      if(startPage > 10 ) {
         out.print("<a href='productList.jsp?pageNum="+(currentPage-10)+"&search="+search+"&s_search="+s_search+"&i_search="+i_search+"'><div id='pBox' class='pBox_b' title='이전 10페이지'>"+"〈"+"</div></a>");
      }
      // 페이징 블럭 출력 처리
      for(int i=startPage; i<=endPage; i++) {
         if(currentPage == i) { // 선택된 페이지가 현재 페이지일 때
            out.print("<div id='pBox' class='pBox_c'>"+i+"</div>");
         } else {      // 선택된 페이지가 다른 페이지일 떄 -> 이동에 대한 링크 설정
            out.print("<a href='productList.jsp?pageNum=" + i + "&search=" + search+"&s_search="+s_search+"&i_search="+i_search+"'><div id='pBox'>" + i + "</div></a>");   
         }
      }
      
      // 다음 페이지 처리 
      if(endPage < pageCount) {
         int movePage = currentPage + 10;
         if(movePage > pageCount) movePage=pageCount;
         out.print("<a href='productList.jsp?pageNum="+movePage+"&search="+search+"&s_search="+s_search+"&i_search="+i_search+"'><div id='pBox' class='pBox_b' title='다음 10페이지'>"+"〉"+"</div></a>");
      }
      
      // 맨 끝 페이지 이동처리
      if(endPage < pageCount) {
         out.print("<a href='productList.jsp?pageNum="+pageCount+"&search="+search+"&s_search="+s_search+"&i_search="+i_search+"'><div id='pBox' class='pBox_b' title='끝 페이지'>"+"〉〉"+"</div></a>");
      }
   }
   %>
   </div>
   
</div>
</body>
</html>