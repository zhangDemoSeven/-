<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
<title>用户添加</title>
<%@include file="/header/header.jsp" %>

<style type="text/css">
.bootstrap-select > .dropdown-toggle{width:745px}
 .bs-searchbox .form-control{width:745px}
</style>
<script type="text/javascript">
//校验规则+提交事件
function formValidator(){
	$("#userForm").bootstrapValidator({
		message:'该值无法校验',
		feedbackIcons: {
	           valid: 'glyphicon glyphicon-ok',
	           invalid: 'glyphicon glyphicon-remove',
	           validating: 'glyphicon glyphicon-refresh'
	    },
	    fields:{
	    	username:{
	    		validators:{
	    			notEmpty:{
	    				message:'用户名不能为空,请使用bdqn开头'
	    			},
	    			stringLength:{
	    				min:6,
	    				max:10,
	    				message:'用户名称的长度在6-10个字节,请使用bdqn开头'
	    			},
	    			regexp:{
	    				regexp:/[a-z0-9]+$/,
	    				message:"用户名只能小写字母+数字"
	    			}
	    		}
	    	},
	    	password:{
	    		validators:{
	    			notEmpty:{
	    				message:'密码不可为空'
	    			},
	    			stringLength:{
	    				min:6,
	    				max:10,
	    				message:'密码的长度在6-10个字节'
	    			},
	    			regexp:{
	    				regexp:/^[a-zA-Z0-9]+$/,
	    				message:"密码存在非法字符"
	    			}
	    		}
	    	},
	    	nickName:{
	    		validators:{
	    			notEmpty:{
	    				message:'姓名不可为空'
	    			},
	    			stringLength:{
	    				min:2,
	    				max:5,
	    				message:'姓名长度在2-5个字符'
	    			},
	    			regexp:{
	    				regexp:/^[\u4e00-\u9fa5]+$/,
	    				message:"姓名只能是中文"
	    			}
	    		}
	    	},
	    	email:{
	    		validators:{
		    		notEmpty:{
	    				message:'邮箱不可为空'
	    			},
	    			emailAddress: {
	                    message: '这不是一个正确的邮箱地址'
	                },
	    			regexp:{
	    				regexp:/^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/,
	    				message:"邮箱存在非法字符"
	    			}
	    		}	
	    	},
	    	 birthday:{
	    		validators:{
	    			notEmpty:{
	    				message:'生日不可为空'
	    			}
	    		}	
	    	},
	    	cord:{
	    		validators:{
	    			notEmpty:{
	    				message:'身份证号码不可为空'
	    			},
	    			stringLength:{
	    				min:15,
	    				max:18,
	    				message:'身份证号码长度必须15-18位'
	    			},
	    			regexp:{
	    				regexp:/^([0-9]{17}[0-9X]{1})|([0-9]{15})$/,
	    				message:"身份证格式不正确"
	    			}
	    		}
	    	},
	    	address:{
	    		validators:{
	    			notEmpty:{
	    				message:'地址不可为空'
	    			},
	    			stringLength:{
	    				min:5,
	    				max:100,
	    				message:'地址在5-100个字符'
	    			},
	    			regexp: {
                        regexp: /^[a-zA-Z0-9\u4e00-\u9fa5]+$/,
                        message: '地址存在非法字符'
                    }
	    		}
	    	},
	    	telephoneA:{
	    		validators:{
		    		notEmpty:{
	    				message:'常用手机号码不能为空'
	    			},
	    			regexp: {
                        regexp: /^[1][3,4,5,6,7,8][0-9]{9}$/,
                        message: '号码格式不正确'
                    }
	    		}	
	    	},
	    	telephoneB:{
	    		validators:{
	    			regexp: {
                        regexp: /^[1][3,4,5,6,7,8][0-9]{9}$/,
                        message: '号码格式不正确'
                    }
	    		}
	    	},
	    	level:{
        	   validators:{
        		   callback: {
                       message: '请选择所在部门',
                       callback: function (value, validator) {
                           if (value <= 0) { 
                               return false;
                           } else {
                               return true;
                           }
                       }
                   }
        	   }
          	 },
          	sex:{
          		validators:{
	    			choice: {
	                    min:1,
	                    message: '至少要选择一个'
	                }
	    		}
          	},
           identity:{
        	   validators:{
	    			choice: {
	                    min:1,
	                    message: '至少要选择一个'
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
	    				message:'用户备注的长度在1-100个字节'
	    			}/* ,
	    			regexp: {
	                    regexp: /^[a-zA-Z0-9\u4e00-\u9fa5]+$/,
	                    message: '备注存在非法字符'
	                } */
	    		}
	    	},
	    	'roleIds':{
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
<body  class="container" style="padding-top: 20px;">
<blockquote class="layui-elem-quote col-sm-12 col-xs-12 col-md-12 col-lg-12">添加教师账号</blockquote>
	<form id="userForm"  method="post" class="form-horizontal" action="${pageContext.request.contextPath}/user/add/entity.do" >
		<div class="form-group">
			<label for="username" class="col-sm-3 col-xs-3 col-md-2 col-lg-3  control-label">登录账号</label>
			<div class="col-sm-9 col-xs-9 col-md-10 col-lg-9">
				<input id="id" name="id" type="hidden" value="${dataUser.id}" />
				<input id="singleIdentity" type="hidden" value="${dataUser.identity }" />
				<input id="singleSex" type="hidden" value="${dataUser.sex }" />
				<c:if test="${empty dataUser.id}">
					<input id="username" name="username" type="text"   placeholder="请输入用户账号" value="${dataUser.username}" class="form-control" />
				</c:if>
				<c:if test="${not empty dataUser.id}">
					<input id="username" name="username" type="text" disabled="disabled"  placeholder="请输入用户账号" value="${dataUser.username}" class="form-control" />
				</c:if>
			</div>
		</div>
		<div class="form-group">
			<label for="password" class="col-sm-3 col-xs-3 col-md-2 col-lg-3  control-label">用户密码</label>
			<div class="col-sm-9 col-xs-9 col-md-10 col-lg-9">
				<input id="password" name="password" type="text" placeholder="请输入用户密码" value="${dataUser.password}" class="form-control"/>
			</div>
		</div>
		<div class="form-group">
			<label for="nickName" class="col-sm-3 col-xs-3 col-md-2 col-lg-3  control-label">真实姓名</label>
			<div class="col-sm-9 col-xs-9 col-md-10 col-lg-9">
				<input id="nickName" name="nickName" type="text" placeholder="请输入用户姓名" value="${dataUser.nickName}" class="form-control"/>
			</div>
		</div>
	
		<div class="form-group">
			<label for="sex" class="col-sm-3 col-xs-3 col-md-2 col-lg-3  control-label">用户性别</label>
			<div class="col-sm-9 col-xs-9 col-md-10 col-lg-9">
				<label class="radio-inline">
					<input type="radio" name="sex" id="sex" value="1"> 男
				</label>
				<label class="radio-inline">
					<input type="radio" name="sex" id="sex" value="0"> 女
				</label>
			</div>
		</div>
		
		
		<div class="form-group">
			<label for="email" class="col-sm-3 col-xs-3 col-md-2 col-lg-3  control-label">常用邮箱</label>
			<div class="col-sm-9 col-xs-9 col-md-10 col-lg-9">
				<input id="email" name="email" type="text" placeholder="请输入邮箱" value="${dataUser.email}" class="form-control"/>
			</div>
		</div>
	
		<div class="form-group">
			<label for="birthday" class="col-sm-3 col-xs-3 col-md-2 col-lg-3  control-label">用户生日</label>
			<div class="col-sm-9 col-xs-9 col-md-10 col-lg-9">
			 	<div class="input-group date form_datetime col-md-12" data-date="2018-08-11" data-date-format="yyyy-MM-dd" data-link-field="dtp_input1" >
                    <input class="form-control" id="birthday" name="birthday" size="16" type="text" value='<fmt:formatDate value="${dataUser.birthday}" pattern="yyyy-MM-dd HH:mm:ss" />' readonly>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
					<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                </div>
				<input type="hidden" id="dtp_input1" value="" /><br/>
			</div>
		</div>
		
		<div class="form-group">
			<label for="cord" class="col-sm-3 col-xs-3 col-md-2 col-lg-3  control-label">身份号码</label>
			<div class="col-sm-9 col-xs-9 col-md-10 col-lg-9">
				<input id="cord" name="cord" type="text" placeholder="输入身份证号码" value="${dataUser.cord}" class="form-control"/>
			</div>
		</div>
		
		<div class="form-group">
			<label for="address" class="col-sm-3 col-xs-3 col-md-2 col-lg-3  control-label">用户地址</label>
			<div class="col-sm-9 col-xs-9 col-md-10 col-lg-9">
				<input id="address" name="address" type="text" placeholder="请输入用户地址" value="${dataUser.address}" class="form-control"/>
			</div>
		</div>
		
		<div class="form-group">
			<label for="telephoneA" class="col-sm-3 col-xs-3 col-md-2 col-lg-3  control-label">手机号码</label>
			<div class="col-sm-9 col-xs-9 col-md-10 col-lg-9">
				<input id="telephoneA" name="telephoneA" type="text" placeholder="请输入手机号" value="${dataUser.telephoneA}" class="form-control"/>
			</div>
		</div>
		
		<div class="form-group">
			<label for="telephoneB" class="col-sm-3 col-xs-3 col-md-2 col-lg-3  control-label">备用号码</label>
			<div class="col-sm-9 col-xs-9 col-md-10 col-lg-9">
				<input id="telephoneB" name="telephoneB" type="text" placeholder="请输入备用手机号[选填]" value="${dataUser.telephoneB}" class="form-control"/>
			</div>
		</div>
		
	
		<div class="form-group">
			<label for="level" class="col-sm-3 col-xs-3 col-md-2 col-lg-3  control-label">所在部门</label>
			<div class="col-sm-9 col-xs-9 col-md-10 col-lg-9">
				<select id="level" name="level" class="selectpicker"  multiple data-live-search="true" data-max-options="1">
				</select>
				<input id="levelValue" type="hidden" value="${dataUser.level}"/>
			</div>
		</div>
	
		<div class="form-group">
			<label for="identity" class="col-sm-3 col-xs-3 col-md-2 col-lg-3  control-label">所属身份</label>
				<div id="identity" class="col-sm-9 col-xs-9 col-md-10 col-lg-9"></div>
		</div>
		
		<div class="form-group">
			<label for="roleTD" class="col-sm-3 col-xs-3 col-md-2 col-lg-3  control-label">赋予角色</label>
			<div id="roleTD" class="col-sm-9 col-xs-9 col-md-10 col-lg-9"></div>
		</div>
		
	
		<div class="form-group">
			<label for="description" class="col-sm-3 col-xs-3 col-md-2 col-lg-3  control-label">用户描述</label>
			<div class="col-sm-9 col-xs-9 col-md-10 col-lg-9">
				<textarea rows="" cols="" id="description" name="description" placeholder="请输入备注" class="form-control">${dataUser.description}</textarea>
			</div>
		</div>	
      	
      	<!-- <button id="subBtn" type="submit" style="border:0;background:#FF7519;color:white"  class="col-sm-12 col-xs-12 col-md-12 col-lg-12 btn btn-primary"><i class="fa fa-times">提交</i></button> -->
	</form>
</body>
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
	
	
	
	var _identity = $("#singleIdentity").val();

	//回显性别
	var _sex = $("#singleSex").val();
	if(_sex != null|| _sex != "" || _sex != undefined){
		var _array = $("input[name='sex']");
		$.each(_array,function(i,v){
			if(v.value == _sex){
				$(this).attr('checked',"checked");
			}
		});
	}
	//加载身份
	$.post(getRootPath()+"/identity/get/nopage.do",{},function(data){
		$.each(data,function(i,v){
			$("#identity").append("<div class='radio' style='display:inline-block;padding-right:5px;'><label><input id="+v.id+" type='radio' value='"+v.id+"' name='identity'/>" + this.name);
			//回显身份
			if(_identity != null|| _identity != "" || _identity != undefined){
				if(_identity == v.id){
					$("#" + v.id).attr("checked","checked");
				}
			}
		});
	},'json');
	
	  //日期初始化
	  $('.form_datetime').datetimepicker({
	        format: 'yyyy-mm-dd hh:ii:ss',
		    autoclose:true,		//选择完毕自动关闭
		    todayBtn:true,		//显示today按钮
		    todayHighlight:true, //高亮今日日期
		    language:'zh-CN',
		    endDate:new Date(),
	   }).on('hide',function(e) { 
		   $('#userForm').data('bootstrapValidator') 
		   .updateStatus('birthday', 'NOT_VALIDATED',null) 
		   .validateField('birthday'); 
		   });
	
	
	//加载部门
	$.post(getRootPath()+"/level/get/nopage.do",{},function(data){
		$.each(data,function(i,v){
			$("#level").append('<option value="'+v.id+'">'+v.name+'</option>');
		});
		
		var levelValue = $("#levelValue").val();
		var level_array = document.getElementById('level').options;
		$.each(level_array,function(i,v){
			
			if(levelValue == v.value){
				$(this).attr('selected','selected');
			}
		});
		
		$("#level").selectpicker('refresh'); //加载完毕数据后必须有这两行代码,否则数据无法显示
		$("#level").selectpicker('render');
	},'json');
	
	
	//加载角色
	$.post(getRootPath()+"/role/get/nopage.do",{},function(data){
		// 生成checkbox列表 
		 $(data).each(function(i,v){
			$("#roleTD").append("<div class='checkbox' style='display:inline-block;padding-right:5px;'><label><input id="+v.id+" type='checkbox' value='"+v.id+"' name='roleIds'/>" + this.name);
		 });
		//回显数据
		var userId = $("#id").val();
		if(userId != null|| userId != "" || userId != undefined){
			$.post(getRootPath()+"/role/back/entity.do",{"userId":userId},function(data){
				$(data).each(function(i,v){
					$("#"+v.id).attr("checked","checked");
				});
			},'json');
		}
		formValidator();
	},'json');
	
});


function subChildForm(){
 var bootstrapValidator = $("#userForm").data('bootstrapValidator');
   bootstrapValidator.validate();
   if(bootstrapValidator.isValid()){
	   var id = $("#id").val();
		var username =  $("#username").val();
		
		var value = true;
		
		if( (id == null || id == "" || id == undefined )&&(username.trim().length > 0)){
			$.ajax({
				 type:'POST',
				 async:false,
				 dataType:'json',
				 data:{"username":username},
				 url:getRootPath()+"/user/check/name.do",
				 success:function(data){
					 if(data.code == 5000){
						 value = false;
						 layer.msg(data.message);
					 }
				 }
			 });
		}
		
		if(value  == true){
			$.post($("#userForm").attr('action'), $("#userForm").serialize(), function(data) {
				var index =parent.layer.getFrameIndex(window.name);
				parent.layer.close(index);
				parent.layer.msg(data.message);
			}, 'json');
		}
   }else{
	   return;
   }
}
</script>
</html>