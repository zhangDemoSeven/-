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
		    	<input id="menuName" type="text" value=""  placeholder="请输入菜单名称" class="layui-input search_input">
		    </div>
		    <a onclick="queryMenu()" class="layui-btn search_btn" ><b>查询</b></a>
		</div>
		<div class="layui-inline">
			<a class="layui-btn linksAdd_btn"  onclick="openWindow();" style="background-color:#5FB878"><b>新增菜单</b></a>
		</div>
		<div class="layui-inline">
			<a class="layui-btn linksAdd_btn"  onclick="updateWindow();" style="background-color:#FFB800"><b>修改信息</b></a>
		</div>
		<div class="layui-inline">
			<a class="layui-btn layui-btn-danger batchDel" onclick="del();"><b>删除菜单</b></a>
		</div>
		<div class="layui-inline">
			<a class="layui-btn linksAdd_btn"  onclick="opt();" style="background-color:#2F4056"><b>启禁操作</b></a>
		</div>
	</blockquote>
	<div class="table-responsive">
		<table class="table table-striped table-hover" id="menuTable" style="text-align:center"></table>
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


//菜单表格
function initMenuTable(){ 
	$("#menuTable").bootstrapTable({
		url:getRootPath()+'/menu/get/list.do',//加载表格数据的接口
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
					menuName:$("#menuName").val(),
			};
			return temp;
		},
		columns:[
			{radio:true},
			{field:'id',visible:false},//设置隐藏列
			{field:'title',title:'菜单名称',align:'center'},
			{field:'href',title:'菜单路径',align:'center'},
			{field:'priority',title:'菜单权重',align:'center'},
			{field:'prohibition',title:'启禁状态',align:'center',formatter:function(value,row,index){
				if(value == 1) return "<font color='green'>已启用</font>";
				if(value == 0) return "<font color='red'>已禁用</font>";
			}},
			{field:'createUser',title:'创建人',align:'center'},
			{field:'createTime',title:'创建时间',align:'center',formatter:function(value,row,index){
				return dateFormatter(value);
			}},
			{field:'modifyUser',title:'修改人',align:'center'},
			{field:'mdifyTime',title:'修改时间',align:'center',formatter:function(value,row,index){
				return dateFormatter(value);
			}}
		]
	});
}

//启禁按钮
function opt(){
	var rows = $("#menuTable").bootstrapTable('getSelections');
	if(rows.length != 1){
		layer.msg("您必须选择一条记录进行操作");
		return;
	}
	var menuId = rows[0].id;
	parent.layer.confirm(
		"您确定要操作该条记录吗?",
		{title:'确认框'},
		function(index){
			 $.ajax({
				type:'POST',//什么样方式进行提交
				dataType:'json',//服务器返回数据的格式
				data:{"menuId":menuId},
				url:getRootPath()+'/menu/opt/entity.do',
				success:function(data){//成功回调函数
					//弹出服务端传递的消息体
					parent.layer.msg(data.message);
					//关闭弹窗
					layer.close(index);
					//刷新一下表格
					$("#menuTable").bootstrapTable('refresh');
				}
			});
		},
		function(index){
			layer.close(index);
		}
	);
}

//新增
function openWindow(){
	parent.layer.open({
		area:['70%',"50%"],
		title:'添加或修改菜单',
		type:2,
		shade:[1.2,"#000"],
		shadeClose:true,
		maxmin:true,
		content:getRootPath()+"/menu/show/addentity.do",
		btn:["提交",'取消'],
		btnAlign:'c',
		yes:function(index,layero){
			var body = layer.getChildFrame('body', index);
		    var iframeWin = parent.window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：
		    iframeWin.subChildForm();
		},
		end:function(index){
			$("#menuTable").bootstrapTable('refresh');
		}
	});
}

//修改
function updateWindow(){
	var rows = $("#menuTable").bootstrapTable('getSelections');
	if(rows.length != 1){
		parent.layer.msg("您必须选择一条记录进行操作");
		return;
	}
	
	var prohibition = rows[0].prohibition;
	
	if(prohibition == 0){
		parent.layer.msg("禁用状态的数据无法编辑");
		return;
	}
	
	var menuId = rows[0].id;
	
	parent.layer.open({
		area:['70%',"50%"],
		title:'添加或修改菜单',
		type:2,
		shade:[1.2,"#000"],
		shadeClose:true,
		maxmin:true,
		content:getRootPath()+"/menu/show/addentity.do?menuId="+menuId,
		btn:["提交",'取消'],
		btnAlign:'c',
		yes:function(index,layero){
			var body = layer.getChildFrame('body', index);
		    var iframeWin = parent.window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：
		    iframeWin.subChildForm();
		},
		end:function(index){
			$("#menuTable").bootstrapTable('refresh');
		}
	});
}


//删除按钮
function del(){
	var rows = $("#menuTable").bootstrapTable('getSelections');
	if(rows.length != 1){
		layer.msg("您必须选择一条记录进行操作");
		return;
	}
	var menuId = rows[0].id;
	parent.layer.confirm(
		"您确定要删除该条记录吗?",
		{title:'确认框'},
		function(index){
			 $.ajax({
				type:'POST',//什么样方式进行提交
				dataType:'json',//服务器返回数据的格式
				data:{"menuId":menuId},
				url:getRootPath()+'/menu/del/entity.do',
				success:function(data){//成功回调函数
					//弹出服务端传递的消息体
					parent.layer.msg(data.message);
					//关闭弹窗
					layer.close(index);
					//刷新一下表格
					$("#menuTable").bootstrapTable('refresh');
				}
			});
		},
		function(index){
			layer.close(index);
		}
	);
}

function queryMenu(){
	$("#menuTable").bootstrapTable('refresh');
}


</script>
</html>