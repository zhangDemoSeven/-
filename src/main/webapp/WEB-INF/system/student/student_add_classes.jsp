<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生指定班级</title>
<%@include file="/header/header.jsp" %>
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
	
	//加载身份
	$.post(getRootPath()+"/classes/get/s1.do",{},function(data){
		$.each(data,function(i,v){
			$("#classesTD").append("<label style='margin-right:15px;margin-bottom:15px;' class='btn btn-default'><input id="+v.id+" type='radio' value='"+v.id+"' name='classesId'/>" + this.className+"</label>");
		});
	},'json');
});

//父级窗口调用的方法: 提交该页面的表单
function subChildForm(){
	//检查要新增的班级是否正在考试
	var flag = false;
	$.ajax({
		type:'POST',
		dataType:'json',
		async:false,
		url:getRootPath()+"/student/check/examination.do",
		data:$("#addClassesForm").serialize(),
		success:function(data){
			if(data.code=='2000'){
				flag = true;
			}else{
				flag = false;
				parent.layer.msg(data.message);
			}
		}
	})
	
	if(flag){
		//执行新增班级
		$.ajax({
			type:'POST',
			dataType:'json',
			url:$("#addClassesForm").attr('action'),
			data:$("#addClassesForm").serialize(),
			success:function(data){
				parent.layer.msg(data.message);
				var index = parent.layer.getFrameIndex(window.name);
				parent.layer.close(index);
				
			}
		});
	}
}

</script>

</head>
<body class="container" style="padding-top:15px;">
	<form id="addClassesForm"  method="post" class="form-horizontal" action="${pageContext.request.contextPath}/student/add/s1classes.do" >
		<input type="hidden" name="userId" value="${userId}"/>
		<div class="form-group">
			<label for="classesTD"  class="col-sm-3 col-xs-3 col-md-2 col-lg-3  control-label" >指定班级</label>
			<div id="classesTD" data-toggle='buttons' style='display:inline-block;' class="col-sm-9 col-xs-9 col-md-10 col-lg-9"></div>
		</div>
	</form>
</body>
</html>