<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学科列表</title>
<%@include file="/header/header.jsp" %>
</head>
<body class="container-fluid">
		<blockquote class="layui-elem-quote news_search" style="margin-top: 10px">
		<div class="layui-inline">
		    <div class="layui-input-inline">
		    	<input id="name" name="name" type="text" value="" placeholder="请输入学科名称" class="layui-input search_input">
		    </div>
		    <a class="layui-btn search_btn" onclick="searchClassification()"><b>查询</b></a>
		</div>
		<div class="layui-inline">
			<a class="layui-btn linksAdd_btn"  onclick="openWindow();" style="background-color:#5FB878"><b>新增学科</b></a>
		</div>
	</blockquote>
	<div class="table-responsive">
	<table id="classificationTable"></table>
	</div>
</body>
<script type="text/javascript">
$(function(){
	initclassificationTable();
	
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

//查询方法
function searchClassification() {
	$("#classificationTable").bootstrapTable("refresh");
}

function initclassificationTable(){ 
	$("#classificationTable").bootstrapTable({
		url:getRootPath()+'/classification/get/list.do',//加载表格数据的接口
		method:'GET',//提交方式
		dataType:'json',//服务器返回的数据格式
		toolbar:'#tb', //指定按钮组
		checkboxHeader:false,//设置为false时,表头隐藏复选框
		singleSelect:false,//只能单选行
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
				offset:params.offset,//sql语句中的起始索引  //↓总页数
				page:(params.offset / params.limit) + 1,
				name:$("#name").val()
			};
			return temp;
		},
		columns:[
			{radio:true},
			{field:'id',visible:false},//设置隐藏列
			{field:'name',title:'学科名称',align:'center'},
			{field:'prohibition',title:'启禁状态',align:'center',formatter:function(value,row,index){
				if(value == 1) return "<font color='green'>已启用</font>";
				if(value == 0) return "<font color='red'>已禁用</font>";
			}},
			{field:'createUser',title:'创建人',align:'center'},
			{field:'createTime',title:'创建时间',align:'center',formatter:function(value,row,index){
				return dateFormatter(value);
			}},
			{field:'modifyUser',title:'修改人',align:'center'},
			{field:'modifyTime',title:'修改时间',align:'center',formatter:function(value,row,index){
				return dateFormatter(value);
			}},
			{field : 'opt',title : '操作',align : 'center',formatter : function(value,row,index){
				var id = row.id;
				var result = "<div class='btn-group' role='group' aria-label='...''>";
				result += "<button  onclick='e("+ id+ ")' type='button' class='btn btn-success btn-xs'>编辑";
				result += "<button  onclick='o("+ id+ ")' type='button' class='btn btn-warning btn-xs'>启禁";
				result += "<button  onclick='d("+ id+ ")' type='button' class='btn btn-danger btn-xs'>删除";
				result += "</div>";
				return result;
			}}
		]
	});
}

//新增
function openWindow(){
	parent.layer.open({
		id: 'LAY_layuipro',
		type:2,
		area:["550px","200px"],
		content:getRootPath()+"/classification/show/classification.do",
		btn:["确定","取消"],
		yes:function(index,layero){
			var body = layer.getChildFrame('body', index);
		    var iframeWin = parent.window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：
		    iframeWin.subChildForm();
		},
		end:function(index){
			location.reload(true);
		}
	});
}

//编辑
function e(id){
	
	var rows = $("#classificationTable").bootstrapTable('getSelections');
	
	if(rows[0].prohibition == "0"){
		parent.layer.msg("被禁用的状态不允许编辑");
		return false;
	}
	
	parent.layer.open({
		type:2,
		area:["550px","200px"],
		content:getRootPath()+"/classification/show/classification.do?id="+id,
		btn:["确定","取消"],
		btnAlign:'c',
		yes:function(index,layero){
			var body = layer.getChildFrame('body', index);
		    var iframeWin = parent.window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：
		    iframeWin.subChildForm();
		},
		end:function(index){
			location.reload(true);
		}
	});
	
}

//启禁
function o(id){
	parent.layer.confirm(
		"您确定要操作该条记录吗?",
		{title:'确认框'},
		function(index){
			$.ajax({
				dataType:'json',
				type:'POST',
				data:{"id":id},
				url:getRootPath()+"/classification/opt/classification.do",
				success:function(data){
					layer.close(index);
					parent.layer.msg(data.message);
					location.reload(true);
				}
			});
		}
	);
}

//删除
function d(id){
	parent.layer.confirm(
		"您确认删除该条记录吗?",
		{title:'确认框'},
		function(index){
			$.ajax({
				dataType:'json',
				type:'POST',
				data:{"id":id},
				url:getRootPath()+"/classification/del/classification.do",
				success:function(data){
					layer.close(index);
					parent.layer.msg(data.message);
					location.reload(true);
				}
			});
		}	
	);
}
</script>
</html>