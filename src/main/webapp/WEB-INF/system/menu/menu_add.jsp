<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
<title>菜单添加-修改</title>
<%@include file="/header/header.jsp" %>

<style type="text/css">
.bootstrap-select > .dropdown-toggle{width:697.5px}
 .bs-searchbox .form-control{width:697.5px}
</style>

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
	
	
	//加载父节点菜单
	$.ajax({
		type:'POST',
		dataType:'json',
		url:getRootPath()+'/menu/get/select.do',
		success:function(data){
			$.each(data,function(i,v){
				$("#parentMenu").append('<option value="'+v.id+'">'+v.text+'</option>');
			});	
			
			//编辑时,回显数据
			var parentMenuValue = $("#parentId").val();
			var parentMenu_array = document.getElementById('parentMenu').options;
			$.each(parentMenu_array,function(i,v){
				if(parentMenuValue == v.value){
					$(this).attr("selected","selected");
				}
			});
			
			$("#parentMenu").selectpicker('refresh'); //加载完毕数据后必须有这两行代码,否则数据无法显示
			$("#parentMenu").selectpicker('render');
		}
	}); 
	
	
	formValidator();
});

//校验规则+提交事件
function formValidator(){
	$("#menuForm").bootstrapValidator({
		message:'is not valid',
		feedbackIcons:{
			valid: 'glyphicon glyphicon-ok',
	        invalid: 'glyphicon glyphicon-remove',
	        validating: 'glyphicon glyphicon-refresh'
		},
		fields:{
			title:{
				validators:{
					notEmpty:{
						message:'菜单名称不能为空'
					},
	    			regexp: {
                        regexp: /^[a-zA-Z0-9\u4e00-\u9fa5]+$/,
                        message: '菜单名称中存在非法字符'
                    }
				}
			},
			href:{
				validators:{
					stringLength:{
						min:5,
						max:30,
						message:'菜单路径的长度在5-30个字节'
					}
				}
			},
			priority:{
				validators:{
					notEmpty:{
						message:'权重不能为空'
					},
					stringLength:{
						min:1,
						max:2,
						message:'权重的长度在1-3个字节'
					},
					regexp:{
	    				regexp:/^[0-9]*[1-9][0-9]*$/,
	    				 message: '只能输入数字'
	    			}
				}
			},
			description:{
				validators:{
					notEmpty:{
						message:'描述不能为空'
					},
					stringLength:{
						min:1,
						max:100,
						message:'描述的长度在1-100个字节'
					},
	    			regexp: {
                        regexp: /^[a-zA-Z0-9\u4e00-\u9fa5]+$/,
                        message: '菜单描述中存在非法字符'
                    }
				}
			}
		}		
	});
}

</script>
</head>
<body class="container" style="padding-top: 20px;">
	<form id="menuForm" method="post" action="${pageContext.request.contextPath}/menu/add/entity.do" class="form-horizontal">
		
		<div class="form-group">
			<label for="title" class="col-sm-3 col-xs-3 col-md-3 col-lg-3 control-label">温馨提示</label>
			<div class="col-sm-9 col-xs-9 col-md-9 col-lg-9">
				<h5 style="color:red">若生成父级菜单,请勿填写路径值和选择父级菜单下拉框</h5>
			</div>
		</div>
		
		<div class="form-group">
			<input id="menuId" name="id" value="${menu.id}" type="hidden" />
			<input id="parentId" value="${menu.pid}" type="hidden"/>
			<label for="title" class="col-sm-3 col-xs-3 col-md-3 col-lg-3 control-label">菜单名称</label>
			<div class="col-sm-9 col-xs-9 col-md-9 col-lg-9">
				<input id="title" name="title" value="${menu.title}" type="text" placeholder="请输入菜单名称" class="form-control" />
			</div>
		</div>
		<div class="form-group">
			<label for="href" class="col-sm-3 col-xs-3 col-md-3 col-lg-3 control-label">菜单路径</label>
			<div class="col-sm-9 col-xs-9 col-md-9 col-lg-9">
				<input id="href" name="href" value="${menu.href}" type="text" placeholder="请输入菜单路径" class="form-control" />
			</div>
		</div>
		
		<div class="form-group">
			<label for="parentMenu" class="col-sm-3 col-xs-3 col-md-3 col-lg-3 control-label">父级菜单</label>
			<div class="col-sm-9 col-xs-9 col-md-9 col-lg-9">
				<select id="parentMenu" name="pid"  class="selectpicker" multiple data-live-search="true" data-max-options="1"></select>
			</div>
		</div>
		
		<div class="form-group">
			<label for="priority" class="col-sm-3 col-xs-3 col-md-3 col-lg-3 control-label">菜单权重</label>
			<div class="col-sm-9 col-xs-9 col-md-9 col-lg-9">
				<input id="priority" name="priority" value="${menu.priority}" type="text" placeholder="请输入菜单权重" class="form-control" />
			</div>
		</div>
		<div class="form-group">
			<label for="description" class="col-sm-3 col-xs-3 col-md-3 col-lg-3 control-label">菜单描述</label>
			<div class="col-sm-9 col-xs-9 col-md-9 col-lg-9">
				<textarea rows="" cols="" id="description" name="description"  placeholder="请输入菜单描述" class="form-control" >${menu.description}</textarea>
			</div>
		</div>
		<!-- <div class="modal-footer">
			<button id="subBtn" type="submit" style="border:0;background:#FF7519;color:white" class="col-sm-12 col-xs-12 col-lg-12 col-md-12 btn btn-primary"><i class="fa fa-times">提交</i></button>
		</div> -->
	</form>
</body>
<script type="text/javascript">
function subChildForm(){
   var bootstrapValidator = $("#menuForm").data('bootstrapValidator');
   bootstrapValidator.validate();
   if(bootstrapValidator.isValid()){
		var href = $("#href").val();
		var parentMenuValue = $("#parentMenu option:selected").val(); 
		
		if(href.trim().length > 0 && (parentMenuValue == null || parentMenuValue == "" || parentMenuValue== undefined)){
			layer.msg("如果填写路径,必须选择父级菜单");
			return false;
		}
		
		if((parentMenuValue != undefined) && href.trim().length <= 0){
			layer.msg("如果选择父级菜单,则必须填写路径");
			return false;
		}
		
		 $.post($("#menuForm").attr('action'),$("#menuForm").serialize(),function(result){
			var index =parent.layer.getFrameIndex(window.name);
			parent.layer.close(index);
			parent.layer.msg(result.message);
			//window.location.href=getRootPath()+"/menu/s/view.do";
		},'json');   
   }else{
	   return;
   }
}
</script>
</html>