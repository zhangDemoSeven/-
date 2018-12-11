<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
<title>菜单列表</title>
<%@include file="/header/header.jsp" %>
</head>
<body class="container-fluid">
	<blockquote class="layui-elem-quote news_search" style="margin-top: 10px">
		<div class="layui-inline">
		    <div class="layui-input-inline">
		    	<input id="methodName" type="text" value=""  placeholder="请输入触发事件名称" class="layui-input search_input">
		    </div>
		    <div class="layui-input-inline">
		    	<input id="modelName" type="text" value=""  placeholder="请输入模块名称" class="layui-input search_input">
		    </div>
		    <div class="layui-input-inline">
			  <input id="queryDate" type="text" class="layui-input" placeholder="请选择创建时间" >
			</div>
		    <div class="layui-input-inline">
		    	<select id="isOk" name="isOk" onchange="isOkChange()" lay-verify="" class="layui-input search_input" style="width: 198px;">
			  		<option value="">请选择试卷状态</option>
			  		<option value="执行成功">执行成功</option>
			  		<option value="执行失败">执行失败</option>
			  	</select> 
			  	<input type="hidden" id="isOkHidden" />
		   </div>
		    
		    <a onclick="queryLog()" class="layui-btn search_btn" ><b>查询</b></a>
		</div>
	</blockquote>
	<div class="table-responsive">
		<table class="table table-striped table-hover" id="logTable" style="text-align:center"></table>
	</div> 
</body>
<script type="text/javascript">
$(function(){
	
	initMenuTable();
	
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
});

function isOkChange(){
	var isOk = document.getElementById('isOk');
	var result = isOk.options[isOk.selectedIndex].value;
	$("#isOkHidden").val(result);
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


//菜单表格
function initMenuTable(){ 
	$("#logTable").bootstrapTable({
		url:getRootPath()+'/log/get/list.do',//加载表格数据的接口
		method:'GET',//提交方式
		dataType:'json',//服务器返回的数据格式
		toolbar:'#tb', //指定按钮组
		checkboxHeader:false,//设置为false时,表头隐藏复选框
		singleSelect:true,//只能单选行
		striped:true,//隔行换色
		cache:false,//不进行缓存
		clickToSelect:true, //点击行时,自动勾选复选框或单选框
		pagination:true,//开启分页功能
		sidePagination:'server',//这个分页功能需要在服务器端实现
		pageNumber:1,//分页的起始页
		pageSize:10,//初始化页面容量为10
		pageList:[10,20,30,40,'All'],//设置可供选择的页面数据条数 设置为all时显示所有记录 
		uniqueId:'id',//设置行的唯一标示
		cardView:false,//是否显示详细视图
		detailView:false,//是否显示父子表
		queryParams:function(params){
			var temp = {
					limit:params.limit, //每页显示数量
					offset:params.offset,//sql语句中的起始索引
					page:(params.offset / params.limit) + 1, //总页数
					methodName:$("#methodName").val(),
					modelName:$("#modelName").val(),
					queryDate:$("#queryDate").val(),
					isOk:$("#isOkHidden").val(),
			};
			return temp;
		},
		columns:[
			{field:'id',visible:false},//设置隐藏列
			{field:'nickName',title:'操作人',align:'center'},
			{field:'model',title:'模块名称',align:'center'},
			{field:'method',title:'触发事件',align:'center'},
			{field:'ip',title:'IP地址',align:'center'},
			{field:'source',title:'来源端口',align:'center'},
			{field:'date',title:'触发时间',align:'center',formatter:function(value,row,index){
				return dateFormatter(value);
			}},
			{field:'isOk',title:'执行状态',align:'center',formatter:function(value,row,index){
				if(value == "执行成功") return "<font color='green'>执行成功</font>";
				if(value == "执行失败") return "<font color='red'>执行失败</font>";
			}}
		]
	});
}


function queryLog(){
	$("#logTable").bootstrapTable('refresh');
}


</script>
</html>