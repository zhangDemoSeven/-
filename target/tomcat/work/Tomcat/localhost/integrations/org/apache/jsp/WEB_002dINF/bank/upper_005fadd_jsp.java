/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-12-08 13:17:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.bank;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class upper_005fadd_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/header/header.jsp", Long.valueOf(1541900141329L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>用户添加</title>\r\n");
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
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/bootstrap/bootstrapfileupload/js/fileinput.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/bootstrap/bootstrapfileupload/js/locales/zh.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/kindeditor-master/kindeditor-all.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/kindeditor-master/lang/zh-CN.js\"></script>\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/kindeditor-master/themes/default/default.css\" />\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("function subChildForm(){\r\n");
      out.write("\r\n");
      out.write("\t// 通过kindEditor数据到textarea \r\n");
      out.write("\twindow.editor.sync();\r\n");
      out.write("\t\r\n");
      out.write("\tvar booksId  = $('input[name=\"booksId\"]:checked').val(); \r\n");
      out.write("\tvar chapterId  = $('input[name=\"chapterId\"]:checked').val(); \r\n");
      out.write("\tvar title = $(\"#kindeditorWindow\").val();\r\n");
      out.write("\t\r\n");
      out.write("\tif(booksId == null || booksId == \"\" || booksId == undefined){parent.layer.msg(\"请正确定义课程\");return;}\r\n");
      out.write("\t\r\n");
      out.write("\tif(chapterId == null || chapterId == \"\" || chapterId == undefined){parent.layer.msg(\"请正确定义章节\");return;}\r\n");
      out.write("\t\r\n");
      out.write("\tif(title == null || title == \"\" || title == undefined){parent.layer.msg(\"请正确定义题干\");return;}\r\n");
      out.write("\t\r\n");
      out.write("\tvar bootstrapValidator = $('#upperForm').data('bootstrapValidator');\r\n");
      out.write("\t\r\n");
      out.write("\tbootstrapValidator.validate();\r\n");
      out.write("\t  \r\n");
      out.write("\tif(bootstrapValidator.isValid()){\r\n");
      out.write("\t\t $.post($(\"#upperForm\").attr('action'), $(\"#upperForm\").serialize(), function(result) {\r\n");
      out.write("    \t    parent.layer.msg(result.message);\r\n");
      out.write("    \t    KindEditor.instances[0].html(\"\"); \r\n");
      out.write("    \t    var index = parent.layer.getFrameIndex(window.name);\r\n");
      out.write("\t\t\tparent.layer.close(index);\r\n");
      out.write("\t     }, 'json');\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\tlayer.msg(\"校验不通过\");\r\n");
      out.write("\t    return;\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("//校验规则+提交事件\r\n");
      out.write("function formValidator(){\r\n");
      out.write("\t$(\"#upperForm\").bootstrapValidator({\r\n");
      out.write("\t\tmessage:'该值无法校验',\r\n");
      out.write("\t\tfeedbackIcons: {\r\n");
      out.write("\t           valid: 'glyphicon glyphicon-ok',\r\n");
      out.write("\t           invalid: 'glyphicon glyphicon-remove',\r\n");
      out.write("\t           validating: 'glyphicon glyphicon-refresh'\r\n");
      out.write("\t    },\r\n");
      out.write("\t    fields:{\r\n");
      out.write("\t    \ttitle:{\r\n");
      out.write("\t    \t\tvalidators:{\r\n");
      out.write("\t    \t\t\tnotEmpty:{\r\n");
      out.write("\t    \t\t\t\tmessage:'题干不能为空'\r\n");
      out.write("\t    \t\t\t},\r\n");
      out.write("\t    \t\t\tstringLength:{\r\n");
      out.write("\t    \t\t\t\tmin:5,\r\n");
      out.write("\t    \t\t\t\tmax:2000,\r\n");
      out.write("\t    \t\t\t\tmessage:'题目的长度在5-2000个字节'\r\n");
      out.write("\t    \t\t\t}\r\n");
      out.write("\t    \t\t}\r\n");
      out.write("\t    \t},\r\n");
      out.write("\t    \tanalysis:{\r\n");
      out.write("\t    \t\tvalidators:{\r\n");
      out.write("\t    \t\t\tnotEmpty:{\r\n");
      out.write("\t    \t\t\t\tmessage:'试题解析不能为空'\r\n");
      out.write("\t    \t\t\t},\r\n");
      out.write("\t    \t\t\tstringLength:{\r\n");
      out.write("\t    \t\t\t\tmin:10,\r\n");
      out.write("\t    \t\t\t\tmax:500,\r\n");
      out.write("\t    \t\t\t\tmessage:'试题解析的长度在10-500个字节'\r\n");
      out.write("\t    \t\t\t}\r\n");
      out.write("\t    \t\t}\r\n");
      out.write("\t    \t},\r\n");
      out.write("          \tquestiontypesId:{\r\n");
      out.write("        \t   validators:{\r\n");
      out.write("\t    \t\t\tchoice: {\r\n");
      out.write("\t                    min:1,\r\n");
      out.write("\t                    message: '至少要选择一个'\r\n");
      out.write("\t                }\r\n");
      out.write("\t    \t\t}\r\n");
      out.write("           \t},\r\n");
      out.write("\t    \t'stageId':{\r\n");
      out.write("\t    \t\tvalidators:{\r\n");
      out.write("\t    \t\t\tchoice: {\r\n");
      out.write("\t                    min:1,\r\n");
      out.write("\t                    message: '至少要选择一个'\r\n");
      out.write("\t                }\r\n");
      out.write("\t    \t\t}\r\n");
      out.write("\t    \t},\r\n");
      out.write("\t    \t'booksId':{\r\n");
      out.write("\t    \t\tvalidators:{\r\n");
      out.write("\t    \t\t\tchoice: {\r\n");
      out.write("\t                    min:1,\r\n");
      out.write("\t                    message: '至少要选择一个'\r\n");
      out.write("\t                }\r\n");
      out.write("\t    \t\t}\r\n");
      out.write("\t    \t},\r\n");
      out.write("\t    \t'chapterId':{\r\n");
      out.write("\t    \t\tvalidators:{\r\n");
      out.write("\t    \t\t\tchoice: {\r\n");
      out.write("\t                    min:1,\r\n");
      out.write("\t                    message: '至少要选择一个'\r\n");
      out.write("\t                }\r\n");
      out.write("\t    \t\t}\r\n");
      out.write("\t    \t}\r\n");
      out.write("\t    }\r\n");
      out.write("\t});\r\n");
      out.write("}\t\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"container\" style=\"padding-top: 20px;\">\r\n");
      out.write("<blockquote class=\"layui-elem-quote\">添加上机题      <font color=\"red\">添加的图片会被隐藏,可放心添加</font></blockquote>\r\n");
      out.write("\t<form id=\"upperForm\"  method=\"post\"  enctype=\"multipart/form-data\" class=\"form-horizontal\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/upper/add/entity.do\" >\r\n");
      out.write("\t\t<input  id=\"id\" name=\"id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${upper.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"hidden\" />\r\n");
      out.write("\t   <blockquote class=\"layui-elem-quote layui-quote-nm\">\r\n");
      out.write("\t   \r\n");
      out.write("\t   \t<div class=\"form-group\">\r\n");
      out.write("\t\t\t<label for=\"questiontypesId\" class=\"col-sm-2 control-label\">试题类型</label>\r\n");
      out.write("\t\t\t<div class=\"col-sm-10\" data-toggle=\"buttons\">\r\n");
      out.write("\t\t\t\t<label class=\"radio-inline btn btn-default active\">\r\n");
      out.write("\t\t\t\t\t<input id=\"questiontypesId\" name=\"questiontypesId\" value=\"6\" type=\"radio\" checked=\"checked\" /> 上机题\r\n");
      out.write("\t\t\t\t</label>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t   \r\n");
      out.write("\t\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!-- <div class=\"form-group\">\r\n");
      out.write("\t\t\t<label for=\"importID\" class=\"col-sm-2 control-label\">上传文件</label>\r\n");
      out.write("\t\t\t<div id=\"fileUpload\" class=\"col-sm-10\"  style=\"display: none;\">\r\n");
      out.write("\t\t\t\t\t<input id=\"f_upload\" type=\"file\" name=\"file\" class=\"file\" />\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div> -->\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t<label for=\"kindeditorWindow\" class=\"col-sm-2 control-label\">试题题目</label>\r\n");
      out.write("\t\t\t<div class=\"col-sm-10\">\r\n");
      out.write("\t\t\t\t<textarea rows=\"\" cols=\"\" id=\"kindeditorWindow\" name=\"title\" placeholder=\"请输入试题题目D的内容\" class=\"form-control\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${upper.title}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t<label for=\"analysis\" class=\"col-sm-2 control-label\">试题解析</label>\r\n");
      out.write("\t\t\t<div class=\"col-sm-10\">\r\n");
      out.write("\t\t\t\t<textarea rows=\"\" cols=\"\" id=\"analysis\" name=\"analysis\" placeholder=\"请输入试题解析的内容\" class=\"form-control\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${upper.analysis}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</blockquote>\t\r\n");
      out.write("\t</form>\r\n");
      out.write("</body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(function(){\r\n");
      out.write("\t\r\n");
      out.write("    history.pushState(null, null, document.URL);\r\n");
      out.write("    window.addEventListener('popstate', function () {\r\n");
      out.write("        history.pushState(null, null, document.URL);\r\n");
      out.write("    });\r\n");
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
      out.write("\tKindEditor.ready(function(K){\r\n");
      out.write("\t\twindow.editor = K.create(\"#kindeditorWindow\",{\r\n");
      out.write("\t\t\titems:[\r\n");
      out.write("\t\t\t\t 'justifyleft', 'justifycenter',  '|','justifyright',\r\n");
      out.write("\t\t        'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'quickformat', \r\n");
      out.write("\t\t        'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold',\r\n");
      out.write("\t\t        'italic', 'underline', '|', 'image', 'table', 'hr' \r\n");
      out.write("\t\t\t],\r\n");
      out.write("\t\t\tallowFileManager:true,\r\n");
      out.write("\t\t\tuploadJson : getRootPath()+\"/editor/upload/image.do\",\r\n");
      out.write("\t\t\tfileManagerJson : getRootPath()+\"/editor/manage/image.do\"\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t//加载阶段\r\n");
      out.write("\t$.get(getRootPath()+'/stage/get/nopage.do', function(data){\r\n");
      out.write("\t\t$(data).each(function(i,v){\r\n");
      out.write("\t\t\t$(\"#stageTD\").append(\"<div class='checkbox' style='display:inline-block;padding-right:5px;'><label><input id=\"+v.id+\" name='stageId' value='\"+v.id+\"' type='radio' onclick='loadBooks(\"+v.id+\")'/>\" + this.name);\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tformValidator();\r\n");
      out.write("\t}); \r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("function loadBooks(){\r\n");
      out.write("\t//获得选中的id\r\n");
      out.write("\tvar checkStageId  = $('input[name=\"stageId\"]:checked').val(); \r\n");
      out.write("\t//加载课程\r\n");
      out.write("\t$.post(getRootPath()+'/books/get/books.do',{\"stageId\":checkStageId},function(data){\r\n");
      out.write("\t\t$(\"#booksTD\").empty();\r\n");
      out.write("\t\t$(data).each(function(i,v){\r\n");
      out.write("\t\t\t$(\"#booksTD\").append(\"<div class='checkbox' style='display:inline-block;padding-right:5px;'><label><input id=\"+v.id+\" name='booksId' value='\"+v.id+\"' type='radio' onclick='loadChapter(\"+v.id+\")'/>\" + this.name);\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function loadChapter(booksId){\r\n");
      out.write("\t$.get(getRootPath()+\"/chapter/get/chapter.do\",{\"booksId\":booksId},function(data){\r\n");
      out.write("\t\t$(\"#chapterTD\").empty();\r\n");
      out.write("\t\t$(data).each(function(i,v){\r\n");
      out.write("\t\t\t$(v).each(function(j,value){\r\n");
      out.write("\t\t\t\t$(\"#chapterTD\").append(\"<div class='checkbox' style='display:inline-block;padding-right:5px;'><label><input id=\"+v.id+\" name='chapterId' value='\"+v.id+\"' type='radio' />\" + this.name);\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* function loadUpBtn(){\r\n");
      out.write("\tdocument.getElementById('fileUpload').style.display=\"\";\r\n");
      out.write("\tvar stageId = $('input[name=\"stageId\"]:checked').val();\r\n");
      out.write("\tvar booksId = $('input[name=\"booksId\"]:checked').val();\r\n");
      out.write("\tvar chapterId=$('input[name=\"chapterId\"]:checked').val();\r\n");
      out.write("\t\r\n");
      out.write("\t$(\"#f_upload\").fileinput(\"refresh\",{\r\n");
      out.write("\t\t uploadAsync: true, //默认异步上传\r\n");
      out.write("         showUpload:true, //是否显示上传按钮\r\n");
      out.write("         showRemove :false, //显示移除按钮\r\n");
      out.write("         showPreview :false, //是否显示预览\r\n");
      out.write("         showCaption:false,//是否显示标题\r\n");
      out.write("         showCancel:false,\r\n");
      out.write("\t\t browseClass:\"btn btn-default\", //按钮样式    \r\n");
      out.write("\t\t allowedFileExtensions: ['zip'],//接收的文件后缀\r\n");
      out.write("\t\t maxFileCount:1,//允许上传文件的最大数\r\n");
      out.write("\t\t maxFileSize:0,//不限制上传文件的大小\r\n");
      out.write("\t\t uploadUrl :getRootPath()+\"/upper/upload/file.do\" ,\r\n");
      out.write("         uploadExtraData:{\"stageId\":stageId,\"booksId\":booksId,\"chapterId\":chapterId}\r\n");
      out.write("\t }).on('fileuploaded', function(event, data, previewId, index) {  \r\n");
      out.write("\t\t\tparent.layer.msg(data.response.message);\r\n");
      out.write("\t\t\t$(\"#id\").val(data.response.id);\r\n");
      out.write("\t });\r\n");
      out.write("} */\r\n");
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /WEB-INF/bank/upper_add.jsp(140,2) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty upper.id }", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t<div class=\"form-group\">\r\n");
        out.write("\t\t\t\t<label for=\"stageTD\" class=\"col-sm-2 control-label\">阶段列表</label>\r\n");
        out.write("\t\t\t\t<div id=\"stageTD\" class=\"col-sm-10\"></div>\r\n");
        out.write("\t\t\t\t<input id=\"stageValue\" type=\"hidden\" value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${upper.stageId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("\"/>\r\n");
        out.write("\t\t\t</div>\r\n");
        out.write("\t\t\t\r\n");
        out.write("\t\t\t<div class=\"form-group\">\r\n");
        out.write("\t\t\t\t<label for=\"booksTD\" class=\"col-sm-2 control-label\">课程列表</label>\r\n");
        out.write("\t\t\t\t<div id=\"booksTD\" class=\"col-sm-10\"></div>\r\n");
        out.write("\t\t\t\t<input id=\"booksValue\" type=\"hidden\" value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${upper.booksId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("\"/>\r\n");
        out.write("\t\t\t</div>\r\n");
        out.write("\t\t\t\r\n");
        out.write("\t\t\t<div class=\"form-group\">\r\n");
        out.write("\t\t\t\t<label for=\"chapterTD\" class=\"col-sm-2 control-label\">章节列表</label>\r\n");
        out.write("\t\t\t\t<div id=\"chapterTD\" class=\"col-sm-10\"></div>\r\n");
        out.write("\t\t\t\t<input id=\"chapterValue\" type=\"hidden\" value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${upper.chapterId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("\"/>\r\n");
        out.write("\t\t\t</div>\r\n");
        out.write("\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent(null);
    // /WEB-INF/bank/upper_add.jsp(159,2) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty upper.id }", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t<div class=\"form-group\">\r\n");
        out.write("\t\t\t\t<label for=\"stageId\" class=\"col-sm-2 control-label\">阶段列表</label>\r\n");
        out.write("\t\t\t\t<div class=\"col-sm-10\" data-toggle=\"buttons\" >\r\n");
        out.write("\t\t\t\t\t<label class=\"radio-inline btn btn-default active\">\r\n");
        out.write("\t\t\t\t\t\t<input id=\"stageId\" name=\"stageId\" value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${upper.stageId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("\" type=\"radio\" checked=\"checked\" /> ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${upper.stageName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("\r\n");
        out.write("\t\t\t\t\t</label>\r\n");
        out.write("\t\t\t\t</div>\r\n");
        out.write("\t\t\t</div>\r\n");
        out.write("\t\t\t\r\n");
        out.write("\t\t\t<div class=\"form-group\">\r\n");
        out.write("\t\t\t\t<label for=\"booksId\" class=\"col-sm-2 control-label\">课程列表</label>\r\n");
        out.write("\t\t\t\t<div class=\"col-sm-10\" data-toggle=\"buttons\">\r\n");
        out.write("\t\t\t\t\t<label class=\"radio-inline btn btn-default active\">\r\n");
        out.write("\t\t\t\t\t\t<input id=\"booksId\" name=\"booksId\" value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${upper.booksId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("\" type=\"radio\" checked=\"checked\" /> ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${upper.booksName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("\r\n");
        out.write("\t\t\t\t\t</label>\r\n");
        out.write("\t\t\t\t</div>\r\n");
        out.write("\t\t\t</div>\r\n");
        out.write("\t\t\t\r\n");
        out.write("\t\t\t<div class=\"form-group\">\r\n");
        out.write("\t\t\t\t<label for=\"chapterId\" class=\"col-sm-2 control-label\">章节列表</label>\r\n");
        out.write("\t\t\t\t<div class=\"col-sm-10\" data-toggle=\"buttons\">\r\n");
        out.write("\t\t\t\t\t<label class=\"radio-inline btn btn-default active\">\r\n");
        out.write("\t\t\t\t\t\t<input id=\"chapterId\" name=\"chapterId\" value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${upper.chapterId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("\" type=\"radio\" checked=\"checked\" /> ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${upper.chapterName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("\r\n");
        out.write("\t\t\t\t\t</label>\r\n");
        out.write("\t\t\t\t</div>\r\n");
        out.write("\t\t\t</div>\r\n");
        out.write("\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
    return false;
  }
}
