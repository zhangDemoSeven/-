/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-12-07 00:54:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

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
      out.write("<html lang=\"zh-CN\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\r\n");
      out.write("<meta name=\"renderer\" content=\"webkit\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n");
      out.write("<meta http-equiv=\"Access-Control-Allow-Origin\" content=\"*\">\r\n");
      out.write("<meta name=\"apple-mobile-web-app-status-bar-style\" content=\"black\">\r\n");
      out.write("<meta name=\"apple-mobile-web-app-capable\" content=\"yes\">\r\n");
      out.write("<meta name=\"format-detection\" content=\"telephone=no\">\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/plugins/layui/css/layui.css\" media=\"all\"/>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"//at.alicdn.com/t/font_tnyc012u2rlwstt9.css\" media=\"all\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/css/main.css\" media=\"all\" />\r\n");
      out.write("<title>石家庄东美春宁 智谷</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"main_body\">\r\n");
      out.write("\t<div class=\"layui-layout layui-layout-admin\">\r\n");
      out.write("\t\t<!-- 顶部 -->\t\t\r\n");
      out.write("\t\t<div class=\"layui-header header\">\r\n");
      out.write("\t\t\t<div class=\"layui-main\">\r\n");
      out.write("\t\t\t\t<a href=\"#\" class=\"logo\">东美春宁  智谷</a>\r\n");
      out.write("\t\t\t\t<!-- 显示/隐藏菜单 -->\r\n");
      out.write("\t\t\t\t<a href=\"javascript:;\" class=\"iconfont hideMenu icon-menu1\"></a>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t    <!-- 天气信息 -->\r\n");
      out.write("\t\t\t    <div class=\"weather\" pc>\r\n");
      out.write("\t\t\t    \t<div id=\"tp-weather-widget\"></div>\r\n");
      out.write("\t\t\t\t\t<script>(function(T,h,i,n,k,P,a,g,e){g=function(){P=h.createElement(i);a=h.getElementsByTagName(i)[0];P.src=k;P.charset=\"utf-8\";P.async=1;a.parentNode.insertBefore(P,a)};T[\"ThinkPageWeatherWidgetObject\"]=n;T[n]||(T[n]=function(){(T[n].q=T[n].q||[]).push(arguments)});T[n].l=+new Date();if(T.attachEvent){T.attachEvent(\"onload\",g)}else{T.addEventListener(\"load\",g,false)}}(window,document,\"script\",\"tpwidget\",\"//widget.seniverse.com/widget/chameleon.js\"))</script>\r\n");
      out.write("\t\t\t\t\t<script>tpwidget(\"init\", {\r\n");
      out.write("\t\t\t\t\t    \"flavor\": \"slim\",\r\n");
      out.write("\t\t\t\t\t    \"location\": \"WX4FBXXFKE4F\",\r\n");
      out.write("\t\t\t\t\t    \"geolocation\": \"enabled\",\r\n");
      out.write("\t\t\t\t\t    \"language\": \"zh-chs\",\r\n");
      out.write("\t\t\t\t\t    \"unit\": \"c\",\r\n");
      out.write("\t\t\t\t\t    \"theme\": \"chameleon\",\r\n");
      out.write("\t\t\t\t\t    \"container\": \"tp-weather-widget\",\r\n");
      out.write("\t\t\t\t\t    \"bubble\": \"disabled\",\r\n");
      out.write("\t\t\t\t\t    \"alarmType\": \"badge\",\r\n");
      out.write("\t\t\t\t\t    \"color\": \"#FFFFFF\",\r\n");
      out.write("\t\t\t\t\t    \"uid\": \"U9EC08A15F\",\r\n");
      out.write("\t\t\t\t\t    \"hash\": \"039da28f5581f4bcb5c799fb4cdfb673\"\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\ttpwidget(\"show\");</script>\r\n");
      out.write("\t\t\t    </div>\r\n");
      out.write("\t\t\t    <!-- 顶部右侧菜单 -->\r\n");
      out.write("\t\t\t    <ul class=\"layui-nav top_menu\">\r\n");
      out.write("\t\t\t    \t<li class=\"layui-nav-item showNotice\" id=\"showNotice\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:;\"><i class=\"iconfont icon-gonggao\"></i><cite>系统公告<span class=\"layui-badge-dot\" id=\"isHasNew\" style=\"display:none;\"></span></cite></a>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t    \r\n");
      out.write("\t\t\t    \t<li class=\"layui-nav-item\" mobile>\r\n");
      out.write("\t\t\t    \t\t<a href=\"page/login/login.html\" class=\"signOut\"><i class=\"iconfont icon-loginout\"></i> 退出</a>\r\n");
      out.write("\t\t\t    \t</li>\r\n");
      out.write("\t\t\t\t\t<li class=\"layui-nav-item lockcms\" pc>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:;\"><i class=\"iconfont icon-lock1\"></i><cite>锁屏</cite></a>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li class=\"layui-nav-item\" pc>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:;\">\r\n");
      out.write("\t\t\t\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/images/32.jpg\" class=\"layui-circle\" width=\"35\" height=\"35\">\r\n");
      out.write("\t\t\t\t\t\t\t<cite>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.nickName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</cite>\r\n");
      out.write("\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- 左侧导航 -->\r\n");
      out.write("\t\t<div class=\"layui-side layui-bg-black\">\r\n");
      out.write("\t\t\t<div class=\"user-photo\">\r\n");
      out.write("\t\t\t\t<a class=\"img\" title=\"我的头像\" ><img src=\"static/img/badge/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.identity }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(".png\"></a>\r\n");
      out.write("\t\t\t\t<p>你好！<span class=\"userName\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.nickName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</span></p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"navBar layui-side-scroll\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- 右侧内容 -->\r\n");
      out.write("\t\t<div class=\"layui-body layui-form\">\r\n");
      out.write("\t\t\t<div class=\"layui-tab marg0\" lay-filter=\"bodyTab\" id=\"top_tabs_box\">\r\n");
      out.write("\t\t\t\t<ul class=\"layui-tab-title top_tab\" id=\"top_tabs\">\r\n");
      out.write("\t\t\t\t\t<li class=\"layui-this\" lay-id=\"\"><i class=\"iconfont icon-computer\"></i> <cite>后台首页</cite></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t<ul class=\"layui-nav closeBox\">\r\n");
      out.write("\t\t\t\t  <li class=\"layui-nav-item\">\r\n");
      out.write("\t\t\t\t    <a href=\"javascript:;\"><i class=\"iconfont icon-caozuo\"></i> 页面操作</a>\r\n");
      out.write("\t\t\t\t    <dl class=\"layui-nav-child\">\r\n");
      out.write("\t\t\t\t\t  <dd><a href=\"javascript:;\" class=\"refresh refreshThis\"><i class=\"layui-icon\">&#x1002;</i> 刷新当前</a></dd>\r\n");
      out.write("\t\t\t\t\t  <dd><a href=\"javascript:;\" class=\"goParents\"><i class=\"layui-icon\">&#xe65c;</i> 返回父级</a></dd>\r\n");
      out.write("\t\t\t\t\t  <dd><a href=\"javascript:;\" class=\"closePageOther\"><i class=\"iconfont icon-prohibit\"></i> 关闭其他</a></dd>\r\n");
      out.write("\t\t\t\t      <dd><a href=\"javascript:;\" class=\"closePageAll\"><i class=\"iconfont icon-guanbi\"></i> 关闭全部</a></dd>\r\n");
      out.write("\t\t\t\t    </dl>\r\n");
      out.write("\t\t\t\t  </li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t<div class=\"layui-tab-content clildFrame\">\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-tab-item layui-show\">\r\n");
      out.write("\t\t\t\t\t\t<iframe style=\"background-image: url('static/img/bei01.jpg');\"></iframe>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- 底部 -->\r\n");
      out.write("\t\t<div class=\"layui-footer footer\">\r\n");
      out.write("\t\t\t<marquee id = \"messageCard\" style=\"margin:0px; color: white; background-color: darkgrey;\" direction=\"left\" behavior=\"scroll\" scrollamount=\"3\" scrolldelay=\"40\">\r\n");
      out.write("\t\t\t</marquee>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- 项目地址 -->\r\n");
      out.write("\t<input id =\"getRootPath\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("\t<!-- 移动导航 -->\r\n");
      out.write("\t<div class=\"site-tree-mobile layui-hide\"><i class=\"layui-icon\">&#xe602;</i></div>\r\n");
      out.write("\t<div class=\"site-mobile-shade\"></div>\r\n");
      out.write("\t\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/js/jquery.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/plugins/layui/layui.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/js/leftNav.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/js/index.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/js/tool.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t$(function(){\r\n");
      out.write("\t\t\thistory.pushState(null, null, document.URL);\r\n");
      out.write("\t\t\twindow.addEventListener('popstate', function () {\r\n");
      out.write("\t\t\t    history.pushState(null, null, document.URL);\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tdocument.oncontextmenu = function () { \r\n");
      out.write("\t\t\t\treturn false; \r\n");
      out.write("\t\t\t};\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t    document.onkeydown = function () {\r\n");
      out.write("\t\t       if (window.event && window.event.keyCode == 123) {\r\n");
      out.write("\t\t           event.keyCode = 0;\r\n");
      out.write("\t\t           event.returnValue = false;\r\n");
      out.write("\t\t           return false;\r\n");
      out.write("\t\t        }\r\n");
      out.write("\t\t     };\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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