package com.inter.controller.system;

import java.text.ParseException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inter.annotation.Log;
import com.inter.base.BaseController;
import com.inter.exception.CustomException;
import com.inter.exception.ReturnViewException;
import com.inter.service.system.StudentService;
import com.inter.utils.PageHelper;
import com.inter.vo.UserStudentVo;

@Controller
@RequestMapping("/student")
public class StudentController extends BaseController{

	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/s/view.do")
	@Log(operationType="系统管理",operationName="学生管理页面",operationSource="教师端")
	public String initAllStudentListView() throws ReturnViewException, CustomException {
		checkPermissionToView("STUDENT_VIEW");
		return "system/student/student_list";
	}
	
	@RequestMapping("/get/list.do")
	@ResponseBody
	public PageHelper<UserStudentVo> getAllList(UserStudentVo userStudentVo,String userName,Integer offset,Integer limit) throws CustomException, ParseException{
		return studentService.getOkOrNoStudentByPage(userStudentVo,"9",null,userName,null,null,null,null,offset,limit);
	}
	
	
	@RequestMapping("/s/ok.do")
	@Log(operationType="系统管理",operationName="正式学生页面",operationSource="教师端")
	public String initOkStudentListView() {
		return "system/student/student_ok_list";
	}
	
	@RequestMapping("/get/oklist.do")
	@ResponseBody
	public PageHelper<UserStudentVo> getOkStudentByPage(UserStudentVo userStudentVo,String userName,String queryDate,Integer user1,Integer user2,Integer user3, Integer offset,Integer limit)throws CustomException, ParseException{
		checkPermissionToMessage("ZS_STUDENT_LIST");
		return studentService.getOkOrNoStudentByPage(userStudentVo,"9","1",userName,queryDate,user1,user2,user3,offset,limit);
	}
	
	@RequestMapping("/s/no.do")
	public String initNoStudentListView() {
		return "system/student/student_no_list";
	}
	
	@RequestMapping("/get/nolist.do")
	@ResponseBody
	public PageHelper<UserStudentVo> getNoStudentByPage(UserStudentVo userStudentVo,String userName,String queryDate,Integer user1,Integer user2,Integer user3,Integer offset,Integer limit)throws CustomException, ParseException{
		checkPermissionToMessage("SCB_LIST");
		return studentService.getOkOrNoStudentByPage(userStudentVo,"9","0",userName,queryDate,user1,user2,user3,offset,limit);
	}
	
	@RequestMapping("/show/addentity.do")
	public String initAddOrUpdateView(Model model,Integer userId) throws CustomException, ReturnViewException {
		if(userId != null) {
			checkPermissionToView("SCB_EDIT");
			UserStudentVo vo = studentService.getUserByUserId(userId);
			model.addAttribute("vo", vo);
		}
		checkPermissionToView("SCB_SAVE");
		return "system/student/student_no_add";
	}
	
	@RequestMapping("/check/nickname.do")
	@ResponseBody
	public Map<String,Object> checkNickNameAndTelephoneA(String nickName,String telephoneA) throws CustomException{
		return studentService.checkNickNameAndTelephoneA(nickName,telephoneA);
	}
	
	@RequestMapping("/check/username.do")
	@ResponseBody
	public Map<String,Object> checkUsername(String username) throws CustomException{
		return studentService.checkUsername(username);
	}
	
	@RequestMapping("/add/flagstudent.do")
	@ResponseBody
	@Log(operationType="系统管理",operationName="市场部添加临时学生",operationSource="教师端")
	public Map<String,Object> saveOrUpdateStudent(String[] roleIds,UserStudentVo vo) throws CustomException, ReturnViewException{
		if(vo.getId() == null) {
			checkPermissionToView("SCB_SAVE");
		}else {
			checkPermissionToView("SCB_EDIT");
		}
		return studentService.saveOrUpdateStudent(roleIds,vo);
	}
	
	@RequestMapping("/edit/isTemp.do")
	@ResponseBody
	@Log(operationType="系统管理",operationName="编辑临时学生",operationSource="教师端")
	public Map<String,Object> editIsTemp(Integer userId) throws CustomException, IllegalArgumentException, IllegalAccessException{
		checkPermissionToMessage("SCB_REVERSE");
		return studentService.editIsTemp(userId);
	}
	
	@RequestMapping("/check/classes.do")
	@ResponseBody
	public Map<String,Object> checkClasses(Integer userId) throws CustomException{
		return studentService.checkClasses(userId);
	}
	
	
	/** 检查班级是否正在考试，考试中的话，不能讲学生指定到该班级*/
	@RequestMapping("/check/examination.do")
	@ResponseBody
	public Map<String,Object> checkClassesExamination(Integer classesId) throws CustomException{
		return studentService.checkClassesExamination(classesId);
	}
	
	
	@RequestMapping("/show/classes.do")
	public String initAddClasses(Model model,Integer userId)throws CustomException {
		model.addAttribute("userId", userId);
		return "system/student/student_add_classes";
	}
	
	@RequestMapping("/add/s1classes.do")
	@ResponseBody
	public Map<String,Object> addClasses(Integer classesId,Integer userId)  throws CustomException{
		checkPermissionToMessage("ZS_STUDENT_CLASS");
		return studentService.addClasses(classesId,userId);
	}
	
	@RequestMapping("/get/user123.do")
	public String initAddUser123View(Model model, Integer userId,Integer types)throws CustomException {
		model.addAttribute("student", studentService.getUserByUserId(userId));
		model.addAttribute("userId", userId);
		model.addAttribute("types", types);
		return "system/student/student_add_user123";
	} 
	
	@RequestMapping("/add/user123.do")
	@ResponseBody
	public Map<String,Object> addUser123(Integer userId,Integer types,Integer user123Id)throws CustomException{
		if(types == 1)
		
		if(checkPermission("SCB_WZ") == false)
		
		throw new CustomException("权限不足");
		
		if(types == 2)
			
		if(checkPermission("SCB_ZL") == false)
			
		throw new CustomException("权限不足");
		
		if(types == 3)
			
		if(checkPermission("SCB_ZX") == false)
			
		throw new CustomException("权限不足");
		
		return studentService.addUser123(userId,types,user123Id);
	}
	
}
