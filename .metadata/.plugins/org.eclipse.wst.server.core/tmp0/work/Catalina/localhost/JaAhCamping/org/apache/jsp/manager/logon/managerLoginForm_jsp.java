/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.62
 * Generated at: 2022-06-06 11:19:36 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.manager.logon;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class managerLoginForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>관리자 로그인 폼</title>\r\n");
      out.write("<style>\r\n");
      out.write("@import url('https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Hammersmith+One&family=Paytone+One&display=swap');\r\n");
      out.write("a { text-decoration: none; color: black;}\r\n");
      out.write("/* 상단 - 메인, 서브 타이틀 */\r\n");
      out.write(".m_title { font-family:'Paytone One', sans-serif; text-align: center;}\r\n");
      out.write("\r\n");
      out.write(".s_title { font-family:'Do Hyeon', sans-serif; font-size: 2em; text-align: center; margin-top: 40px; margin-bottom: 30px;}\r\n");
      out.write("\r\n");
      out.write("/* 중단 - 로그인 박스 */\r\n");
      out.write(".a_box { width: 300px; margin: 60px auto;}\r\n");
      out.write(".b_box { border: 1px solid lightgray; padding: 5px; margin: 10px;}\r\n");
      out.write(".b_box input[type='text'], .b_box input[type='password'] { height: 30px; padding-left: 35px; border: none;}\r\n");
      out.write(".b_box input[type='text']:focus, .b_box input[type='password']:focus { outline: none;} \r\n");
      out.write(".b_box input[type='text'] { background: url('../../icons/login_id.png') no-repeat; background-size: 25px; background-position: left center;}\r\n");
      out.write(".b_box input[type='password'] { background: url('../../icons/login_pwd.png') no-repeat; background-size: 22px; background-position: left center;}\r\n");
      out.write(".c_box { padding: 0; margin: 10px;}\r\n");
      out.write(".c_box input[type='button'] { width: 280px; height: 45px; border: none; background: #5e869c; color: #fff; font-weight: bold; font-size: 1.03em;}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("document.addEventListener(\"DOMContentLoaded\", function() {\r\n");
      out.write("	let form = document.managerLoginForm;\r\n");
      out.write("	\r\n");
      out.write("	let btn_login = document.getElementById(\"btn_login\");\r\n");
      out.write("	btn_login.addEventListener(\"click\", function() {\r\n");
      out.write("		if(!form.managerId.value) {\r\n");
      out.write("			alert('아이디를 입력하시오.');\r\n");
      out.write("			form.managerId.focus();\r\n");
      out.write("			return;\r\n");
      out.write("		}\r\n");
      out.write("		if(!form.managerPwd.value) {\r\n");
      out.write("			alert('비밀번호를 입력하시오.');\r\n");
      out.write("			form.managerPwd.focus();\r\n");
      out.write("			return;\r\n");
      out.write("		}\r\n");
      out.write("		form.submit();\r\n");
      out.write("	})\r\n");
      out.write("})\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div id=\"container\">\r\n");
      out.write("	");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../mall/shopTop.jsp", out, false);
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	<div class=\"s_title\">관리자 로그인</div>\r\n");
      out.write("	\r\n");
      out.write("	<form action=\"managerLoginPro.jsp\" method=\"post\" name=\"managerLoginForm\">\r\n");
      out.write("		<div class=\"a_box\">\r\n");
      out.write("			<div class=\"b_box\">\r\n");
      out.write("				");
      out.write("\r\n");
      out.write("				<input type=\"text\" name=\"managerId\" id=\"managerId\" placeholder=\"아이디\" size=\"28\">\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"b_box\">\r\n");
      out.write("				<input type=\"password\" name=\"managerPwd\" id=\"managerPwd\" placeholder=\"비밀번호\" size=\"28\">\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"c_box\">\r\n");
      out.write("				<input type=\"button\" value=\"로그인\" id=\"btn_login\">\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	\r\n");
      out.write("	</form>\r\n");
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
