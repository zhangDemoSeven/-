<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html  lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,inital-scale=1,maximum-scale=1,user-scalable=no">
<%@include file="/header/header.jsp" %>
<title>权限添加或修改</title>
<script type="text/javascript">
$(function(){
	formValidator();
	
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

//父子调用
function subChildForm(){
   var bootstrapValidator = $("#permissionForm").data('bootstrapValidator');
   bootstrapValidator.validate();
   if(bootstrapValidator.isValid()){
	   var name = $("#name").val();
		var id = $("#id").val();
		
		var result = true;
		
		if((id == null || id == "" || id == undefined )&&(name.trim().length > 0)){
			//重名校验
			$.ajax({
				async:false,
				type:'POST',
				dataType:'json',
				url:getRootPath()+"/permission/check/name.do",
				data:{"name":name},
				success:function(data){
					if(data.code == 5000){
						layer.msg(data.message);
						result = false;
					}
				}
			});
		}
		
		if(result == true){
			 $.post($("#permissionForm").attr('action'), $("#permissionForm").serialize(), function(data) {
				 	var index =parent.layer.getFrameIndex(window.name);
					parent.layer.close(index);
					parent.layer.msg(data.message);
		     }, 'json');
		}
   }else{
	   return;
   }
}


//校验规则+提交事件
function formValidator(){
	$("#permissionForm").bootstrapValidator({
		message:'该值无法校验',
		feedbackIcons: {
	           valid: 'glyphicon glyphicon-ok',
	           invalid: 'glyphicon glyphicon-remove',
	           validating: 'glyphicon glyphicon-refresh'
	    },
	    fields:{
	    	name:{
	    		validators:{
	    			notEmpty:{
	    				message:'权限名称不能为空'
	    			},
	    			stringLength:{
	    				min:3,
	    				max:20,
	    				message:'权限名称的长度在3-20个字节'
	    			},
	    			regexp: {
                        regexp: /^[a-zA-Z\u4e00-\u9fa5]+$/,
                        message: '权限名称中存在非法字符'
                    }
	    		}
	    	},
	    	keyword:{
	    		validators:{
	    			notEmpty:{
	    				message:'关键字不可为空'
	    			},
	    			stringLength:{
	    				min:3,
	    				max:20,
	    				message:'权限关键字的长度在3-20个字节'
	    			},
	    			regexp:{
	    				regexp:/[a-z]+:[a-z]+$/,
	    				 message: '格式不正确,如 single:save'
	    			}
	    		}
	    	},
	    	description:{
	    		validators:{
	    			notEmpty:{
	    				message:'备注不可为空'
	    			},
	    			stringLength:{
	    				min:1,
	    				max:100,
	    				message:'权限备注的长度在1-100个字节'
	    			},
	    			regexp: {
                        regexp: /^[a-zA-Z0-9\u4e00-\u9fa5]+$/,
                        message: '权限备注中存在非法字符'
                    }
	    		}
	    	}
	    }
	});
}

</script>
</head>
<body class="container" style="padding-top:20px;">
	<form id="permissionForm" method="post" class="form-horizontal" action="${pageContext.request.contextPath}/permission/add/entity.do" >
		<div class="form-group">
			<label for="name" class="col-sm-3 col-xs-3 col-md-3 col-lg-3 control-label">权限名称</label>
			<div class="col-sm-9 col-xs-9 col-md-9 col-lg-9">
				<input id="id" name="id" value="${permission.id}" type="hidden" />
				<input id="name" name="name" value="${permission.name}"  type="text"  placeholder="权限名称" class="form-control" />
			</div>
		</div>
		<div class="form-group">
			<label for="keyword" class="col-sm-3 col-xs-3 col-md-3 col-lg-3 control-label">关键字</label>
			<div class="col-sm-9 col-xs-9 col-md-9 col-lg-9">
				<input id="keyword" name="keyword" value="${permission.keyword}" type="text"  placeholder="关键字" class="form-control"/>
			</div>
		</div>
		<div class="form-group">
			<label for="description" class="col-sm-3 col-xs-3 col-md-3 col-lg-3 control-label">描述</label>
			<div class="col-sm-9 col-xs-9 col-md-9 col-lg-9">
				<textarea rows="" cols="" id="description" name="description" placeholder="备注" class="form-control">${permission.description}</textarea>
			</div>
		</div>
	</form>
</body>
</html>