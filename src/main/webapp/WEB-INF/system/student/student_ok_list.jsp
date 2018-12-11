<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
<title>正式学生列表</title>
<%@include file="/header/header.jsp" %>
<script type="text/javascript"></script>
</head>
	<body class="container-fluid">
		<blockquote class="layui-elem-quote news_search" style="margin-top: 10px">
			<div class="layui-inline">
			     <div class="layui-input-inline">
			    	<input id="userName" type="text" value=""  placeholder="请输入学生姓名" class="layui-input search_input">
			    </div>
			    <div class="layui-inline">
				  <input id="queryDate" type="text" class="layui-input" placeholder="请选择创建时间" >
				</div>
			    
			    <a onclick="queryUser()" class="layui-btn search_btn" ><b>查询</b></a>
			
				<div class="layui-inline" style="margin-top: 5px">
					<a class="layui-btn linksAdd_btn"  onclick="addClasses();" style="background-color:#5FB878"><b>指定班级</b></a>
				</div>
				<div class="layui-inline">
					<a class="layui-btn linksAdd_btn"  onclick="editClasses();" style="background-color:#FFB800"><b>转班申请</b></a>
				</div>
			</div>	
		</blockquote>
		<div class="table-responsive">
			<table class="table table-striped table-hover" id="studentTable" style="text-align:center"></table>
		</div> 
	</body>

<script type="text/javascript">
$(function(){
	
	history.pushState(null, null, document.URL);
	window.addEventListener('popstate', function () {
	    history.pushState(null, null, document.URL);
	});
	
	document.oncontextmenu = function () { 
		return false; 
	};
	
    document.onkeydown = function () {
       if (window.event && window.event.keyCode == 123) {
           event.keyCode = 0;
           event.returnValue = false;
           return false;
        }
     };
	
	initStudentTable();
});

function addClasses(){
	
	var rows = $("#studentTable").bootstrapTable("getSelections");
	
	if(rows.length != 1){
		parent.layer.msg("请选择一行进行操作");
		return;
	}
	
	var userId = rows[0].id;
	
	$.post(getRootPath()+"/student/check/classes.do",{"userId":userId},function(data){
		if(data.code == 5000){
			parent.layer.msg(data.message);
			return;
		}else{
			parent.layer.open({
				id:'insert-form',
				area:["500px","300px"],
				type:2,
				scrollbar:true,
				maxmin:true,
				content:getRootPath()+"/student/show/classes.do?userId="+userId,
				btn:["提交","取消"],
				btnAlign:'c',
				yes:function(index,layero){
				    var body = layer.getChildFrame('body', index);
				    var iframeWin = parent.window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：
				    iframeWin.subChildForm();
				},
				end:function(index){
					window.location.reload(true);
				}
			});
		}
	});
	
}


function initStudentTable(){
	$("#studentTable").bootstrapTable({
		url:getRootPath()+'/student/get/oklist.do',
		method : 'GET',
		dataType : 'json',
		checkboxHeader : false, //设置为false时,表头隐藏复选框
		singleSelect : true, //只能单选行
		striped : true, //隔行换色
		cache : false, ////是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		clickToSelect : true, //点击行时,自动勾选复选框或单选框
		pagination : true,//是否显示分页工具条
		sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*）
		pageNumber : 1, //首页页码
		pageSize : 10, //页面容量
		uniqueId : "id", //每一行的唯一标识，一般为主键列
		cardView : false, //是否显示详细视图
		detailView : true, //是否显示父子表
		queryParams : function(params) {//得到查询的参数
			//这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
			var temp = {
				limit : params.limit, // 每页显示数量
				offset : params.offset, // SQL语句起始索引
				page : (params.offset / params.limit) + 1,
				userName:$("#userName").val(),
				queryDate:$("#queryDate").val(),
				
			};
			return temp;
		},
		columns:[
			{radio : true},
			{field : 'id',visible : false},
			{field : 'username',visible : false},
			{field : 'password',visible : false},
			{field : 'cord',visible : false},			
			{field : 'level',visible : false},
			{field : 'identity',visible : false},
			{field : 'examId',visible : false},
			{field : 'nickName',title : '学生姓名',align : 'center'},
			{field : 'telephoneA',title : '常用电话',align : 'center'},
			{field : 'classesNames',title : '所在班级',align : 'center'},
			{field : 'user1Name',title : '网咨',align : 'center'},
			{field : 'user2Name',title : '咨询',align : 'center'},
			{field : 'user3Name',title : '助理',align : 'center'}
		],
		onExpandRow : function(index, row, $detail){
			//创建一个新的table表
			var parentId = row.id;
			var cur_table = $detail.html('<table></table>').find('table');
			var html = "";
			html += "<table class='table table-bordered table-condensed'>";
			html += "<thead>";
			html += "<tr style='height: 40px'>";
			html +="<th style='text-align: center;padding-bottom:10px;' class='warning'>年龄</th>";
			html +="<th style='text-align: center;padding-bottom:10px;' class='warning'>生日</th>";
			html +="<th style='text-align: center;padding-bottom:10px;' class='warning'>QQ</th>";
			html +="<th style='text-align: center;padding-bottom:10px;' class='warning'>备用电话</th>";
			html +="<th style='text-align: center;padding-bottom:10px;' class='warning'>邮箱</th>";
			html +="<th style='text-align: center;padding-bottom:10px;' class='warning'>地址</th>";
			html +="<th style='text-align: center;padding-bottom:10px;' class='warning'>备注</th>";
			html +="<th style='text-align: center;padding-bottom:10px;' class='warning'>创建时间</th>";
			html +="<th style='text-align: center;padding-bottom:10px;' class='warning'>学历</th>";
			html +="<th style='text-align: center;padding-bottom:10px;' class='warning'>专业</th>";
			html +="<th style='text-align: center;padding-bottom:10px;' class='warning'>现状</th>";
			html +="<th style='text-align: center;padding-bottom:10px;' class='warning'>课程</th>";
			html +="<th style='text-align: center;padding-bottom:10px;' class='warning'>网站</th>";
			html +="<th style='text-align: center;padding-bottom:10px;' class='warning'>工具</th>";
			html +="<th style='text-align: center;padding-bottom:10px;' class='warning'>渠道</th>";
			html +="</tr>";
			html +="</thead>";
			
			html+="<tr>"
				+"<td>"+row.age+"</td>"
				+"<td>"+dateFormatter(row.birthday)+"</td>"
				+"<td>"+row.qq+"</td>"
				+"<td>"+row.telephoneB+"</td>"
				+"<td>"+row.email+"</td>"
				+"<td><button class='btn btn-default btn-xs' style='background:#FF7519;color:white' onclick='layer.msg(\""+row.address+"\")'>查看</button></td>"
				+"<td><button class='btn btn-default btn-xs' style='background:#FF7519;color:white' onclick='layer.msg(\""+row.description+"\")'>查看</button></td>"
				+"<td>"+dateFormatter(row.createTime)+"</td>"
				+"<td>"+row.educationName+"</td>"
				+"<td>"+row.majorName+"</td>"
				+"<td>"+row.stiuationName+"</td>"
				+"<td>"+row.classificationName+"</td>"
				+"<td>"+row.sourceName+"</td>"
				+"<td>"+row.toolName+"</td>"
				+"<td>"+row.channelName+"</td>"
				+"</tr>";
			html +="</table>";	
			//最重要的一句话
			$detail.html(html);
		}
	});
}


layui.use(['laydate','layer','form'], function(){
  var laydate = layui.laydate,
  layer = layui.layer,
  form = layui.form;
  
  //加载日期
  laydate.render({
	range: '~',
    elem: '#queryDate',
    done: function(value, date, endDate){
    	$("#queryDate").val(value);
    }
  });
});

function queryUser(){
	$("#studentTable").bootstrapTable('refresh');
}

</script>

</html>