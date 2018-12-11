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
	
	$.ajax({
		type:'POST',
		dataType:'json',
		url:getRootPath()+'/stage/get/nopage.do',
		success:function(data){
			var stageValue = $("#stageValue").val();
			$.each(data,function(i,v){
				$("#stageTD").append("<label style='margin-right:15px;margin-bottom:15px;' class='btn btn-default'><input id='stage"+this.id+"' type='radio' value="+this.id+" name='stageId'/>"+this.name+"</label>");
			});
			var _element = $("input[type='radio']");
			if(stageValue != null || stageValue != "" || stageValue != undefined){
				$.each(_element,function(index,value){
					if(value.value == stageValue){
						$(this).attr('checked','checked');
					}
				});
				
				$("input[type='radio']:checked").parent().addClass('active');
			}
			
		}
	});
});

document.onkeydown = function (e) {
	var theEvent = e || window.event;
	var code = theEvent.keyCode || theEvent.which || theEvent;
	if(code == 13) return false;
};

function subChildForm(){
	
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
	
 	var name = $("#name").val();
	
	if(name == null || name == "" || name == undefined){
		layer.msg("请填写课程名称");
		return;
	}
	
	var radioValue =  $('input[type="radio"]:checked').val();
	if(radioValue == null || radioValue == "" || radioValue == undefined){
		layer.msg("请选择阶段");
		return;
	}
	
	$.post($("#booksForm").attr('action'), $("#booksForm").serialize(),function(data){
		var index = parent.layer.getFrameIndex(window.name);
		parent.layer.close(index);
		parent.layer.msg(data.message);
	});
}

</script>
</head>
<body class="container" style="padding-top: 30px;">
	<form id="booksForm" method="post" action="${pageContext.request.contextPath}/books/add/books.do" class="form-horizontal">
		<input id="id" name="id" type="hidden" value="${books.id}" />
		
		<div class="form-group">
			<label for="stageTD"  class="col-sm-3 col-xs-3 col-md-2 col-lg-3  control-label" >对应阶段</label>
			<div id="stageTD" data-toggle='buttons' style='display:inline-block;' class="col-sm-9 col-xs-9 col-md-10 col-lg-9"></div>
			<input id="stageValue" type="hidden" value="${books.stageId}"/>
		</div>
		<div class="form-group">
			<label for="name" class="col-sm-3 col-xs-3 col-md-2 col-lg-3 control-label">课程名称</label>
			<div class="col-sm-9 col-xs-9 col-md-10 col-lg-9">
				<input id="name" name="name" type="text" placeholder="请输入课程名称" value="${books.name}" class="form-control"/>
			</div>
		</div>
	</form>
</body>
</html>