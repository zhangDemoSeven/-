/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-12-04 09:29:48 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.system.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class student_005fok_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html lang=\"zh-CN\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no\">\r\n");
      out.write("<title>正式学生列表</title>\r\n");
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
      out.write("<script type=\"text/javascript\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("\t<body class=\"container-fluid\">\r\n");
      out.write("\t\t<blockquote class=\"layui-elem-quote news_search\" style=\"margin-top: 10px\">\r\n");
      out.write("\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t     <div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t    \t<input id=\"userName\" type=\"text\" value=\"\"  placeholder=\"请输入学生姓名\" class=\"layui-input search_input\">\r\n");
      out.write("\t\t\t    </div>\r\n");
      out.write("\t\t\t    <div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t  <input id=\"queryDate\" type=\"text\" class=\"layui-input\" placeholder=\"请选择创建时间\" >\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t    \r\n");
      out.write("\t\t\t    <a onclick=\"queryUser()\" class=\"layui-btn search_btn\" ><b>查询</b></a>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"layui-inline\" style=\"margin-top: 5px\">\r\n");
      out.write("\t\t\t\t\t<a class=\"layui-btn linksAdd_btn\"  onclick=\"addClasses();\" style=\"background-color:#5FB878\"><b>指定班级</b></a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t\t<a class=\"layui-btn linksAdd_btn\"  onclick=\"editClasses();\" style=\"background-color:#FFB800\"><b>转班申请</b></a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\t\r\n");
      out.write("\t\t</blockquote>\r\n");
      out.write("\t\t<div class=\"table-responsive\">\r\n");
      out.write("\t\t\t<table class=\"table table-striped table-hover\" id=\"studentTable\" style=\"text-align:center\"></table>\r\n");
      out.write("\t\t</div> \r\n");
      out.write("\t</body>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(function(){\r\n");
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
      out.write("       if (window.event && window.event.keyCode == 123) {\r\n");
      out.write("           event.keyCode = 0;\r\n");
      out.write("           event.returnValue = false;\r\n");
      out.write("           return false;\r\n");
      out.write("        }\r\n");
      out.write("     };\r\n");
      out.write("\t\r\n");
      out.write("\tinitStudentTable();\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("function addClasses(){\r\n");
      out.write("\t\r\n");
      out.write("\tvar rows = $(\"#studentTable\").bootstrapTable(\"getSelections\");\r\n");
      out.write("\t\r\n");
      out.write("\tif(rows.length != 1){\r\n");
      out.write("\t\tparent.layer.msg(\"请选择一行进行操作\");\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tvar userId = rows[0].id;\r\n");
      out.write("\t\r\n");
      out.write("\t$.post(getRootPath()+\"/student/check/classes.do\",{\"userId\":userId},function(data){\r\n");
      out.write("\t\tif(data.code == 5000){\r\n");
      out.write("\t\t\tparent.layer.msg(data.message);\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\tparent.layer.open({\r\n");
      out.write("\t\t\t\tid:'insert-form',\r\n");
      out.write("\t\t\t\tarea:[\"500px\",\"300px\"],\r\n");
      out.write("\t\t\t\ttype:2,\r\n");
      out.write("\t\t\t\tscrollbar:true,\r\n");
      out.write("\t\t\t\tmaxmin:true,\r\n");
      out.write("\t\t\t\tcontent:getRootPath()+\"/student/show/classes.do?userId=\"+userId,\r\n");
      out.write("\t\t\t\tbtn:[\"提交\",\"取消\"],\r\n");
      out.write("\t\t\t\tbtnAlign:'c',\r\n");
      out.write("\t\t\t\tyes:function(index,layero){\r\n");
      out.write("\t\t\t\t    var body = layer.getChildFrame('body', index);\r\n");
      out.write("\t\t\t\t    var iframeWin = parent.window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：\r\n");
      out.write("\t\t\t\t    iframeWin.subChildForm();\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tend:function(index){\r\n");
      out.write("\t\t\t\t\twindow.location.reload(true);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function initStudentTable(){\r\n");
      out.write("\t$(\"#studentTable\").bootstrapTable({\r\n");
      out.write("\t\turl:getRootPath()+'/student/get/oklist.do',\r\n");
      out.write("\t\tmethod : 'GET',\r\n");
      out.write("\t\tdataType : 'json',\r\n");
      out.write("\t\tcheckboxHeader : false, //设置为false时,表头隐藏复选框\r\n");
      out.write("\t\tsingleSelect : true, //只能单选行\r\n");
      out.write("\t\tstriped : true, //隔行换色\r\n");
      out.write("\t\tcache : false, ////是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）\r\n");
      out.write("\t\tclickToSelect : true, //点击行时,自动勾选复选框或单选框\r\n");
      out.write("\t\tpagination : true,//是否显示分页工具条\r\n");
      out.write("\t\tsidePagination : \"server\", //分页方式：client客户端分页，server服务端分页（*）\r\n");
      out.write("\t\tpageNumber : 1, //首页页码\r\n");
      out.write("\t\tpageSize : 10, //页面容量\r\n");
      out.write("\t\tuniqueId : \"id\", //每一行的唯一标识，一般为主键列\r\n");
      out.write("\t\tcardView : false, //是否显示详细视图\r\n");
      out.write("\t\tdetailView : true, //是否显示父子表\r\n");
      out.write("\t\tqueryParams : function(params) {//得到查询的参数\r\n");
      out.write("\t\t\t//这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的\r\n");
      out.write("\t\t\tvar temp = {\r\n");
      out.write("\t\t\t\tlimit : params.limit, // 每页显示数量\r\n");
      out.write("\t\t\t\toffset : params.offset, // SQL语句起始索引\r\n");
      out.write("\t\t\t\tpage : (params.offset / params.limit) + 1,\r\n");
      out.write("\t\t\t\tuserName:$(\"#userName\").val(),\r\n");
      out.write("\t\t\t\tqueryDate:$(\"#queryDate\").val(),\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t};\r\n");
      out.write("\t\t\treturn temp;\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\tcolumns:[\r\n");
      out.write("\t\t\t{radio : true},\r\n");
      out.write("\t\t\t{field : 'id',visible : false},\r\n");
      out.write("\t\t\t{field : 'username',visible : false},\r\n");
      out.write("\t\t\t{field : 'password',visible : false},\r\n");
      out.write("\t\t\t{field : 'cord',visible : false},\t\t\t\r\n");
      out.write("\t\t\t{field : 'level',visible : false},\r\n");
      out.write("\t\t\t{field : 'identity',visible : false},\r\n");
      out.write("\t\t\t{field : 'examId',visible : false},\r\n");
      out.write("\t\t\t{field : 'nickName',title : '学生姓名',align : 'center'},\r\n");
      out.write("\t\t\t{field : 'telephoneA',title : '常用电话',align : 'center'},\r\n");
      out.write("\t\t\t{field : 'classesNames',title : '所在班级',align : 'center'},\r\n");
      out.write("\t\t\t{field : 'user1Name',title : '网咨',align : 'center'},\r\n");
      out.write("\t\t\t{field : 'user2Name',title : '咨询',align : 'center'},\r\n");
      out.write("\t\t\t{field : 'user3Name',title : '助理',align : 'center'}\r\n");
      out.write("\t\t],\r\n");
      out.write("\t\tonExpandRow : function(index, row, $detail){\r\n");
      out.write("\t\t\t//创建一个新的table表\r\n");
      out.write("\t\t\tvar parentId = row.id;\r\n");
      out.write("\t\t\tvar cur_table = $detail.html('<table></table>').find('table');\r\n");
      out.write("\t\t\tvar html = \"\";\r\n");
      out.write("\t\t\thtml += \"<table class='table table-bordered table-condensed'>\";\r\n");
      out.write("\t\t\thtml += \"<thead>\";\r\n");
      out.write("\t\t\thtml += \"<tr style='height: 40px'>\";\r\n");
      out.write("\t\t\thtml +=\"<th style='text-align: center;padding-bottom:10px;' class='warning'>年龄</th>\";\r\n");
      out.write("\t\t\thtml +=\"<th style='text-align: center;padding-bottom:10px;' class='warning'>生日</th>\";\r\n");
      out.write("\t\t\thtml +=\"<th style='text-align: center;padding-bottom:10px;' class='warning'>QQ</th>\";\r\n");
      out.write("\t\t\thtml +=\"<th style='text-align: center;padding-bottom:10px;' class='warning'>备用电话</th>\";\r\n");
      out.write("\t\t\thtml +=\"<th style='text-align: center;padding-bottom:10px;' class='warning'>邮箱</th>\";\r\n");
      out.write("\t\t\thtml +=\"<th style='text-align: center;padding-bottom:10px;' class='warning'>地址</th>\";\r\n");
      out.write("\t\t\thtml +=\"<th style='text-align: center;padding-bottom:10px;' class='warning'>备注</th>\";\r\n");
      out.write("\t\t\thtml +=\"<th style='text-align: center;padding-bottom:10px;' class='warning'>创建时间</th>\";\r\n");
      out.write("\t\t\thtml +=\"<th style='text-align: center;padding-bottom:10px;' class='warning'>学历</th>\";\r\n");
      out.write("\t\t\thtml +=\"<th style='text-align: center;padding-bottom:10px;' class='warning'>专业</th>\";\r\n");
      out.write("\t\t\thtml +=\"<th style='text-align: center;padding-bottom:10px;' class='warning'>现状</th>\";\r\n");
      out.write("\t\t\thtml +=\"<th style='text-align: center;padding-bottom:10px;' class='warning'>课程</th>\";\r\n");
      out.write("\t\t\thtml +=\"<th style='text-align: center;padding-bottom:10px;' class='warning'>网站</th>\";\r\n");
      out.write("\t\t\thtml +=\"<th style='text-align: center;padding-bottom:10px;' class='warning'>工具</th>\";\r\n");
      out.write("\t\t\thtml +=\"<th style='text-align: center;padding-bottom:10px;' class='warning'>渠道</th>\";\r\n");
      out.write("\t\t\thtml +=\"</tr>\";\r\n");
      out.write("\t\t\thtml +=\"</thead>\";\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\thtml+=\"<tr>\"\r\n");
      out.write("\t\t\t\t+\"<td>\"+row.age+\"</td>\"\r\n");
      out.write("\t\t\t\t+\"<td>\"+dateFormatter(row.birthday)+\"</td>\"\r\n");
      out.write("\t\t\t\t+\"<td>\"+row.qq+\"</td>\"\r\n");
      out.write("\t\t\t\t+\"<td>\"+row.telephoneB+\"</td>\"\r\n");
      out.write("\t\t\t\t+\"<td>\"+row.email+\"</td>\"\r\n");
      out.write("\t\t\t\t+\"<td><button class='btn btn-default btn-xs' style='background:#FF7519;color:white' onclick='layer.msg(\\\"\"+row.address+\"\\\")'>查看</button></td>\"\r\n");
      out.write("\t\t\t\t+\"<td><button class='btn btn-default btn-xs' style='background:#FF7519;color:white' onclick='layer.msg(\\\"\"+row.description+\"\\\")'>查看</button></td>\"\r\n");
      out.write("\t\t\t\t+\"<td>\"+dateFormatter(row.createTime)+\"</td>\"\r\n");
      out.write("\t\t\t\t+\"<td>\"+row.educationName+\"</td>\"\r\n");
      out.write("\t\t\t\t+\"<td>\"+row.majorName+\"</td>\"\r\n");
      out.write("\t\t\t\t+\"<td>\"+row.stiuationName+\"</td>\"\r\n");
      out.write("\t\t\t\t+\"<td>\"+row.classificationName+\"</td>\"\r\n");
      out.write("\t\t\t\t+\"<td>\"+row.sourceName+\"</td>\"\r\n");
      out.write("\t\t\t\t+\"<td>\"+row.toolName+\"</td>\"\r\n");
      out.write("\t\t\t\t+\"<td>\"+row.channelName+\"</td>\"\r\n");
      out.write("\t\t\t\t+\"</tr>\";\r\n");
      out.write("\t\t\thtml +=\"</table>\";\t\r\n");
      out.write("\t\t\t//最重要的一句话\r\n");
      out.write("\t\t\t$detail.html(html);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("layui.use(['laydate','layer','form'], function(){\r\n");
      out.write("  var laydate = layui.laydate,\r\n");
      out.write("  layer = layui.layer,\r\n");
      out.write("  form = layui.form;\r\n");
      out.write("  \r\n");
      out.write("  //加载日期\r\n");
      out.write("  laydate.render({\r\n");
      out.write("\trange: '~',\r\n");
      out.write("    elem: '#queryDate',\r\n");
      out.write("    done: function(value, date, endDate){\r\n");
      out.write("    \t$(\"#queryDate\").val(value);\r\n");
      out.write("    }\r\n");
      out.write("  });\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("function queryUser(){\r\n");
      out.write("\t$(\"#studentTable\").bootstrapTable('refresh');\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
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
