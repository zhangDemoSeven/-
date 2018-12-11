<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎登陆</title>
<%@include file="/header/header.jsp"%>
<link href="${pageContext.request.contextPath}/static/login/css/login.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
<link href="${pageContext.request.contextPath}/static/login/css/demo.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="${pageContext.request.contextPath}/static/login/js/jquery1.42.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/login/js/jquery.SuperSlide.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/login/js/Validform_v5.3.2_min.js"></script>
</head>
<body>
	<div class="header">
	    <h1 class="headerLogo">
	  	  <a title="后台管理系统" href="javascript:void(0)">
	  		<img alt="logo" width="230px" height="100px" src="${pageContext.request.contextPath}/static/login/images/logo1.png">
	  	  </a>
	  	  
	  	 <%--  <a title="后台管理系统" href="javascript:void(0)">
		  	<img alt="logo" width="186px" height="71px" src="${pageContext.request.contextPath}/static/login/images/logo.png">
		  </a> --%>
	    </h1>
	  
		<div class="headerNav">
			<a target="_blank" href="#">开发团队</a>
		</div>
	</div>
	
	<div class="banner">
		<div class="login-aside">
		  <div id="o-box-up"></div>
		  <div id="o-box-down"  style="table-layout:fixed;">
		  <div class="error-box"></div>
			   <form class="registerform" id="userForm" action="${pageContext.request.contextPath}/ln.do">
				  <div class="fm-item">
					   <label for="logonId" class="form-label">登陆用户：</label>
					   <input id="username"  type="text" class="i-text" name="username" placeholder="请输入账户名" required autofocus />
				       <div class="ui-form-explain"></div>
				  </div>
				  
				  <div class="fm-item">
					   <label for="logonId" class="form-label">登陆密码：</label>
					   <input id="password" type="password" class="i-text" name="password" placeholder="请输入密码" required autofocus />
				       <div class="ui-form-explain"></div>
				  </div>
				  
				  <div class="fm-item">
					   <label for="logonId" class="form-label"></label>
				       <button type="button"  onclick="ajaxSub()" class="btn-login"></button>
				       <div class="ui-form-explain"></div>
				  </div>
			  </form>
		  </div>
		</div>
		<div class="bd">
			<ul>
				<li style="background:url(static/login/themes/theme-pic1.jpg) #CCE1F3 center 0 no-repeat;"></li>
				<li style="background:url(static/login/themes/theme-pic2.jpg) #BCE0FF center 0 no-repeat;"></li>
			</ul>
		</div>
		
		<div class="hd"><ul></ul></div>
	</div>
<script type="text/javascript">jQuery(".banner").slide({ titCell:".hd ul", mainCell:".bd ul", effect:"fold",  autoPlay:true, autoPage:true, trigger:"click" });</script>
<div class="banner-shadow"></div>
<script type="text/javascript">
$(function(){
	
	var xian=$(document).width();
	if(xian<parseInt(700)){
		$(".mycenter").addClass("bodyWidth");
	}else{
		$(".mycenter").removeClass("bodyWidth");
	}
	
	history.pushState(null, null, document.URL);
	window.addEventListener('popstate', function () {
	    history.pushState(null, null, document.URL);
	});
	
	document.oncontextmenu = function () { 
		return false; 
	};
	
    document.onkeydown = function () {
	    if(window.event && window.event.keyCode == 123) {
	      event.keyCode = 0;
	      event.returnValue = false;
	      return false;
	    }
    };

	$(document).bind("keydown", function(e) {//文档绑定键盘按下事件 
		e = window.event || e;//解决浏览器兼容的问题   
		if(e.keyCode == 116) {//F5按下 
			return false; 
		}else{//让刷新，并完成特定事件 //完成特定事件 
			
		} 
	});
});

function ajaxSub(){
	$.ajax({
		type:'POST',
		data:$("#userForm").serialize(),
		url:$("#userForm").attr('action'),
		success:function(data){
			if(!data.type){
				window.location.href=getRootPath()+"/login.do";
			}else{
				layer.msg(data.message,function(){});
				$("#username").val("");
				$("#password").val("");
				return;
			}
		}
	});
}


$(window).resize(function(){
	var xian=$(document).width();
	if(xian<parseInt(700)){
		$(".mycenter").addClass("bodyWidth");
	}else{
		$(".mycenter").removeClass("bodyWidth");
	}
})
</script>
</body>
</html>
