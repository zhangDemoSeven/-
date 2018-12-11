<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
<title>临时学生列表</title>
<%@include file="/header/header.jsp" %>
</head>
<body>
	<body class="container-fluid">
		<blockquote class="layui-elem-quote news_search" style="margin-top: 10px">
			<div class="layui-inline">
			    <div class="layui-input-inline">
			    	<select id="user1" name="user1" onchange="showuser1()" lay-verify="" class="layui-input search_input" style="width: 198px;">
				  	</select> 
				  	<input type="hidden" id="user1Hidden" />
			    </div>
			    
			    <div class="layui-input-inline">
			    	<select id="user2" name="user2" onchange="showuser2()" lay-verify="" class="layui-input search_input" style="width: 198px;">
				  </select> 
				  <input type="hidden" id="user2Hidden" />
			    </div>
			    <div class="layui-input-inline">
				  <select id="user3" name="user3" onchange="showuser3()" lay-verify="" class="layui-input search_input" style="width: 198px;">
				  </select>  
				  <input type="hidden" id="user3Hidden" />    
			    </div>
			     <div class="layui-input-inline">
			    	<input id="userName" type="text" value=""  placeholder="请输入学生姓名" class="layui-input search_input">
			    </div>
			    <div class="layui-inline">
				  <input id="queryDate" type="text" class="layui-input" placeholder="请选择创建时间" >
				</div>
			    
			    <a onclick="queryUser()" class="layui-btn search_btn" ><b>查询</b></a>
			
				<div class="layui-inline" style="margin-top: 5px">
					<a class="layui-btn linksAdd_btn"  onclick="add();" style="background-color:#5FB878"><b>添加咨询</b></a>
				</div>
				<div class="layui-inline">
					<a class="layui-btn linksAdd_btn"  onclick="edit();" style="background-color:#FFB800"><b>修改咨询</b></a>
				</div>
				<div class="layui-inline">
					<a class="layui-btn layui-btn-danger batchDel" onclick="addUser(1);"><b>指定网咨</b></a>
				</div>
				<div class="layui-inline">
					<a class="layui-btn linksAdd_btn"  onclick="addUser(2);" style="background-color:#2F4056"><b>指定助理</b></a>
				</div>
				
				<div class="layui-inline">
					<a class="layui-btn linksAdd_btn"  onclick="addUser(3);" style="background-color:#5FB878"><b>指定咨询</b></a>
				</div>
				
				<div class="layui-inline">
					<a class="layui-btn linksAdd_btn"  onclick="editIsTemp();" style="background-color:#FFB800"><b>转为正式</b></a>
				</div>
			</div>	
		</blockquote>
		<div class="table-responsive">
			<table class="table table-striped table-hover" id="flagstudentTable" style="text-align:center"></table>
		</div> 
	</body>
	
</body>

<script type="text/javascript">

function showuser1(){
	var user1 = document.getElementById('user1');
	var user1Id = user1.options[user1.selectedIndex].value;
	//把选择的章节id存入到隐藏域
	$("#user1Hidden").val(user1Id);
}

function showuser2(){
	var user2 = document.getElementById('user2');
	var user2Id = user2.options[user2.selectedIndex].value;
	//把选择的章节id存入到隐藏域
	$("#user2Hidden").val(user2Id);
}

function showuser3(){
	var user3 = document.getElementById('user3');
	var user3Id = user3.options[user3.selectedIndex].value;
	//把选择的章节id存入到隐藏域
	$("#user3Hidden").val(user3Id);
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

$(function(){
	 //加载网咨列表
	 $.ajax({
		type:'POST',
		dataType:'json',
		url:getRootPath()+"/user/get/user1.do",
		success:function(data){
			$("#user1").append($("<option>").val("").text("请选择网咨"));
			$.each(data,function(i,v){
				var options = $('<option>').val(this.id).text(this.nickName);
				$("#user1").append(options);
			});
		}
	});
	
	 
	 //加载助理列表
	 $.ajax({
		type:'POST',
		dataType:'json',
		url:getRootPath()+"/user/get/user2.do",
		success:function(data){
			$("#user2").append($("<option>").val("").text("请选择助理"));
			$.each(data,function(i,v){
				var options = $('<option>').val(this.id).text(this.nickName);
				$("#user2").append(options);
			});
		}
	});
	 
	 
	 //加载咨询列表
	 $.ajax({
		type:'POST',
		dataType:'json',
		url:getRootPath()+"/user/get/user3.do",
		success:function(data){
			$("#user3").append($("<option>").val("").text("请选择咨询"));
			$.each(data,function(i,v){
				var options = $('<option>').val(this.id).text(this.nickName);
				$("#user3").append(options);
			});
		}
	});
	
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
	
	initFlagStudentTable();
});

function add(){
	parent.layer.open({
		area:['1200px','500px'],
		type:2,
		title:'添加或修改临时咨询信息',
		maxmin:true,
		shade:[1.2,"#000"],
		content:getRootPath()+'/student/show/addentity.do',
		btn:["提交"],
		btnAlign:'c',
		yes:function(index,layero){
			var body = layer.getChildFrame('body', index);
		    var iframeWin = parent.window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：
		    iframeWin.subChildForm();
		},
		end:function(index){
			$("#flagstudentTable").bootstrapTable('refresh');
		}
	});
}

function edit(){
	
	var rows = $("#flagstudentTable").bootstrapTable('getSelections');
	
	if(rows.length != 1){
		layer.msg("请选择一行进行操作");
		return;
	}
	
	var userId = rows[0].id;
	
	parent.layer.open({
		area:['1200px','500px'],
		type:2,
		title:'添加或修改临时咨询信息',
		shade:[1.2,"#000"],
		maxmin:true,
		content:getRootPath()+'/student/show/addentity.do?userId='+userId,
		btn:["提交"],
		btnAlign:'c',
		yes:function(index,layero){
			var body = layer.getChildFrame('body', index);
		    var iframeWin = parent.window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：
		    iframeWin.subChildForm();
		},
		end:function(index){
			$("#flagstudentTable").bootstrapTable('refresh');
		}
	});
}

function editIsTemp(){
	
	var rows = $("#flagstudentTable").bootstrapTable('getSelections');
	
	if(rows.length != 1){
		parent.layer.msg("请选择一行进行操作");
		return;
	}
	
	var userId = rows[0].id;
	
	parent.layer.confirm(
			'您确定要把该名学生转换成正式学生并把该数据发送给教质部吗?'
			,{title:'确认窗口'},
			function(index){
				$.ajax({
					type:'POST',
					dataType:'json',
					data:{"userId":userId},
					url:getRootPath()+'/student/edit/isTemp.do',
					success:function(data){
						layer.close(index);
						parent.layer.msg(data.message,{time:1000000,shade:[1.2,"#000"],shadeClose:true,btn:["确定"],btnAlign:'c'});
						$("#flagstudentTable").bootstrapTable('refresh');
					}
				});
			}
	);
}

//指定网咨 助理 咨询
function addUser(types){
	
	var rows = $("#flagstudentTable").bootstrapTable('getSelections');
	
	if(rows.length != 1){
		parent.layer.msg("请选择一行进行操作");
		return;
	}
	
	var userId = rows[0].id;
	
	parent.layer.open({
		id:'insert-form',
		area:["500px","300px"],
		type:2,
		scrollbar:true,
		maxmin:true,
		content:getRootPath()+"/student/get/user123.do?userId="+userId+"&types="+types,
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

function initFlagStudentTable(){
	$("#flagstudentTable").bootstrapTable({
		url:getRootPath()+'/student/get/nolist.do',
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
				user1:$("#user1Hidden").val(),
				user2:$("#user2Hidden").val(),
				user3:$("#user3Hidden").val(),
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
			{field : 'user1Name',title : '网咨',align : 'center'},
			{field : 'user2Name',title : '助理',align : 'center'},
			{field : 'user3Name',title : '咨询',align : 'center'}
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
			html +="<th style='text-align: center;padding-bottom:10px;' class='warning'>性别</th>";
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
				+"<td>"+toSexName(row.sex)+"</td>"
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

function toSexName(param){
	return param == "1" ? "男":"女";
}

function queryUser(){
	$("#flagstudentTable").bootstrapTable('refresh');
}
</script>

</html>