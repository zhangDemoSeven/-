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
		    <button class="layui-btn" onclick="query()">查询</button>
		    <button class="layui-btn" onclick="publishPaper()">发布试卷</button>
		    <button class="layui-btn layui-btn-normal" onclick="seePaper()">查看试卷</button>
		    <button class="layui-btn layui-btn-warm" onclick="startExam()">开始考试</button>
		    <button class="layui-btn layui-btn-danger" onclick="endExam()">结束试卷</button>
		    <!-- 合并 -->
		    <button class="layui-btn layui-btn-normal" onclick="postil()">批注考试</button>
		    <button class="layui-btn layui-btn-normal" onclick="tellPaper()">试卷讲解</button>
		    <button class="layui-btn layui-btn-normal" onclick="seeScore()">查看成绩</button>
		    <button class="layui-btn layui-btn-warm" onclick="seeRank()">查看排名</button>
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
					{type: "radio",fixed: "left"},		
					{field: 'id',title: 'ID',align: "center",sort:true},
					{field: 'examName',title: '考试名称',align: "center",sort:true},
					{field: 'stageId',title: '阶段',align: "center",
						templet: function(d){
							if (d.stageId == 1 || d.stageId == '1') return "S1";
							if (d.stageId == 2 || d.stageId == '2') return "S2";
							if (d.stageId == 3 || d.stageId == '3') return "S3";
							if (d.stageId == 4 || d.stageId == '4') return "Y2";
							if (d.stageId == 5 || d.stageId == '5') return "就业阶段";
						}
					},
					{field: 'booksId',title: '课程',align: "center",
						templet: function(d){
							if (d.stageId == 1 || d.stageId == '1') return "计算机与网络基础";
							if (d.stageId == 2 || d.stageId == '2') return "美术基础";
							if (d.stageId == 4 || d.stageId == '4') return "使用Ⅲustrator设计图形";
							if (d.stageId == 5 || d.stageId == '5') return "制作Flash动画";
							if (d.stageId == 6 || d.stageId == '6') return "网站配色与布局";
							if (d.stageId == 7 || d.stageId == '7') return "创意设计项目实战";
							if (d.stageId == 8 || d.stageId == '8') return "使用Dreamweaver制作网页";
							if (d.stageId == 9 || d.stageId == '9') return "网页样式与脚本特效";
							if (d.stageId == 10 || d.stageId == '10') return "软件技术基础";
							if (d.stageId == 11 || d.stageId == '11') return "使用Java理解程序逻辑";
							if (d.stageId == 12 || d.stageId == '12') return "使用HTML语言和CSS开发商业站点";
							if (d.stageId == 13 || d.stageId == '13') return "C#语言和SQL Server数据库技术";
							if (d.stageId == 14 || d.stageId == '14') return "使用C#开发数据库应用系统";
							if (d.stageId == 15 || d.stageId == '15') return "深入.NET平台和C#编程";
							if (d.stageId == 16 || d.stageId == '16') return "使用Java实现面向对象编程";
							if (d.stageId == 17 || d.stageId == '17') return "使用Java实现数据库编程";
							if (d.stageId == 18 || d.stageId == '18') return "使用jQuery快速高效制作网页交互特效";
							if (d.stageId == 19 || d.stageId == '19') return "使用JSP/Servlet技术开发新闻发布系统";
							if (d.stageId == 20 || d.stageId == '20') return "使用SSM框架开发企业级应用";
							if (d.stageId == 21 || d.stageId == '21') return "基于SSH框架的企业级应用开发";
							if (d.stageId == 22 || d.stageId == '22') return "基于Hadoop生态系统的大数据解决方案";
							if (d.stageId == 23 || d.stageId == '23') return "使用ASP.NET MVC开发企业级应用";
							if (d.stageId == 24 || d.stageId == '24') return "Web前端框架与移动应用开发";
							if (d.stageId == 29 || d.stageId == '29') return "动态网页特效";
							if (d.stageId == 30 || d.stageId == '30') return "Photosho图像视觉特效（下）";
							if (d.stageId == 31 || d.stageId == '31') return "静态网页制作";
							if (d.stageId == 32 || d.stageId == '32') return "趣味游戏编程";
							if (d.stageId == 33 || d.stageId == '33') return "Photosho图像视觉特效（上）";
						}
					},
					{field: 'chapterIds',title: '章节',align: "center",
						templet: function(d){
							if (d.chapterIds == 1 || d.chapterIds == '1') return "深入.NET框架的";
							if (d.chapterIds == 2 || d.chapterIds == '2') return "深入C#数据类型";
							if (d.chapterIds == 3 || d.chapterIds == '3') return "使用集合组织相关数据";
							if (d.chapterIds == 4 || d.chapterIds == '4') return "深入类的方法";
							if (d.chapterIds == 5 || d.chapterIds == '5') return "指导学习:体检套餐管理系统";
							if (d.chapterIds == 6 || d.chapterIds == '6') return "初识继承和多态";
							if (d.chapterIds == 7 || d.chapterIds == '7') return "深入理解多态";
							if (d.chapterIds == 8 || d.chapterIds == '8') return "可扩展标记语言XML";
							if (d.chapterIds == 9 || d.chapterIds == '9') return "文件操作";
							if (d.chapterIds == 10 || d.chapterIds == '10') return "对象和封装";
							if (d.chapterIds == 11 || d.chapterIds == '11') return "继承";
							if (d.chapterIds == 12 || d.chapterIds == '12') return "多态";
							if (d.chapterIds == 13 || d.chapterIds == '13') return "接口";
							if (d.chapterIds == 14 || d.chapterIds == '14') return "异常";
							if (d.chapterIds == 15 || d.chapterIds == '15') return "集合框架";
							if (d.chapterIds == 16 || d.chapterIds == '16') return "多线程";
							if (d.chapterIds == 17 || d.chapterIds == '17') return "File I/O";
							if (d.chapterIds == 18 || d.chapterIds == '18') return "数据库的设计";
							if (d.chapterIds == 19 || d.chapterIds == '19') return "初始Mysql";
							if (d.chapterIds == 20 || d.chapterIds == '20') return "高级查询(一)";
							if (d.chapterIds == 21 || d.chapterIds == '21') return "高级查询(二)";
							if (d.chapterIds == 22 || d.chapterIds == '22') return "事务、视图、索引、备份和恢复";
							if (d.chapterIds == 23 || d.chapterIds == '23') return "项目案例:银行ATM存取款机系统";
							if (d.chapterIds == 24 || d.chapterIds == '24') return "JDBC";
							if (d.chapterIds == 25 || d.chapterIds == '25') return "DAO模式";
							if (d.chapterIds == 26 || d.chapterIds == '26') return "JavaScript基础";
							if (d.chapterIds == 27 || d.chapterIds == '27') return "JavaScript操作BOM对象";
							if (d.chapterIds == 28 || d.chapterIds == '28') return "JavaScript操作DOM对象";
							if (d.chapterIds == 29 || d.chapterIds == '29') return "JavaScript对象及初识面向对象";
							if (d.chapterIds == 30 || d.chapterIds == '30') return "初识jQuery对象";
							if (d.chapterIds == 31 || d.chapterIds == '31') return "jQuery选择器";
							if (d.chapterIds == 32 || d.chapterIds == '32') return "jQuery中的事件与动画";
							if (d.chapterIds == 33 || d.chapterIds == '33') return "使用jQuery操作DOM";
							if (d.chapterIds == 34 || d.chapterIds == '34') return "使用jQuery操作DOM";
							if (d.chapterIds == 35 || d.chapterIds == '35') return "表单验证";
							if (d.chapterIds == 36 || d.chapterIds == '36') return "动态网页开发基础";
							if (d.chapterIds == 37 || d.chapterIds == '37') return "JSP数据交互(一)";
							if (d.chapterIds == 38 || d.chapterIds == '38') return "JSP数据交互(二)";
							if (d.chapterIds == 39 || d.chapterIds == '39') return "项目案例:新闻发布系统";
							if (d.chapterIds == 40 || d.chapterIds == '40') return "使用分层实现业务处理";
							if (d.chapterIds == 41 || d.chapterIds == '41') return "JSP开发业务应用";
							if (d.chapterIds == 42 || d.chapterIds == '42') return "Servlet基础";
							if (d.chapterIds == 43 || d.chapterIds == '43') return "JSTL和EL";
							if (d.chapterIds == 44 || d.chapterIds == '44') return "项目案例:论坛短信息";
							if (d.chapterIds == 45 || d.chapterIds == '45') return "Ajax与jQuery";
							if (d.chapterIds == 46 || d.chapterIds == '46') return "Ajax交互扩展";
							if (d.chapterIds == 47 || d.chapterIds == '47') return "初识MyBatis";
							if (d.chapterIds == 48 || d.chapterIds == '48') return "SQL映射文件";
							if (d.chapterIds == 49 || d.chapterIds == '49') return "动态SQL";
							if (d.chapterIds == 50 || d.chapterIds == '50') return "指导学习：使用MyBatis框架改造易买网";
							if (d.chapterIds == 51 || d.chapterIds == '51') return "Spring核心概念";
							if (d.chapterIds == 52 || d.chapterIds == '52') return "IoC和AOP使用扩展";
							if (d.chapterIds == 53 || d.chapterIds == '53') return "MyBatis与Spring的整合";
							if (d.chapterIds == 54 || d.chapterIds == '54') return "Spring配置补充";
							if (d.chapterIds == 55 || d.chapterIds == '55') return "SpringMVC体系结构和处理请求控制器";
							if (d.chapterIds == 56 || d.chapterIds == '56') return "Spring MVC 框架改造超市订单系统-1";
							if (d.chapterIds == 57 || d.chapterIds == '57') return "Spring MVC 框架改造超市订单系统-2";
							if (d.chapterIds == 58 || d.chapterIds == '58') return "Spring MVC扩展和SSM框架整合";
							if (d.chapterIds == 59 || d.chapterIds == '59') return "Oracle数据库基础";
							if (d.chapterIds == 60 || d.chapterIds == '60') return "Oracle数据库应用";
							if (d.chapterIds == 61 || d.chapterIds == '61') return "PL/SQL编程";
							if (d.chapterIds == 62 || d.chapterIds == '62') return "Hibernate入门";
							if (d.chapterIds == 63 || d.chapterIds == '63') return "Struts 2配置详解";
							if (d.chapterIds == 64 || d.chapterIds == '64') return "OGNL";
							if (d.chapterIds == 65 || d.chapterIds == '65') return "拦截器";
							if (d.chapterIds == 66 || d.chapterIds == '66') return "搭建SSH框架";
							if (d.chapterIds == 67 || d.chapterIds == '67') return "Hadoop入门";
							if (d.chapterIds == 68 || d.chapterIds == '68') return "HDFS实现分布式存储";
							if (d.chapterIds == 69 || d.chapterIds == '69') return "MapReduce实现分布式计算";
							if (d.chapterIds == 70 || d.chapterIds == '70') return "HBase数据库";
							if (d.chapterIds == 71 || d.chapterIds == '71') return "Hadoop综合应用";
							if (d.chapterIds == 72 || d.chapterIds == '72') return "响应式布局";
							if (d.chapterIds == 73 || d.chapterIds == '73') return "bootstrap 样式";
							if (d.chapterIds == 74 || d.chapterIds == '74') return "bootstrap 组件";
							if (d.chapterIds == 75 || d.chapterIds == '75') return "JavaScript插件";
							if (d.chapterIds == 76 || d.chapterIds == '76') return "指导学习：制作微票儿首页";
							if (d.chapterIds == 77 || d.chapterIds == '77') return "移动web页面开发";
							if (d.chapterIds == 78 || d.chapterIds == '78') return "移动web特效开发";
							if (d.chapterIds == 79 || d.chapterIds == '79') return "指导学习：58招聘季专题页";
							if (d.chapterIds == 80 || d.chapterIds == '80') return "项目案例：制作找房无忧网站";
							if (d.chapterIds == 81 || d.chapterIds == '81') return "搭建Android开发环境";
							if (d.chapterIds == 82 || d.chapterIds == '82') return "Android UI的布局";
							if (d.chapterIds == 83 || d.chapterIds == '83') return "初识Java";
							if (d.chapterIds == 84 || d.chapterIds == '84') return "变量、数据类型和运算符";
							if (d.chapterIds == 85 || d.chapterIds == '85') return "选择结构（一）";
							if (d.chapterIds == 86 || d.chapterIds == '86') return "选择结构（二）";
							if (d.chapterIds == 87 || d.chapterIds == '87') return "循环结构（一）";
							if (d.chapterIds == 88 || d.chapterIds == '88') return "循环结构（二）";
							if (d.chapterIds == 89 || d.chapterIds == '89') return "循环结构综合练习";
							if (d.chapterIds == 90 || d.chapterIds == '90') return "数组（一）";
							if (d.chapterIds == 91 || d.chapterIds == '91') return "循环结构进阶";
							if (d.chapterIds == 92 || d.chapterIds == '92') return "指导学习：幸运抽奖";
							if (d.chapterIds == 93 || d.chapterIds == '93') return "类和对象";
							if (d.chapterIds == 94 || d.chapterIds == '94') return "类的无参方法";
							if (d.chapterIds == 95 || d.chapterIds == '95') return "指导学习：人机猜拳";
							if (d.chapterIds == 96 || d.chapterIds == '96') return "带参数的方法";
							if (d.chapterIds == 97 || d.chapterIds == '97') return "字符串";
							if (d.chapterIds == 98 || d.chapterIds == '98') return "HTML5基础";
							if (d.chapterIds == 99 || d.chapterIds == '99') return "列表、表格与媒体元素";
							if (d.chapterIds == 100 || d.chapterIds == '100') return "表单";
							if (d.chapterIds == 101 || d.chapterIds == '101') return "初识CSS3";
							if (d.chapterIds == 102 || d.chapterIds == '102') return "CSS3美化网页元素";
							if (d.chapterIds == 103 || d.chapterIds == '103') return "盒子模型";
							if (d.chapterIds == 104 || d.chapterIds == '104') return "浮动";
							if (d.chapterIds == 105 || d.chapterIds == '105') return "定位网页元素";
							if (d.chapterIds == 106 || d.chapterIds == '106') return "利用CSS3制作网页动画";
							if (d.chapterIds == 107 || d.chapterIds == '107') return "第一个C#程序";
							if (d.chapterIds == 108 || d.chapterIds == '108') return "C#语法快速热身";
							if (d.chapterIds == 109 || d.chapterIds == '109') return "使用属性升级MyBank";
							if (d.chapterIds == 110 || d.chapterIds == '110') return "深入C#的String类";
							if (d.chapterIds == 111 || d.chapterIds == '111') return "指导学习：库存管理";
							if (d.chapterIds == 112 || d.chapterIds == '112') return "程序数据集散地：数据库";
							if (d.chapterIds == 113 || d.chapterIds == '113') return "用表组织数据";
							if (d.chapterIds == 114 || d.chapterIds == '114') return "用SQL语句操作数据";
							if (d.chapterIds == 115 || d.chapterIds == '115') return "数据查询基础";
							if (d.chapterIds == 116 || d.chapterIds == '116') return "模糊查询和聚合函数";
							if (d.chapterIds == 117 || d.chapterIds == '117') return "连接查询和分组查询";
							if (d.chapterIds == 118 || d.chapterIds == '118') return "项目案例：QQ数据库管理";
							if (d.chapterIds == 119 || d.chapterIds == '119') return "使用ADO.NET访问数据库";
							if (d.chapterIds == 120 || d.chapterIds == '120') return "使用ADO.NET查询和操作数据";
							if (d.chapterIds == 121 || d.chapterIds == '121') return "初识Windows程序";
							if (d.chapterIds == 122 || d.chapterIds == '122') return "构建布局良好的Windows程序";
							if (d.chapterIds == 123 || d.chapterIds == '123') return "使用ListView控件展示数据";
							if (d.chapterIds == 124 || d.chapterIds == '124') return "实现Windows程序的数据更新";
							if (d.chapterIds == 125 || d.chapterIds == '125') return "实现Windows程序的数据绑定";
							if (d.chapterIds == 128 || d.chapterIds == '128') return "数据筛选和排序";
							if (d.chapterIds == 129 || d.chapterIds == '129') return "初识CSS";
							if (d.chapterIds == 130 || d.chapterIds == '130') return "文本与图像";
							if (d.chapterIds == 131 || d.chapterIds == '131') return "CSS高级应用";
							if (d.chapterIds == 132 || d.chapterIds == '132') return "JavaScript基础语法";
							if (d.chapterIds == 133 || d.chapterIds == '133') return "选择结构";
							if (d.chapterIds == 134 || d.chapterIds == '134') return "基本的表单验证";
							if (d.chapterIds == 135 || d.chapterIds == '135') return "制作常见网页特效";
							if (d.chapterIds == 136 || d.chapterIds == '136') return "项目案例:开心网";
							if (d.chapterIds == 137 || d.chapterIds == '137') return "路径、形状工具与选区";
							if (d.chapterIds == 138 || d.chapterIds == '138') return "滤镜与通道";
							if (d.chapterIds == 139 || d.chapterIds == '139') return "图案设计";
							if (d.chapterIds == 140 || d.chapterIds == '140') return "按钮设计";
							if (d.chapterIds == 141 || d.chapterIds == '141') return "Logo设计";
							if (d.chapterIds == 142 || d.chapterIds == '142') return "特效字的设计";
							if (d.chapterIds == 143 || d.chapterIds == '143') return "项目案例：制作商业宣传折页";
							if (d.chapterIds == 144 || d.chapterIds == '144') return "项目案例:'网络营销员'系列书籍封面设计";
							if (d.chapterIds == 145 || d.chapterIds == '145') return "创意的地位";
							if (d.chapterIds == 146 || d.chapterIds == '146') return "创意的概念";
							if (d.chapterIds == 147 || d.chapterIds == '147') return "创意在设计中的作用";
							if (d.chapterIds == 148 || d.chapterIds == '148') return "创意设计的方法";
							if (d.chapterIds == 149 || d.chapterIds == '149') return "创意设计与艺术";
							if (d.chapterIds == 150 || d.chapterIds == '150') return "项目案例:宣传海报";
							if (d.chapterIds == 151 || d.chapterIds == '151') return "品牌创意设计";
							if (d.chapterIds == 152 || d.chapterIds == '152') return "平面广告创意设计";
							if (d.chapterIds == 153 || d.chapterIds == '153') return "包装及书籍装帧创意设计";
							if (d.chapterIds == 154 || d.chapterIds == '154') return "项目案例:移动平台播放器";
							if (d.chapterIds == 155 || d.chapterIds == '155') return "创意的生命力";
							if (d.chapterIds == 156 || d.chapterIds == '156') return "lllustrator基础";
							if (d.chapterIds == 157 || d.chapterIds == '157') return "基本图形的绘制与编辑";
							if (d.chapterIds == 158 || d.chapterIds == '158') return "路径和画笔工具的应用";
							if (d.chapterIds == 159 || d.chapterIds == '159') return "填充效果和混合效果的应用";
							if (d.chapterIds == 160 || d.chapterIds == '160') return "项目案例：标志和礼券";
							if (d.chapterIds == 161 || d.chapterIds == '161') return "文字和图表的应用";
							if (d.chapterIds == 162 || d.chapterIds == '162') return "图层和蒙版的应用";
							if (d.chapterIds == 163 || d.chapterIds == '163') return "项目案例：汽车销售报表和三星手机广告";
							if (d.chapterIds == 164 || d.chapterIds == '164') return "效果和样式的应用";
							if (d.chapterIds == 165 || d.chapterIds == '165') return "DM设计";
							if (d.chapterIds == 166 || d.chapterIds == '166') return "POP设计";
							if (d.chapterIds == 167 || d.chapterIds == '167') return "VI设计";
							if (d.chapterIds == 168 || d.chapterIds == '168') return "项目案例：房地产广告设计";
							if (d.chapterIds == 169 || d.chapterIds == '169') return "网页入门";
							if (d.chapterIds == 170 || d.chapterIds == '170') return "图像与超级链接";
							if (d.chapterIds == 171 || d.chapterIds == '171') return "列表";
							if (d.chapterIds == 172 || d.chapterIds == '172') return "网页中的表格";
							if (d.chapterIds == 173 || d.chapterIds == '173') return "网页中的表单";
							if (d.chapterIds == 174 || d.chapterIds == '174') return "项目案例 淘宝网";
							if (d.chapterIds == 175 || d.chapterIds == '175') return "使用css美化网页";
							if (d.chapterIds == 176 || d.chapterIds == '176') return "项目案例 易趣网";
							if (d.chapterIds == 177 || d.chapterIds == '177') return "HTML总结";
							if (d.chapterIds == 178 || d.chapterIds == '178') return "项目案例 拍拍网";
							if (d.chapterIds == 179 || d.chapterIds == '179') return "好玩的Scratch";
							if (d.chapterIds == 180 || d.chapterIds == '180') return "马戏团表演";
							if (d.chapterIds == 181 || d.chapterIds == '181') return "有趣的运算和统计";
							if (d.chapterIds == 182 || d.chapterIds == '182') return "神器的画笔";
							if (d.chapterIds == 183 || d.chapterIds == '183') return "音乐之声";
							if (d.chapterIds == 184 || d.chapterIds == '184') return "Scratch实战应用（一）";
							if (d.chapterIds == 185 || d.chapterIds == '185') return "Scratch实战应用（二）";
							if (d.chapterIds == 186 || d.chapterIds == '186') return "项目案例“创意科技，互动未来”";
							if (d.chapterIds == 187 || d.chapterIds == '187') return "基础知识";
							if (d.chapterIds == 189 || d.chapterIds == '189') return "Photoshop基本操作";
							if (d.chapterIds == 190 || d.chapterIds == '190') return "Photoshop的绘图工具";
							if (d.chapterIds == 191 || d.chapterIds == '191') return "Photoshop图像修饰工具";
							if (d.chapterIds == 192 || d.chapterIds == '192') return "色彩调整与校正";
							if (d.chapterIds == 193 || d.chapterIds == '193') return "图层与蒙版";
							if (d.chapterIds == 194 || d.chapterIds == '194') return "文字工具";
							if (d.chapterIds == 195 || d.chapterIds == '195') return "项目案例：制作“北大青鸟助学夏令营”主体活动宣传海报";
						}
					},
					{field: 'classesIds',title: '参考班级',align: "center",
						templet: function(d){
							var arr=new Array();
							arr = d.classesIds.split(',');	//以逗号分隔
							for (var i = 0; i < arr.length; i++) {
								 arr = arr[i];
								 $.ajax({
										url: '${pageContext.request.contextPath}/exam/getClasses',
										type: "GET",
										dataType: "JSON",
										data: {"id": arr},
										success: function(data) {
											return data.class_name;
										}
								 });
							}
						}		
					},
					{field: 'startTime',title: '开始时间',align: "center"},
					{field: 'endTime',title: '结束时间',align: "center"},
					{field: 'userName',title: '发布人',align: "center"},
					{field: 'types',title: '考卷类型',align: 'center',
						templet: function(d){
							if (d.types == 1 || d.types == '1') return "周测";
							if (d.types == 2 || d.types == '2') return "内测";
							if (d.types == 3 || d.types == '3') return "月考";
						}	
					},
					{field: 'status',title: '考试状态',align: "center", 
						templet: function(d){
							if (d.status == 1 || d.status == '1') return "<font color='red'><b>未开考</b></font>";
							if (d.status == 2 || d.status == '2') return "<font color='green'><b>进行中</b></font>";
							if (d.status == 3 || d.status == '3') return "<font color='yellow'><b>批改中</b></font>";
							if (d.status == 4 || d.status == '4') return "<font color='gray'><b>已结束</b></font>";
						}
					},
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
	</script>
</body>
</html>