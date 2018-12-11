<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html  lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
<title>发送消息</title>
<%@include file="/header/header.jsp"%>
</head>
<body class="container" style="width: 100%;padding-top: 20px">
	<form id="form1" method="post" class="form-horizontal">
		<div class="form-group">
			<label for="target" class="col-sm-2 col-xs-2 col-md-2 col-lg-2 control-label">目标部门</label>
			<div class="col-sm-10 col-xs-10 col-md-10 col-lg-10">
				<select id="target" name="target"  class="selectpicker" multiple data-live-search="true" data-max-options="20"></select>
			</div>
		</div>
	
		<div class="form-group">
			<label for="content" class="col-sm-2 col-xs-2 col-md-2 col-lg-2 control-label">消息内容</label>
			<div class="col-sm-10 col-xs-10 col-md-10 col-lg-10">
				<textarea  rows="" cols="" id="content" name="content" style="width:780px;" placeholder="请输入消息内容" class="form-control" ></textarea>
			</div>
		</div>
	</form>
	<!-- <button id="btn-sub" style="display:block;margin:0 auto" class="layui-btn layui-btn-lg" >立即发送</button> -->
</body>
<script type="text/javascript">
$(function() {
	formValidator();
	
	//回显部门信息
   	$.ajax({
		type : "POST",
		dataType : "json",
		url : getRootPath() + "/level/get/nopage.do",//url
		success : function(data) {
			for (var i = 0; i < data.length; i++) $("#target").append("<option value="+data[i].id+">"+data[i].name+"</option>");
			$("#target").selectpicker('refresh');
     		$("#target").selectpicker('render');
     		$('#target').selectpicker('val',['noneSelectedText']);//回到初始状态
		},
		error : function(data) {
			parent.layer.msg(data.message,function(){});
		}
	}); 
		
	/* $(".form_datetime").datetimepicker({
		format : 'yyyy-mm-dd hh:ii:ss',
		minView : 'month',
		language : 'zh-CN',
		autoclose : true,//选中自动关闭
		startDate : '1900-01-01',
		todayBtn : true
	}); */
})
	
function subChildForm(){
   var bootstrapValidator = $("#form1").data('bootstrapValidator');
   bootstrapValidator.validate();
   if(bootstrapValidator.isValid()){
	   $.ajax({
			type : "POST",
			dataType : "json",
			url : getRootPath() + "/message/add/entity.do",//url
			data:$('#form1').serialize(),
			success : function(data) {
				var index = parent.layer.getFrameIndex(window.name);
				parent.layer.close(index);
				parent.layer.msg(data.message);
			},
			error : function(data) {
				parent.layer.msg(data.message);
			}
		}); 
   }else{
	   return;
   }
}	
	
	
//校验规则+提交事件
function formValidator(){
	$("#form1").bootstrapValidator({
		message:'该值无法校验',
		feedbackIcons: {
	           valid: 'glyphicon glyphicon-ok',
	           invalid: 'glyphicon glyphicon-remove',
	           validating: 'glyphicon glyphicon-refresh'
	    },
	    fields:{
	    	content:{
	    		validators:{
	    			notEmpty:{
	    				message:'消息不可为空'
	    			},
	    			stringLength:{
	    				min:1,
	    				max:100,
	    				message:'消息的长度在1-100个字节'
	    			}
	    		}
	    	},
	    	'target':{
	    		validators:{
	    			choice: {
	                    min:1,
	                    message: '至少要选择一个'
	                }
	    		}
	    	}
	    }
	});
}		
	
</script>
</html>