/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.62
 * Generated at: 2022-06-12 14:49:58 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.mall;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class shopTop_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>Insert title here</title>\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("#container { width: 1200px; margin: 20px auto;}\r\n");
      out.write("/* 상단 */\r\n");
      out.write("a { text-decoration: none; color: black;}\r\n");
      out.write(".t_box1 { text-align: right;}\r\n");
      out.write(".t_box1 #admin_page { display: inline-block; float: left;}\r\n");
      out.write(".t_box1 .user_menu { display: inline-block; float: right; color: gray;}\r\n");
      out.write(".h_line { clear: both; border: 1px solid lightgray; margin-top: 20px;}\r\n");
      out.write(".title { text-align: center; font-family: 'Do Hyeon', sans-serif; font-size: 40px;}\r\n");
      out.write("#camping { width: 70px; height: 70px;}\r\n");
      out.write("#title_sub_go { font-size: 0.8em;}\r\n");
      out.write("\r\n");
      out.write("/* 메뉴 */\r\n");
      out.write(".m_menu { list-style: none; font-weight: bold; color: lightgray;}\r\n");
      out.write(".m_menu .m_m_list { display: inline-block; float: left; width: 150px; height: 40px; \r\n");
      out.write("margin-right: 10px; border: 1px solid lightgray; text-align: center; line-height: 40px; border-radius: 10px;}\r\n");
      out.write(".m_menu > .m_m_list { position: relative;}\r\n");
      out.write(".m_menu > .m_m_list:hover >.s_menu { display: block;}\r\n");
      out.write(".m_m_list > .s_menu { display: none; position: absolute; top: 41px; border: 1px solid lightgray; background: white; border-radius: 10px;}\r\n");
      out.write(".s_menu .s_m_list { text-align: left; width: 200px;}\r\n");
      out.write("\r\n");
      out.write(".t_line { clear: both; border: 1px solid lightgray; margin-top: 100px;}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");

request.setCharacterEncoding("utf-8");

String memberId = (String)session.getAttribute("memberId");



      out.write("\r\n");
      out.write("<div id=\"container\">\r\n");
      out.write("\r\n");
      out.write("	<div class=\"t_box1\"> ");
      out.write("\r\n");
      out.write("		<div id=\"admin_page\"><a href=\"http://localhost:8088/JaAhCamping/manager/managerMain.jsp\">관리자 페이지</a></div>\r\n");
      out.write("		<div class=\"user_menu\">\r\n");
      out.write("		");
if(memberId == null) {  
      out.write("\r\n");
      out.write("			<a href=\"http://localhost:8088/JaAhCamping/logon/memberLoginForm.jsp\"><span>로그인</span></a>&ensp; |&ensp;\r\n");
      out.write("			<a href=\"http://localhost:8088/JaAhCamping/member/memberJoinForm.jsp\"><span>회원가입</span></a>&ensp; |&ensp;\r\n");
      out.write("		");
} else { 
      out.write("\r\n");
      out.write("			<a href=\"../member/memberInfoForm.jsp\"><span>");
      out.print(memberId );
      out.write("님</span></a>&ensp; |&ensp;\r\n");
      out.write("			<a href=\"../logon/memberLogout.jsp\"><span>로그아웃</span></a>&ensp; |&ensp;\r\n");
      out.write("			<a href=\"cart/cartList.jsp\"><span>장바구니</span></a>&ensp; |&ensp;\r\n");
      out.write("		");
} 
      out.write("\r\n");
      out.write("		<a href=\"#\">고객센터</a>&nbsp;|&nbsp;\r\n");
      out.write("		<a href=\"#\">커뮤니티</a>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	<hr class=\"h_line\">\r\n");
      out.write("	\r\n");
      out.write("	");
      out.write("\r\n");
      out.write("	<h1 class=\"title\"><a href=\"http://localhost:8088/JaAhCamping/mall/shopAll.jsp\">자아캠핑&nbsp;<img alt=\"camping\" src=\"/JaAhCamping/icons/camping.png\" id=\"camping\"></a></h1>\r\n");
      out.write("	\r\n");
      out.write("	<nav class=\"menu\">\r\n");
      out.write("		<ul class=\"m_menu\">\r\n");
      out.write("			<li class=\"m_m_list\"><a href=\"#\">텐트/타프</a>\r\n");
      out.write("				<div class=\"s_menu\">\r\n");
      out.write("					<ul>\r\n");
      out.write("						<li class=\"s_m_list\"><a href=\"#\">텐트</a></li>\r\n");
      out.write("						<li class=\"s_m_list\"><a href=\"#\">텐트관련품</a></li>\r\n");
      out.write("						<li class=\"s_m_list\"><a href=\"#\">타프</a></li>\r\n");
      out.write("						<li class=\"s_m_list\"><a href=\"#\">폴대/펙/스트링/스토퍼</a></li>\r\n");
      out.write("						<li class=\"s_m_list\"><a href=\"#\">공구</a></li>\r\n");
      out.write("						<li class=\"s_m_list\"><a href=\"#\">기타(텐트/타프)</a></li>\r\n");
      out.write("					</ul>\r\n");
      out.write("				</div>\r\n");
      out.write("			</li>\r\n");
      out.write("			<li class=\"m_m_list\"><a href=\"#\">의자/테이블/침대</a>\r\n");
      out.write("				<div class=\"s_menu\">\r\n");
      out.write("					<ul>\r\n");
      out.write("						<li class=\"s_m_list\"><a href=\"#\">의자</a></li>\r\n");
      out.write("						<li class=\"s_m_list\"><a href=\"#\">테이블</a></li>\r\n");
      out.write("						<li class=\"s_m_list\"><a href=\"#\">선반/수납가구</a></li>\r\n");
      out.write("						<li class=\"s_m_list\"><a href=\"#\">야전침대</a></li>\r\n");
      out.write("						<li class=\"s_m_list\"><a href=\"#\">퍼니쳐</a></li>\r\n");
      out.write("						<li class=\"s_m_list\"><a href=\"#\">기타(의자/테이블/침대)</a></li>\r\n");
      out.write("					</ul>\r\n");
      out.write("				</div>\r\n");
      out.write("			</li>\r\n");
      out.write("			<li class=\"m_m_list\"><a href=\"#\">버너/코펠/취사용품</a>\r\n");
      out.write("				<div class=\"s_menu\">\r\n");
      out.write("					<ul>\r\n");
      out.write("						<li class=\"s_m_list\"><a href=\"#\">버너</a></li>\r\n");
      out.write("						<li class=\"s_m_list\"><a href=\"#\">코펠</a></li>\r\n");
      out.write("						<li class=\"s_m_list\"><a href=\"#\">취사용품</a></li>\r\n");
      out.write("						<li class=\"s_m_list\"><a href=\"#\">식기류</a></li>\r\n");
      out.write("						<li class=\"s_m_list\"><a href=\"#\">기타(버터/코펠/취사용품)</a></li>\r\n");
      out.write("					</ul>\r\n");
      out.write("				</div>\r\n");
      out.write("			</li>\r\n");
      out.write("			<li class=\"m_m_list\"><a href=\"#\">랜턴/난로</a>\r\n");
      out.write("				<div class=\"s_menu\">\r\n");
      out.write("					<ul>\r\n");
      out.write("						<li class=\"s_m_list\"><a href=\"#\">랜턴</a></li>\r\n");
      out.write("						<li class=\"s_m_list\"><a href=\"#\">후레쉬</a></li>\r\n");
      out.write("						<li class=\"s_m_list\"><a href=\"#\">난로</a></li>\r\n");
      out.write("						<li class=\"s_m_list\"><a href=\"#\">액세서리</a></li>\r\n");
      out.write("						<li class=\"s_m_list\"><a href=\"#\">기타(랜턴/난로)</a></li>\r\n");
      out.write("					</ul>\r\n");
      out.write("				</div>\r\n");
      out.write("			</li>\r\n");
      out.write("			<li class=\"m_m_list\"><a href=\"#\">화로/바베큐</a>\r\n");
      out.write("				<div class=\"s_menu\">\r\n");
      out.write("					<ul>\r\n");
      out.write("						<li class=\"s_m_list\"><a href=\"#\">화로대</a></li>\r\n");
      out.write("						<li class=\"s_m_list\"><a href=\"#\">바베큐 그릴</a></li>\r\n");
      out.write("						<li class=\"s_m_list\"><a href=\"#\">토치</a></li>\r\n");
      out.write("						<li class=\"s_m_list\"><a href=\"#\">바베큐 소품</a></li>\r\n");
      out.write("						<li class=\"s_m_list\"><a href=\"#\">기타(화로/바베큐)</a></li>\r\n");
      out.write("					</ul>\r\n");
      out.write("				</div>\r\n");
      out.write("			</li>\r\n");
      out.write("			<li class=\"m_m_list\"><a href=\"#\">침낭/매트/해먹</a>\r\n");
      out.write("				<div class=\"s_menu\">\r\n");
      out.write("					<ul>\r\n");
      out.write("						<li class=\"s_m_list\"><a href=\"#\">침낭</a></li>\r\n");
      out.write("						<li class=\"s_m_list\"><a href=\"#\">베개/쿠션/방석</a></li>\r\n");
      out.write("						<li class=\"s_m_list\"><a href=\"#\">매트</a></li>\r\n");
      out.write("						<li class=\"s_m_list\"><a href=\"#\">해먹</a></li>\r\n");
      out.write("						<li class=\"s_m_list\"><a href=\"#\">기타(침낭/매트/해먹)</a></li>\r\n");
      out.write("					</ul>\r\n");
      out.write("				</div>\r\n");
      out.write("			</li>\r\n");
      out.write("			<li class=\"m_m_list\"><a href=\"#\">고객센터</a>\r\n");
      out.write("			</li>\r\n");
      out.write("		</ul>\r\n");
      out.write("	</nav>\r\n");
      out.write("	<hr class=\"t_line\">\r\n");
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
