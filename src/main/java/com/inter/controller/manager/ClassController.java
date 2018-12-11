package com.inter.controller.manager;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inter.exception.CustomException;
import com.inter.pojo.school.Classes;
import com.inter.service.dictionaries.ClassesService;
import com.inter.utils.PageHelper;

@Controller
@RequestMapping("/classes")
public class ClassController {

	
	@Autowired
	private ClassesService classesService;
	
	@RequestMapping("/s/view.do")
	public String initClassesView() {
		return "manager/classes_list";
	}
	
	@RequestMapping("/get/list.do")
	@ResponseBody
	public PageHelper<Classes> getClassesListByPage(String teacherName,Integer classesId,Integer page,Integer offset,Integer limit)throws CustomException{
		return classesService.getClassesListByPage(teacherName,classesId,page,offset,limit);
	}
	
	@RequestMapping("/show/addentity.do")
	public String showAddOrUpdateView(Model model,Integer classesId)throws CustomException {
		
		if(classesId != null){
			model.addAttribute("classes", classesService.selectByPrimaryKey(classesId));
		}
		return "manager/classes_add";
	}
	
	@RequestMapping("/add/entity.do")
	@ResponseBody
	public Map<String,Object> saveOrUpdate(Classes classes,Integer teacherID,Integer assistantID,Integer headmasterID)throws CustomException{
		return classesService.saveOrUpdate(classes,teacherID,assistantID,headmasterID);
	}
	
	@RequestMapping("/get/check.do")
	@ResponseBody
	public Map<String,Object> checkClassesNameById(String classesIds)throws CustomException{
		return classesService.checkClassesNameById(classesIds);
	}
}
