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
import com.inter.pojo.dictionaries.Classification;
import com.inter.service.dictionaries.ClassificationService;
import com.inter.utils.PageHelper;

@Controller
@RequestMapping("/classification")
public class ClassificationController extends BaseController {

	@Autowired
	private ClassificationService classificationService;
	
	@RequestMapping("/get/nopage.do")
	@ResponseBody
	public List<Classification> getClassificationListByNoPage() throws CustomException{
		return classificationService.getClassificationListByNoPage();
	}
	
	@RequestMapping("/s/view.do")
	@Log(operationType="字典管理",operationName="启禁学科字典",operationSource="教师端")
	public String initclassificationView() throws ReturnViewException, CustomException{
		checkPermissionToView("DICTIONARIES_CLASSIFICATION");
		return "dictionaries/classification_list";
	}
	
	@RequestMapping("/show/classification.do")
	public String initAddOrUpdateView(Model model,Integer id) throws CustomException {
		if(id != null) {
			model.addAttribute("classification", classificationService.selectByPrimaryKey(id));
		}
		return "dictionaries/classification_add";
	}
	
	@RequestMapping("/get/list.do")
	@ResponseBody
	public PageHelper<Classification> getClassificationListByPage(String name,Integer offset,Integer limit)throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_CLASSIFICATION");
		return classificationService.getClassificationListByPage(name,offset,limit);
	}
	
	@RequestMapping("/add/classification.do")
	@ResponseBody
	@Log(operationType="字典管理",operationName="新增学科字典",operationSource="教师端")
	public Map<String,Object> saveOrUpdateClassification(Classification classification) throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_CLASSIFICATION");
		return classificationService.saveOrUpdateClassification(classification);
	}
	
	@RequestMapping("/opt/classification.do")
	@ResponseBody
	@Log(operationType="字典管理",operationName="启禁学科字典",operationSource="教师端")
	public Map<String,Object> optClassification(Integer id) throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_CLASSIFICATION");
		return classificationService.optClassification(id);
	}
	
	@RequestMapping("/del/classification.do")
	@ResponseBody
	@Log(operationType="字典管理",operationName="删除学科字典",operationSource="教师端")
	public Map<String,Object> delClassification(Integer id) throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_CLASSIFICATION");
		return classificationService.delClassification(id);
	}
}
