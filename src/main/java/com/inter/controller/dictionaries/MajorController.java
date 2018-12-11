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
import com.inter.pojo.dictionaries.Major;
import com.inter.service.dictionaries.MajorService;
import com.inter.utils.PageHelper;

/**专业*/
@Controller
@RequestMapping("/major")
public class MajorController extends BaseController {

	@Autowired
	private MajorService majorService;
	
	@RequestMapping("/get/nopage.do")
	@ResponseBody
	public List<Major> getMajorListByNoPage()throws CustomException{
		return majorService.getMajorListByNoPage();
	}
	
	@RequestMapping("/s/view.do")
	@Log(operationType="字典管理",operationName="专业字典页面",operationSource="教师端")
	public String initMajorView() throws ReturnViewException, CustomException{
		checkPermissionToView("DICTIONARIES_MAJOR");
		return "dictionaries/major_list";
	}
	
	@RequestMapping("/show/major.do")
	public String initAddOrUpdateView(Model model,Integer id) throws CustomException {
		if(id != null) {
			model.addAttribute("major", majorService.selectByPrimaryKey(id));
		}
		return "dictionaries/major_add";
	}
	
	@RequestMapping("/get/list.do")
	@ResponseBody
	public PageHelper<Major> getMajorListByPage(String majorName,Integer offset,Integer limit)throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_MAJOR");
		return majorService.getMajorListByPage(majorName,offset,limit);
	}
	
	@RequestMapping("/add/major.do")
	@ResponseBody
	@Log(operationType="字典管理",operationName="新增专业字典",operationSource="教师端")
	public Map<String,Object> saveOrUpdateMajor(Major major) throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_MAJOR");
		return majorService.saveOrUpdateMajor(major);
	}
	
	@RequestMapping("/opt/major.do")
	@ResponseBody
	@Log(operationType="字典管理",operationName="启禁专业字典",operationSource="教师端")
	public Map<String,Object> optMajor(Integer id) throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_MAJOR");
		return majorService.optMajor(id);
	}
	
	@RequestMapping("/del/major.do")
	@ResponseBody
	@Log(operationType="字典管理",operationName="删除章节字典",operationSource="教师端")
	public Map<String,Object> delMajor(Integer id) throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_MAJOR");
		return majorService.delMajor(id);
	}
	
}
