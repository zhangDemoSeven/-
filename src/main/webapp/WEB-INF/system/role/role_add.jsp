<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,inital-scale=1,maximum-scale=1,user-scalable=no">
<title>角色添加或修改</title>
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
	
	var roleId = $("#id").val();

	//页面加载后,获得所有非禁用,非删除状态的菜单复选框集合
	$.ajax({
		type:'POST',
		dataType:'json',
		url:getRootPath()+'/menu/get/load.do',
		success:function(data){
			// 生成checkbox列表 
			 $(data).each(function(i,v){
				$("#menuTD").append("<div class='checkbox'  style='display:inline-block;padding-right:5px;'><label><input id=menu"+v.id+" type='checkbox' value='"+v.id+"'  name='menuIds'  />" + this.title); 
			 }); 
			
			//当编辑时,回显菜单数据
			if(roleId != null){
				$.post(getRootPath()+"/menu/back/entity.do",{"roleId":roleId},function(data){
					$(data).each(function(i,v){
						$("#menu"+v.id).attr("checked","checked");
					});
				},'json');
			}
			
			
			
			
			//页面加载后,获得所有非禁用,非删除状态的权限复选框集合
			$.ajax({
				type:'POST',
				dataType:'json',
				url:getRootPath()+'/permission/get/load.do',
				success:function(data){
					// 生成checkbox列表 
					$(data).each(function(i,v){
						$("#permissionTD").append("<div class='checkbox' style='display:inline-block;padding-right:5px;'><label><input id=permission"+v.id+" type='checkbox' value='"+v.id+"' name='permissionIds'/>" + this.name);
					});
					
					//回显权限数据
					if(roleId != null || roleId != "" || roleId != undefined){
						$.post(getRootPath()+"/permission/back/entity.do",{"roleId":roleId},function(data){
							$(data).each(function(i,v){
								$("#permission"+v.id).attr("checked","checked");
							});
						},'json');
					}
					
					formValidator();
				}
			});
		}
	});	
});
	
	
//父子调用
function subChildForm(){
	   var bootstrapValidator = $("#roleForm").data('bootstrapValidator');
	   bootstrapValidator.validate();
	   if(bootstrapValidator.isValid()){
		   var name = $("#name").val();
			
			var result = true;
			
			if(name.trim().length > 0){
				$.ajax({
					async:false,
					type:'POST',
					dataType:'json',
					url:getRootPath()+"/role/check/name.do",
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
				parent.layer.load(2);
				$.post($("#roleForm").attr('action'), $("#roleForm").serialize(), function(result) {
				 	parent.layer.msg(result.message);
				 	parent.layer.closeAll('iframe');
				 	parent.layer.closeAll('loading');
			    }, 'json');
			}
	   }else{
		   return;
	   }
	}
	
	
//校验规则+提交事件
function formValidator(){
	$("#roleForm").bootstrapValidator({
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
	    				message:'角色名称不能为空'
	    			},
	    			stringLength:{
	    				min:3,
	    				max:20,
	    				message:'角色名称的长度在3-20个字节'
	    			},
	    			regexp: {
                        regexp: /^[a-zA-Z\u4e00-\u9fa5]+$/,
                        message: '角色名称中存在非法字符'
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
	    				message:'角色关键字的长度在3-20个字节'
	    			},
	    			regexp:{
	    				regexp:/[a-z]+$/,
	    				 message: '关键字只能是小写字母'
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
	    				message:'角色备注的长度在1-100个字节'
	    			},
	    			regexp: {
                        regexp: /^[a-zA-Z\u4e00-\u9fa5]+$/,
                        message: '角色备注中存在非法字符'
                    }
	    		}
	    	},
	    	'menuIds':{
	    		validators:{
	    			choice: {
	                    min:1,
	                    message: '至少要选择一个'
	                }
	    		}
	    	},
	    	'permissionIds':{
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
</head>
<body class="container" style="padding-top: 20px;">
	<form id="roleForm"  method="post" class="form-horizontal" action="${pageContext.request.contextPath}/role/add/entity.do" >
			
			<div class="form-group">
				<label for="name" class="col-sm-3 col-xs-3 col-md-3 col-lg-3 control-label">角色名称</label>
				<div class="col-sm-9 col-xs-9 col-md-9 col-lg-9">
					<input id="id" name="id" type="hidden" value="${role.id}" />
					<input id="name" name="name" type="text"  placeholder="角色名称" value="${role.name}" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="keyword" class="col-sm-3 col-xs-3 col-md-3 col-lg-3 control-label">关键字</label>
				<div class="col-sm-9 col-xs-9 col-md-9 col-lg-9">
					<input id="keyword" name="keyword" type="text" placeholder="关键字" value="${role.keyword}" class="form-control"/>
				</div>
			</div>
			<div class="form-group">
				<label for="description" class="col-sm-3 col-xs-3 col-md-3 col-lg-3 control-label">描述</label>
				<div class="col-sm-9 col-xs-9 col-md-9 col-lg-9">
					<textarea rows="" cols="" id="description" name="description" placeholder="备注" class="form-control">${role.description}</textarea>
				</div>
			</div>
			
		<div class="form-group">
			<label for="permissionTD" class="col-sm-3 col-xs-3 col-md-3 col-lg-3 control-label">权限选择</label>
			<div id="permissionTD" class="col-sm-9 col-xs-9 col-md-9 col-lg-9"></div>
		</div>
		
		
		<div class="form-group">
			<label for="menuTD" class="col-sm-3 col-xs-3 col-md-3 col-lg-3 control-label">菜单选择</label>
			<div id="menuTD" class="col-sm-9 col-xs-9 col-md-9 col-lg-9"></div>
		</div>
		
		<!-- <div class="form-group">
         		<button id="subBtn" type="submit" style="border:0;background:#FF7519;color:white" class="col-sm-12 btn btn-primary"><i class="fa fa-times">提交</i></button>
		</div> -->
	</form>
</body>
</html>