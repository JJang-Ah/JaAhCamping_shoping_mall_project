/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.62
 * Generated at: 2022-05-23 14:46:07 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.manager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class managerMain_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>쇼핑몰 관리자 페이지</title>\r\n");
      out.write("<style>\r\n");
      out.write("@import url('https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Hammersmith+One&family=Paytone+One&display=swap');\r\n");
      out.write("#container { width: 300px; margin: 20px auto;}\r\n");
      out.write("a { text-decoration: none; color: black;}\r\n");
      out.write("\r\n");
      out.write("/* 상단 - 메인, 서브 타이틀 */\r\n");
      out.write(".m_title { font-family:'Paytone One', sans-serif; font-size: 3em; text-align: center;}\r\n");
      out.write(".s_title { font-family:'Do Hyeon', sans-serif; font-size: 2em; text-align: center; margin-bottom: 30px}\r\n");
      out.write("a { text-decoration: none; font-size: 0.95em; font-weight: bold;}\r\n");
      out.write(".c_logout { text-align: right; margin-bottom: 10px;}\r\n");
      out.write(".c_logout a { color: #705e7b;}\r\n");
      out.write("\r\n");
      out.write("/* 중단 - 로그인 박스 */\r\n");
      out.write(".b_box { border: 1px solid lightgray; padding: 5px; margin: 10px;}\r\n");
      out.write(".b_box input[type='text'], .b_box input[type='password'] { height: 30px; padding-left: 35px; border: none;}\r\n");
      out.write(".b_box input[type='text']:focus, .b_box input[type='password']:focus { outline: none;} \r\n");
      out.write(".b_box input[type='text'] { background: url('../../icons/login_id.png') no-repeat; background-size: 25px; background-position: left center;}\r\n");
      out.write(".b_box input[type='password'] { background: url('../../icons/login_pwd.png') no-repeat; background-size: 22px; background-position: left center;}\r\n");
      out.write(".c_box { padding: 0; margin: 10px;}\r\n");
      out.write(".c_box input[type='button'] { width: 280px; height: 45px; border: none; background: #5e869c; color: #fff; font-weight: bold; font-size: 1.03em;}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("/* 테이블 메뉴 */\r\n");
      out.write("table { width: 100%; border: 1px solid black; border-collapse: collapse;\r\n");
      out.write("border-top: 3px solid black; border-bottom: 3px solid gray; border-left: hidden; border-right: hidden;}\r\n");
      out.write("tr { height: 50px;}\r\n");
      out.write("th { border: 1px solid black;}\r\n");
      out.write(".logout_row { background: #dddce9;}\r\n");
      out.write(".title_row { background: #dee2e6; font-size: 1.1em;}\r\n");
      out.write(".a_row { background: #dddce9; opacity: 0.5; cursor: pointer;}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");

String managerId = (String)session.getAttribute("managerId");
if(managerId == null) {
	out.print("<script>location = 'logon/managerLoginForm.jsp';</script>");
}

      out.write("\r\n");
      out.write("<div id=\"container\">\r\n");
      out.write("	<div class=\"m_title\"><a href=\"#\">자아캠핑</a></div>\r\n");
      out.write("	<div class=\"s_title\">관리자 페이지</div>\r\n");
      out.write("	<div class=\"c_logout\"><a href=\"logon/managerLogout.jsp\">로그아웃</a></div>\r\n");
      out.write("	<table>\r\n");
      out.write("		<tr class=\"title_row\"><th>상품 관리</th></tr>\r\n");
      out.write("		<tr class=\"a_row\"><th><a href=\"product/productRegisterForm.jsp\">상품 등록</a></th></tr>\r\n");
      out.write("		<tr class=\"a_row\"><th><a href=\"product/productList.jsp\">상품 목록(수정/삭제)</a></th></tr>\r\n");
      out.write("		<tr class=\"title_row\"><th>주문 관리</th></tr>\r\n");
      out.write("		<tr class=\"a_row\"><th><a href=\"\">주문 목록(수정/삭제)</a></th></tr>\r\n");
      out.write("		<tr class=\"title_row\"><th>회원 관리</th></tr>\r\n");
      out.write("		<tr class=\"a_row\"><th><a href=\"\">회원 목록(수정/삭제)</a></th></tr>\r\n");
      out.write("		\r\n");
      out.write("	</table>\r\n");
      out.write("</div>\r\n");
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
