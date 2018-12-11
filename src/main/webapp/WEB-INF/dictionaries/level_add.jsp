<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>课程新增/修改</title>
<%@include file="/header/header.jsp" %>


<script type="text/javascript">

$(function(){
	
	$("input,textarea").bind("keydown",function(e){
		var theEvent = e || window.event;
		var code = theEvent.keyCode || theEvent.which || theEvent;
		if(code == 13) return false;		
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
});

document.onkeydown = function (e) {
	var theEvent = e || window.event;
	var code = theEvent.keyCode || theEvent.which || theEvent;
	if(code == 13) return false;
};

function subChildForm(){
	
 	var name = $("#name").val();
	
	if(name == null || name == "" || name == undefined){
		layer.msg("请填写部门名称");
		return;
	}
	
	$.post($("#levelForm").attr('action'), $("#levelForm").serialize(),function(data){
		var index = parent.layer.getFrameIndex(window.name);
		parent.layer.close(index);
		parent.layer.msg(data.message);
	});
}
</script>
</head>
<body class="container" style="padding-top: 30px;">
	<form id="levelForm" method="post" action="${pageContext.request.contextPath}/level/add/level.do" class="form-horizontal">
		<input id="id" name="id" type="hidden" value="${level.id}" />
		<div class="form-group">
			<label for="name" class="col-sm-2 col-xs-2 col-md-2 col-lg-2 control-label">部门名称</label>
			<div class="col-sm-10 col-xs-10 col-md-10 col-lg-10">
				<input id="name" name="name" type="text" placeholder="请输入部门名称" value="${level.name}" class="form-control"/>
			</div>
		</div>
	</form>
</body>
</html>