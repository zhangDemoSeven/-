<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<%@include file="/header/header.jsp"%>
	</head>
	<title>月度考试</title>
<body>
		<div class="layui-form">  
            <div class="layui-input-inline">  
                <select name="stage" lay-filter="stage" class="province">  
                    <option>请选择阶段</option>  
                </select>  
            </div>  
            <div class="layui-input-inline">  
                <select name="classes" lay-filter="classes" disabled>  
                    <option>请选择参考班级</option>  
                </select>  
            </div>  
            <div class="layui-input-inline">  
                <select name="status" lay-filter="status" disabled>  
                    <option>请选择试卷状态</option>  
                </select>  
            </div>  
            <div class="layui-input-inline">  
                <select name="paperName" lay-filter="paperName" disabled>  
                    <option>请选择试卷名称</option>  
                </select>  
            </div>  
            <div class="layui-input-inline"> 
                <input type="text" class="layui-input" id="createTime" placeholder="请选择时间" >
            </div>
        </div>  
        <div style="margin-left: 10px;margin-top: 10px;">
		    <button class="layui-btn">查询</button>
		    <button class="layui-btn">发布试卷</button>
		    <button class="layui-btn layui-btn-normal">查看试卷</button>
		    <button class="layui-btn layui-btn-warm">开始考试</button>
		    <button class="layui-btn layui-btn-danger">结束试卷</button>
		    <button class="layui-btn layui-btn-normal" onclick="postil()">批注考试</button>
		    <button class="layui-btn layui-btn-normal">试卷讲解</button>
		    <button class="layui-btn layui-btn-normal">查看成绩</button>
		    <button class="layui-btn layui-btn-warm">查看排名</button>
		</div>  
        <table id="examList" class="layui-hide"></table>
	<script type="text/javascript">
		layui.use(['layer', 'table', 'laydate'], function() {
			var layer = layer
			,table = layui.table
			,laydate = layui.laydate;
			
			//日期渲染
			//日期时间选择器
			laydate.render({
			    elem: '#createTime'
			    ,type: 'datetime'
			    ,min: 0
			    ,max: 7
			});
			//用户列表
			var tableIns = table.render({
				elem: '#examList',
				url: '${pageContext.request.contextPath}/exam/getAllExams.do',
				toolbar: '#toolbar'
				,cellMinWidth: 95
				,title: '考试信息表'
		        ,parseData: function(res){ 		//res 即为原始返回的数据
		    	    return {
		    	      "code": res.code, 		//解析接口状态
		    	      "msg": res.msg, 			//解析提示文本
		    	      "count": res.count, 		//解析数据长度
		    	      "data": res.data.list 	//解析数据列表
		    	    };
		        },
				id: "userListTable",
				cols: [[	
					{type: "checkbox",fixed: "left"},		
					{field: 'id',title: 'ID',align: "center",sort:true},
					{field: 'showeye',title: '查看答案',align: "center"},
					{field: 'status',title: '考试状态',align: "center"},
					{field: 'types',title: '考卷类型',align: 'center'}
				]]
		        ,page: true		//开启分页
			});
		});
		
		
		//判断试卷状态不能再进行中
		function postil() {
				layui.use('layer', function(){
					  var layer = layui.layer;
					  if(status = 4){
					  	layer.msg('该试卷不在批改范围内，不能批注！'); 
					  }
					}); 
		}
		
		//
	</script>
</body>
</html>