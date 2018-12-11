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
import com.inter.pojo.dictionaries.Stiuation;
import com.inter.service.dictionaries.StiuationService;
import com.inter.utils.PageHelper;

/**现状*/
@Controller
@RequestMapping("/stiuation")
public class StiuationController extends BaseController{

	@Autowired
	private StiuationService stiuationService;
	
	@RequestMapping("/s/view.do")
	@Log(operationType="字典管理",operationName="现状字典管理",operationSource="教师端")
	public String initStiuationView() throws ReturnViewException, CustomException{
		checkPermissionToView("DICTIONARIES_STIUATION");
return "dictionaries/stiuation_list";
	}
	
	@RequestMapping("/show/addentity.do")
	public String initAddOrUpdateView(Model model,Integer id) throws CustomException {
		if(id != null) {
			model.addAttribute("stiuation", stiuationService.selectByPrimaryKey(id));
		}
		return "dictionaries/stiuation_add";
	}
	
	@RequestMapping("/get/nopage.do")
	@ResponseBody
	public List<Stiuation> getStiuationListByNoPage()throws CustomException{
		return stiuationService.getStiuationListByNoPage();
	}
	
	@RequestMapping("/get/list.do")
	@ResponseBody
	public PageHelper<Stiuation> getStiuationListByPage(String name,Integer offset,Integer limit) throws ReturnViewException, CustomException{
		checkPermissionToView("DICTIONARIES_STIUATION");
return stiuationService.getStiuationListByPage(name,offset,limit);
	}
	
	@RequestMapping("/add/stiuation.do")
	@ResponseBody
	@Log(operationType="字典管理",operationName="新增现状字典",operationSource="教师端")
	public Map<String,Object> saveOrUpdateStiuation(Stiuation stiuation) throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_STIUATION");
return stiuationService.saveOrUpdateStiuation(stiuation);
	}
	
	@RequestMapping("/opt/stiuation.do")
	@ResponseBody
	@Log(operationType="字典管理",operationName="启禁现状字典",operationSource="教师端")
	public Map<String,Object> optStiuation(Integer id) throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_STIUATION");
return stiuationService.optStiuation(id);
	}
	
	@RequestMapping("/del/stiuation.do")
	@ResponseBody
	@Log(operationType="字典管理",operationName="删除现状字典",operationSource="教师端")
	public Map<String,Object> delStiuation(Integer id) throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_STIUATION");
return stiuationService.delStiuation(id);
	}
	
}
