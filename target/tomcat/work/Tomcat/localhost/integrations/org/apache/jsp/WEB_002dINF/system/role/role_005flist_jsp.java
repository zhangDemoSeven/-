/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-12-07 01:53:57 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.system.role;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class role_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<meta name=\"viewport\" content=\"width=device-width,inital-scale=1,maximum-scale=1,user-scalable=no\">\r\n");
      out.write("<title>角色列表</title>\r\n");
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
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(function(){\r\n");
      out.write("\tinitRoleTable();\r\n");
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
      out.write("\t\t\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("//创建角色表格\r\n");
      out.write("function initRoleTable(){\r\n");
      out.write("\t$(\"#roleTable\").bootstrapTable({\r\n");
      out.write("\t\ttoolbar:'#tb',\r\n");
      out.write("\t\turl:getRootPath() + \"/role/get/list.do\",\r\n");
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
      out.write("\t\tpageSize : 5, //页面容量\r\n");
      out.write("\t\tpageList : [ 10, 25, 50, 100, 'All' ],//设置可供选择的页面数据条数。设置为 All 或者 Unlimited，则显示所有记录\r\n");
      out.write("\t\tuniqueId : \"id\", //每一行的唯一标识，一般为主键列\r\n");
      out.write("\t\tcardView : false, //是否显示详细视图\r\n");
      out.write("\t\tqueryParams : function(params) {//得到查询的参数\r\n");
      out.write("\t\t\t//这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的\r\n");
      out.write("\t\t\tvar temp = {\r\n");
      out.write("\t\t\t\tlimit : params.limit, // 每页显示数量\r\n");
      out.write("\t\t\t\toffset : params.offset, // SQL语句起始索引\r\n");
      out.write("\t\t\t\tpage : (params.offset / params.limit) + 1,\r\n");
      out.write("\t\t\t\troleName:$(\"#roleName\").val(),\r\n");
      out.write("\t\t\t};\r\n");
      out.write("\t\t\treturn temp;\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\tcolumns:[\r\n");
      out.write("\t\t\t{radio : true},\r\n");
      out.write("\t\t\t{field : 'id',visible : false},//visible:false隐藏\r\n");
      out.write("\t\t\t{field : 'name',title : '角色名称',titleTooltip : '这是角色的名称',align : 'center'},\r\n");
      out.write("\t\t\t{field : 'keyword',title : '关键字',align : 'center'},\r\n");
      out.write("\t\t\t{field : 'description',title : '角色描述',align : 'center'},\r\n");
      out.write("\t\t\t{field : 'prohibition',title : '启禁状态',align : 'center', formatter : function(value,row,index){\r\n");
      out.write("\t\t\t\tif (value == 0) return \"<font color='red'>已禁用</font>\";\r\n");
      out.write("\t\t\t\tif (value == 1) return \"<font color='green'>已启用</font>\";\r\n");
      out.write("\t\t\t\telse return \"<font color='yellow'>数据加载异常</font>\";\r\n");
      out.write("\t\t\t}}\r\n");
      out.write("\t\t]\r\n");
      out.write("\t});\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function queryRole(){\r\n");
      out.write("\t$(\"#roleTable\").bootstrapTable('refresh');\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("//新增按钮\r\n");
      out.write("function openWindow(){\r\n");
      out.write("\tparent.layer.open({\r\n");
      out.write("\t\tcontent:getRootPath()+'/role/show/addentity.do',\r\n");
      out.write("\t\ttype:2,\r\n");
      out.write("\t\tshade: [1.2, '#000'],\r\n");
      out.write("\t\tshadeClose:true,\r\n");
      out.write("\t\tarea: ['80%', '80%'],\r\n");
      out.write("\t\tmaxmin: true,\r\n");
      out.write("\t\tbtn:[\"提交\",'取消'],\r\n");
      out.write("\t\tbtnAlign:'c',\r\n");
      out.write("\t\tyes:function(index,layero){\r\n");
      out.write("\t\t\tvar body = layer.getChildFrame('body', index);\r\n");
      out.write("\t\t    var iframeWin = parent.window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：\r\n");
      out.write("\t\t    iframeWin.subChildForm();\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\tend:function(index){\r\n");
      out.write("\t\t\t$(\"#roleTable\").bootstrapTable('refresh');\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("//编辑按钮\r\n");
      out.write("function edit(){\r\n");
      out.write("\tvar rows = $(\"#roleTable\").bootstrapTable('getSelections');\r\n");
      out.write("\t\r\n");
      out.write("\tif(rows.length != 1){\r\n");
      out.write("\t\tparent.layer.msg(\"请选择一条数据进行操作\");\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tvar prohibition = rows[0].prohibition;\r\n");
      out.write("\t\r\n");
      out.write("\tif(prohibition == \"0\"){\r\n");
      out.write("\t\tlayer.msg(\"禁用的记录无法编辑\");\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tvar roleId = rows[0].id;\r\n");
      out.write("\t\r\n");
      out.write("\tparent.layer.open({\r\n");
      out.write("\t\tcontent:getRootPath()+'/role/show/addentity.do?roleId='+roleId,\r\n");
      out.write("\t\ttype:2,\r\n");
      out.write("\t\tshade: [1.2, '#000'],\r\n");
      out.write("\t\tshadeClose:true,\r\n");
      out.write("\t\tarea: ['80%', '80%'],\r\n");
      out.write("\t\tmaxmin: true,\r\n");
      out.write("\t\tbtn:[\"提交\",'取消'],\r\n");
      out.write("\t\tbtnAlign:'c',\r\n");
      out.write("\t\tyes:function(index,layero){\r\n");
      out.write("\t\t\tvar body = layer.getChildFrame('body', index);\r\n");
      out.write("\t\t    var iframeWin = parent.window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：\r\n");
      out.write("\t\t    iframeWin.subChildForm();\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\tend:function(index){\r\n");
      out.write("\t\t\t$(\"#roleTable\").bootstrapTable('refresh');\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("//启禁按钮\r\n");
      out.write("function opt(){\r\n");
      out.write("\tvar rows = $(\"#roleTable\").bootstrapTable('getSelections');\r\n");
      out.write("\t\r\n");
      out.write("\tif(rows.length != 1){\r\n");
      out.write("\t\tparent.layer.msg(\"请选择一条数据进行操作\");\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tvar roleId = rows[0].id;\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\tparent.layer.confirm(\r\n");
      out.write("\t\t\t'您确定要操作该条数据吗?'\r\n");
      out.write("\t\t\t,{title:'启禁确认'},\r\n");
      out.write("\t\t\tfunction(index){\r\n");
      out.write("\t\t\t\t$.post(getRootPath()+'/role/opt/entity.do',{\"roleId\":roleId},function(data){\r\n");
      out.write("\t\t\t\t\tparent.layer.msg(data.message);\r\n");
      out.write("\t\t\t\t\tlayer.close(index);\r\n");
      out.write("\t\t\t\t\t$(\"#roleTable\").bootstrapTable('refresh');\r\n");
      out.write("\t\t\t\t},'json');\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tfunction(index){\r\n");
      out.write("\t\t\t\tlayer.close(index);\r\n");
      out.write("\t\t\t\tparent.layer.msg(\"取消了操作\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("//删除按钮\r\n");
      out.write("function del(){\r\n");
      out.write("\tvar rows = $(\"#roleTable\").bootstrapTable('getSelections');\r\n");
      out.write("\t\r\n");
      out.write("\tif(rows.length != 1){\r\n");
      out.write("\t\tparent.layer.msg(\"请选择一条数据进行操作\");\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tvar roleId = rows[0].id;\r\n");
      out.write("\tparent.layer.confirm(\r\n");
      out.write("\t\t\t'您确定要删除该条数据吗?'\r\n");
      out.write("\t\t\t,{title:'删除确认'},\r\n");
      out.write("\t\t\tfunction(index){\r\n");
      out.write("\t\t\t\t$.post(getRootPath()+'/role/del/entity.do',{\"roleId\":roleId},function(data){\r\n");
      out.write("\t\t\t\t\tparent.layer.msg(data.message);\r\n");
      out.write("\t\t\t\t\tlayer.close(index);\r\n");
      out.write("\t\t\t\t\t$(\"#roleTable\").bootstrapTable('refresh');\r\n");
      out.write("\t\t\t\t},'json');\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tfunction(index){\r\n");
      out.write("\t\t\t\tlayer.close(index);\r\n");
      out.write("\t\t\t\tparent.layer.msg(\"取消了操作\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"container-fluid\">\r\n");
      out.write("\t<blockquote class=\"layui-elem-quote news_search\" style=\"margin-top: 10px\">\r\n");
      out.write("\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t    <div class=\"layui-input-inline\">\r\n");
      out.write("\t\t    \t<input id=\"roleName\" type=\"text\" value=\"\"  placeholder=\"请输入角色名称\" class=\"layui-input search_input\">\r\n");
      out.write("\t\t    </div>\r\n");
      out.write("\t\t    <a onclick=\"queryRole()\" class=\"layui-btn search_btn\" ><b>查询</b></a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t<a class=\"layui-btn linksAdd_btn\"  onclick=\"openWindow();\" style=\"background-color:#5FB878\"><b>新增角色</b></a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t<a class=\"layui-btn linksAdd_btn\"  onclick=\"edit();\" style=\"background-color:#FFB800\"><b>修改信息</b></a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t<a class=\"layui-btn layui-btn-danger batchDel\" onclick=\"del();\"><b>删除角色</b></a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t<a class=\"layui-btn linksAdd_btn\"  onclick=\"opt();\" style=\"background-color:#2F4056\"><b>启禁操作</b></a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</blockquote>\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"table-responsive\">\r\n");
      out.write("\t\t<table id=\"roleTable\"  class=\"table table-striped table-hover\"  style=\"text-align: center;\"></table>\r\n");
      out.write("\t</div>\r\n");
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
