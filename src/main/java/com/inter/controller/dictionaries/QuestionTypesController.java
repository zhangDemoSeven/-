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
import com.inter.pojo.dictionaries.Questiontypes;
import com.inter.service.dictionaries.QuestiontypesService;
import com.inter.utils.PageHelper;

@Controller
@RequestMapping("/questiontypes")
public class QuestionTypesController extends BaseController {

	@Autowired
	private QuestiontypesService questiontypesService;
	
	
	@RequestMapping("/get/nopage.do")
	@ResponseBody
	public List<Questiontypes> getQuestiontypesListByNoPage()throws CustomException{
		return questiontypesService.getQuestiontypesListByNoPage();
	}
	
	@RequestMapping("/s/view.do")
	@Log(operationType="字典管理",operationName="题型字典页面",operationSource="教师端")
	public String initQuestiontypesView() throws ReturnViewException, CustomException{
		checkPermissionToView("DICTIONARIES_QUESTIONTYPES");
return "dictionaries/questiontypes_list";
	}
	
	@RequestMapping("/show/questiontypes.do")
	public String initAddOrUpdateView(Model model,Integer id) throws CustomException {
		if(id != null) {
			model.addAttribute("questiontypes", questiontypesService.selectByPrimaryKey(id));
		}
		return "dictionaries/questiontypes_add";
	}
	
	@RequestMapping("/get/list.do")
	@ResponseBody
	public PageHelper<Questiontypes> getQuestiontypesListByPage(String name,Integer offset,Integer limit)throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_QUESTIONTYPES");
		return questiontypesService.getQuestiontypesListByPage(name,offset,limit);
	}
	
	@RequestMapping("/add/questiontypes.do")
	@ResponseBody
	@Log(operationName="保存题型",operationSource="教师端",operationType="题型字典")
	public Map<String,Object> saveOrUpdateQuestiontypes(Questiontypes questiontypes) throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_QUESTIONTYPES");
		return questiontypesService.saveOrUpdateQuestiontypes(questiontypes);
	}
	
	@RequestMapping("/opt/questiontypes.do")
	@ResponseBody
	@Log(operationName="启禁题型",operationSource="教师端",operationType="题型字典")
	public Map<String,Object> optQuestiontypes(Integer id) throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_QUESTIONTYPES");
		return questiontypesService.optQuestiontypes(id);
	}
	
	@RequestMapping("/del/questiontypes.do")
	@ResponseBody
	@Log(operationName="删除题型",operationSource="教师端",operationType="题型字典")
	public Map<String,Object> delQuestiontypes(Integer id) throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_QUESTIONTYPES");
		return questiontypesService.delQuestiontypes(id);
	}
}
