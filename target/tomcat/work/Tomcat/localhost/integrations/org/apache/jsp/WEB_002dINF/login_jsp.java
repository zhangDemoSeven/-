/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-12-04 06:16:19 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/header/header.jsp", Long.valueOf(1541900141329L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>欢迎登陆</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/bootstrap/vendor/bootstrap/css/bootstrap.css\"/>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/bootstrap/dist/css/bootstrapValidator.css\"/>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/bootstrap/bootstraptable/bootstrap-table.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/bootstrap/bootstrapselect/css/bootstrap-select.min.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/bootstrap/bootstrapdatetimepicker/css/bootstrap-datetimepicker.min.css\" />\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/bootstrap/vendor/jquery/jquery-1.10.2.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/js/tool.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/bootstrap/bootstraptable/bootstrap-table.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/bootstrap/bootstraptable/bootstrap-table-zh-CN.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/bootstrap/bootstrap.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/bootstrap/dist/js/bootstrapValidator.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/bootstrap/bootstrapselect/js/bootstrap-select.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/bootstrap/bootstrapselect/js/i18n/defaults-zh_CN.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/plugins/layer/layer.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/bootstrap/bootstrapdatetimepicker/js/bootstrap-datetimepicker.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/bootstrap/bootstrapdatetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/plugins/layui/css/layui.css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/plugins/layui/layui.js\"></script>");
      out.write("\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/login/css/login.css\" rel=\"stylesheet\" rev=\"stylesheet\" type=\"text/css\" media=\"all\" />\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/login/css/demo.css\" rel=\"stylesheet\" rev=\"stylesheet\" type=\"text/css\" media=\"all\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/login/js/jquery1.42.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/login/js/jquery.SuperSlide.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/login/js/Validform_v5.3.2_min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"header\">\r\n");
      out.write("\t    <h1 class=\"headerLogo\">\r\n");
      out.write("\t  \t  <a title=\"后台管理系统\" href=\"javascript:void(0)\">\r\n");
      out.write("\t  \t\t<img alt=\"logo\" width=\"230px\" height=\"100px\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/login/images/logo1.png\">\r\n");
      out.write("\t  \t  </a>\r\n");
      out.write("\t  \t  \r\n");
      out.write("\t  \t ");
      out.write("\r\n");
      out.write("\t    </h1>\r\n");
      out.write("\t  \r\n");
      out.write("\t\t<div class=\"headerNav\">\r\n");
      out.write("\t\t\t<a target=\"_blank\" href=\"#\">开发团队</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"banner\">\r\n");
      out.write("\t\t<div class=\"login-aside\">\r\n");
      out.write("\t\t  <div id=\"o-box-up\"></div>\r\n");
      out.write("\t\t  <div id=\"o-box-down\"  style=\"table-layout:fixed;\">\r\n");
      out.write("\t\t  <div class=\"error-box\"></div>\r\n");
      out.write("\t\t\t   <form class=\"registerform\" id=\"userForm\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/ln.do\">\r\n");
      out.write("\t\t\t\t  <div class=\"fm-item\">\r\n");
      out.write("\t\t\t\t\t   <label for=\"logonId\" class=\"form-label\">登陆用户：</label>\r\n");
      out.write("\t\t\t\t\t   <input id=\"username\"  type=\"text\" class=\"i-text\" name=\"username\" placeholder=\"请输入账户名\" required autofocus />\r\n");
      out.write("\t\t\t\t       <div class=\"ui-form-explain\"></div>\r\n");
      out.write("\t\t\t\t  </div>\r\n");
      out.write("\t\t\t\t  \r\n");
      out.write("\t\t\t\t  <div class=\"fm-item\">\r\n");
      out.write("\t\t\t\t\t   <label for=\"logonId\" class=\"form-label\">登陆密码：</label>\r\n");
      out.write("\t\t\t\t\t   <input id=\"password\" type=\"password\" class=\"i-text\" name=\"password\" placeholder=\"请输入密码\" required autofocus />\r\n");
      out.write("\t\t\t\t       <div class=\"ui-form-explain\"></div>\r\n");
      out.write("\t\t\t\t  </div>\r\n");
      out.write("\t\t\t\t  \r\n");
      out.write("\t\t\t\t  <div class=\"fm-item\">\r\n");
      out.write("\t\t\t\t\t   <label for=\"logonId\" class=\"form-label\"></label>\r\n");
      out.write("\t\t\t\t       <button type=\"button\"  onclick=\"ajaxSub()\" class=\"btn-login\"></button>\r\n");
      out.write("\t\t\t\t       <div class=\"ui-form-explain\"></div>\r\n");
      out.write("\t\t\t\t  </div>\r\n");
      out.write("\t\t\t  </form>\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"bd\">\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t<li style=\"background:url(static/login/themes/theme-pic1.jpg) #CCE1F3 center 0 no-repeat;\"></li>\r\n");
      out.write("\t\t\t\t<li style=\"background:url(static/login/themes/theme-pic2.jpg) #BCE0FF center 0 no-repeat;\"></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"hd\"><ul></ul></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("<script type=\"text/javascript\">jQuery(\".banner\").slide({ titCell:\".hd ul\", mainCell:\".bd ul\", effect:\"fold\",  autoPlay:true, autoPage:true, trigger:\"click\" });</script>\r\n");
      out.write("<div class=\"banner-shadow\"></div>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(function(){\r\n");
      out.write("\t\r\n");
      out.write("\tvar xian=$(document).width();\r\n");
      out.write("\tif(xian<parseInt(700)){\r\n");
      out.write("\t\t$(\".mycenter\").addClass(\"bodyWidth\");\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\t$(\".mycenter\").removeClass(\"bodyWidth\");\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\thistory.pushState(null, null, document.URL);\r\n");
      out.write("\twindow.addEventListener('popstate', function () {\r\n");
      out.write("\t    history.pushState(null, null, document.URL);\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\tdocument.oncontextmenu = function () { \r\n");
      out.write("\t\treturn false; \r\n");
      out.write("\t};\r\n");
      out.write("\t\r\n");
      out.write("    document.onkeydown = function () {\r\n");
      out.write("\t    if(window.event && window.event.keyCode == 123) {\r\n");
      out.write("\t      event.keyCode = 0;\r\n");
      out.write("\t      event.returnValue = false;\r\n");
      out.write("\t      return false;\r\n");
      out.write("\t    }\r\n");
      out.write("    };\r\n");
      out.write("\r\n");
      out.write("\t$(document).bind(\"keydown\", function(e) {//文档绑定键盘按下事件 \r\n");
      out.write("\t\te = window.event || e;//解决浏览器兼容的问题   \r\n");
      out.write("\t\tif(e.keyCode == 116) {//F5按下 \r\n");
      out.write("\t\t\treturn false; \r\n");
      out.write("\t\t}else{//让刷新，并完成特定事件 //完成特定事件 \r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t} \r\n");
      out.write("\t});\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("function ajaxSub(){\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\t\ttype:'POST',\r\n");
      out.write("\t\tdata:$(\"#userForm\").serialize(),\r\n");
      out.write("\t\turl:$(\"#userForm\").attr('action'),\r\n");
      out.write("\t\tsuccess:function(data){\r\n");
      out.write("\t\t\tif(!data.type){\r\n");
      out.write("\t\t\t\twindow.location.href=getRootPath()+\"/login.do\";\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\tlayer.msg(data.message,function(){});\r\n");
      out.write("\t\t\t\t$(\"#username\").val(\"\");\r\n");
      out.write("\t\t\t\t$(\"#password\").val(\"\");\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("$(window).resize(function(){\r\n");
      out.write("\tvar xian=$(document).width();\r\n");
      out.write("\tif(xian<parseInt(700)){\r\n");
      out.write("\t\t$(\".mycenter\").addClass(\"bodyWidth\");\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\t$(\".mycenter\").removeClass(\"bodyWidth\");\r\n");
      out.write("\t}\r\n");
      out.write("})\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
