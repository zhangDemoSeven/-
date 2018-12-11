package com.inter.controller.dictionaries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inter.exception.CustomException;
import com.inter.pojo.school.Classes;
import com.inter.service.dictionaries.ClassesService;

@Controller
@RequestMapping("/classes")
public class ClassesController {

	@Autowired
	private ClassesService classesService;
	
	@RequestMapping("/get/nopage.do")
	@ResponseBody
	public List<Classes> getClassesListByNoPage()throws CustomException{
		return classesService.getClassesListByNoPage("1");//查找没有毕业的班级集合
	}
	
	@RequestMapping("/get/s1.do")
	@ResponseBody
	public List<Classes> getClassesListByS1()throws CustomException{
		return classesService.getClassesListByS1();
	}
	
	@ResponseBody
	@RequestMapping("/getClassesByStage.do")
 	public List<Classes> getClassesByStage(Integer id) throws CustomException {
		return classesService.getClassesByStage(id);
 	}
}
