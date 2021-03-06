<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>渠道新增/修改</title>
<%@include file="/header/header.jsp" %>


<script type="text/javascript">

function subChildForm(){
	
 	var name = $("#name").val();
	
	if(name == null || name == "" || name == undefined){
		layer.msg("请填写渠道名称");
		return;
	}
	
	$.post($("#channelForm").attr('action'), $("#channelForm").serialize(),function(data){
		var index = parent.layer.getFrameIndex(window.name);
		parent.layer.close(index);
		parent.layer.msg(data.message);
	});
}

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

	//如果为修改时，回显用户的选择数据

	var id = $("#id").val();
	
	if(id!="" && id!=null){
		$.post(getRootPath() + "/channel/back/parent.do", {channelId:id},function(data){
			$("#parent").val(data.id);
			$("#parent").selectpicker('render');
			$("#parent").selectpicker('refresh');
		});
	}
	
	
});
</script>
</head>
<body class="container" style="padding-top: 30px;overflow: hidden;">
	<form id="channelForm" method="post" action="${pageContext.request.contextPath}/channel/add/channel.do" class="form-horizontal">
		<input id="id" name="id" type="hidden" value="${channel.id}" />
		<div class="form-group">
			<label for="name" class="col-sm-2 col-xs-2 col-md-2 col-lg-2 control-label">渠道名称</label>
			<div class="col-sm-10 col-xs-10 col-md-10 col-lg-10">
				<input id="name" name="channelName" type="text" placeholder="请输入渠道名称" value="${channel.channelName}" class="form-control"/>
			</div>
		</div>
		<div class="form-group">
			<label for="name" class="col-sm-2 col-xs-2 col-md-2 col-lg-2 control-label">父级分类</label>
				<select id="parent" name="pid"  class="col-sm-10 col-xs-10 col-md-10 col-lg-10 selectpicker" multiple data-live-search="true" data-max-options="1">
					<c:if test="${ not empty parents }">
						<!-- 开始遍历 -->
						<c:forEach items="${parents}" var="parent" varStatus="status">
							<option value="${parent.id }">${parent.channelName }</option>
						</c:forEach>
					</c:if>
				</select>
		</div>
	</form>
</body>

</html>