/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.62
 * Generated at: 2022-07-07 13:15:50 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.mall.buy;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import mall.cart.*;
import mall.buy.*;
import java.util.*;
import java.sql.*;

public final class buyInsertPro_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("mall.cart");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("mall.buy");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>최종구매확인 처리</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");

request.setCharacterEncoding("utf-8");

String memberId = (String)session.getAttribute("memberId");

if(memberId == null) { 
	out.print("<script>alert('로그인을 해주세요.');");
	out.print("location='../logon/memberLoginForm.jsp';</script>");
	return;
}

// 정보 확인 - buy_count ?
List<CartDTO> cartList = (List<CartDTO>)session.getAttribute("cartList");
String account = request.getParameter("account");
String delivery_name = request.getParameter("delivery_name");
String delivery_tel = request.getParameter("delivery_tel");
String delivery_address = request.getParameter("delivery_address1") + " " + request.getParameter("delivery_address2");

// 고유한 구매 아이디를 생성 (하나의 카트에 담겨 있는 모든 상품에 대한)
// 구매 아이디(buy_id): 날짜 8자리 + 고유한 숫자 12자리 -> 20자리의 고유한 구매 아이디를 생성
// 1. 날짜 8자리
Timestamp now = new Timestamp(System.currentTimeMillis());
String n = now.toString();
String s1 = n.substring(0, 4) + n.substring(5, 7) + n.substring(8, 10);
// 2. 고유한 숫자 12자리
UUID uuid = UUID.randomUUID();
String s2 = uuid.toString().replace("-", "").substring(0, 12);
String buy_id = s1 + s2;

// 구매 리스트에 저장 
List<BuyDTO> buyList = new ArrayList<BuyDTO>();
BuyDTO buy = null;
for(CartDTO cart : cartList) {
	buy = new BuyDTO();
	buy.setBuy_id(buy_id);
	buy.setBuyer(cart.getBuyer());
	buy.setProduct_id(cart.getProduct_id());
	buy.setProduct_name(cart.getProduct_name());
	buy.setBuy_price(cart.getBuy_price());
	buy.setBuy_count(cart.getBuy_count());
	buy.setProduct_image(cart.getProduct_image());
	buy.setAccount(account);
	buy.setDelivery_name(delivery_name);
	buy.setDelivery_tel(delivery_tel);
	buy.setDelivery_address(delivery_address);
	buyList.add(buy);
}
session.setAttribute("buyList", buyList);

// buyList 확인
/* for(BuyDTO b : buyList) {
	System.out.println(b);
} */

// BuyDAO 연동
BuyDAO buyDAO = BuyDAO.getInstance();
buyDAO.insertBuyList(buyList, cartList);
response.sendRedirect("buyList.jsp");

      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
