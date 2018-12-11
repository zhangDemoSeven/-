<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师列表</title>
<%@include file="/header/header.jsp" %>
</head>
	<body class="container-fluid">
		<blockquote class="layui-elem-quote news_search" style="margin-top: 10px">
			<div class="layui-inline">
			    <div class="layui-input-inline">
				  <select id="levelId" name="levelId" onchange="levelChange()" lay-verify="" class="layui-input search_input" style="width: 198px;">
				  </select>  
				  <input type="hidden" id="levelHidden" />    
			    </div>
			    <div class="layui-input-inline">
				  <select id="identityId" name="identityId" onchange="identityChange()" lay-verify="" class="layui-input search_input" style="width: 198px;">
				  </select>  
				  <input type="hidden" id="identityHidden" />    
			    </div>
			     <div class="layui-input-inline">
			    	<input id="teacherName" type="text" value=""  placeholder="请输入教师名称" class="layui-input search_input">
			    </div>
			    <div class="layui-input-inline">
				  <select id="classesId" name="classesId" onchange="classesChange()" lay-verify="" class="layui-input search_input" style="width: 198px;">
				  </select>  
				  <input type="hidden" id="classesIdHidden" />    
			    </div>
			 	<div class="layui-input-inline">
			    	<a onclick="queryTeacher()" class="layui-btn search_btn" ><b>查询</b></a>
			    </div>
				<div class="layui-inline">
					<a class="layui-btn linksAdd_btn"  onclick="add();" style="background-color:#5FB878"><b>工作交接</b></a>
				</div>
			</div>		
		</blockquote>
		<div class="table-responsive">
			<table class="table table-striped table-hover" id="teacherTable" style="text-align:center"></table>
		</div> 
	</body>

<script type="text/javascript">
$(function(){
	initClassesTable();
	
	//加载部门
	$.ajax({
		type:'POST',
		dataType:'json',
		url:getRootPath()+'/level/get/nopage.do',
		success:function(data){
			$("#levelId").append($("<option>").val("").text("请选择部门"));
			$.each(data,function(i,v){
				$("#levelId").append($("<option>").val(this.id).text(this.name));
			});
		}
	});
	
	//加载身份
	$.ajax({
		type:'POST',
		dataType:'json',
		url:getRootPath()+'/identity/get/nopage.do',
		success:function(data){
			$("#identityId").append($("<option>").val("").text("请选择身份"));
			$.each(data,function(i,v){
				$("#identityId").append($("<option>").val(this.id).text(this.name));
			});
		}
	});
	
	//加载班级
	$.ajax({
		type:'POST',
		dataType:'json',
		url:getRootPath()+'/classes/get/nopage.do',
		success:function(data){
			$("#classesId").append($("<option>").val("").text("请选择所带班级"));
			$.each(data,function(i,v){
				$("#classesId").append($("<option>").val(this.id).text(this.className));
			});
		}
	});
	
});

function classesChange(){
	var classes = document.getElementById('classesId');
	var value = classes.options[classes.selectedIndex].value;
	$("#classesIdHidden").val(value);
}


function levelChange(){
	var level = document.getElementById('levelId');
	var value = level.options[level.selectedIndex].value;
	$("#levelHidden").val(value);
}

function identityChange(){
	var identity = document.getElementById('identityId');
	var value = identity.options[identity.selectedIndex].value;
	$("#identityHidden").val(value);
}

function queryTeacher(){
	$("#teacherTable").bootstrapTable('refresh');
}

function initClassesTable(){
	$("#teacherTable").bootstrapTable({
		url:getRootPath()+'/teacher/get/list.do',
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
		detailView : false, //是否显示父子表
		queryParams : function(params) {//得到查询的参数
			//这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
			var temp = {
				limit : params.limit, // 每页显示数量
				offset : params.offset, // SQL语句起始索引
				page : (params.offset / params.limit) + 1,
				teacherName:$("#teacherName").val(),
				level:$("#levelHidden").val(),
				identity:$("#identityHidden").val(),
				classesId:$("#classesIdHidden").val()
			};
			return temp;
		},
		columns:[
			{radio : true},
			{field : 'id',visible : false},
			{field : 'level',visible : false},
			{field : 'identity',visible : false},
			{field : 'nickName',title : '教师姓名',align : 'center'},
			{field : 'levelName',title:'所在部门',align:'center'},
			{field : 'identityName',title:'所属身份',align:'center'},
			{field : 'classesNames',title:'所带班级',align:'center',formatter:function(value,row,index){
				if(!value) return "暂无班级";
				else return value;
 			}}
		]
	});
}
	
	
</script>

</html>