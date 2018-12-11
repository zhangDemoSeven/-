<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生指定网咨</title>
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
	var types=$("#types").val();
	//加载网咨1 助理2 咨询3
	 $.ajax({
			type:'POST',
			dataType:'json',
			url:getRootPath()+"/user/get/user"+types+".do",
			success:function(data){
				$.each(data,function(i,v){
					$("#user1TD").append("<label id='"+this.id+"' style='margin-right:15px;margin-bottom:15px;' class='btn btn-default'><input id="+v.id+" type='radio' value='"+v.id+"' name='user123Id'/>" + this.nickName+"</label>");
				});
				
				//回显
				var user1= $("#user1").val();
				var user2= $("#user2").val();
				var user3= $("#user3").val();
				
				var options = $("input[name='user123Id']");
				
				$.each(options,function(i,v){
					if(v.value == user1){
						$(this).attr("checked","checked");
						$("#"+v.id).addClass('active');
					}
					if(v.value == user2){
						$(this).attr("checked","checked");
						$("#"+v.id).addClass('active');
					}
					if(v.value == user3){
						$(this).attr("checked","checked");
						$("#"+v.id).addClass('active');
					}
					
				});
				
			}
		});
	
});

//父级窗口调用的方法: 提交该页面的表单
function subChildForm(){
	$.ajax({
		type:'POST',
		dataType:'json',
		url:$("#addUser1Form").attr('action'),
		data:$("#addUser1Form").serialize(),
		success:function(data){
			parent.layer.msg(data.message);
			var index = parent.layer.getFrameIndex(window.name);
			parent.layer.close(index);
		}
	});
}
</script>

</head>
<body class="container" style="padding-top:15px;">
		<input id="user1" type="hidden" name="user1" value="${student.user1}">
		<input id="user2" type="hidden" name="user2" value="${student.user2}">
		<input id="user3" type="hidden" name="user3" value="${student.user3}">
	<form id="addUser1Form"  method="post" class="form-horizontal" action="${pageContext.request.contextPath}/student/add/user123.do" >
		<input id="userId" type="hidden" name="userId" value="${userId}"/>
		<input id="types" type="hidden" name="types" value="${types}">
		<div class="form-group">
			<label for="user1TD"  class="col-sm-3 col-xs-3 col-md-2 col-lg-3  control-label" >指定认定人员</label>
			<div id="user1TD" data-toggle='buttons' style='display:inline-block;' class="col-sm-9 col-xs-9 col-md-10 col-lg-9"></div>
		</div>
	</form>
</body>
</html>