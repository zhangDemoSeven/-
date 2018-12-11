package com.inter.controller.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inter.base.BaseController;
import com.inter.exception.CustomException;
import com.inter.pojo.system.User;
import com.inter.service.manager.TeacherService;
import com.inter.utils.PageHelper;


@Controller
@RequestMapping("/teacher")
public class TeacherController extends BaseController{

	@Autowired
	private TeacherService teacherService;
	
	@RequestMapping("/s/view.do")
	public String initTeacherListView() {
		return "manager/teacher_list";
	}
	
	@RequestMapping("/get/teacher.do")
	@ResponseBody
	public List<User> getTeacherListByIdentity()throws CustomException{
		return teacherService.getTeachListByIdentity("2");
	}
	
	@RequestMapping("/get/assistant.do")
	@ResponseBody
	public List<User> getAssistantListByIdentity()throws CustomException{
		
		return teacherService.getTeachListByIdentity("3");
	}
	
	@RequestMapping("/get/headmaster.do")
	@ResponseBody
	public List<User> getHeadmasterListByIdentity()throws CustomException{
		
		return teacherService.getTeachListByIdentity("4");
	}
	
	@RequestMapping("/get/list.do")
	@ResponseBody
	public PageHelper<User> getTeacherListByPage(Integer classesId,String teacherName,Integer level,Integer identity,Integer offset,Integer limit)throws CustomException{
		checkPermissionToMessage("BOSS_TEACHER_LIST");
		return teacherService.getTeacherListByPage(classesId,teacherName,level,identity,offset,limit);
	}
}
