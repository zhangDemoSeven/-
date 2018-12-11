<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>章节新增/修改</title>
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
$(function(){
	$.ajax({
		type:'POST',
		dataType:'json',
		url:getRootPath()+"/books/get/nopage.do",
		success:function(data){
			$.each(data,function(i,v){
				$("#booksTD").append("<label style='margin-right:15px;margin-bottom:15px;' class='btn btn-default'><input type='radio' name='booksId' id='books"+this.id+"' value='"+this.id+"'/>"+this.name+"</label>");
			});
			
			var booksValue = $("#booksValue").val();

			var _element = $("input[type='radio']");
			if(booksValue != null || booksValue != "" || booksValue != undefined){
				$.each(_element,function(index,value){
					if(value.value == booksValue){
						$(this).attr('checked','checked');
					}
				});
				
				$("input[type='radio']:checked").parent().addClass('active');
			}
		}
		
	});
});

function subChildForm(){
	
 	var name = $("#name").val();
	
	if(name == null || name == "" || name == undefined){
		layer.msg("请填写章节名称");
		return;
	}
	
	var radioValue =  $('input[type="radio"]:checked').val();
	if(radioValue == null || radioValue == "" || radioValue == undefined){
		layer.msg("请选择课程");
		return;
	}
	
	$.post($("#chapterForm").attr('action'), $("#chapterForm").serialize(),function(data){
		var index = parent.layer.getFrameIndex(window.name);
		parent.layer.close(index);
		parent.layer.msg(data.message);
	});
}
</script>
</head>
<body class="container" style="padding-top: 30px;">
	<form id="chapterForm" method="post" action="${pageContext.request.contextPath}/chapter/add/chapter.do" class="form-horizontal">
		<input id="id" name="id" type="hidden" value="${chapter.id}" />
		
		<div class="form-group">
			<label for="booksTD"  class="col-sm-3 col-xs-3 col-md-2 col-lg-3  control-label" >对应课程</label>
			<div id="booksTD" data-toggle='buttons' style='display:inline-block;' class="col-sm-9 col-xs-9 col-md-10 col-lg-9"></div>
			<input id="booksValue" type="hidden" value="${chapter.booksId}"/>
		</div>
		
		<div class="form-group">
			<label for="name" class="col-sm-3 col-xs-3 col-md-2 col-lg-3 control-label">章节名称</label>
			<div class="col-sm-9 col-xs-9 col-md-10 col-lg-9">
				<input id="name" name="name" type="text" placeholder="请输入章节名称" value="${chapter.name}" class="form-control"/>
			</div>
		</div>
	</form>
</body>

</html>