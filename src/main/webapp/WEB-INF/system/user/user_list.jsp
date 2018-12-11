<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html  lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
<title>用户列表</title>
<%@include file="/header/header.jsp" %>
</head>
	<body class="container-fluid">
		<!-- 按钮组 -->
		<blockquote class="layui-elem-quote news_search" style="margin-top: 10px">
			<div class="layui-inline">
			    <div class="layui-input-inline">
			    	<input id="userName" type="text" value=""  placeholder="请输入用户名称" class="layui-input search_input">
			    </div>
			    <a onclick="queryUser()" class="layui-btn search_btn" ><b>查询</b></a>
			
				<div class="layui-inline">
					<a class="layui-btn linksAdd_btn"  onclick="openWindow();" style="background-color:#5FB878"><b>新增用户</b></a>
				</div>
				<div class="layui-inline">
					<a class="layui-btn linksAdd_btn"  onclick="updateWindow();" style="background-color:#FFB800"><b>修改信息</b></a>
				</div>
				<div class="layui-inline">
					<a class="layui-btn layui-btn-danger batchDel" onclick="del();"><b>删除用户</b></a>
				</div>
				<div class="layui-inline">
					<a class="layui-btn linksAdd_btn"  onclick="opt();" style="background-color:#2F4056"><b>启禁操作</b></a>
				</div>
			</div>	
		</blockquote>
		<div class="table-responsive">
			<table id="userTable" style="text-align: center;"></table>
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

	//初始化
	initUserTable();
	
});


function initUserTable(){
	$("#userTable").bootstrapTable({
		url:getRootPath()+'/user/get/list.do',
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
		pageList:[10,20,30,40,'All'],
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
			};
			return temp;
		},
		columns:[
			{radio : true},
			{field : 'id',visible : false},//visible:false隐藏
			{field : 'nickName',title : '用户姓名',titleTooltip : '这是用户的名称',align : 'center'},
			{field : 'sex',title : '性别',align : 'center',formatter : function(value,row,index){
				if(value == 1) return "男";
				if(value == 0) return "女";
			}},
			{field : 'username',title : '用户名',align : 'center'},
			{field : 'password',title : '密码',align : 'center'},
			{field : 'levelName',title : '所在部门',align : 'center'},
			{field : 'identityName',title : '所属身份',align : 'center'},
			{field : 'cord',title : '身份证',align : 'center'},
			{field : 'telephoneA',title : '常用电话',align : 'center'},
			{field : 'telephoneB',title : '备用电话',align : 'center'},
			{field : 'prohibition',title : '启禁状态',align : 'center', formatter : function(value,row,index){
				if (value == 0) return "<font color='red'>已禁用</font>";
				if (value == 1) return "<font color='green'>已启用</font>";
				else return "<font color='yellow'>数据加载异常</font>";
			}}
		],
		//注册加载子表的事件。你可以理解为点击父表中+号时触发的事件
		onExpandRow : function(index, row, $detail) {
			//这一步就是相当于在当前点击列下新创建一个table
			var parentId = row.id;
			var cur_table = $detail.html('<table></table>')
					.find('table');
			var html = "";
			html += "<table class='table table-bordered table-condensed'>";
			html += "<thead>";
			html += "<tr style='height: 40px'>";
			html += "<th style='text-align: center;padding-bottom:10px;' class='warning'>邮箱</th>";
			html += "<th style='text-align: center;padding-bottom:10px;' class='warning'>生日</th>";
			html += "<th style='text-align: center;padding-bottom:10px;' class='warning'>地址</th>";
			html += "<th style='text-align: center;padding-bottom:10px;' class='warning'>描述</th>";
			html += "<th style='text-align: center;padding-bottom:10px;' class='warning'>创建人</th>";
			html += "<th style='text-align: center;padding-bottom:10px;' class='warning'>创建时间</th>";
			html += "<th style='text-align: center;padding-bottom:10px;' class='warning'>修改人</th>";
			html += "<th style='text-align: center;padding-bottom:10px;' class='warning'>修改时间</th>";
			html += "</tr>";
			html += "</thead>";
			//遍历子表数据
			html += "<tr>" 
					+ "<td class='warning'>"+ row.email + "</td>"
					+ "<td class='warning'>"+ dateFormatter(row.birthday) + "</td>"
					+ "<td class='warning'>"+ row.address + "</td>"
					+ "<td class='warning'>"+ row.description + "</td>"
					+ "<td class='warning'>"+ row.createUser + "</td>"
					+ "<td class='warning'>"+ dateFormatter(row.createTime)+ "</td>" 
					+ "<td class='warning'>"+ row.modifyUser + "</td>"
					+ "<td class='warning'>"+ dateFormatter(row.modifyTime)+ "</td>" 
					+ "</tr>";
			html += '</table>';
			$detail.html(html); // 关键地方
		}
	});
}


//新增按钮
function openWindow(){
	parent.layer.open({
		content:getRootPath() +"/user/show/addentity.do",
		type:2,
		shade: [1.2, '#000'],
		shadeClose:true,
		area: ['80%', '80%'],
		maxmin: true,
		btn:["提交",'取消'],
		btnAlign:'c',
		yes:function(index,layero){
			var body = layer.getChildFrame('body', index);
		    var iframeWin = parent.window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：
		    iframeWin.subChildForm();
		},
		end:function(index){
			$("#userTable").bootstrapTable('refresh');
		}
	});	
}

//编辑按钮(跳转页面并用于数据回显)
function updateWindow(){
	
	var rows = $("#userTable").bootstrapTable('getSelections');
	
	if(rows.length != 1){
		parent.layer.msg("请选择一条数据进行操作");
		return false;
	}
	
	if(rows[0].prohibition == 0){
		parent.layer.msg("禁用的记录无法编辑");
		return false;
	}
	
	var userId = rows[0].id;
	
	parent.layer.open({
		content:getRootPath() + "/user/show/addentity.do?userId="+userId,
		type:2,
		shade: [1.2, '#000'],
		shadeClose:true,
		area: ['80%', '80%'],
		maxmin: true,
		btn:["提交",'取消'],
		btnAlign:'c',
		yes:function(index,layero){
			var body = layer.getChildFrame('body', index);
		    var iframeWin = parent.window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：
		    iframeWin.subChildForm();
		},
		end:function(index){
			$("#userTable").bootstrapTable('refresh');
		}
	});	
}


//启禁按钮
function opt(){
	var rows = $("#userTable").bootstrapTable('getSelections');
	if(rows.length != 1){
		parent.layer.msg("请选择一条数据进行操作");
		return false;
	}
	var userId = rows[0].id;
	parent.layer.confirm(
		"您确定要操作该条记录吗?",
		{title:'确认框'},
		function(index){
			$.ajax({
				dataType:'json',
				type:'POST',
				data:{"userId":userId},
				url:getRootPath()+'/user/opt/entity.do',
				success:function(data){
					layer.close(index);
					parent.layer.msg(data.message);
					location.reload(true);
				}
			});
		},
		function(index){
			layer.close(index);
		}
	);
}

//删除按钮
function del(){
	var rows = $("#userTable").bootstrapTable('getSelections');
	if(rows.length != 1){
		parent.layer.msg("请选择一条数据进行操作");
		return false;
	}
	var userId = rows[0].id;
	parent.layer.confirm(
		"您确定要删除该条记录吗?",
		{title:'确认框'},
		function(index){
			$.ajax({
				dataType:'json',
				type:'POST',
				data:{"userId":userId},
				url:getRootPath()+'/user/del/entity.do',
				success:function(data){
					layer.close(index);
					parent.layer.msg(data.message);
					location.reload(true);
				}
			});
		},
		function(index){
			layer.close(index);
		}
	);
}

function queryUser(){
	$("#userTable").bootstrapTable('refresh');
}

</script>
</html>