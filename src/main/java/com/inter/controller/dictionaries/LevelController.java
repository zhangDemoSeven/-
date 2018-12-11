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
import com.inter.pojo.dictionaries.Level;
import com.inter.service.dictionaries.LevelService;
import com.inter.utils.PageHelper;

/**部门*/
@Controller
@RequestMapping("/level")
public class LevelController extends BaseController {

	@Autowired
	private LevelService levelService;
	
	@RequestMapping("/s/view.do")
	@Log(operationType="字典管理",operationName="部门字典管理",operationSource="教师端")
	public String showLevelListView() throws CustomException, ReturnViewException {
		checkPermissionToView("DICTIONARIES_LEVEL");
		return "dictionaries/level_list";
	}
	
	@RequestMapping("/get/list.do")
	@ResponseBody
	public PageHelper<Level> getListByPage(String name,Integer offset,Integer limit)throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_LEVEL");
		return levelService.getListByPage(name,offset,limit);
	}
	
	@RequestMapping("/get/nopage.do")
	@ResponseBody
	public List<Level> getLevelListByNoPage()throws CustomException{
		return levelService.getLevelListByNoPage();
	}
	
	
	@RequestMapping("/show/level.do")
	public String initAddOrUpdateView(Model model,Integer id) throws CustomException {
		if(id != null) {
			model.addAttribute("level", levelService.selectByPrimaryKey(id));
		}
		return "dictionaries/level_add";
	}
	
	@RequestMapping("/add/level.do")
	@ResponseBody
	@Log(operationType="字典管理",operationName="新增部门字典",operationSource="教师端")
	public Map<String,Object> saveOrUpdateLevel(Level level) throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_LEVEL");
		return levelService.saveOrUpdateLevel(level);
	}
	
	@RequestMapping("/opt/level.do")
	@ResponseBody
	@Log(operationType="字典管理",operationName="启禁部门字典",operationSource="教师端")
	public Map<String,Object> optLevel(Integer id) throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_LEVEL");
		return levelService.optLevel(id);
	}
	
	@RequestMapping("/del/level.do")
	@ResponseBody
	@Log(operationType="字典管理",operationName="删除部门字典",operationSource="教师端")
	public Map<String,Object> delLevel(Integer id) throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_LEVEL");
		return levelService.delLevel(id);
	}
}