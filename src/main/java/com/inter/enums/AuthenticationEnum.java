package com.inter.enums;

public enum AuthenticationEnum {

	MENU_SAVE("menu:save"),
	MENU_DEL("menu:del"),
	MENU_EDIT("menu:edit"),
	MENU_QUERY("menu:query"),
	MENU_OPT("menu:opt"),
	MENU_LIST("menu:list"),
	
	PERMISSION_SAVE("permission:save"),
	PERMISSION_DEL("permission:del"),
	PERMISSION_EDIT("permission:edit"),
	PERMISSION_QUERY("permission:query"),
	PERMISSION_OPT("permission:opt"),
	PERMISSION_LIST("permission:list"),
	
	ROLE_SAVE("role:save"),
	ROLE_DEL("role:del"),
	ROLE_EDIT("role:edit"),
	ROLE_QUERY("role:query"),
	ROLE_OPT("role:opt"),
	ROLE_LIST("role:list"),
	
	USER_SAVE("user:save"),
	USER_DEL("user:del"),
	USER_EDIT("user:edit"),
	USER_QUERY("user:query"),
	USER_OPT("user:opt"),
	USER_LIST("user:list"),
	
	BOOKS_SAVE("books:save"),
	BOOKS_DEL("books:del"),
	BOOKS_EDIT("books:edit"),
	BOOKS_QUERY("books:query"),
	BOOKS_OPT("books:opt"),
	BOOKS_LIST("books:list"),
	
	
	
	SINGLE_SAVE("single:save"),
	SINGLE_EDIT("single:edit"),
	SINGLE_DEL("single:del"),
	SINGLE_QUERY("single:query"),
	SINGLE_OPT("single:opt"),
	SINGLE_LIST("single:list"),
	SINGLE_EMPORT("single:emport"),
	SINGLE_IMPORT("single:import"),
	
	
	MULTIPLE_SAVE("multiple:save"),
	MULTIPLE_EDIT("multiple:edit"),
	MULTIPLE_DEL("multiple:del"),
	MULTIPLE_QUERY("multiple:query"),
	MULTIPLE_OPT("multiple:opt"),
	MULTIPLE_LIST("multiple:list"),
	MULTIPLE_EMPORT("multiple:emport"),
	MULTIPLE_IMPORT("multiple:import"),
	
	QUESANDANS_SAVE("quesandans:save"),
	QUESANDANS_EDIT("quesandans:edit"),
	QUESANDANS_DEL("quesandans:del"),
	QUESANDANS_QUERY("quesandans:query"),
	QUESANDANS_OPT("quesandans:opt"),
	QUESANDANS_LIST("quesandans:list"),
	QUESANDANS_EMPORT("quesandans:emport"),
	QUESANDANS_IMPORT("quesandans:import"),
	
	
	UPPER_SAVE("upper:save"),
	UPPER_EDIT("upper:edit"),
	UPPER_DEL("upper:del"),
	UPPER_QUERY("upper:query"),
	UPPER_OPT("upper:opt"),
	UPPER_LIST("upper:list"),
	
	//总经办-消息管理
	MESSAGE_SAVE("message:save"),
	MESSAGE_DEL("message:del"),
	MESSAGE_LIST("message:list"),
	
	//总经办-教师管理
	BOSS_TEACHER_LIST("boss:teacher:list"),
	
	//总经办-班级管理
	BOSS_CLASS_LIST("boss:class:list"),
	BOSS_CLASS_EDIT("boss:class:edit"),
	BOSS_CLASS_SAVE("boss:class:save"),
	//教质部-正式学生
	ZS_STUDENT_LIST("zsstudent:list"),
	ZS_STUDENT_CLASS("zsstudent:class"),
	
	//市场部-咨询录量
	SCB_LIST("scb:list"),
	SCB_SAVE("scb:save"),
	SCB_EDIT("scb:edit"),
	SCB_ZX("scb:zx"),
	SCB_ZL("scb:zl"),
	SCB_WZ("scb:wz"),
	SCB_REVERSE("scb:reverse"),
	
	
	//考试管理的权限 月考 周测 内测
	PAPER_MONTH_LIST("paper:month:list"), //月考列表
	PAPER_WEEK_LIST("paper:week:list"),	//周测列表
	PAPER_INTERNAL_LIST("paper:internal:list"),	//内测列表
	PAPER_SAVE("paper:save"),//发布月考试卷
	INTERNAL_PAPER_SAVE("internal:paper:save"),//发布内测试卷
	WEEK_PAPER_SAVE("week:paper:save"),//发布内测试卷
	PAPER_QUERY("paper:query"),
	PAPER_SEE("paper:see"),//考前查看时间
	PAPER_STOP("paper:stop"),//停止考试
	PAPER_START("paper:start"),//开始考试
	PAPER_CORRECT("paper:correct"),//公布答案
	PAPER_SPEAK("paper:speak"),//试卷讲解
	PAPER_SEEEXAM("paper:seeexam"), //查看成绩
	PAPER_ANALYSIS("paper:analysis"),//试卷分析
	PAPER_EDITCORRECT("paper:editcorrect"), //公布答案
	PAPER_SHOWQAA("paper:showqaa"),//试卷批注---查看问答题按钮
	PAPER_SHOWUPPER("paper:showupper"),//试卷批注---查看上机题按钮
	PAPER_SHOWRANK("paper:showrank"), //试卷排名
	
	
	//系统管理权限
	SYSTEM_LOGVIEW("system:logview"), //进入日志管理页面
	SYSTEM_LOGLIST("system:loglist"), //日志数据列表

	
	//字典权限 --- 每个字典管理之需要一个权限控制,所有的方法使用一个权限.只有超级管理员拥有该权限.
	//目的为了防止非管理直接使用url进行操作
	DICTIONARIES_BOOKS("dictionaries:books"),
	DICTIONARIES_CHANNEL("dictionaries:channel"),
	DICTIONARIES_CHAPTER("dictionaries:chapter"),
	DICTIONARIES_CLASSIFICATION("dictionaries:classification"),
	DICTIONARIES_EDUCATION("dictionaries:education"),
	DICTIONARIES_IDENTITY("dictionaries:identity"),
	DICTIONARIES_LEVEL("dictionaries:level"),
	DICTIONARIES_MAJOR("dictionaries:major"),
	DICTIONARIES_QUESTIONTYPES("dictionaries:questiontypes"),
	DICTIONARIES_SOURCE("dictionaries:source"),
	DICTIONARIES_STAGE("dictionaries:stage"),
	DICTIONARIES_STIUATION("dictionaries:stiuation"),
	DICTIONARIES_TOOL("dictionaries:tool"),
	
	//URL权限
	MENU_VIEW("menu:view"),
	USER_VIEW("user:view"),
	ROLE_VIEW("role:view"),
	PERMISSION_VIEW("permission:view"),
	STUDENT_VIEW("student:view"),
	
	SINGLE_VIEW("single:view"),
	MULTIPLE_VIEW("multiple:view"),
	QAA_VIEW("qaa:view"),
	UPPER_VIEW("upper:view"),
	
	
	
	
	;
	
    private AuthenticationEnum(String type) {
        this.type = type;
    }

    private String type;

    public String getType() {
        return this.type;
    }
}
