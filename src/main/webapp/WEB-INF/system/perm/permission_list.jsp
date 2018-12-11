<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,inital-scale=1,maximum-scale=1,user-scalable=no">
<title>权限列表</title>
<%@include file="/header/header.jsp" %>
</head>
<body class="container-fluid">
	<blockquote class="layui-elem-quote news_search" style="margin-top: 10px">
		<div class="layui-inline">
		    <div class="layui-input-inline">
		    	<input id="permissionName" type="text" value=""  placeholder="请输入权限名称" class="layui-input search_input">
		    </div>
		    <a onclick="queryPermission()" class="layui-btn search_btn" ><b>查询</b></a>
		</div>
		<div class="layui-inline">
			<a class="layui-btn linksAdd_btn"  onclick="o();" style="background-color:#5FB878"><b>新增权限</b></a>
		</div>
		<div class="layui-inline">
			<a class="layui-btn linksAdd_btn"  onclick="u();" style="background-color:#FFB800"><b>修改信息</b></a>
		</div>
		<div class="layui-inline">
			<a class="layui-btn layui-btn-danger batchDel" onclick="d();"><b>删除权限</b></a>
		</div>
		<div class="layui-inline">
			<a class="layui-btn linksAdd_btn"  onclick="p();" style="background-color:#2F4056"><b>启禁操作</b></a>
		</div>
	</blockquote>
	
	<div class="table-responsive">
		<table class="table table-striped table-hover" id="permTable" style="text-align:center"></table>
	</div> 
</body>
<script type="text/javascript">
$(function(){
	
	initPermTable();

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

function initPermTable(){
	
	$("#permTable").bootstrapTable({
		toolbar:'#tb',
		url:getRootPath() + "/permission/get/list.do",
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
		pageSize : 4, //页面容量
		pageList : [ 10, 25, 50, 100, 'All' ],//设置可供选择的页面数据条数。设置为 All 或者 Unlimited，则显示所有记录
		uniqueId : "id", //每一行的唯一标识，一般为主键列
		cardView : false, //是否显示详细视图
		queryParams : function(params) {//得到查询的参数
			//这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
			var temp = {
				limit : params.limit, // 每页显示数量
				offset : params.offset, // SQL语句起始索引
				page : (params.offset / params.limit) + 1,
				permissionName:$("#permissionName").val(),
			};
			return temp;
		},
		columns:[
			{radio : true},
			{field : 'id',visible : false},//visible:false隐藏
			{field : 'name',title : '权限名称',titleTooltip : '这是权限的名称',align : 'center'},
			{field : 'keyword',title : '关键字',align : 'center'},
			{field : 'description',title : '权限描述',align : 'center'},
			{field : 'prohibition',title : '启禁状态',align : 'center', formatter : function(value,row,index){
				if (value == 0) return "<font color='red'>已禁用</font>";
				if (value == 1) return "<font color='green'>已启用</font>";
				else return "<font color='yellow'>数据加载异常</font>";
			}}
		]
	});
}

//新增
function o(){
	parent.layer.open({
		content:getRootPath() + "/permission/show/addentity.do",
		area:['60%','60%'],
		title:'添加或修改权限',
		type:2,
		maxmin:true,
		shade:[1.2,"#000"],
		shadeClose:true,
		btn:["提交",'取消'],
		btnAlign:'c',
		yes:function(index,layero){
			var body = layer.getChildFrame('body', index);
		    var iframeWin = parent.window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：
		    iframeWin.subChildForm();
		},
		end:function(index){
			$("#permTable").bootstrapTable('refresh');
		}
	});
}

//编辑
function u(){
	var rows = $("#permTable").bootstrapTable('getSelections');
	if(rows.length != 1){
		layer.msg("您必须选择一条记录进行操作");
		return;
	}
	
	var prohibition = rows[0].prohibition;
	
	if(prohibition == "0"){
		layer.msg("禁用的记录无法编辑");
		return;
	}
	
	var permissionId = rows[0].id;
	
	parent.layer.open({
		area:['60%','60%'],
		title:'添加或修改权限',
		type:2,
		shade:[1.2,"#000"],
		shadeClose:true,
		maxmin:true,
		content:getRootPath() + "/permission/show/addentity.do?permissionId="+permissionId,
		btn:["提交",'取消'],
		btnAlign:'c',
		yes:function(index,layero){
			var body = layer.getChildFrame('body', index);
		    var iframeWin = parent.window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：
		    iframeWin.subChildForm();
		},
		end:function(index){
			$("#permTable").bootstrapTable('refresh');
		}
	});
}


//启禁
function p(){
	
	var rows = $("#permTable").bootstrapTable('getSelections');
	if(rows.length != 1){
		layer.msg("您必须选择一条记录进行操作");
		return;
	}
	var permissionId = rows[0].id;
	
	parent.layer.confirm('您确定要操作该条数据吗?',{title:'启禁确认'}, 
		function(index){
			$.ajax({
				type:'POST',
				dataType:'json',
				url:getRootPath()+'/permission/opt/entity.do',
				data:{"permissionId":permissionId},
				success:function(data){
					parent.layer.msg(data.message);
					parent.layer.close(index);
					$("#permTable").bootstrapTable('refresh');
				}
			});
		},
		function(index){
			layer.close(index);
			parent.layer.msg("取消了操作");
		});
}

//删除
function d(){
	
	var rows = $("#permTable").bootstrapTable('getSelections');
	
	if(rows.length != 1){
		layer.msg("您必须选择一条记录进行操作");
		return false;
	}
	
	var permissionId = rows[0].id;
	
	parent.layer.confirm("您确定要删除吗?",function(index){
			$.ajax({
				type:'POST',
				dataType:'json',
				url:getRootPath()+'/permission/del/entity.do',
				data:{"permissionId":permissionId},
				success:function(data){
					parent.layer.msg(data.message);
					parent.layer.close(index);
					$("#permTable").bootstrapTable('refresh');
				}
			});
		},
		function(index){
			layer.close(index);
			layer.msg("取消了操作");
		}
	);
}

function queryPermission(){
	$("#permTable").bootstrapTable('refresh');
}


</script>
</html>