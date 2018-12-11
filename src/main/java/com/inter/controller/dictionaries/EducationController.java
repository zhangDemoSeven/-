package com.inter.controller.dictionaries;

import java.util.List;
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
import com.inter.pojo.dictionaries.Education;
import com.inter.service.dictionaries.EducationService;
import com.inter.utils.PageHelper;

/**学历*/
@Controller
@RequestMapping("/education")
public class EducationController extends BaseController {

	@Autowired
	private  EducationService  educationService;
	
	@RequestMapping("/s/view.do")
	@Log(operationType="字典管理",operationName="学历字典页面",operationSource="教师端")
	public String initEducationView() throws ReturnViewException, CustomException {
		checkPermissionToView("DICTIONARIES_EDUCATION");
		return "dictionaries/education_list";
	}
	
	@RequestMapping("/get/nopage.do")
	@ResponseBody
	public List<Education> getEducationListByNoPage()throws CustomException{
		return educationService.getEducationListByNoPage();
	}
	
	
	@RequestMapping("/show/education.do")
	public String initAddOrUpdateView(Model model,Integer id) throws CustomException {
		if(id != null) {
			model.addAttribute("education", educationService.selectByPrimaryKey(id));
		}
		return "dictionaries/education_add";
	}
	
	@RequestMapping("/get/list.do")
	@ResponseBody
	public PageHelper<Education> getEducationListByPage(String name,Integer offset,Integer limit)throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_EDUCATION");
		return educationService.getEducationListByPage(name,offset,limit);
	}
	
	@RequestMapping("/add/education.do")
	@ResponseBody
	@Log(operationType="字典管理",operationName="新增学历字典",operationSource="教师端")
	public Map<String,Object> saveOrUpdateEducation(Education education) throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_EDUCATION");
		return educationService.saveOrUpdateEducation(education);
	}
	
	@RequestMapping("/opt/education.do")
	@ResponseBody
	@Log(operationType="字典管理",operationName="启禁学历字典",operationSource="教师端")
	public Map<String,Object> optEducation(Integer id) throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_EDUCATION");
		return educationService.optEducation(id);
	}
	
	@RequestMapping("/del/education.do")
	@ResponseBody
	@Log(operationType="字典管理",operationName="删除学历字典",operationSource="教师端")
	public Map<String,Object> delEducation(Integer id) throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_EDUCATION");
		return educationService.delEducation(id);
	}
}
