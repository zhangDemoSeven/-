<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加或修改班级</title>
<%@include file="/header/header.jsp" %>
</head>
<body class="container" style="padding-top: 20px;margin-bottom: 10px;">
	<form id="classesForm" method="post" class="form-horizontal" action="${pageContext.request.contextPath}/classes/add/entity.do">
     	<input id="stageIdValue"  type="hidden" value="${classes.stageId}" />
		<input id="id" name="id" type="hidden" value="${classes.id}" />
		<input id="teacherIdsValue" type="hidden" value="${classes.teacherIds}" />
    	
    	<div class="form-group">
			<label for="className" class="col-sm-3 col-xs-3 col-md-2 col-lg-3 control-label">班级名称</label>
			<div class="col-sm-9 col-xs-9 col-md-10 col-lg-9">
				<input id="className" name="className" type="text" placeholder="请输入班级名称" value="${classes.className}"  class="form-control" />
			</div>
		</div>
		
		<div class="form-group">
			<label for="shiftTime" class="col-sm-3 col-xs-3 col-md-2 col-lg-3 control-label">开班时间</label>
			<div class="col-sm-9 col-xs-9 col-md-10 col-lg-9">
				<div class="input-group date form_datetime col-md-12" data-date="2018-10-01" data-date-format="yyyy-MM-dd" data-link-field="dtp_input1">
                <input class="form-control" id="shiftTime" name="shiftTime" size="16" type="text" value='<fmt:formatDate value="${classes.shiftTime}" pattern="yyyy-MM-dd HH:mm:ss" />' readonly>
                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
				<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
            </div>
			<input type="hidden" id="dtp_input1" value="" /><br/>
			</div>
		</div>
		
		<div class="form-group">
			<label for="stageId" class="col-sm-3 col-xs-3 col-md-2 col-lg-3 control-label">指定阶段</label>
			<div class="col-sm-9 col-xs-9 col-md-10 col-lg-9">
				<select id="stageId" name="stageId" class="selectpicker"  multiple data-live-search="true" data-max-options="1">
				</select>
			</div>
		</div>
     
     
     	<div class="form-group">
			<label for="teacherID" class="col-sm-3 col-xs-3 col-md-2 col-lg-3 control-label">指定教员</label>
			<div class="col-sm-9 col-xs-9 col-md-10 col-lg-9">
				<select id="teacherID" name="teacherID" class="selectpicker"  multiple data-live-search="true" data-max-options="1">
				</select>
			</div>
		</div>
		
		
		<div class="form-group">
			<label for="assistantID" class="col-sm-3 col-xs-3 col-md-2 col-lg-3 control-label">指定助教</label>
			<div class="col-sm-9 col-xs-9 col-md-10 col-lg-9">
				<select id="assistantID" name="assistantID" class="selectpicker"  multiple data-live-search="true" data-max-options="1">
				</select>
			</div>
		</div>
		
		<div class="form-group">
			<label for="headmasterID" class="col-sm-3 col-xs-3 col-md-2 col-lg-3 control-label">指定班任</label>
			<div class="col-sm-9 col-xs-9 col-md-10 col-lg-9">
				<select id="headmasterID" name="headmasterID" class="selectpicker"  multiple data-live-search="true" data-max-options="1">
				</select>
			</div>
		</div>
		
	<!-- <blockquote class="layui-elem-quote layui-quote-nm">
		<button class="btn btn-primary col-sm-12"><i class="fa fa-times">提交</i></button>
	</blockquote> -->
	</form>
</body>

<script type="text/javascript">

$(function(){
	var teacherIdsValue = $("#teacherIdsValue").val();
	var stageIdValue = $("#stageIdValue").val();

	//日期初始化
   $('.form_datetime').datetimepicker({
        format: 'yyyy-mm-dd hh:ii:ss',
	    autoclose:true,		//选择完毕自动关闭
	    todayBtn:true,		//显示today按钮
	    todayHighlight:true, //高亮今日日期
	    language:'zh-CN',
   }).on('hide',function(e) { 
	   $('#classesForm').data('bootstrapValidator') 
	   .updateStatus('shiftTime', 'NOT_VALIDATED',null) 
	   .validateField('shiftTime'); 
	   }); 
	
	 
	 //加载阶段
	  $.ajax({
		 url:getRootPath()+'/stage/get/nopage.do',
		 dataType:'json',
		 type:'POST',
		 success:function(data){
			 $.each(data,function(i,v){
				 $("#stageId").append("<option value='"+v.id+"'>"+v.name+"</option>");
			 });
			 
			 //回显
			if(stageIdValue != null){
				var stageId_array =  document.getElementById('stageId').options;
				$.each(stageId_array,function(i,v){
					if(stageIdValue == v.value){
						$(this).attr('selected','selected');
					}
				});
			}
			 
			$("#stageId").selectpicker('refresh'); //加载完毕数据后必须有这两行代码,否则数据无法显示
			$("#stageId").selectpicker('render');
		 }
	 });
	  
	 //加载教员列表
 	  $.ajax({
		 url:getRootPath()+'/teacher/get/teacher.do',
		 dataType:'json',
		 type:'POST',
		 success:function(data){
			$.each(data,function(i,v){
				$("#teacherID").append("<option value='"+v.id+"'>"+v.nickName+"</option>");
			});
			 
			//回显教员
			if(teacherIdsValue != null){
				var teacherIdsArray = teacherIdsValue.split(",");
				var teacherId = teacherIdsArray[0];
				var teacher_array =  document.getElementById('teacherID').options;
				$.each(teacher_array,function(i,v){
					if(teacherId == v.value){
						$(this).attr('selected','selected');
					}
				});
			}
			 
			$("#teacherID").selectpicker('refresh'); //加载完毕数据后必须有这两行代码,否则数据无法显示
			$("#teacherID").selectpicker('render');
		 }
	 }); 
	 
	 //加载助教列表
 	  $.ajax({
		 url:getRootPath()+'/teacher/get/assistant.do',
		 dataType:'json',
		 type:'POST',
		 success:function(data){
			 $.each(data,function(i,v){
				 $("#assistantID").append("<option value='"+v.id+"'>"+v.nickName+"</option>");
			 });
			 
			 //回显助教列表,注意: 该列表可不选择
			 if(teacherIdsValue != null){
					var teacherIdsArray = teacherIdsValue.split(",");
					var assistantId = teacherIdsArray[1];
					if(assistantId != null){
						var assistant_array =  document.getElementById('assistantID').options;
						$.each(assistant_array,function(i,v){
							if(assistantId == v.value){
								$(this).attr('selected','selected');
							}
						});
					}
				}
			 
			$("#assistantID").selectpicker('refresh'); //加载完毕数据后必须有这两行代码,否则数据无法显示
			$("#assistantID").selectpicker('render');
		 }
	 }); 
	 
	 //加载班主任列表
	  $.ajax({
		 url:getRootPath()+'/teacher/get/headmaster.do',
		 dataType:'json',
		 type:'POST',
		 success:function(data){
			 $.each(data,function(i,v){
				 $("#headmasterID").append("<option value='"+v.id+"'>"+v.nickName+"</option>");
			 });
			 
			 //回显
			 if(teacherIdsValue != null){
					var teacherIdsArray = teacherIdsValue.split(",");
					var headmasterId = teacherIdsArray[2];
					var headmaster_array =  document.getElementById('headmasterID').options;
					$.each(headmaster_array,function(i,v){
						if(headmasterId == v.value){
							$(this).attr('selected','selected');
						}
					});
				}
			 
			$("#headmasterID").selectpicker('refresh'); //加载完毕数据后必须有这两行代码,否则数据无法显示
			$("#headmasterID").selectpicker('render');
		 }
	 }); 
	 
	 formValidator();
});


//校验规则+提交事件
function formValidator(){
	$("#classesForm").bootstrapValidator({
		message:'该值无法校验',
		feedbackIcons: {
	           valid: 'glyphicon glyphicon-ok',
	           invalid: 'glyphicon glyphicon-remove',
	           validating: 'glyphicon glyphicon-refresh'
	    },
	    fields:{
	    	className:{
	    		validators:{
	    			notEmpty:{
	    				message:'班级名称不能为空'
	    			},
	    			stringLength:{
	    				min:6,
	    				max:10,
	    				message:'班级名称的长度在6-10个字节'
	    			}
	    		}
	    	} ,
	    	shiftTime:{
	    		validators:{
	    			notEmpty:{
	    				message:'开班时间不可为空'
	    			}
	    		}	
	    	},
	    	stageId:{
        	   validators:{
        		   callback: {
                       message: '请选择阶段',
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
          	headmasterID:{
         	   validators:{
         		   callback: {
                        message: '请选择班主任',
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
           	teacherID:{
         	   validators:{
         		   callback: {
                        message: '请选择教员',
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
           	assistantID:{
         		  validators:{
            		   callback: {
                           message: '请选择助教',
                           callback: function (value, validator) {
                               if (value <= 0) { 
                                   return false;
                               } else {
                                   return true;
                               }
                           }
                       }
         	   	  }
           	 } 
	    }
	});
}	

function subChildForm(){
	
	var bootstrapValidator = $('#classesForm').data('bootstrapValidator');
	
	bootstrapValidator.validate();
	  
	if(bootstrapValidator.isValid()){
		
		$.ajax({
			type:'POST',
			dataType:'json',
			data:$("#classesForm").serialize(),
			url:$("#classesForm").attr('action'),
			success:function(data){
				var index = parent.layer.getFrameIndex(window.name);
				parent.layer.close(index);
				parent.layer.msg(data.message);
			}
		});
    }else{
		layer.msg("校验不通过");
	   return;
    }
	
}


</script>
</html>