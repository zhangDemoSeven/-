/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-12-07 01:54:16 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.system.menu;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class menu_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>菜单列表</title>\r\n");
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
      out.write("</head>\r\n");
      out.write("<body class=\"container-fluid\">\r\n");
      out.write("\t<blockquote class=\"layui-elem-quote news_search\" style=\"margin-top: 10px\">\r\n");
      out.write("\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t    <div class=\"layui-input-inline\">\r\n");
      out.write("\t\t    \t<input id=\"menuName\" type=\"text\" value=\"\"  placeholder=\"请输入菜单名称\" class=\"layui-input search_input\">\r\n");
      out.write("\t\t    </div>\r\n");
      out.write("\t\t    <a onclick=\"queryMenu()\" class=\"layui-btn search_btn\" ><b>查询</b></a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t<a class=\"layui-btn linksAdd_btn\"  onclick=\"openWindow();\" style=\"background-color:#5FB878\"><b>新增菜单</b></a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t<a class=\"layui-btn linksAdd_btn\"  onclick=\"updateWindow();\" style=\"background-color:#FFB800\"><b>修改信息</b></a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t<a class=\"layui-btn layui-btn-danger batchDel\" onclick=\"del();\"><b>删除菜单</b></a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t<a class=\"layui-btn linksAdd_btn\"  onclick=\"opt();\" style=\"background-color:#2F4056\"><b>启禁操作</b></a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</blockquote>\r\n");
      out.write("\t<div class=\"table-responsive\">\r\n");
      out.write("\t\t<table class=\"table table-striped table-hover\" id=\"menuTable\" style=\"text-align:center\"></table>\r\n");
      out.write("\t</div> \r\n");
      out.write("</body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(function(){\r\n");
      out.write("\t\r\n");
      out.write("\tinitMenuTable();\r\n");
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
      out.write("});\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("//菜单表格\r\n");
      out.write("function initMenuTable(){ \r\n");
      out.write("\t$(\"#menuTable\").bootstrapTable({\r\n");
      out.write("\t\turl:getRootPath()+'/menu/get/list.do',//加载表格数据的接口\r\n");
      out.write("\t\tmethod:'GET',//提交方式\r\n");
      out.write("\t\tdataType:'json',//服务器返回的数据格式\r\n");
      out.write("\t\ttoolbar:'#tb', //指定按钮组\r\n");
      out.write("\t\tcheckboxHeader:false,//设置为false时,表头隐藏复选框\r\n");
      out.write("\t\tsingleSelect:true,//只能单选行\r\n");
      out.write("\t\tstriped:true,//隔行换色\r\n");
      out.write("\t\tcache:false,//不进行缓存\r\n");
      out.write("\t\tclickToSelect:true, //点击行时,自动勾选复选框或单选框\r\n");
      out.write("\t\tpagination:true,//开启分页功能\r\n");
      out.write("\t\tsidePagination:'server',//这个分页功能需要在服务器端实现\r\n");
      out.write("\t\tpageNumber:1,//分页的起始页\r\n");
      out.write("\t\tpageSize:10,//初始化页面容量为10\r\n");
      out.write("\t\tpageList:[10,20,30,40,'All'],//设置可供选择的页面数据条数 设置为all时显示所有记录 \r\n");
      out.write("\t\tuniqueId:'id',//设置行的唯一标示\r\n");
      out.write("\t\tcardView:false,//是否显示详细视图\r\n");
      out.write("\t\tdetailView:false,//是否显示父子表\r\n");
      out.write("\t\tqueryParams:function(params){\r\n");
      out.write("\t\t\tvar temp = {\r\n");
      out.write("\t\t\t\t\tlimit:params.limit, //每页显示数量\r\n");
      out.write("\t\t\t\t\toffset:params.offset,//sql语句中的起始索引\r\n");
      out.write("\t\t\t\t\tpage:(params.offset / params.limit) + 1, //总页数\r\n");
      out.write("\t\t\t\t\tmenuName:$(\"#menuName\").val(),\r\n");
      out.write("\t\t\t};\r\n");
      out.write("\t\t\treturn temp;\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\tcolumns:[\r\n");
      out.write("\t\t\t{radio:true},\r\n");
      out.write("\t\t\t{field:'id',visible:false},//设置隐藏列\r\n");
      out.write("\t\t\t{field:'title',title:'菜单名称',align:'center'},\r\n");
      out.write("\t\t\t{field:'href',title:'菜单路径',align:'center'},\r\n");
      out.write("\t\t\t{field:'priority',title:'菜单权重',align:'center'},\r\n");
      out.write("\t\t\t{field:'prohibition',title:'启禁状态',align:'center',formatter:function(value,row,index){\r\n");
      out.write("\t\t\t\tif(value == 1) return \"<font color='green'>已启用</font>\";\r\n");
      out.write("\t\t\t\tif(value == 0) return \"<font color='red'>已禁用</font>\";\r\n");
      out.write("\t\t\t}},\r\n");
      out.write("\t\t\t{field:'createUser',title:'创建人',align:'center'},\r\n");
      out.write("\t\t\t{field:'createTime',title:'创建时间',align:'center',formatter:function(value,row,index){\r\n");
      out.write("\t\t\t\treturn dateFormatter(value);\r\n");
      out.write("\t\t\t}},\r\n");
      out.write("\t\t\t{field:'modifyUser',title:'修改人',align:'center'},\r\n");
      out.write("\t\t\t{field:'mdifyTime',title:'修改时间',align:'center',formatter:function(value,row,index){\r\n");
      out.write("\t\t\t\treturn dateFormatter(value);\r\n");
      out.write("\t\t\t}}\r\n");
      out.write("\t\t]\r\n");
      out.write("\t});\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("//启禁按钮\r\n");
      out.write("function opt(){\r\n");
      out.write("\tvar rows = $(\"#menuTable\").bootstrapTable('getSelections');\r\n");
      out.write("\tif(rows.length != 1){\r\n");
      out.write("\t\tlayer.msg(\"您必须选择一条记录进行操作\");\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}\r\n");
      out.write("\tvar menuId = rows[0].id;\r\n");
      out.write("\tparent.layer.confirm(\r\n");
      out.write("\t\t\"您确定要操作该条记录吗?\",\r\n");
      out.write("\t\t{title:'确认框'},\r\n");
      out.write("\t\tfunction(index){\r\n");
      out.write("\t\t\t $.ajax({\r\n");
      out.write("\t\t\t\ttype:'POST',//什么样方式进行提交\r\n");
      out.write("\t\t\t\tdataType:'json',//服务器返回数据的格式\r\n");
      out.write("\t\t\t\tdata:{\"menuId\":menuId},\r\n");
      out.write("\t\t\t\turl:getRootPath()+'/menu/opt/entity.do',\r\n");
      out.write("\t\t\t\tsuccess:function(data){//成功回调函数\r\n");
      out.write("\t\t\t\t\t//弹出服务端传递的消息体\r\n");
      out.write("\t\t\t\t\tparent.layer.msg(data.message);\r\n");
      out.write("\t\t\t\t\t//关闭弹窗\r\n");
      out.write("\t\t\t\t\tlayer.close(index);\r\n");
      out.write("\t\t\t\t\t//刷新一下表格\r\n");
      out.write("\t\t\t\t\t$(\"#menuTable\").bootstrapTable('refresh');\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\tfunction(index){\r\n");
      out.write("\t\t\tlayer.close(index);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("//新增\r\n");
      out.write("function openWindow(){\r\n");
      out.write("\tparent.layer.open({\r\n");
      out.write("\t\tarea:['70%',\"50%\"],\r\n");
      out.write("\t\ttitle:'添加或修改菜单',\r\n");
      out.write("\t\ttype:2,\r\n");
      out.write("\t\tshade:[1.2,\"#000\"],\r\n");
      out.write("\t\tshadeClose:true,\r\n");
      out.write("\t\tmaxmin:true,\r\n");
      out.write("\t\tcontent:getRootPath()+\"/menu/show/addentity.do\",\r\n");
      out.write("\t\tbtn:[\"提交\",'取消'],\r\n");
      out.write("\t\tbtnAlign:'c',\r\n");
      out.write("\t\tyes:function(index,layero){\r\n");
      out.write("\t\t\tvar body = layer.getChildFrame('body', index);\r\n");
      out.write("\t\t    var iframeWin = parent.window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：\r\n");
      out.write("\t\t    iframeWin.subChildForm();\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\tend:function(index){\r\n");
      out.write("\t\t\t$(\"#menuTable\").bootstrapTable('refresh');\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("//修改\r\n");
      out.write("function updateWindow(){\r\n");
      out.write("\tvar rows = $(\"#menuTable\").bootstrapTable('getSelections');\r\n");
      out.write("\tif(rows.length != 1){\r\n");
      out.write("\t\tparent.layer.msg(\"您必须选择一条记录进行操作\");\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tvar prohibition = rows[0].prohibition;\r\n");
      out.write("\t\r\n");
      out.write("\tif(prohibition == 0){\r\n");
      out.write("\t\tparent.layer.msg(\"禁用状态的数据无法编辑\");\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tvar menuId = rows[0].id;\r\n");
      out.write("\t\r\n");
      out.write("\tparent.layer.open({\r\n");
      out.write("\t\tarea:['70%',\"50%\"],\r\n");
      out.write("\t\ttitle:'添加或修改菜单',\r\n");
      out.write("\t\ttype:2,\r\n");
      out.write("\t\tshade:[1.2,\"#000\"],\r\n");
      out.write("\t\tshadeClose:true,\r\n");
      out.write("\t\tmaxmin:true,\r\n");
      out.write("\t\tcontent:getRootPath()+\"/menu/show/addentity.do?menuId=\"+menuId,\r\n");
      out.write("\t\tbtn:[\"提交\",'取消'],\r\n");
      out.write("\t\tbtnAlign:'c',\r\n");
      out.write("\t\tyes:function(index,layero){\r\n");
      out.write("\t\t\tvar body = layer.getChildFrame('body', index);\r\n");
      out.write("\t\t    var iframeWin = parent.window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：\r\n");
      out.write("\t\t    iframeWin.subChildForm();\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\tend:function(index){\r\n");
      out.write("\t\t\t$(\"#menuTable\").bootstrapTable('refresh');\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("//删除按钮\r\n");
      out.write("function del(){\r\n");
      out.write("\tvar rows = $(\"#menuTable\").bootstrapTable('getSelections');\r\n");
      out.write("\tif(rows.length != 1){\r\n");
      out.write("\t\tlayer.msg(\"您必须选择一条记录进行操作\");\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}\r\n");
      out.write("\tvar menuId = rows[0].id;\r\n");
      out.write("\tparent.layer.confirm(\r\n");
      out.write("\t\t\"您确定要删除该条记录吗?\",\r\n");
      out.write("\t\t{title:'确认框'},\r\n");
      out.write("\t\tfunction(index){\r\n");
      out.write("\t\t\t $.ajax({\r\n");
      out.write("\t\t\t\ttype:'POST',//什么样方式进行提交\r\n");
      out.write("\t\t\t\tdataType:'json',//服务器返回数据的格式\r\n");
      out.write("\t\t\t\tdata:{\"menuId\":menuId},\r\n");
      out.write("\t\t\t\turl:getRootPath()+'/menu/del/entity.do',\r\n");
      out.write("\t\t\t\tsuccess:function(data){//成功回调函数\r\n");
      out.write("\t\t\t\t\t//弹出服务端传递的消息体\r\n");
      out.write("\t\t\t\t\tparent.layer.msg(data.message);\r\n");
      out.write("\t\t\t\t\t//关闭弹窗\r\n");
      out.write("\t\t\t\t\tlayer.close(index);\r\n");
      out.write("\t\t\t\t\t//刷新一下表格\r\n");
      out.write("\t\t\t\t\t$(\"#menuTable\").bootstrapTable('refresh');\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\tfunction(index){\r\n");
      out.write("\t\t\tlayer.close(index);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function queryMenu(){\r\n");
      out.write("\t$(\"#menuTable\").bootstrapTable('refresh');\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
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
