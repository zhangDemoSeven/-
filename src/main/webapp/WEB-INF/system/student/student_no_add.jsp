<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
<title>临时学生添加</title>
<%@include file="/header/header.jsp" %>
<script type="text/javascript">
//校验规则+提交事件
function formValidator(){
	$("#flagstudentForm").bootstrapValidator({
		message:'该值无法校验',
		feedbackIcons: {
	           valid: 'glyphicon glyphicon-ok',
	           invalid: 'glyphicon glyphicon-remove',
	           validating: 'glyphicon glyphicon-refresh'
	    },
	    fields:{
	    	username:{
	    		validators:{
	    			stringLength:{
	    				min:5,
	    				max:10,
	    				message:'用户名称的长度在5-10个字节'
	    			},
	    			regexp:{
	    				regexp:/[a-z0-9]+$/,
	    				message:"用户名只能小写字母+数字"
	    			}
	    		}
	    	},
	    	unqueCode:{
	    		validators:{
	    			stringLength:{
	    				min:32,
	    				max:32,
	    				message:'搜索编码的长度在必须是32个字节'
	    			},
	    			regexp:{
	    				regexp:/[a-zA-Z0-9]+$/,
	    				message:"搜索编码的只能大小写字母及数字"
	    			}
	    		}
	    	},
	    	password:{
	    		validators:{
	    			stringLength:{
	    				min:5,
	    				max:10,
	    				message:'密码的长度在5-10个字节'
	    			},
	    			regexp:{
	    				regexp:/^[a-zA-Z0-9]+$/,
	    				message:"密码存在非法字符"
	    			}
	    		}
	    	},
	    	qq:{
	    		validators:{
	    			stringLength:{
	    				min:5,
	    				max:12,
	    				message:'qq的长度在5-12个字节'
	    			},
	    			regexp:{
	    				regexp:/^[1-9][0-9]+$/,
	    				message:"qq只能是0-9的数字"
	    			}
	    		}
	    	},
	    	age:{
	    		validators:{
	    			stringLength:{
	    				min:2,
	    				max:2,
	    				message:'年龄只能是2位数'
	    			},
	    			regexp:{
	    				regexp:/^[1-4][0-9]$/,
	    				message:"只能是0-9的数字"
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
		   	 birthday:{
	    		validators:{
	    			notEmpty:{
	    				message:'生日不可为空'
	    			}
	    		}	
	    	},
	    	email:{
	    		validators:{
	    			emailAddress: {
	                    message: '这不是一个正确的邮箱地址'
	                }
	    		}	
	    	},
	    	cord:{
	    		validators:{
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
	    			stringLength:{
	    				min:5,
	    				max:100,
	    				message:'地址长度在5-100个字符'
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
        		   choice: {
	                    min:1,
	                    message: '至少要选择一个'
	                }
        	   }
          	 },
          	isTemp:{
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
           	subName:{
	    		validators:{
	    			stringLength:{
	    				min:2,
	    				max:5,
	    				message:'用户关系只能2-5个字符'
	    			},
	    			regexp: {
	    				regexp:/^[\u4e00-\u9fa5]+$/,
	    				message:"用户关系只能是中文"
                    }
	    		}
	    	},
	    	searchName:{
	    		validators:{
	    			stringLength:{
	    				min:1,
	    				max:10,
	    				message:'搜索关键字只能1-10个字符'
	    			},
	    			regexp: {
	    				regexp:/^[\u4e00-\u9fa5]+$/,
	    				message:"搜索关键字只能是中文"
                    }
	    		}
	    	},
	    	description:{
	    		validators:{
	    			stringLength:{
	    				min:1,
	    				max:100,
	    				message:'用户备注的长度在1-100个字节'
	    			},
	    			regexp: {
                        regexp: /^[a-zA-Z0-9\u4e00-\u9fa5]+$/,
                        message: '用户备注存在非法字符'
                    }
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
<body class="container" style="padding-top: 20px;">
	<form id="flagstudentForm"  method="post" class="form-horizontal" action="${pageContext.request.contextPath}/student/add/flagstudent.do" >
		<div class="form-group">
			<label for="username" class="col-sm-2 col-xs-3 col-md-2 col-lg-3 control-label">登录账号</label>
			<div class="col-sm-10 col-xs-9 col-md-10 col-lg-9">
				<input id="id" name="id" value="${vo.id}" type="hidden"/>
				<c:if test="${empty vo.id}">
					<input id="username" name="username" type="text" placeholder="请输入用户账号" value="${vo.username}" class="form-control" />
				</c:if>
				<c:if test="${not empty vo.id  &&  empty vo.username}">
					<input id="username" name="username" type="text"  placeholder="请输入用户账号" value="${vo.username}" class="form-control" />
				</c:if>
				<c:if test="${not empty vo.id  &&  not empty vo.username}">
					<input id="username" name="username" type="text" readonly placeholder="请输入用户账号" value="${vo.username}" class="form-control" />
				</c:if>
			</div>
		</div>
		<div class="form-group">
			<label for="password" class="col-sm-2 col-xs-3 col-md-2 col-lg-3 control-label">用户密码</label>
			<div class="col-sm-10 col-xs-9 col-md-10 col-lg-9">
				<input id="password" name="password" type="text" placeholder="请输入用户密码" value="${vo.password}" class="form-control"/>
			</div>
		</div>
		<div class="form-group">
			<label for="nickName" class="col-sm-2 col-xs-3 col-md-2 col-lg-3 control-label"><font color="red">真实姓名</font></label>
			<div class="col-sm-10 col-xs-9 col-md-10 col-lg-9">
				<input id="nickName" name="nickName" type="text" placeholder="请输入用户姓名" value="${vo.nickName}" class="form-control"/>
			</div>
		</div>
	
		<div class="form-group">
			<label for="subName" class="col-sm-2 col-xs-3 col-md-2 col-lg-3 control-label">亲属关系</label>
			<div class="col-sm-10 col-xs-9 col-md-10 col-lg-9">
				<input id="subName" name="subName" type="text" value="${vo.subName}" placeholder="请输入陪同人姓名,本人即填写本人" value="${vo.nickName}" class="form-control"/>
			</div>
		</div>
		
		<div class="form-group">
			<label for="telephoneA" class="col-sm-2 col-xs-3 col-md-2 col-lg-3 control-label"><font color="red">手机号码</font></label>
			<div class="col-sm-10 col-xs-9 col-md-10 col-lg-9">
				<input id="telephoneA" name="telephoneA" type="text" value="${vo.telephoneA}" placeholder="请输入手机号" value="" class="form-control"/>
			</div>
		</div>
	
		<div class="form-group">
			<label for="telephoneB" class="col-sm-2 col-xs-3 col-md-2 col-lg-3 control-label">备用号码</label>
			<div class="col-sm-10 col-xs-9 col-md-10 col-lg-9">
				<input id="telephoneB" name="telephoneB" type="text" value="${vo.telephoneB}"  placeholder="请输入备用手机号" value="" class="form-control"/>
			</div>
		</div>
		
		<div class="form-group">
			<label for="qq" class="col-sm-2 col-xs-3 col-md-2 col-lg-3 control-label">QQ号码</label>
			<div class="col-sm-10 col-xs-9 col-md-10 col-lg-9">
				<input id="qq" name="qq" type="text" value="${vo.qq}"  placeholder="请输入QQ" value="" class="form-control"/>
			</div>
		</div>
		
		<div class="form-group">
			<label for="age" class="col-sm-2 col-xs-3 col-md-2 col-lg-3 control-label">学生年龄</label>
			<div class="col-sm-10 col-xs-9 col-md-10 col-lg-9">
				<input id="age" name="age" type="text"  value="${vo.age}"  placeholder="请输入年龄" value="" class="form-control"/>
			</div>
		</div>

		<div class="form-group">
			<label for="sex" class="col-sm-2 col-xs-3 col-md-2 col-lg-3 control-label">用户性别</label>
			<div class="col-sm-10 col-xs-9 col-md-10 col-lg-9">
				<label class="radio-inline">
					<input type="radio" name="sex" id="sex" value="1"> 男
				</label>
				<label class="radio-inline">
					<input type="radio" name="sex" id="sex" value="0"> 女
				</label>
				<input id="singleSex" type="hidden" value="${vo.sex}"/>
			</div>
		</div>
		
		<div class="form-group">
			<label for="email" class="col-sm-2 col-xs-3 col-md-2 col-lg-3 control-label">常用邮箱</label>
			<div class="col-sm-10 col-xs-9 col-md-10 col-lg-9">
				<input id="email" name="email" type="text" value="${vo.email}"  placeholder="请输入邮箱" value="${dataUser.email}" class="form-control"/>
			</div>
		</div>
	
		<div class="form-group">
			<label for="birthday" class="col-sm-2 col-xs-3 col-md-2 col-lg-3 control-label">用户生日</label>
			<div class="col-sm-10 col-xs-9 col-md-10 col-lg-9">
			 	<div class="input-group date form_datetime col-md-12" data-date="2018-08-11" data-date-format="yyyy-MM-dd" data-link-field="dtp_input1">
                    <input class="form-control" id="birthday" name="birthday" size="16" type="text" value='<fmt:formatDate value="${vo.birthday}" pattern="yyyy-MM-dd HH:mm:ss" />' readonly>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
					<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                </div>
				<input type="hidden" id="dtp_input1" value="" /><br/>
			</div>
		</div>
		
		<div class="form-group">
			<label for="cord" class="col-sm-2 col-xs-3 col-md-2 col-lg-3 control-label">身份号码</label>
			<div class="col-sm-10 col-xs-9 col-md-10 col-lg-9">
				<input id="cord" name="cord" type="text" placeholder="输入身份证号码" value="${vo.cord}" class="form-control"/>
			</div>
		</div>
		
		<div class="form-group">
			<label for="address" class="col-sm-2 col-xs-3 col-md-2 col-lg-3 control-label">用户地址</label>
			<div class="col-sm-10 col-xs-9 col-md-10 col-lg-9">
				<input id="address" name="address" type="text" placeholder="请输入用户地址" value="${vo.address}" class="form-control"/>
			</div>
		</div>
		
		<div class="form-group">
			<label for="level" class="col-sm-2 col-xs-3 col-md-2 col-lg-3 control-label">所在部门</label>
			<div class="col-sm-10 col-xs-9 col-md-10 col-lg-9">
				<label class="radio-inline">
					<input id="level" name="level" value="6" type="radio" checked="checked" /> 学生班级
				</label>
			</div>
		</div>
	
		<div class="form-group">
			<label for="identity" class="col-sm-2 col-xs-3 col-md-2 col-lg-3 control-label">所属身份</label>
			<div class="col-sm-10 col-xs-9 col-md-10 col-lg-9">
				<label class="radio-inline">
					<input id="identity" name="identity" value="9" type="radio" checked="checked" /> 学生
				</label>
			</div>
		</div>
	
		<div class="form-group">
			<label for="isTemp" class="col-sm-2 col-xs-3 col-md-2 col-lg-3 control-label">用户级别</label>
			<input id="isTempId" type="hidden" value="${vo.isTemp}"/>
			<div class="col-sm-10 col-xs-9 col-md-10 col-lg-9">
				<label class="radio-inline">
					<input type="radio" name="isTemp"  value="0" checked="checked"> 临时学生(未缴费)
				</label>
			</div>
		</div>
	
		<div class="form-group">
			<label for="roleTD" class="col-sm-2 col-xs-3 col-md-2 col-lg-3 control-label">赋予角色</label>
			<div id="roleTD" class="col-sm-10 col-xs-9 col-md-10 col-lg-9"></div>
		</div>
		
		
	
		<div class="form-group">
			<label for="description" class="col-sm-2 col-xs-3 col-md-2 col-lg-3 control-label">用户描述</label>
			<div class="col-sm-10 col-xs-9 col-md-10 col-lg-9">
				<textarea rows="" cols="" id="description" name="description" placeholder="请输入备注" class="form-control">${vo.description}</textarea>
			</div>
		</div>
		
		<div class="form-group">
			<label for="searchName" class="col-sm-2 col-xs-3 col-md-2 col-lg-3 control-label">关键字</label>
			<div class="col-sm-10 col-xs-9 col-md-10 col-lg-9">
				<input id="searchName" name="searchName" type="text" placeholder="请输入搜索关键字" value="${vo.searchName}" class="form-control"/>
			</div>
		</div>	
		
		<div class="form-group">
			<label for="unqueCode" class="col-sm-2 col-xs-3 col-md-2 col-lg-3 control-label">搜索编码</label>
			<div class="col-sm-10 col-xs-9 col-md-10 col-lg-9">
				<input id="unqueCode" name="unqueCode" type="text" placeholder="请输入32位搜索编码" value="${vo.unqueCode}" class="form-control"/>
			</div>
		</div>
		
		<div class="form-group">
			<label for="educationId" class="col-sm-2 col-xs-3 col-md-2 col-lg-3 control-label">指定学历</label>
			<div class="col-sm-10 col-xs-9 col-md-10 col-lg-9">
				<select id="educationId" name="educationId" class="selectpicker"  multiple data-live-search="true" data-max-options="1">
				</select>
				<input id="educationValue" value="${vo.educationId}" type="hidden"/>
			</div>
		</div>
		
		<div class="form-group">
			<label for="majorId" class="col-sm-2 col-xs-3 col-md-2 col-lg-3 control-label">指定专业</label>
			<div class="col-sm-10 col-xs-9 col-md-10 col-lg-9">
				<select id="majorId" name="majorId" class="selectpicker"  multiple data-live-search="true" data-max-options="1">
				</select>
				<input id="majorValue" value="${vo.majorId}" type="hidden"/>
			</div>
		</div>
		
		<div class="form-group">
			<label for="stiuationId" class="col-sm-2 col-xs-3 col-md-2 col-lg-3 control-label">指定现状</label>
			<div class="col-sm-10 col-xs-9 col-md-10 col-lg-9">
				<select id="stiuationId" name="stiuationId" class="selectpicker"  multiple data-live-search="true" data-max-options="1">
				</select>
				<input id="stiuationValue" value="${vo.stiuationId}" type="hidden"/>
			</div>
		</div>
		
		<div class="form-group">
			<label for="classificationId" class="col-sm-2 col-xs-3 col-md-2 col-lg-3 control-label">指定课程</label>
			<div class="col-sm-10 col-xs-9 col-md-10 col-lg-9">
				<select id="classificationId" name="classificationId" class="selectpicker"  multiple data-live-search="true" data-max-options="1">
				</select>
				<input id="classificationValue" value="${vo.classificationId}" type="hidden"/>
			</div>
		</div>
		
		<div class="form-group">
			<label for="source" class="col-sm-2 col-xs-3 col-md-2 col-lg-3 control-label">网站来源</label>
			<div class="col-sm-10 col-xs-9 col-md-10 col-lg-9">
				<select id="source" name="sourceId" class="selectpicker" multiple data-live-search="true" data-max-options="1">
				</select>
				<input id="sourceValue" value="${vo.sourceId}" type="hidden"/>
			</div>
		</div>
		
		<div class="form-group">
			<label for="tool" class="col-sm-2 col-xs-3 col-md-2 col-lg-3 control-label">咨询工具</label>
			<div class="col-sm-10 col-xs-9 col-md-10 col-lg-9">
				<select id="tool" name="toolId" class="selectpicker" multiple data-live-search="true" data-max-options="1">
				</select>
				<input id="toolValue" value="${vo.toolId}" type="hidden"/>
			</div>
		</div>
		
		<div class="form-group">
			<label for="channel" class="col-sm-2 col-xs-3 col-md-2 col-lg-3 control-label">渠道来源</label>
			<div class="col-sm-10 col-xs-9 col-md-10 col-lg-9">
				<select id="channel" name="channelId" class="selectpicker" multiple data-live-search="true" data-max-options="1">
				</select>
				<input  id="channelValue" value="${vo.channelId}" type="hidden"/>
			</div>
		</div>
		
<%-- 		<div class="form-group">
			<center>
			    <button id="subBtn" type="submit"  style="border:0;background:#FF7519;color:white;" class="col-sm-12 col-xs-12 col-md-12 col-lg-12 btn btn-primary btn-md"><i class="fa fa-times">提交</i></button>
			</center>
		</div> --%>
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
	
	//加载学历列表
	$.ajax({
		type:'POST',
		dataType:'json',
		url:getRootPath()+'/education/get/nopage.do',
		success:function(data){
			$.each(data,function(i,v){
				$("#educationId").append("<option value='"+v.id+"'>"+v.name+"</option>");
			});
			
			var educationValue = $("#educationValue").val();
			if(educationValue != "" || educationValue != null || educationValue != undefined){
				var education_array = document.getElementById('educationId').options;
				$.each(education_array,function(i,v){
					if(educationValue == v.value){
						$(this).attr("selected","selected");
					}
				}); 
			}
			
			$("#educationId").selectpicker('refresh');
			$("#educationId").selectpicker('render');
		}
	});

	//加载专业列表
	$.ajax({
		type:'POST',
		dataType:'json',
		url:getRootPath()+'/major/get/nopage.do',
		success:function(data){
			$.each(data,function(i,v){
				$("#majorId").append("<option value='"+v.id+"'>"+v.name+"</option>");
			});
			
			var majorValue = $("#majorValue").val();
			
			if(majorValue != "" || majorValue != null || majorValue != undefined){
				var major_array = document.getElementById('majorId').options;
				$.each(major_array,function(i,v){
					if(majorValue == v.value){
						$(this).attr("selected","selected");
					}
				}); 
			}
			
			$("#majorId").selectpicker('refresh');
			$("#majorId").selectpicker('render');
		}
	}); 
	
	//加载现状
	$.ajax({
		type:'POST',
		dataType:'json',
		url:getRootPath()+'/stiuation/get/nopage.do',
		success:function(data){
			$.each(data,function(i,v){
				$("#stiuationId").append("<option value='"+v.id+"'>"+v.name+"</option>");
			});
			
			var stiuationValue = $("#stiuationValue").val();
			
			if(stiuationValue != null || stiuationValue != "" || stiuationValue != undefined){
				var stiuation_array = document.getElementById('stiuationId').options;
				$.each(stiuation_array,function(i,v){
					if(stiuationValue == v.value){
						$(this).attr("selected","selected");
					}
				}); 
			}
			
			$("#stiuationId").selectpicker('refresh');
			$("#stiuationId").selectpicker('render');
		}
	});
	
	
	//加载课业
	$.ajax({
		type:'POST',
		dataType:'json',
		url:getRootPath()+'/classification/get/nopage.do',
		success:function(data){
			$.each(data,function(i,v){
				$("#classificationId").append("<option value='"+v.id+"'>"+v.name+"</option>");
			});
			
			var classificationValue = $("#classificationValue").val();
			
			if(classificationValue != null || classificationValue != "" || classificationValue != undefined){
				var classification_array = document.getElementById('classificationId').options;
				$.each(classification_array,function(i,v){
					if(classificationValue == v.value){
						$(this).attr("selected","selected");
					}
				}); 
			}
			
			$("#classificationId").selectpicker('refresh');
			$("#classificationId").selectpicker('render');
		}
	});
	
	//网站来源 
	$.ajax({
		type:'POST',
		dataType:'json',
		url:getRootPath()+'/source/get/nopage.do',
		success:function(data){
			 $.each(data,function(index,value){
				$("#source").append("<optgroup id='"+index+"' label='"+value.parentName+"'>");
					$.each(value.childSourceList,function(i,v){
						$("#"+index).append("<option value='"+v.id+"'>"+v.sourceName+"</option>");
					});
				$("#"+index).append("</optgroup>");
			});
			
			//编辑时,网站来源数据回显
			var sourceValue = $("#sourceValue").val();
			
			if(sourceValue != null || sourceValue != "" || sourceValue != undefined){
				var source_array = document.getElementById('source').options;
				$.each(source_array,function(i,v){
					if(sourceValue == v.value){
						$(this).attr("selected","selected");
					}
				}); 
			}
			
			$("#source").selectpicker('refresh'); //加载完毕数据后必须有这两行代码,否则数据无法显示
			$("#source").selectpicker('render'); 
		}
	}); 
	
	//咨询工具
	$.ajax({
		type:'POST',
		dataType:'json',
		url:getRootPath()+'/tool/get/nopage.do',
		success:function(data){
			$.each(data,function(i,v){
				$("#tool").append('<option value="'+v.id+'">'+v.toolName+'</option>');
			});			
			
			//编辑时,咨询工具数据回显
		 	var toolValue = $("#toolValue").val();
			
			if(toolValue != null || toolValue != "" || toolValue != undefined){
				var tool_array = document.getElementById('tool').options;
				$.each(tool_array,function(i,v){
					if(toolValue == v.value){
						$(this).attr("selected","selected");
					}
				}); 
			}
			
			$("#tool").selectpicker('refresh'); //加载完毕数据后必须有这两行代码,否则数据无法显示
			$("#tool").selectpicker('render');
		}
	});
	
	//查询渠道
	$.ajax({
		type:'POST',
		dataType:'json',
		url:getRootPath()+'/channel/get/nopage.do',
		success:function(data){
			console.log(data);
			$.each(data,function(index,value){
				$("#channel").append("<optgroup id='channel"+index+"' label='"+value.parentName+"'>");
					$.each(value.childChannelList,function(i,v){
						$("#channel"+index).append("<option value='"+v.id+"'>"+v.channelName+"</option>");
					});
				$("#channel"+index).append("</optgroup>");
			});		
			
			//编辑时,渠道数据回显
		 	var channelValue = $("#channelValue").val();
			var channel_array = document.getElementById('channel').options;
			$.each(channel_array,function(i,v){
				if(channelValue == v.value){
					$(this).attr("selected","selected");
				}
			}); 
			$("#channel").selectpicker('refresh'); //加载完毕数据后必须有这两行代码,否则数据无法显示
			$("#channel").selectpicker('render'); 
		}
	});
	
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
	
	//回显是否成为正式学生
	var isTemp = $("#isTempId").val();
	if(isTemp != null || isTemp != "" || isTemp != undefined){
		var isTemp_array = $("input[name='isTemp']");
		$.each(isTemp_array,function(i,v){
			if(v.value == isTemp){
				$(this).attr('checked',"checked");
			}
		});
	}
	
	
	
	  //日期初始化
	  $('.form_datetime').datetimepicker({
	        format: 'yyyy-mm-dd hh:ii:ss',
		    autoclose:true,		//选择完毕自动关闭
		    todayBtn:true,		//显示today按钮
		    todayHighlight:true, //高亮今日日期
		    language:'zh-CN',
		    endDate:new Date(),
	   }).on('hide',function(e) { 
		   $('#flagstudentForm').data('bootstrapValidator') 
		   .updateStatus('birthday', 'NOT_VALIDATED',null) 
		   .validateField('birthday'); 
		   });
	
	  
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
   var bootstrapValidator = $("#flagstudentForm").data('bootstrapValidator');
   bootstrapValidator.validate();
   if(bootstrapValidator.isValid()){
	    var value = true;
		var id = $("#id").val();
		//根据姓名和手机号校验学生是否存在
		var nickName = $("#nickName").val();
		var telephoneA = $("#telephoneA").val();
		
		if(nickName.trim().length <= 0  ||  telephoneA.trim().length <= 0){
			layer.msg("用户名或常用电话为空");
			return;
		}else{
			if(id == null || id == "" || id == undefined){
				$.ajax({
					type:'POST',
					dataType:'json',
					async:false,
					url:getRootPath()+'/student/check/nickname.do',
					data:{"nickName":nickName,"telephoneA":telephoneA},
					success:function(data){
						if(data.type == true){
							value = false;
							parent.layer.msg(data.message);
						}
					}
				});
			}
		}
		
		var username = $("#username").val();
		
		
		//校验输入的登录账号是否存在
		if((id == null || id == "" || id == undefined) && username.trim().length > 0){
			
			$.ajax({
				type:'POST',
				dataType:'json',
				async:false,
				url:getRootPath()+"/student/check/username.do",
				data:{"username":username},
				success:function(data){
					if(data.type == true){
						value = false;
						parent.layer.msg(data.message);
					}
				}
			});
		}
		
		if(value){
		 	$.post($("#flagstudentForm").attr('action'), $("#flagstudentForm").serialize(), function(result) {
				parent.layer.msg(result.message);
				parent.layer.closeAll('iframe');
		     }, 'json');
		}
   }else{
	   return;
   }
}
</script>
</html>