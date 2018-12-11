<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,inital-scale=1,maximum-scale=1,user-scalable=no">
<title>消息管理</title>
<%@include file="/header/header.jsp"%>
</head>
	<body class="container-fluid">
		<blockquote class="layui-elem-quote news_search" style="margin-top: 10px">
			<div class="layui-inline">
			     <div class="layui-input-inline">
			    	<input id="messageName" type="text" value=""  placeholder="请输入发送消息的名称" class="layui-input search_input">
			    </div>
			    <div class="layui-inline">
				  <input id="queryDate" type="text" class="layui-input" placeholder="请选择创建时间" >
				</div>
			    
			    <a onclick="queryMessage()" class="layui-btn search_btn" ><b>查询</b></a>
				<div class="layui-inline" style="margin-top: 5px">
					<a class="layui-btn linksAdd_btn"  onclick="addMessage();" style="background-color:#5FB878"><b>发布消息</b></a>
				</div>
				<div class="layui-inline">
					<a class="layui-btn linksAdd_btn"  onclick="delSingle();" style="background-color:#FFB800"><b>删除消息</b></a>
				</div>
			</div>	
		</blockquote>
		<div class="table-responsive">
			<table class="table table-striped table-hover" id="messageTable" style="text-align:center"></table>
		</div> 
	</body>
<script type="text/javascript">
	$(function() {
		initTable();
	});

	//转换日期格式(时间戳转换为datetime格式)
	function changeDateFormat(cellval) {
		var dateVal = cellval + "";
		if (cellval != null) {
			var date = new Date(parseInt(dateVal.replace("/Date(", "").replace(
					")/", ""), 10));
			var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1)
					: date.getMonth() + 1;
			var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date
					.getDate();
			var hours = date.getHours() < 10 ? "0" + date.getHours() : date
					.getHours();
			var minutes = date.getMinutes() < 10 ? "0" + date.getMinutes()
					: date.getMinutes();
			var seconds = date.getSeconds() < 10 ? "0" + date.getSeconds()
					: date.getSeconds();
			return date.getFullYear() + "-" + month + "-" + currentDate + " "
					+ hours + ":" + minutes + ":" + seconds;
		}
	}

	function initTable() {
		$('#messageTable').bootstrapTable({
			url : getRootPath() + "/message/s/list.do", //请求后台的URL（*）
			method : 'get', //请求方式（*）
			toolbar : '#toolbar', //工具按钮用哪个容器
			striped : true, //是否显示行间隔色
			trimOnSearch : true,
			cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			sidePagination : 'server', //分页方式：client客户端分页，server服务端分页（*）
			pagination : true, //是否显示分页（*）
			pageNumber : 1, //初始化加载第一页，默认第一页
			pageSize : 10, //每页的记录行数（*）
			pageList : [ 10, 20, 30, 40 ], //可供选择的每页的行数（*）
			dataType : 'json',
			clickToSelect : true, //是否启用点击选中行
			uniqueId : "id", //每一行的唯一标识，一般为主键列
			columns : [ {
				checkbox : true
			}, {
				field : 'id',
				visible : false
			}, {
				field : 'content',
				title : '消息内容',
				align : 'center'
			}, {
				field : 'sourceName',
				title : '来源部门',
				align : 'center'
			}, {
				field : 'targetName',
				title : '目标部门',
				align : 'center',
				formatter : function(value, row, index) {
					return "<font color=#1E9FFF>" + value + "</font>"
				}
			}, {
				field : 'createUser',
				title : '发送者',
				align : 'center'
			}, {
				field : 'createTime',
				title : '发送时间',
				align : 'center',
				formatter : function(value, row, index) {
					return changeDateFormat(value)
				}
			} ],
			queryParams : function(params) {
				var flag = {
					offset : params.offset, //页码
					limit : params.limit,
					page : (params.offset / params.limit) + 1,
					messageName:$("#messageName").val(),
					queryDate:$("#queryDate").val(),
				}
				return flag;
			}
		});

	};

function addMessage() {
	parent.layer.open({
		type : 2,
		title : "发送消息",
		area : [ '1023px', '320px' ],
		encodeURI : 'utf-8',
		shade : [1.2,"#000"],
		maxmin : true,
		content : getRootPath() + "/message/addentity/view.do",
		btn:["提交"],
		btnAlign:'c',
		yes:function(index,layero){
			var body = layer.getChildFrame('body', index);
		    var iframeWin = parent.window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：
		    iframeWin.subChildForm();
		},
		end : function() {
			$("#messageTable").bootstrapTable('refresh');
		}
	});
}

//删除操作---要开始使用$.post   $.ajax太长，占空间
function delSingle() {
	var rows = $('#messageTable').bootstrapTable('getSelections');
	if (rows.length < 1) {
		parent.layer.msg('请选中记录进行操作', function() {});
		return;
	}
	
	 parent.layer.msg('您确定要进行删除消息吗?', {
		btnAlign : 'c',
		shade : [ 1.2, '#000' ],
		time : 10000,
		btn : [ '确定', '取消' ],
		yes : function(index) {
			var arr = [];
			for (var i = 0; i < rows.length; i++) {
				arr.push(rows[i].id);
			}
			var ids = arr.join(",");
			$.ajax({
				url:getRootPath() + "/message/del/entity.do", 
				data:{ids : ids},
				type:'POST',
				dataType:'json',
				success:function(data) {
					parent.layer.msg(data.message);
					parent.layer.close(index);
					$("#messageTable").bootstrapTable('refresh');
				}
			}); 
	 	}
	}) 
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

function queryMessage(){
	$("#messageTable").bootstrapTable('refresh');
}

</script>
</html>