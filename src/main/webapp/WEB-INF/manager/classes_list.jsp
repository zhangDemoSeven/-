<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>班级管理</title>
<%@include file="/header/header.jsp" %>
</head>
	<body class="container-fluid">
		<blockquote class="layui-elem-quote news_search" style="margin-top: 10px">
			<div class="layui-inline">
			    <div class="layui-input-inline">
				  <select id="classesId" name="classesId" onchange="classesChange()" lay-verify="" class="layui-input search_input" style="width: 198px;">
				  </select>  
				  <input type="hidden" id="classesIdHidden" />    
			    </div>
			    <div class="layui-input-inline">
			    	<input id="teacherName" type="text" value=""  placeholder="请输入教师名称" class="layui-input search_input">
			    </div>
			    <a onclick="queryClasses()" class="layui-btn search_btn" ><b>查询</b></a>
			
				<div class="layui-inline" style="margin-top: 5px">
					<a class="layui-btn linksAdd_btn"  onclick="add();" style="background-color:#5FB878"><b>增加班级</b></a>
				</div>
				<div class="layui-inline">
					<a class="layui-btn linksAdd_btn"  onclick="edit();" style="background-color:#FFB800"><b>修改班级</b></a>
				</div>
			</div>	
		</blockquote>
		<div class="table-responsive">
			<table class="table table-striped table-hover" id="classesTable" style="text-align:center"></table>
		</div> 
	</body>
<script type="text/javascript">
$(function(){
	initClassesTable();
	//加载班级列表
	$.ajax({
		type:'POST',
		dataType:'json',
		url:getRootPath()+"/classes/get/nopage.do",
		success:function(data){
			$("#classesId").html("");
			$("#classesId").append($("<option>").val("").text("请选择班级"));
			$.each(data,function(i,v){
				var options = $('<option>').val(this.id).text(this.className);
				$("#classesId").append(options);
			});
		}
	});
});

function classesChange(){
	var classes = document.getElementById('classesId');
	var classesId = classes.options[classes.selectedIndex].value;
	$("#classesIdHidden").val(classesId);
}

function add(){
	parent.layer.open({
		type:2,
		area:["1170px","450px"],
		maxmin:true,
		shade:[1.2,"#000"],
		title:'添加或修改班级信息',
		content:getRootPath()+ "/classes/show/addentity.do",
		btn:["提交","取消"],
		btnAlign:'c',
		yes:function(index,layero){
			var body = layer.getChildFrame('body', index);
		    var iframeWin = parent.window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：
		    iframeWin.subChildForm();
		},
		end:function(){
			location.reload(true);
		}
	});
}

function edit(){
	
	var rows = $("#classesTable").bootstrapTable('getSelections');
	
	if(rows.length != 1){
		parent.layer.msg("请选择一条数据进行操作");
		return;
	}
	
	if(rows[0].ison == 0){
		parent.layer.msg("结业的班级无法编辑");
		return;
	}
	
	var classesId = rows[0].id;
	
	parent.layer.open({
		type:2,
		area:["1170px","450px"],
		maxmin:true,
		shade:[1.2,"#000"],
		title:'添加或修改班级信息',
		content:getRootPath()+ "/classes/show/addentity.do?classesId="+classesId,
		btn:["提交","取消"],
		btnAlign:'c',
		yes:function(index,layero){
			var body = layer.getChildFrame('body', index);
		    var iframeWin = parent.window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：
		    iframeWin.subChildForm();
		},
		end:function(){
			location.reload(true);
		}
	});
}

function queryClasses(){
	$("#classesTable").bootstrapTable('refresh');
}


function initClassesTable(){
	$("#classesTable").bootstrapTable({
		url:getRootPath()+'/classes/get/list.do',
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
		pageList:[10,20,30,'ALL'],
		uniqueId : "id", //每一行的唯一标识，一般为主键列
		cardView : false, //是否显示详细视图
		detailView : false, //是否显示父子表
		queryParams : function(params) {//得到查询的参数
			//这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
			var temp = {
				limit : params.limit, // 每页显示数量
				offset : params.offset, // SQL语句起始索引
				page : (params.offset / params.limit) + 1,
				classesId:$("#classesId").val(),
				teacherName:$("#teacherName").val(),
			};
			return temp;
		},
		columns:[
			{radio : true},
			{field : 'id',visible : false},//visible:false隐藏
			{field : 'stageId',visible : false},
			{field : 'teacherIds',visible : false},
			{field : 'className',title : '班级名称',align : 'center'},
			{field : 'shiftTime',title : '开班时间',align : 'center',formatter:function(value,row,index){
				return dateFormatter(value);
			}},
			{field : 'teacherNames',title :'教师列表',align : 'center',formatter:function(value,row,index){
				var array =  value.split(",");
				return "教员:<font color='red'>"+array[0]+"</font>,"
						+"助教:<font color='blue'>"+array[1]+"</font>,"
						+"班主任:<font color='orange'>"+array[2]+"</font>";
			}},
			{field : 'stageName',title : '阶段名称',align : 'center'},
			{field : 'ison',title : '是否结业',align : 'center',formatter:function(value,row,index){
				if(value == "1") return "<font color='green'>未结业</font>";
				if(value == "0") return "<font color='gray'>已结业</font>";
			}}
		]
	});
}
	
	
</script>

</html>